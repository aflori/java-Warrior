package GameElement.CaseElement;

import Character.*;
import MenuClass.CaseMenu;
import Tools.Health;

public class PotionCase extends Case{

    Health potion;

    public PotionCase(){
        this.potion = null;
    }
    public PotionCase(Health potion) {
        this.potion = new Health(potion);
    }

    public PotionCase(String potionName, int potionPowerRestored) {
        this.potion = new Health(potionName, potionPowerRestored);
    }


    @Override
    public String toString() {
        return "Case potion";
    }

    @Override
    public void interaction(Personnage playerChoice) {
        if(this.potion==null) {
            System.out.println("Cette case ne contien rien.");
            return;
        }
        CaseMenu menu = new CaseMenu();
        boolean didChooseToTakeThePotion = menu.askToTakeAPotion(playerChoice, this.potion);

        if(didChooseToTakeThePotion) {
            playerChoice.heal(this.potion.getHealthRestored());
            System.out.printf("Tu as maintenant %d PV\n", playerChoice.getLifePoint());
            this.potion = null;
        }
    }
}
