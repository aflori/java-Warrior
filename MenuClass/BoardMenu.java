package MenuClass;

import Character.Personnage;
import Exception.*;
import GameElement.*;


import java.util.Scanner;

public class BoardMenu {

    private Personnage playerCharacter;
    private final Scanner consoleInput;
    private BoardGame boardGame;

    public BoardMenu(Personnage playerCharacter) {
        this.playerCharacter = playerCharacter;
        this.consoleInput = ScannerInput.getSingletonClass().consoleScanner;
        this.boardGame = new BoardGame();
    }

    public void startGame() throws FinDePartie {
        do {
            System.out.printf("Vous êtes sur la case %d / %d\n", this.boardGame.getPositionOnBoard(), this.boardGame.getEndingCase());

            System.out.print("Appuyez sur entrer pour jouer ou entrez \"q\" ou \"quit\" pour quitter la partie.\n");
            String inputLine = consoleInput.nextLine().toLowerCase();

            if (inputLine.equals("q") || inputLine.equals("quit")) {
                throw new FinDePartie();
            }

            int dice = Dice.randomInt(1, 6);
            System.out.printf("Vous avez fait %d au dé.\n", dice);

            try {
                this.boardGame.deplaceCharacterByXCases(dice);
            } catch (PersonnageHorsPlateauException e) {
                this.boardGame.setCharacterOnEndCase();
            }

        } while (this.boardGame.isOnEndingCase());
    }


}
