public class BoardGame {
    private Personnage playerCharacter;
    private int positionPersonnage;
    static private final int NB_CASE=64;

    BoardGame(Personnage playerCharacter)
    {
        this.playerCharacter = playerCharacter;
        this.positionPersonnage = 1;
    }
    public void startGame(Menu menuDeJeu, Personnage playerCharacter)
    {
        do
        {
            int dice = Main.randomInt(1,6);
            System.out.printf("Vous avez fait %d au dé.\n",dice);
            this.positionPersonnage+=dice;

            if(this.positionPersonnage>NB_CASE) this.positionPersonnage = NB_CASE;

            System.out.printf("Vous êtes sur la case %d / %d.\n",this.positionPersonnage, NB_CASE);
        }while(this.positionPersonnage<NB_CASE);
    }


}
