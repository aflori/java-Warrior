package GameElement;

import java.util.Random;

public class Dice {

    private static final Random r = new Random();
    public static int randomInt(int vMin, int vMax) {
        if (vMin >= vMax) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        return r.nextInt((vMax - vMin) + 1) + vMin;
    }

}