public abstract class DefenseTool {
    public String name;

    DefenseTool(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}

