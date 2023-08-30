package Dice.DiceGeneric;

import Dice.Dice;
import ProgramRandom.MyPersonnalRandom;

/**
 * Generic class for piped dice (i.e. dice that have a face with 1/2 chance to appear at each throw)
 *
 * @see Dice.DiceClass.DiceTricked6FacesWithFace6Tricked
 * @see Dice.DiceClass.DiceTricked6FacesWithFace1Tricked
 * @see Dice.DiceClass.DiceTricked8FacesWithFace8Tricked
 */
public abstract class TrickedDice implements Dice {
    private final int numberFace;
    private final int numberTriked;
    private final MyPersonnalRandom random;

    public TrickedDice(int numberFace, int faceTricked) {
        this.numberFace = numberFace;
        this.numberTriked = faceTricked;
        this.random = new MyPersonnalRandom();
    }

    public int getDiceThrowResult() {
        int result = random.randomInt(1, 2);
        if (result == 1) {
            return this.numberTriked;
        } else {
            result = random.randomInt(1, this.numberFace-1);
            if( result>=this.numberTriked) return result+1;
            return result;
        }
    }
}
