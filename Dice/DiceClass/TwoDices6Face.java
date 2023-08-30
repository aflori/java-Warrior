package Dice.DiceClass;

import Dice.DiceGeneric.TwoDices;

/**
 * class representing 2 standard dices
 */
public class TwoDices6Face extends TwoDices {
    public TwoDices6Face()
    {
        super(new Dice6Face(), new Dice6Face() );
    }
}
