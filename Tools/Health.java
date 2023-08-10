package Tools;

public class Health {

    private String name;
    private int healthRestored;

    public Health() {
        this.name = "";
        this.healthRestored = 0;
    }
    public Health(Health potionCreated) {
        this(potionCreated.name, potionCreated.healthRestored);
    }
    public Health(String name, int PVrestored) {
        this.name = name;
        this.healthRestored = PVrestored;
    }

    @Override
    public String toString() { return this.name;}

    public String getName() {
        return name;
    }

    public int getHealthRestored() {
        return healthRestored;
    }



}
