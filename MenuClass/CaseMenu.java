package MenuClass;

import Tools.Health;
import Tools.Offense.*;
import Tools.Defense.*;
import Character.*;
import org.jetbrains.annotations.NotNull;

import java.util.Scanner;

public class CaseMenu {

    private final Scanner consoleInput;

    public CaseMenu() {
        this.consoleInput = ScannerInput.getSingletonClass().consoleScanner;
    }

    //return value: if yes or not, wizard has taken the available spell
    public boolean askToTakeSpell(Magicien playerChoice, @NotNull Spell spell) {

        System.out.println("Tu arrives sur une case bonus.");
        System.out.println("Il y a le sort " + spell.getName() + ".");
        System.out.println("Il a une valeur d'attaque de " + spell.getAttackLevel() + ".");

        System.out.println("Doit-on la prendre ([Y]es/[n]o)?");

        return this.getYesNoUserAnswer();
    }

    public boolean askToTakeAWeapon(Guerrier playerChoice, @NotNull Weapon weapon) {

        System.out.println("Tu arrives sur une case bonus.");
        System.out.println("Il y a sur le sol une " + weapon.getName() + ".");
        System.out.println("Qui a une valeur d'attaque de " + weapon.getAttackLevel() + ".");

        System.out.println("Doit-on la prendre ([Y]es/[n]o)?");

        return this.getYesNoUserAnswer();
    }

    public boolean askToTakeAPotion(@NotNull Personnage playerCharacter, @NotNull Health potion) {
        System.out.printf("Tu as %d PV et tu peut utiliser une %s qui soigne %d PV. L'utiliser?\n", playerCharacter.getLifePoint(), potion.getName(), potion.getHealthRestored());
        return this.getYesNoUserAnswer();
    }

    private boolean getYesNoUserAnswer() {
        String userInput;
        do {
            userInput = consoleInput.nextLine().toUpperCase();
        } while (
                !(      userInput.equals("Y") ||
                        userInput.equals("YES") ||
                        userInput.isEmpty() ||
                        userInput.equals("N") ||
                        userInput.equals("NON")
                )
        );

        return userInput.equals("Y") || userInput.equals("YES") || userInput.isEmpty();
    }
}
