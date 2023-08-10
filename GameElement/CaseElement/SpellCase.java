package GameElement.CaseElement;

import Character.*;

public class SpellCase extends Case {
    @Override
    public String toString() {
        return "Case sort";
    }

    @Override
    public void interaction(Personnage playerChoice) {
        if (playerChoice instanceof Guerrier) {
            System.out.println("La case ne contien rien.");
        }
        else {
            System.out.println("La case contien une sort.");
        }
    }
}
