package Dice.DiceGeneric;

import Dice.Dice;

public abstract class TrickedDice implements Dice {
    private int numberFace;
    private int numberTriked;

    public TrickedDice(int numberFace, int faceTricked) {
        this.numberFace = numberFace;
        this.numberTriked = faceTricked;
    }

    public int getDiceThrowResult() {
        int result = DiceCommonFunction.randomInt(1, 2);
        if (result == 1) {
            return this.numberTriked;
        } else {
            result = DiceCommonFunction.randomInt(1, this.numberFace-1);
            if( result>=this.numberTriked) return result+1;
            return result;
        }
    }
}
