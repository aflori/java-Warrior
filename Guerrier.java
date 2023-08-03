
public class Guerrier extends Personnage {

    Guerrier()
    {
        this.name = "";
        this.lifePoint = 5;
        this.attackPower = 5;
        this.weapon = new Weapon("wooden sword", 1, CharacterType.WARRIOR);
        this.shield = null;
    }
    Guerrier (String name)
    {
        this.name = name;
        this.lifePoint = 5;
        this.attackPower = 5;
        this.weapon = new Weapon("wooden sword", 1, CharacterType.WARRIOR);
        this.shield = null;
    }
    Guerrier(String Name, int lifePoint, int attackPower) {
        if(lifePoint<5 || lifePoint>10) System.out.printf("%d est une valeur de points de vie invalide pour un magicien\n", lifePoint);
        if(attackPower<5 || attackPower>10) System.out.printf("%d est une valeur d'attaque invalide pour un magicien\n", attackPower);

        this.name=Name;
        this.lifePoint=lifePoint;
        this.attackPower=attackPower;
        this.weapon = new Weapon("wooden sword", 1, CharacterType.WARRIOR);
        this.shield = null;
    }

    public void setLifePoint(int newPV)
    {
        if(newPV<5)
        {
            System.err.println("les points de vie d'un guerrier doivent être d'au moins 5.");
            return ;
        }
        if (newPV>10)
        {
            System.err.println("les points de vie d'un guerrier ne peuvent pas être supérieur à 10.");
            return ;
        }
        super.setLifePoint(newPV);
    }
    @Override
    public void setAttackPower(int newAtk)
    {
        if(newAtk<5)
        {
            System.err.println("les points d'attaque d'un guerrier doivent être d'au moins 5.");
            return ;
        }
        if (newAtk>10)
        {
            System.err.println("les points de vie d'un guerrier ne peuvent pas être supérieur à 10.");
            return ;
        }
        super.setAttackPower(newAtk);
    }

    @Override
    public void printCharacterInformation() {
        System.out.printf("Le guerrier s'appel %s.\n", this.name);
        System.out.printf("Le guerrier a %d PV et %d point de force.\n", this.lifePoint, this.attackPower);
        System.out.printf("Le guerrier a possède l'arme %s.\n", this.weapon.name);
        if(this.shield == null)
        {
            System.out.print("Le guerrier n'a pas de bouclier.\n");
        }
        else
        {
            System.out.printf("Le guerrier se protège avec %s.\n", this.shield.name);
        }
    }
}
