package Character;

import Tools.Offense.Spell;

public class Magicien extends Personnage {


    public Magicien() {
        this.name = "";
        this.lifePoint = 3;
        this.attackPower = 8;
        this.weapon = new Spell("small fireball", 1);
        this.shield = null;
    }

    public Magicien(String name) {
        this();
        this.name = name;
    }

    public Magicien(String name, int lifePoint, int attackPower) {
        this(name);

        this.lifePoint = lifePoint;
        this.attackPower = attackPower;
    }


    @Override
    public void printCharacterInformation() {
        System.out.printf("Le magicien s'appelle %s.\n", this.name);
        System.out.printf("Le magicien a %d PV et %d point de force.\n", this.lifePoint, this.attackPower);
        System.out.printf("Le magicien possède le sort %s.\n", this.weapon.getName());
        if (this.shield == null) {
            System.out.print("Le magicien n'a pas de philtre.\n");
        } else {
            System.out.printf("Le magicien a un philtre de %s.\n", this.shield.getName());
        }
    }

    @Override
    public boolean isValidStartLifePoint(int lifePoint) {
        return lifePoint >= 3 && lifePoint <= 6;
    }

    @Override
    public boolean isValidStartAttackPoint(int attackPoint) {
        return attackPoint >= 8 && attackPoint <= 15;
    }

    @Override
    public void heal(int healthRestored) {
        this.lifePoint += healthRestored;
        if (this.lifePoint > 6) this.lifePoint = 6;
    }

    @Override
    public String getClassName() {
        return "magicien";
    }
}
