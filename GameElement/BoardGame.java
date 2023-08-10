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


        Case[] baseElement = {new SpellCase("éclair", 2), new WeaponCase("massues", 3), //2
                new EnemyCase(new Goblin()), new SpellCase("éclair", 2),//4
                new WeaponCase("massues", 3), new EnemyCase(new Goblin()),//6
                new PotionCase("potion", 2), new SpellCase("éclair", 2),//8
                new EnemyCase(new Goblin()), new EnemyCase(new Wizard()),//10
                new WeaponCase("massues", 3), new EnemyCase(new Goblin()),//12
                new PotionCase("potion", 2), new EmptyCase(),//14
                new EnemyCase(new Goblin()), new EmptyCase(),//16
                new SpellCase("éclair", 2), new EnemyCase(new Goblin()),//18
                new WeaponCase("épée", 5), new EnemyCase(new Wizard()),//20
                new EnemyCase(new Goblin()), new WeaponCase("massues", 3),//22
                new SpellCase("éclair", 2), new EnemyCase(new Goblin()),//24
                new EnemyCase(new Wizard()), new WeaponCase("épée", 5),//26
                new EnemyCase(new Goblin()), new PotionCase("grande potion", 5),//28
                new EmptyCase(), new EnemyCase(new Goblin()),//30
                new PotionCase("potion", 2), new EnemyCase(new Wizard()),//32
                new PotionCase("potion", 2), new EmptyCase(),//34
                new EnemyCase(new Wizard()), new EnemyCase(new Wizard()),//36
                new EnemyCase(new Wizard()), new WeaponCase("massues", 3),//38
                new PotionCase("potion", 2), new EnemyCase(new Wizard()),//40
                new PotionCase("grande potion", 5), new WeaponCase("épée", 5),//42
                new PotionCase("potion", 2), new EnemyCase(new Wizard()),//44
                new EnemyCase(new Dragon()), new EmptyCase(),//46
                new EnemyCase(new Wizard()), new SpellCase("boules de feu", 7),//48
                new SpellCase("boules de feu", 7), new EmptyCase(),//50
                new EmptyCase(), new EnemyCase(new Dragon()),//52
                new WeaponCase("épée", 5), new EmptyCase(),//54
                new EmptyCase(), new EnemyCase(new Dragon()),//56
                new EmptyCase(), new EmptyCase(), new EmptyCase(),//59
                new EmptyCase(), new EmptyCase(), new EnemyCase(new Dragon()),//62
                new EmptyCase(), new EmptyCase()//64
        };
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
