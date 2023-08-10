package GameElement.CaseElement;

import Character.*;

public class WeaponCase extends Case {

    @Override
    public String toString() {
        return "Case arme";
    }

    @Override
    public void interaction(Personnage playerChoice) {
        if (playerChoice instanceof Magicien) {
            System.out.println("La case ne contien rien.");
        }
        else {
            System.out.println("La case contien une arme.");
        }

    }
}

