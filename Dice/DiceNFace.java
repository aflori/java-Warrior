package Dice;

import static Dice.DiceCommonFunction.randomInt;

public abstract class DiceNFace implements Dice{
    protected final int numberFace;

    public DiceNFace(int numberOfFace){
        this.numberFace = numberOfFace;
    }
    @Override
    public int getDiceThrowResult() {
        return randomInt(1, numberFace);
    }
}
