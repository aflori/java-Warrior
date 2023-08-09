
import GameElement.Game;
import MenuClass.Menu;
import Exception.FinDePartie;
import Character.Personnage;

public class Main {

    public static void main(String[] args) {
        Menu menu = new Menu();
        Game game = null;
        try {
            while(true) {
                Personnage playerCharacter = menu.playGameMenu();

                Game playerGame = new Game(playerCharacter);
                playerGame.startGame();
            }
        } catch (FinDePartie ignored) {
        }

        System.out.println("Merci d'avoir joué");
    }

}

