package GameElement.CaseElement;

import Character.*;

public class EmptyCase extends Case{

    @Override
    public String toString() {
        return "Case vide";
    }

    @Override
    public void interaction(Personnage playerChoice) {
        System.out.println("La case ne contien rien");
    }
}
