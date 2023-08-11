package GameElement;

import Enemy.Dragon;
import Enemy.Goblin;
import Enemy.Wizard;
import Exception.*;
import GameElement.CaseElement.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BoardGame {

    //    static private final int NB_CASE = 64;
    private int positionPlayer;
    private final List<Case> caseContent;

    public BoardGame() {
        positionPlayer = 1;


        Case[] baseElement = {new SpellCase("éclair", 2), new WeaponCase("massues", 3), new EnemyCase(new Goblin()), new SpellCase("éclair", 2), new WeaponCase("massues", 3), new EnemyCase(new Goblin()), new PotionCase("potion", 2), new SpellCase("éclair", 2), new EnemyCase(new Goblin()), new EnemyCase(new Wizard()), new WeaponCase("massues", 3), new EnemyCase(new Goblin()), new PotionCase("potion", 2), new EmptyCase(), new EnemyCase(new Goblin()), new EmptyCase(), new SpellCase("éclair", 2), new EnemyCase(new Goblin()), new WeaponCase("épée", 5), new EnemyCase(new Wizard()), new EnemyCase(new Goblin()), new WeaponCase("massues", 3), new SpellCase("éclair", 2), new EnemyCase(new Goblin()), new EnemyCase(new Wizard()), new WeaponCase("épée", 5), new EnemyCase(new Goblin()), new PotionCase("grande potion", 5), new EmptyCase(), new EnemyCase(new Goblin()), new PotionCase("potion", 2), new EnemyCase(new Wizard()), new PotionCase("potion", 2), new EmptyCase(), new EnemyCase(new Wizard()), new EnemyCase(new Wizard()), new EnemyCase(new Wizard()), new WeaponCase("massues", 3), new PotionCase("potion", 2), new EnemyCase(new Wizard()), new PotionCase("grande potion", 5), new WeaponCase("épée", 5), new PotionCase("potion", 2), new EnemyCase(new Wizard()), new EnemyCase(new Dragon()), new EmptyCase(), new EnemyCase(new Wizard()), new SpellCase("boules de feu", 7), new SpellCase("boules de feu", 7), new EmptyCase(), new EmptyCase(), new EnemyCase(new Dragon()), new WeaponCase("épée", 5), new EmptyCase(), new EmptyCase(), new EnemyCase(new Dragon()), new EmptyCase(), new EmptyCase(), new EmptyCase(), new EmptyCase(), new EmptyCase(), new EnemyCase(new Dragon()), new EmptyCase(), new EmptyCase()};
        caseContent = Arrays.asList(baseElement);
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

    public void setPlayerOnEndingCase() {
        this.positionPlayer = caseContent.size();
    }

    public Case getPlayerCase() {
        return caseContent.get(positionPlayer - 1);
    }
}
