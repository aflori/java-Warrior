package Dice;

public abstract class TwoDices implements Dice {
    private final Dice dice1;
    private final Dice dice2;


    public TwoDices(Dice dice1, Dice dice2) {
        this.dice1=dice1;
        this.dice2=dice2;
    }


    @Override
    public int getDiceThrowResult() {
        return this.dice1.getDiceThrowResult() + this.dice2.getDiceThrowResult();
    }
}
