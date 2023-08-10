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
            return;
        }
    }
}

