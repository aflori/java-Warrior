
import GameElement.Game;
import MenuClass.GeneralMenu;
import Exception.FinDePartie;
import Character.Personnage;
import jdbc_interaction.hero_src;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
        GeneralMenu menu = null;

        try {
            hero_src dataBaseConnection = new hero_src();
            menu = new GeneralMenu(dataBaseConnection.getHeroesSet());
        } catch (SQLException e) {
            System.err.println("Impossible de charger les personnages de la base de donnée!");
            System.exit(1);
        }

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

