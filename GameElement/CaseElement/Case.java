package GameElement.CaseElement;

import Character.Personnage;
public abstract class Case {

    public Case() {

    }

    @Override
    public abstract String toString();

    public abstract void interaction(Personnage playerChoice);
}
