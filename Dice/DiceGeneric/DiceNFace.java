package Dice.DiceGeneric;

import Dice.Dice;
import ProgramRandom.*;

public abstract class DiceNFace implements Dice {
    protected final int numberFace;
    protected final MyPersonnalRandom random;

    public DiceNFace(int numberOfFace){
        this.numberFace = numberOfFace;
        this.random = new MyPersonnalRandom();
    }
    @Override
    public int getDiceThrowResult() {
        return random.randomInt(1, numberFace);
    }
}
