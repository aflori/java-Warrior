
import GameElement.Game;
import MenuClass.Menu;
import Exception.FinDePartie;
import Character.Personnage;
import Character.Guerrier;

public class Main {

    public static void main(String[] args) {
        Menu menu = new Menu();
        Game game = null;
        try {
            while(true) {
                Personnage playerCharacter = menu.playGameMenu(); // line comented to test game itself
                //Personnage playerCharacter = new Guerrier("Michello",8,10);

                Game playerGame = new Game(playerCharacter);
                playerGame.startGame();
            }
        } catch (FinDePartie ignored) {
        }

        System.out.println("Merci d'avoir joué");
    }

}

