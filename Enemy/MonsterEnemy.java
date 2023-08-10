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
        if (lifePoint < 0) lifePoint = 0;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public String getName() {
        return name;
    }

    public int getLifePoint() {
        return lifePoint;
    }

    public String toString() {
        return name;
    }

}
