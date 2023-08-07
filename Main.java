import java.util.Random;
import Character.*;

import Exception.FinDePartie;
public class Main {

    public static void main(String[] args) {
        Menu menu = new Menu();
        Personnage playerCharacter = null;
        Menu.PossibleReturn menuAction;
        BoardGame playerGame;

        try {
            do {

                menuAction = menu.showMenu();

                switch (menuAction) {

                    case CREATE_CHARACTER -> playerCharacter = menu.menuToCreateCharacter();
                    case START_GAME -> {
                        playerGame = new BoardGame(playerCharacter);
                        playerGame.startGame(menu, playerCharacter);
                    }
                }
            } while (menuAction != Menu.PossibleReturn.QUIT_GAME);
        }
        catch (FinDePartie ignored)
        {}

        System.out.println("Merci d'avoir joué");
    }

    private static final Random r = new Random();

    public static int randomInt(int vMin, int vMax) {
        if (vMin >= vMax) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        return r.nextInt((vMax - vMin) + 1) + vMin;
    }
}

