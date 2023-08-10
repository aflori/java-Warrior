package MenuClass;

import Tools.Offense.Spell;
import Character.Magicien;

import java.util.Scanner;

public class CaseMenu {

    private final Scanner consoleInput;

    public CaseMenu() {
        this.consoleInput = ScannerInput.getSingletonClass().consoleScanner;
    }

    //return value: if yes or not, wizard has taken the available spell
    public boolean askToTakeSpell(Magicien playerChoice, Spell spell) {

        System.out.println("Tu arrives sur une case bonus.");
        System.out.println("Il y a le sort " + spell.getName() + ".");
        System.out.println("Il a une valeur d'attaque de " + spell.getAttackLevel() + ".");

        System.out.println("Doit-on la prendre ([Y]es/[n]o)?");

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
