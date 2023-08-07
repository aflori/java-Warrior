import java.util.Scanner;
import Exception.PersonnageHorsPlateauException;
import Character.*;
import Exception.FinDePartie;

public class BoardGame {
    private Personnage playerCharacter;
    private int positionPersonnage;
    static private final int NB_CASE = 64;

    BoardGame(Personnage playerCharacter) {
        this.playerCharacter = playerCharacter;
        this.positionPersonnage = 1;
    }

    public void startGame(Menu menuDeJeu, Personnage playerCharacter) throws FinDePartie {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Vous êtes sur la case %d / %s\n", this.positionPersonnage, NB_CASE);
        do {
            String inputLine;
            System.out.print("Appuyez sur entrer pour jouer ou entrez \"q\" ou \"quit\" pour quitter la partie.\n");
            inputLine = scanner.nextLine().toLowerCase();

            if( inputLine.equals("q") || inputLine.equals("quit") )
            {
                throw new FinDePartie();
            }

            int dice = Main.randomInt(1, 6);
            System.out.printf("Vous avez fait %d au dé.\n", dice);

            try {
                this.characterMovement(dice);
            } catch (PersonnageHorsPlateauException e) {
                this.positionPersonnage = NB_CASE;
            }

            System.out.printf("Vous êtes sur la case %d / %d.\n", this.positionPersonnage, NB_CASE);
        } while (this.positionPersonnage < NB_CASE);

        System.out.println("Bien joué! Vous avez gagné!");
    }

    public void characterMovement(int value) throws PersonnageHorsPlateauException {
        this.positionPersonnage += value;
        if (this.positionPersonnage > NB_CASE) {
            throw new PersonnageHorsPlateauException();
        }
    }
}
