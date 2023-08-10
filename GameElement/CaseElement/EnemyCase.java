package GameElement.CaseElement;

import Character.*;
import Enemy.MonsterEnemy;

public class EnemyCase extends Case {

    private MonsterEnemy nameOfEnemy;

    public EnemyCase() {
        this.nameOfEnemy = null;
    }

    public EnemyCase(MonsterEnemy enemy) {
        this.nameOfEnemy = enemy;
    }

    @Override
    public String toString() {
        return "Case ennemi";
    }

    @Override
    public void interaction(Personnage playerChoice) {
        if (this.nameOfEnemy == null) {
            super.interaction(playerChoice);
            return;
        }
        System.out.printf("Un %s est présent sur la case...\n", this.nameOfEnemy);
        System.out.println("Tu l'attaque tant qu'il ne t'a pas repéré!");

        this.nameOfEnemy.takeDamage(playerChoice.getAttackPower());

        System.out.printf("Tu lui inflige %d dégâts. Il lui reste %d PV.\n", playerChoice.getAttackPower(), this.nameOfEnemy.getLifePoint());
        if (this.nameOfEnemy.isAlive()) {
            System.out.println("Pris de colère, il t'attaque!");
            System.out.printf("Il t'inflige %d dégâts.\n", this.nameOfEnemy.getAttackPower());

            playerChoice.takeDamage(this.nameOfEnemy.getAttackPower());
            System.out.printf("Tu n'as plus que %d points de vie...!\n", playerChoice.getLifePoint());

        } else {
            System.out.printf("Félicitations, le %s est mort!\n", this.nameOfEnemy);
            this.nameOfEnemy = null;
        }
    }
}
