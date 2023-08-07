package MenuClass;

import Character.*;

import java.util.Scanner;
import java.util.InputMismatchException;

import Exception.FinDePartie;

public class Menu {
    public enum PossibleReturn {
        CREATE_CHARACTER, QUIT_GAME, START_GAME
    }

    private boolean didCreateCharacter;
    private boolean didStartGame;
    protected static final Scanner consoleInput = new Scanner(System.in);

    public Menu() {
        this.didCreateCharacter = false;
        this.didStartGame = false;
    }

    private int intInputUserFromConsole(String message, String[] options) {
        int userInput = 0;
        do {
            System.out.println(message);
            for (int i = 0; i < options.length; i++) {
                System.out.println((i + 1) + " - " + options[i]);
            }
            try {
                userInput = consoleInput.nextInt();
            } catch (InputMismatchException e) {
                System.err.println("Entrée invalide");
                consoleInput.nextLine(); //buffer clean to avoid infinite loop
                continue;
            }
        } while (userInput <= 0 || userInput > options.length);

        return userInput;
    }

    public PossibleReturn showMenu() {
        String[] option = {"Créer un nouveau personnage", "Quitter le jeu"};
        if (didCreateCharacter) {
            if (didStartGame) {
                option[0] = "Recommencer une partie";
            } else {
                option[0] = "Commencer la partie";
            }
        }

        int userInput = this.intInputUserFromConsole(
                "Que voulez-vous faire? (tapez le bon numéro):",
                option
        );
        switch (userInput) {
            case 1 -> {
                if (!didCreateCharacter) {
                    return PossibleReturn.CREATE_CHARACTER;
                } else {
                    this.didStartGame = true;
                    return PossibleReturn.START_GAME;
                }
            }
            case 2 -> {
                return PossibleReturn.QUIT_GAME;
            }
        }
        return PossibleReturn.START_GAME;

    }

    public Personnage menuToCreateCharacter() throws FinDePartie {
        CharacterType typeCharacter;
        Personnage playerPersonnage;
        this.didCreateCharacter = true;
        String name;


        typeCharacter = this.menuChooseCharacterType();
        name = this.getCharacterName(typeCharacter);

        if (typeCharacter == CharacterType.MAGICIAN) playerPersonnage = new Magicien(name);
        else playerPersonnage = new Guerrier(name);

        System.out.println("personnage créé!");

        return this.menuEditionCharacter(playerPersonnage);
    }


    /*----------------------------
    showMenu specialized function
      ----------------------------*/

    //none

    /*----------------------------
    createCharacter specialized function
      ----------------------------*/
    private CharacterType menuChooseCharacterType() throws FinDePartie {
        int inputNumber = this.intInputUserFromConsole(
                "Quelle type de personnage voulez-vous créer?",
                new String[]{"un magicien", "un guerrier", "quitter la partie"}
        );
        switch (inputNumber) {
            case 1 -> {
                return CharacterType.MAGICIAN;
            }
            case 2 -> {
                return CharacterType.WARRIOR;
            }
            case 3 -> {
                throw new FinDePartie();
            }
        }

        //this line should never be executed
        return CharacterType.WARRIOR;
    }

    private String getCharacterName(CharacterType typeCharacter) {
        String characterName;
        consoleInput.nextLine();
        do {
            System.out.println("Quel est le nom du future " + (typeCharacter == CharacterType.MAGICIAN ? "magicien" : "guerrier") + ".");
            characterName = consoleInput.nextLine();

        } while (characterName.isEmpty());

        return characterName;
    }

    private Personnage menuEditionCharacter(Personnage defaultConfig) throws FinDePartie {
        CreationCharacterAction inputAnswer;
        do {
            inputAnswer = askCreationCharacterUserAction();
            switch (inputAnswer) {
                case SHOW -> defaultConfig.printCharacterInformation();
                case MODIFY -> this.modifieCharacterSettings(defaultConfig);
            }
        } while (inputAnswer != CreationCharacterAction.END);

        return defaultConfig;
    }

    private enum CreationCharacterAction {SHOW, MODIFY, END}

    private CreationCharacterAction askCreationCharacterUserAction() throws FinDePartie {
        int inputAnswer = this.intInputUserFromConsole(
                "Création du personnage en cour, que voulez-vous faire?",
                new String[]{"Afficher les caractéristiques du personnage",
                        "Modifier les caractéristiques du personnage",
                        "Confirmer la selection",
                        "Quitter la partie"
                }
        );

        switch (inputAnswer) {
            case 1 -> {
                return CreationCharacterAction.SHOW;
            }
            case 2 -> {
                return CreationCharacterAction.MODIFY;
            }
            case 3 -> {
                return CreationCharacterAction.END;
            }

            default -> {
                throw new FinDePartie();
            }
        }
    }

    private void modifieCharacterSettings(Personnage character) throws FinDePartie {
        int inputValue = this.intInputUserFromConsole(
                "Que voulez-vous changer?",
                new String[]{"Le nom", "Sa vie", "Sa force d'attaque", "Quitter la partie"}
        );
        if (inputValue == 4) {
            throw new FinDePartie();
        }
        if (inputValue == 1) {
            System.out.println("Entrez le nouveau nom");
            String newName = "";
            while (newName.isEmpty()) {
                newName = consoleInput.nextLine();
            }
            character.setName(newName);
        } else {
            System.out.println("Entrez sa nouvelle valeur " + (inputValue == 2 ? "de vie" : "d'attaque"));
            int newValue = 0;
            while (newValue <= 0) //the character should be alive
            {
                newValue = consoleInput.nextInt();
            }

            if (inputValue == 2) {
                character.setStartLifePoint(newValue);
            } else {
                character.setStartAttackPower(newValue);
            }
        }
    }
}
