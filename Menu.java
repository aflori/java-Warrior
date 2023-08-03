import java.util.Scanner;

public class Menu {
    public enum PossibleReturn {
        CREATE_CHARACTER, QUIT_GAME
    }
    private boolean didCreateCharacter;
    private static final Scanner consoleInput = new Scanner(System.in);
    Menu() {
        this.didCreateCharacter = false;
    }

    public PossibleReturn showMenu()
    {
        int userInput;

        do{
            System.out.println("Que voulez-vous faire? (tapez le bon numéro):");
            if(! didCreateCharacter ) System.out.println("1 - Créer un nouveau personnage");
            System.out.println("2 - Quitter le jeu");
            userInput = consoleInput.nextInt();

            switch (userInput) {
                case 1 -> {
                    if(!didCreateCharacter)
                    {
                        return PossibleReturn.CREATE_CHARACTER;
                    }
                }
                case 2 -> {
                    return PossibleReturn.QUIT_GAME;
                }
            }
        }while( true );

    }

    public Personnage createCharacter() {
        CharacterType typeCharacter;
        Personnage playerPersonnage;
        this.didCreateCharacter = true;
        String name;


        typeCharacter = this.menuChooseCharacterType();
        name = this.getCharacterName(typeCharacter);

        if ( typeCharacter==CharacterType.MAGICIAN ) playerPersonnage = new Magicien(name);
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
    private CharacterType menuChooseCharacterType()
    {
        int inputNumber;
        do{
            System.out.println("Quelle type de personnage voulez-vous créer?");
            System.out.println("1 - un magicien");
            System.out.println("2 - un guerrier");
            inputNumber = consoleInput.nextInt();
        }while(inputNumber!=1 && inputNumber!=2);
        switch (inputNumber){
            case 1 -> { return CharacterType.MAGICIAN; }
            case 2 -> { return CharacterType.WARRIOR; }
        }

        //this line should never be executed
        return  CharacterType.WARRIOR;
    }
    private String getCharacterName(CharacterType typeCharacter)
    {
        String characterName;
        do{
            consoleInput.nextLine();
            System.out.println("Quel est le nom du future " + (typeCharacter==CharacterType.MAGICIAN?"magicien":"guerrier") + "." );
            characterName = consoleInput.nextLine();

        }while(characterName.isEmpty());

        return characterName;
    }

    private Personnage menuEditionCharacter(Personnage defaultConfig)
    {
        CreationCharacterAction inputAnswer;
        do{
            inputAnswer = askCreationCharacterUserAction();
            switch (inputAnswer)
            {
                case SHOW -> defaultConfig.printCharacterInformation();
                case MODIFY -> this.modifieCharacterSettings(defaultConfig);
            }
        }while( inputAnswer != CreationCharacterAction.END );

        return defaultConfig;
    }
    private enum CreationCharacterAction {SHOW, MODIFY, END}
    private CreationCharacterAction askCreationCharacterUserAction()
    {
        int inputAnswer;
        do{
            System.out.println("Création du personnage en cour, que voulez-vous faire?");
            System.out.println("1 - Afficher les caractéristiques du personnage");
            System.out.println("2 - Modifier les caractéristiques du personnage");
            System.out.println("3 - Confirmer la selection");

            inputAnswer = consoleInput.nextInt();

        }while(inputAnswer<=0 || inputAnswer>3);

        switch (inputAnswer){
            case 1 -> { return CreationCharacterAction.SHOW; }
            case 2 -> { return CreationCharacterAction.MODIFY; }
            default -> { return CreationCharacterAction.END; } // case 3
        }
    }
    private void modifieCharacterSettings(Personnage character)
    {
        int inputValue;

        do{
            System.out.println("Que voulez-vous changer?");
            System.out.println("1 - Le nom");
            System.out.println("2 - Sa vie");
            System.out.println("3 - Sa force d'attaque");

            inputValue = consoleInput.nextInt();
        }while(inputValue<1 || inputValue>3);

        switch (inputValue)
        {
            case 1 -> {
                System.out.println("Entrez le nouveau nom");
                String newName = "";
                while(newName.isEmpty())
                {
                    newName = consoleInput.nextLine();
                }
                character.setName(newName);
            }
            case 2 -> {
                System.out.println("Entrez sa nouvelle valeur de vie");
                int newLifePoint=0;
                while (newLifePoint<=0) //the character should be alive
                {
                    newLifePoint = consoleInput.nextInt();
                }
                character.setLifePoint(newLifePoint);
            }
            case 3 -> {
                System.out.println("Entrez sa nouvelle valeur d'attaque");
                int newAttackPoint=0;
                while (newAttackPoint<=0) //the character should stand on its feet
                {
                    newAttackPoint = consoleInput.nextInt();
                }
                character.setAttackPower(newAttackPoint);
            }
        }
    }
}
