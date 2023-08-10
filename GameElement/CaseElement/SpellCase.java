package GameElement.CaseElement;

import Character.*;
import MenuClass.CaseMenu;
import Tools.Offense.Spell;

public class SpellCase extends Case {

    private Spell spellContent;

    public SpellCase() {
        this.spellContent = null;
    }
    public SpellCase(Spell spell){
        this.spellContent = new Spell(spell);
    }
    public SpellCase(String name, int attackValue){
        this.spellContent = new Spell(name, attackValue);
    }


    @Override
    public String toString() {
        return "Case sort";
    }

    @Override
    public void interaction(Personnage playerChoice) {
        if (playerChoice instanceof Guerrier || this.spellContent == null) {
            System.out.println("La case ne contien rien.");
            return;
        }
        CaseMenu menu = new CaseMenu();
        boolean didTakeSpell = menu.askToTakeSpell((Magicien) playerChoice, this.spellContent);

        if(didTakeSpell) {
            System.out.printf("Tu viens d'oublier le sort %s.\n", playerChoice.getWeaponName());
            System.out.printf("Tu viens d'apprendre le sort %s.\n", this.spellContent);
            playerChoice.setNewWeapon(spellContent);
            spellContent = null;

        }
    }
}
