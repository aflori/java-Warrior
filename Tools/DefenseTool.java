package Tools;

public abstract class DefenseTool {
    public String name;

    public DefenseTool(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}

