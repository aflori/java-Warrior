package MenuClass;


import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.List;

import Exception.FinDePartie;
import Character.Personnage;


public class GeneralMenu {

    private enum CreationCharacterAction {SHOW, MODIFY, END}


    //    private boolean didCreateCharacter;
    private final Scanner consoleInput;
    private final List<Personnage> availableCharacters;
    private Personnage characterChosenByPlayer;

    public GeneralMenu(List<Personnage> availableCharacters) {
//        this.didCreateCharacter = false;
        this.consoleInput = ScannerInput.getSingletonClass();
        this.availableCharacters = availableCharacters;
        this.characterChosenByPlayer = null;
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

                //buffer clean to avoid infinite loop
                consoleInput.nextLine();
            }
        } while (userInput < 1 || userInput > options.length);

        return userInput;
    }

    public Personnage playGameMenu() throws FinDePartie {

        while (true) {
            if (this.characterChosenByPlayer == null) {
                this.menuToChooseCharacter();
            } else {
                if (this.menuToConfirmChoice()) break;
            }
        }

        return this.characterChosenByPlayer;
    }

    private void menuToChooseCharacter() throws FinDePartie {
        int numberAvailableCharacter = this.availableCharacters.size();
        String[] userOption = new String[numberAvailableCharacter + 1];
        String message = "Quel personnage choisir?";
        for (int i = 0; i < this.availableCharacters.size(); i++) {
            userOption[i] = "le " + this.availableCharacters.get(i).getClassName() + ", " + this.availableCharacters.get(i).toString();
        }
        userOption[numberAvailableCharacter] = "Quitter la partie";

        int resultUser = this.intInputUserFromConsole(message, userOption);

        if (resultUser == (numberAvailableCharacter + 1)) {
            throw new FinDePartie();
        }
        this.confirmCharacterChoice(this.availableCharacters.get(resultUser - 1));
    }

    private void confirmCharacterChoice(Personnage personnage) throws FinDePartie {
        System.out.println("Voici les informations du personnage:");
        personnage.printCharacterInformation();

        int result = this.intInputUserFromConsole("Est-ce ton dernier mot?", new String[]{"Oui", "Non", "Quitter la partie"});
        switch (result) {
            case 1 -> {
                this.characterChosenByPlayer = personnage;
            }
            case 3 -> {
                throw new FinDePartie();
            }
        }
    }

    private boolean menuToConfirmChoice() throws FinDePartie {
        int resultReturn = intInputUserFromConsole("Que veux-tu faire?", new String[]{"Commencer la partie", "Changer de personnage", "Quitter le jeu"});
        switch (resultReturn) {
            case 1 -> {
                return true;
            }
            case 3 -> {
                throw new FinDePartie();
            }
            default -> {
                this.characterChosenByPlayer = null;
                return false;
            }
        }
    }

}
