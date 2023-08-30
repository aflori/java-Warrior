package Dice.DiceGeneric;

import Dice.Dice;
import ProgramRandom.*;

/**
 * generic dice for 'non piped' dice
 *
 * @see Dice.DiceClass.Dice6Face
 * @see Dice.DiceClass.Dice8Face
 */
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
