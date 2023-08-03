
public class Magicien extends Personnage
{

    protected Weapon spell;
    protected Shield philter;

    Magicien()
    {
        this.name = "";
        this.lifePoint = 3;
        this.attackPower = 8;
        this.weapon = new Weapon("simple fireball", 1, CharacterType.MAGICIAN);
        this.shield = null;
    }
    Magicien (String name)
    {
        this.name = name;
        this.lifePoint = 3;
        this.attackPower = 8;
        this.weapon = new Weapon("simple fireball", 1, CharacterType.MAGICIAN);
        this.shield = null;
    }
    Magicien(String Name, int lifePoint, int attackPower)
    {
        if(lifePoint<3 || lifePoint>6) System.out.printf("%d est une valeur de points de vie invalide pour un magicien\n", lifePoint);
        if(attackPower<8 || attackPower>15) System.out.printf("%d est une valeur d'attaque invalide pour un magicien\n", attackPower);

        this.name=Name;
        this.lifePoint=lifePoint;
        this.attackPower=attackPower;
        this.weapon = new Weapon("simple fireball", 1, CharacterType.MAGICIAN);
        this.shield = null;
    }

    @Override
    public void setLifePoint(int newPV)
    {
        if(newPV<3)
        {
            System.err.println("les points de vie d'un magicien doivent être d'au moins 3.");
            return ;
        }
        if (newPV>6)
        {
            System.err.println("les points de vie d'un magicien ne peuvent pas être supérieur à 6.");
            return ;
        }
        super.setLifePoint(newPV);
    }
    @Override
    public void setAttackPower(int newAtk)
    {
        if(newAtk<8)
        {
            System.err.println("les points d'attaque d'un magicien doivent être d'au moins 8.");
            return ;
        }
        if (newAtk>15)
        {
            System.err.println("les points de vie d'un magicien ne peuvent pas être supérieur à 15.");
            return ;
        }
        super.setAttackPower(newAtk);
    }

    @Override
    public void printCharacterInformation() {
        System.out.printf("Le magicien s'appel %s.\n", this.name);
        System.out.printf("Le magicien a %d PV et %d point de force.\n", this.lifePoint, this.attackPower);
        System.out.printf("Le magicien a possède le sort %s.\n", this.weapon.name);
        if(this.shield == null)
        {
            System.out.printf("Le magicien n'a pas de philtre.\n");
        }
        else
        {
            System.out.printf("Le magicien a un philtre de %s.\n", this.philter.name);
        }
    }
}
