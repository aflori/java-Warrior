package Character;

import Tools.Defense.DefenseTool;
import Tools.Offense.OffenseTool;

public abstract class Personnage {
    protected String name;
    protected int lifePoint;
    protected int attackPower;

    protected OffenseTool weapon;
    protected DefenseTool shield;

    @Override
    public String toString() {
        return this.name;
    }

    public abstract void printCharacterInformation();

    public String getName() {
        return this.name;
    }

    public int getLifePoint() {
        return this.lifePoint;
    }

    public int getAttackPower() {
        return this.attackPower;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public void setLifePoint(int newPV) {
        this.lifePoint = newPV;
    }

    public void setAttackPower(int newAP) {
        this.attackPower = newAP;
    }

    public String getWeaponName() {
        return this.weapon.getName();
    }

    public void renameWeapon(String newName) {
        this.weapon.setName(newName);
    }

    public abstract boolean isValidStartLifePoint(int lifePoint);

    public abstract boolean isValidStartAttackPoint(int attackPoint);

    //must choose the right subclass
    public void setNewWeapon(OffenseTool tool) {
        this.weapon = tool;
    }

    public abstract void heal(int healthRestored);

    public void takeDamage(int damageTaken) {
        this.lifePoint -= damageTaken;
        if (this.lifePoint < 0) this.lifePoint = 0;
    }

    public abstract String getClassName();
}
