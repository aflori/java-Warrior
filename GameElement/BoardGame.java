package GameElement;

import Exception.*;
//import Character.Personnage;

public class BoardGame {
    private int positionPersonnage;
    static private final int NB_CASE = 64;

    public BoardGame() {
        this.positionPersonnage = 1;
    }

    public int getPositionOnBoard() {
        return this.positionPersonnage;
    }

    public void setCharacterOnEndCase() {
        this.positionPersonnage = NB_CASE;
    }

    public int getEndingCase() {
        return NB_CASE;
    }

    public boolean isOnEndingCase() {
        return NB_CASE == this.positionPersonnage;
    }

    public void deplaceCharacterByXCases(int value) throws PersonnageHorsPlateauException {
        this.positionPersonnage += value;
        if (this.positionPersonnage > NB_CASE) {
            throw new PersonnageHorsPlateauException();
        }
    }
}
