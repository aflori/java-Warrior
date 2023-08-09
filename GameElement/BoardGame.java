package GameElement;

import Exception.*;

public class BoardGame {
    static private final int NB_CASE = 64;
    private int positionPlayer;
    public BoardGame() {
        positionPlayer = 1;
    }

    public int getEndingCase() {
        return NB_CASE;
    }

    public boolean isOnEndingCase() {
        return NB_CASE == this.positionPlayer;
    }

    public void deplaceCharacter(int numberCaseToAdvance) throws PersonnageHorsPlateauException {
        this.positionPlayer += numberCaseToAdvance;
        if (this.positionPlayer > NB_CASE) {
            throw new PersonnageHorsPlateauException();
        }
    }

    public int getPlayerPosition() {
        return this.positionPlayer;
    }

    public void setPlayerOnEndingCase(){
        this.positionPlayer = NB_CASE;
    }
}
