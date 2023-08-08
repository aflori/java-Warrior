package Dice.DiceClass;

import Dice.DiceGeneric.TwoDices;

public class TwoDices6Face extends TwoDices {
    public TwoDices6Face()
    {
        super(new Dice6Face(), new Dice6Face() );
    }
}
