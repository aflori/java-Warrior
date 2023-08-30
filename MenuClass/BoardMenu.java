package MenuClass;

import Exception.*;


import java.util.Scanner;

public class BoardMenu {

    private final Scanner consoleInput;


    public BoardMenu() {
        this.consoleInput = ScannerInput.getSingletonClass();
        this.clearScannerBuffer();
    }

    private void clearScannerBuffer() {
        while (!consoleInput.nextLine().isEmpty()) {
            //The nextLine do its job
        }
    }

    public void waitInputToPlay() throws FinDePartie {
        System.out.print("Appuis sur entrer pour jouer ou entre \"q\" ou \"quit\" pour quitter la partie.\n");
        String inputLine = consoleInput.nextLine().toLowerCase();

        if (inputLine.equals("q") || inputLine.equals("quit")) {
            throw new FinDePartie();
        }

    }

}
