package GameElement.CaseElement;

import Character.*;
import Enemy.MonsterEnemy;

public class EnemyCase extends Case{

    private final String nameOfEnemy;

    public EnemyCase(){
        this.nameOfEnemy = "";
    }
    public EnemyCase(String name) {
        this.nameOfEnemy = name;
    }
    @Override
    public String toString() {
        return "Case ennemi";
    }

    @Override
    public void interaction(Personnage playerChoice) {
        System.out.printf("Un %s est présent sur la case...\nUn combat devrait s'engager...\n", this.nameOfEnemy);
    }
}
