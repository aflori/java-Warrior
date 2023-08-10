package GameElement.CaseElement;

import Character.*;

public class ShieldCase extends Case{
    @Override
    public String toString() {
        return "Case bouclier";
    }

    @Override
    public void interaction(Personnage playerChoice) {
        //pass
        if(playerChoice instanceof Magicien) {
            return;
        }
    }
}

