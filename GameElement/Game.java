package GameElement;

import Character.Personnage;
import Dice.DiceClass.Dice6Face;
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
    }

    public boolean hasWon() {
        return this.boardGame.isOnEndingCase();
    }
}
