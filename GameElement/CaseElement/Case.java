package GameElement.CaseElement;

import Character.Personnage;
public abstract class Case {

    public Case() {

    }

    @Override
    public abstract String toString();

    public void interaction(Personnage playerChoice) {
        System.out.println("Un villain ennemi est sur la case!");
    }
}
