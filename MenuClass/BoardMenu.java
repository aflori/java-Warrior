package MenuClass;

import Character.Personnage;
import Dice.*;
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

    private void clearScannerBuffer()
    {
        while (!consoleInput.nextLine().isEmpty());
    }

    public void startGame() throws FinDePartie {
        this.clearScannerBuffer();
        do {
            Dice dice = new TwoDices6Face();
            System.out.printf("Vous êtes sur la case %d / %d\n", this.boardGame.getPositionOnBoard(), this.boardGame.getEndingCase());

            System.out.print("Appuyez sur entrer pour jouer ou entrez \"q\" ou \"quit\" pour quitter la partie.\n");
            String inputLine = consoleInput.nextLine().toLowerCase();

            if (inputLine.equals("q") || inputLine.equals("quit")) {
                throw new FinDePartie();
            }

            int diceResult = dice.getDiceThrowResult();
            System.out.printf("Vous avez fait %d au dé.\n", diceResult);

            try {
                this.boardGame.deplaceCharacterByXCases(diceResult);
            } catch (PersonnageHorsPlateauException e) {
                this.boardGame.setCharacterOnEndCase();
            }

        } while (!this.boardGame.isOnEndingCase());
        System.out.println("Félicitétions, vous avez gagné la partie car vous avez atteind la case final.");
    }


}
