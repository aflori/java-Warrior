public class BoarGame {
    private Personnage playerCharacter;
    private int positionPersonnage;
    static private final int NB_CASE=64;

    BoarGame(Personnage playerCharacter)
    {
        this.playerCharacter = playerCharacter;
        this.positionPersonnage = 1;
    }
}
