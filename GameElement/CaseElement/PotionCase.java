package GameElement.CaseElement;

import Character.*;

public class PotionCase extends Case{

    @Override
    public String toString() {
        return "Case potion";
    }

    @Override
    public void interaction(Personnage playerChoice) {
        System.out.println("La case contien une potion de vie");
    }

}
