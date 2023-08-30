package Dice.DiceGeneric;

import Dice.Dice;

/**
 * generic class to represent 2 different dice at each throw
 *
 * @see Dice.DiceClass.TwoDices6Face
 */
public abstract class TwoDices implements Dice {
    private final Dice dice1;
    private int lastValueDice1;
    private final Dice dice2;
    private int lastValueDice2;


    public TwoDices(Dice dice1, Dice dice2) {
        this.dice1=dice1;
        this.dice2=dice2;
        this.lastValueDice1 = 0;
        this.lastValueDice2 = 0;
    }


    @Override
    public int getDiceThrowResult() {
        this.lastValueDice1 = this.dice1.getDiceThrowResult();
        this.lastValueDice2 = this.dice2.getDiceThrowResult();
        return this.lastValueDice1 + this.lastValueDice2;
    }
}
