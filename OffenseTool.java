public class OffenseTool {
    public String name;
    public int attackLevel;

    @Override
    public String toString() {
        return this.name;
    }

    OffenseTool(String name, int attack) {
        this.name = name;
        this.attackLevel = attack;
    }
}
