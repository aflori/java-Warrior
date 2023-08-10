package GameElement.CaseElement;

import Character.*;

public class EnemyCase extends Case{
    @Override
    public String toString() {
        return "Case ennemi";
    }

    @Override
    public void interaction(Personnage playerChoice) {
        System.out.println("Un villain ennemi est sur la case!");
    }
}
