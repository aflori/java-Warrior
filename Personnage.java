

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

    public void setStartLifePoint(int newPV) {
        this.lifePoint = newPV;
    }

    public void setStartAttackPower(int newAP) {
        this.attackPower = newAP;
    }

    public String getWeaponName() {
        return this.weapon.name;
    }

    //    public abstract void setNewWeapon(Weapon newWeapon);
    public void renameWeapon(String newName) {
        this.weapon.name = newName;
    }
}
