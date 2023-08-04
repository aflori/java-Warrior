public class BoardGame {
    private Personnage playerCharacter;
    private int positionPersonnage;
    static private final int NB_CASE=64;

    BoardGame(Personnage playerCharacter)
    {
        this.playerCharacter = playerCharacter;
        this.positionPersonnage = 1;
    }
}
