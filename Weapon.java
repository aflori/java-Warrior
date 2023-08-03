public class Weapon {
    public String name;
    public int attackLevel;
    public CharacterType ownerType;

    Weapon(String name, int attack, CharacterType owner)
    {
        this.name = name; this.attackLevel = attack; this.ownerType = owner;
    }
}
;