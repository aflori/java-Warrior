package Character;

import Tools.*;

public class Guerrier extends Personnage {

    public Guerrier() {
        this.name = "";
        this.lifePoint = 5;
        this.attackPower = 5;
        this.weapon = new Weapon("épée en bois", 1);
        this.shield = null;
    }

    public Guerrier(String name) {
        this.name = name;
        this.lifePoint = 5;
        this.attackPower = 5;
        this.weapon = new Weapon("épée en bois", 1);
        this.shield = null;
    }

    public Guerrier(String Name, int lifePoint, int attackPower) {
        if (lifePoint < 5 || lifePoint > 10) {
            System.out.printf("%d est une valeur de points de vie invalide pour un magicien\n", lifePoint);
        }
        if (attackPower < 5 || attackPower > 10) {
            System.out.printf("%d est une valeur d'attaque invalide pour un magicien\n", attackPower);
        }

        this.name = Name;
        this.lifePoint = lifePoint;
        this.attackPower = attackPower;
        this.weapon = new Weapon("wooden sword", 1);
        this.shield = null;
    }

    @Override
    public void setStartLifePoint(int newPV) {
        if (newPV < 5) {
            System.err.println("les points de vie d'un guerrier doivent être d'au moins 5.");
            return;
        }
        if (newPV > 10) {
            System.err.println("les points de vie d'un guerrier ne peuvent pas être supérieur à 10.");
            return;
        }
        super.setStartLifePoint(newPV);
    }

    @Override
    public void setStartAttackPower(int newAtk) {
        if (newAtk < 5) {
            System.err.println("les points d'attaque d'un guerrier doivent être d'au moins 5.");
            return;
        }
        if (newAtk > 10) {
            System.err.println("les points de vie d'un guerrier ne peuvent pas être supérieur à 10.");
            return;
        }
        super.setStartAttackPower(newAtk);
    }

    @Override
    public void printCharacterInformation() {
        System.out.printf("Le guerrier s'appelle %s.\n", this.name);
        System.out.printf("Le guerrier a %d PV et %d point de force.\n", this.lifePoint, this.attackPower);
        System.out.printf("Le guerrier possède l'arme %s.\n", this.weapon.name);
        if (this.shield == null) {
            System.out.print("Le guerrier n'a pas de bouclier.\n");
        } else {
            System.out.printf("Le guerrier se protège avec %s.\n", this.shield.name);
        }
    }
}