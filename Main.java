import java.util.Random;


public class Main {

    public static void main(String[] args) {
        Menu menu = new Menu();
        Personnage playerCharacter;

        Menu.PossibleReturn menuAction;
        do {
            menuAction = menu.showMenu();

            switch (menuAction){
                case CREATE_CHARACTER -> playerCharacter = menu.createCharacter();
            }
        }while(menuAction!= Menu.PossibleReturn.QUIT_GAME);

        System.out.println("Merci d'avoir joué");
    }

    /*
    public static int randomInt(int vMin, int vMax)
    {
        if (vMin >= vMax) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((vMax - vMin) + 1) + vMin;
    }

     */
}

