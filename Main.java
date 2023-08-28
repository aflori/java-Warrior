
import GameElement.Game;
import MenuClass.GeneralMenu;
import Exception.FinDePartie;
import Character.Personnage;
import jdbc_interaction.hero_src;

import java.sql.SQLException;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        GeneralMenu menu = new GeneralMenu();
        Game game = null;
        Set<Personnage> availableCharacter;
        try {
            hero_src testFct = new hero_src();
            availableCharacter = testFct.getHeroesSet();
            System.out.println(availableCharacter);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

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

