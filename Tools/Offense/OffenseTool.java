package Tools.Offense;

public abstract class OffenseTool {
    protected String name;
    protected int attackLevel;

    @Override
    public String toString() {
        return this.name;
    }

    public OffenseTool(String name, int attack) {
        this.name = name;
        this.attackLevel = attack;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAttackLevel(){ return this.attackLevel; }
}
