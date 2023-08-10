package Tools.Offense;

public class Weapon extends OffenseTool {

    public Weapon(String name, int attack) {
        super(name, attack);
    }

    public Weapon(Weapon weapon) {
        super(weapon.name, weapon.attackLevel);
    }
}
