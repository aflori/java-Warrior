package GameElement.CaseElement;

import Character.*;
import MenuClass.CaseMenu;
import Tools.Offense.Weapon;

public class WeaponCase extends Case {

    private Weapon weaponContent;

    public WeaponCase() {
        this.weaponContent = null;
    }
    public WeaponCase(Weapon weapon){
        this.weaponContent = new Weapon(weapon);
    }
    public WeaponCase(String name, int attackValue){
        this.weaponContent = new Weapon(name, attackValue);
    }

    @Override
    public String toString() {
        return "Case arme";
    }

    @Override
    public void interaction(Personnage playerChoice) {
        if (playerChoice instanceof Magicien || this.weaponContent == null) {
            System.out.println("La case ne contien rien.");
            return;
        }
        CaseMenu menu = new CaseMenu();
        boolean didTakeSpell = menu.askToTakeAWeapon((Guerrier) playerChoice, this.weaponContent);

        if(didTakeSpell) {
            System.out.printf("Tu viens de jeter une %s.\n", playerChoice.getWeaponName());
            System.out.printf("Tu viens de prendre une %s.\n", this.weaponContent);
            playerChoice.setNewWeapon(weaponContent);
            weaponContent = null;

        }

    }
}

