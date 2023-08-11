package GameElement;

import Enemy.Dragon;
import Enemy.Goblin;
import Enemy.Wizard;
import Exception.*;
import GameElement.CaseElement.*;
import ProgramRandom.MyPersonnalRandom;

import java.util.ArrayList;
import java.util.List;

public class BoardGame {

    //    static private final int NB_CASE = 64;
    private int positionPlayer;
    private List<Case> caseContent;

    public BoardGame() {
        positionPlayer = 1;


        this.generateBoardWithRandomCase();
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

    private void generateBoardWithRandomCase() {
        MyPersonnalRandom r = new MyPersonnalRandom();
        Case[][] listElement = new Case[][]{{ // contain 64 Case sorted by its content
                new EnemyCase(new Dragon()), new EnemyCase(new Dragon()), new EnemyCase(new Dragon()), new EnemyCase(new Dragon())
        }, {
                new EnemyCase(new Wizard()), new EnemyCase(new Wizard()), new EnemyCase(new Wizard()), new EnemyCase(new Wizard()), new EnemyCase(new Wizard()), new EnemyCase(new Wizard()), new EnemyCase(new Wizard()), new EnemyCase(new Wizard()), new EnemyCase(new Wizard()), new EnemyCase(new Wizard())
        }, {
                new EnemyCase(new Goblin()), new EnemyCase(new Goblin()), new EnemyCase(new Goblin()), new EnemyCase(new Goblin()), new EnemyCase(new Goblin()), new EnemyCase(new Goblin()), new EnemyCase(new Goblin()), new EnemyCase(new Goblin()), new EnemyCase(new Goblin()), new EnemyCase(new Goblin())
        }, {
                new WeaponCase("massue", 3), new WeaponCase("massue", 3), new WeaponCase("massue", 3), new WeaponCase("massue", 3), new WeaponCase("massue", 3)
        }, {
                new WeaponCase("épée", 5), new WeaponCase("épée", 5), new WeaponCase("épée", 5), new WeaponCase("épée", 5)
        }, {
                new SpellCase("éclair", 2), new SpellCase("éclair", 2), new SpellCase("éclair", 2), new SpellCase("éclair", 2), new SpellCase("éclair", 2)
        }, {
                new SpellCase("boule de feu", 7), new SpellCase("boules de feu", 7)
        }, {
                new PotionCase("potion", 2), new PotionCase("potion", 2), new PotionCase("potion", 2), new PotionCase("potion", 2), new PotionCase("potion", 2), new PotionCase("potion", 2)
        }, {
                new PotionCase("grande potion", 5), new PotionCase("grande potion", 5)
        }, {
                new EmptyCase(), new EmptyCase(), new EmptyCase(), new EmptyCase(), new EmptyCase(), new EmptyCase(), new EmptyCase(), new EmptyCase(), new EmptyCase(), new EmptyCase(), new EmptyCase(), new EmptyCase(), new EmptyCase(), new EmptyCase(), new EmptyCase(), new EmptyCase(),
        }};

        this.caseContent = new ArrayList<>(64);
        this.caseContent.add(listElement[9][0]);

        listElement[9][0] = null;

        //case 2-10
        int[] probabilityAppearance = {0, 0, 3, 2, 0, 2, 0, 1, 0, 1};
        moveElement(2, 10, probabilityAppearance, listElement, r);

        //case 10-20
        probabilityAppearance = new int[]{0, 1, 6, 5, 0, 5, 0, 1, 0, 1};
        moveElement(10, 20, probabilityAppearance, listElement, r);

        //case 20-30
        probabilityAppearance = new int[]{0, 5, 10, 8, 3, 8, 0, 2, 0, 1};
        moveElement(20, 30, probabilityAppearance, listElement, r);

        //case 30-45
        probabilityAppearance = new int[]{0, 10, 100, 100, 5, 100, 2, 4, 3, 1};
        moveElement(30, 45, probabilityAppearance, listElement, r);

        //case 45-55
        probabilityAppearance = new int[]{1, 100, 100, 100, 10, 100, 100, 10, 10, 4};
        moveElement(45, 55, probabilityAppearance, listElement, r);

        //case 55-65
        probabilityAppearance = new int[]{1, 100, 100, 100, 100, 100, 100, 100, 0, 1};
        moveElement(55, 65, probabilityAppearance, listElement, r);

    }

    private void moveElement(int startIndex, int endIndex, int[] probabilityAppearance, Case[][] listElement, MyPersonnalRandom r) {
        for (int i = startIndex; i < endIndex; i++) {
            int randomValue = 0;
            for (int j = 0; j < probabilityAppearance.length; j++) {
                if (isNotEmpty(listElement[j])) {
                    randomValue += probabilityAppearance[j];
                }
            }
            randomValue = r.randomInt(1, randomValue);

            for (int j = 0; j < probabilityAppearance.length; j++) {
                if (isNotEmpty(listElement[j])) {
                    if (randomValue <= probabilityAppearance[j]) {
                        this.moveToList(listElement[j]);
                        break;
                    } else {
                        randomValue -= probabilityAppearance[j];
                    }
                }
            }
        }
    }

    private void moveToList(Case[] array) {
        int i = 0;
        while (array[i] == null) {
            i++;
        }
        this.caseContent.add(array[i]);
        array[i] = null;
    }

    private static boolean isNotEmpty(Case[] list) {
        for (Case element : list) {
            if (element != null) return true;
        }
        return false;
    }
}
