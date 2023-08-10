package GameElement.CaseElement;

import Character.*;

public class SurpriseBoxCase extends Case{

    @Override
    public String toString() {
        return "Case surprise";
    }

    @Override
    public void interaction(Personnage playerChoice) {
        System.out.println("Il y a une caisse surprise ici!");
    }
}
