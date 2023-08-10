package Tools.Offense;

public class Spell extends OffenseTool {

    public Spell(String name, int attack) {
        super(name, attack);
    }

    public Spell(Spell spellToCopy) {
        super(spellToCopy.name, spellToCopy.attackLevel);
    }
}
