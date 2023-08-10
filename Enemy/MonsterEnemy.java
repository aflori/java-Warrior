package Enemy;

public abstract class MonsterEnemy {

    protected String name;
    protected int attackPower;
    protected int lifePoint;

    public boolean isAlive() {
        return lifePoint > 0;
    }

    public void takeDamage(int damageTaken) {
        lifePoint -= damageTaken;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public String getName() {
        return name;
    }
    public String toString() {
        return name;
    }

}
