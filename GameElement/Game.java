package GameElement;

import Character.Personnage;
import GameElement.CaseElement.Case;
import MenuClass.BoardMenu;
import Dice.Dice;        // interface
import Dice.DiceClass.*; // implementations
import Exception.*;

public class Game {

    private Personnage playerCharacter;
    private BoardGame boardGame;
    private BoardMenu menu;
    private final Dice dice;

    public Game(Personnage playerCharacter) {
        this.playerCharacter = playerCharacter;
        this.boardGame = new BoardGame();
        this.menu = new BoardMenu();
        this.dice = new PipedDice1();
    }


    public boolean isGameFinished() {
        return this.boardGame.isOnEndingCase();
    }

    public void play_a_turn() throws FinDePartie {
        System.out.printf("tu es sur la case %d / %d\n", this.boardGame.getPlayerPosition(), this.boardGame.getEndingCase());

        this.menu.waitInputToPlay();

        System.out.println("Lancement des dés");
        int diceResult = dice.getDiceThrowResult();
        System.out.printf("tu as fait %d au dé\n", diceResult);

        try {
            boardGame.deplaceCharacter( diceResult);
        } catch (PersonnageHorsPlateauException e) {
            boardGame.setPlayerOnEndingCase();
        }

        System.out.printf("Tu arrives sur la case %d.\n", this.boardGame.getPlayerPosition());
        Case currentPlayerPlace = this.boardGame.getPlayerCase();
        currentPlayerPlace.interaction(this.playerCharacter);
    }

    public boolean hasWon() {
        return this.boardGame.isOnEndingCase();
    }

    public void startGame() throws FinDePartie {
        while (!this.isGameFinished()) {
            this.play_a_turn();
        }

        if (this.hasWon()) System.out.println("Bien joué, tu as gagné la partie");
        else System.out.println("Dommage, tu feras mieu la prochaine fois!");
    }
}
