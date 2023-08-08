package Dice;

import static Dice.DiceOld.randomInt;

public class DiceNFace implements Dice{
    private final int numberFace;

    public DiceNFace(int numberOfFace){
        this.numberFace = numberOfFace;
    }
    @Override
    public int getDiceThrowResult() {
        return randomInt(1, numberFace);
    }
}
