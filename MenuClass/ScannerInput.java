package MenuClass;

import java.util.Scanner;

public class ScannerInput {

    private final Scanner consoleScanner;

    private static ScannerInput uniqueElement;
    private ScannerInput()
    {
        this.consoleScanner = new Scanner(System.in);
    }

    public static Scanner getSingletonClass()
    {
        if(uniqueElement == null)
        {
            uniqueElement = new ScannerInput();
        }

        return uniqueElement.consoleScanner;
    }

}
