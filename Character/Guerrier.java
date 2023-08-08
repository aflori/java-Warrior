package Character;

import Tools.Offense.Weapon;

public class Guerrier extends Personnage {

    public Guerrier() {
        this.name = "";
        this.lifePoint = 5;
        this.attackPower = 5;
        this.weapon = new Weapon("épée en bois", 1);
        this.shield = null;
    }

    public Guerrier(String name) {
        this();
        this.name = name;
    }

    public Guerrier(String name, int lifePoint, int attackPower) {
        this(name);

        this.lifePoint = lifePoint;
        this.attackPower = attackPower;
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

    @Override
    public boolean isValidStartLifePoint(int lifePoint) {
        return lifePoint >= 5 && lifePoint <= 10;
    }

    @Override
    public boolean isValidStartAttackPoint(int attackPoint) {
        return attackPoint >= 5 && attackPoint <= 10;
    }

}
