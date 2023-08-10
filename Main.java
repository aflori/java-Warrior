
import GameElement.Game;
import MenuClass.GeneralMenu;
import Exception.FinDePartie;
import Character.Personnage;

public class Main {

    public static void main(String[] args) {
        GeneralMenu menu = new GeneralMenu();
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

