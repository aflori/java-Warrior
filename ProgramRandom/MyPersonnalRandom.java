package ProgramRandom;

import java.util.Random;

//will be changed into package visibility
public class MyPersonnalRandom extends Random {


    public MyPersonnalRandom() {
        super();
    }

    public int randomInt(int vMin, int vMax) {
        if (vMin == vMax) return vMax;

        if (vMin > vMax) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        return super.nextInt((vMax - vMin) + 1) + vMin;
    }

}
