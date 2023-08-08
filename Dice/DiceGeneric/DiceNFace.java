package Dice.DiceGeneric;

import Dice.Dice;

public abstract class DiceNFace implements Dice {
    protected final int numberFace;

    public DiceNFace(int numberOfFace){
        this.numberFace = numberOfFace;
    }
    @Override
    public int getDiceThrowResult() {
        return DiceCommonFunction.randomInt(1, numberFace);
    }
}
