package GameElement;

import Exception.*;
import GameElement.CaseElement.*;

import java.util.ArrayList;
import java.util.List;

public class BoardGame {
//    static private final int NB_CASE = 64;
    private int positionPlayer;
    private final List<Case> caseContent;
    public BoardGame() {
        positionPlayer = 1;
        caseContent = new ArrayList<Case>();

        caseContent.add(new EmptyCase());
        caseContent.add(new EnemyCase("Michel sauvage"));
        caseContent.add(new WeaponCase("épée en pierre", 4));
        caseContent.add(new PotionCase("potion de vie", 2));
        caseContent.add(new SpellCase("éclaire", 3));
        caseContent.add(new EmptyCase());

    }

    public int getEndingCase() {
        return caseContent.size();
    }

    public boolean isOnEndingCase() {
        return caseContent.size() == this.positionPlayer;
    }

    public void moveCharacter(int numberCaseToAdvance) throws PersonnageHorsPlateauException {
        this.positionPlayer += numberCaseToAdvance;
        if (this.positionPlayer > caseContent.size()) {
            throw new PersonnageHorsPlateauException();
        }
    }

    public int getPlayerPosition() {
        return this.positionPlayer;
    }

    public void setPlayerOnEndingCase(){
        this.positionPlayer = caseContent.size();
    }

    public Case getPlayerCase() {
        return caseContent.get(positionPlayer-1);
    }
}
