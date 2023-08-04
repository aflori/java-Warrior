import java.util.Scanner;

public class BoardGame {
    private Personnage playerCharacter;
    private int positionPersonnage;
    static private final int NB_CASE = 64;

    BoardGame(Personnage playerCharacter) {
        this.playerCharacter = playerCharacter;
        this.positionPersonnage = 1;
    }

    public void startGame(Menu menuDeJeu, Personnage playerCharacter) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Vous êtes sur la case %d / %s\n", this.positionPersonnage, NB_CASE);
        do {
            System.out.print("Appuyez sur entrer pour jouer.\n");
            scanner.nextLine();

            int dice = Main.randomInt(1, 6);
            System.out.printf("Vous avez fait %d au dé.\n", dice);

            this.characterMovement(dice);

            System.out.printf("Vous êtes sur la case %d / %d.\n", this.positionPersonnage, NB_CASE);
        } while (this.positionPersonnage < NB_CASE);
    }

    public void characterMovement(int value) {
        this.positionPersonnage += value;
        if (this.positionPersonnage > NB_CASE) {
            this.positionPersonnage = 2 * NB_CASE - this.positionPersonnage;
        }
    }
}
