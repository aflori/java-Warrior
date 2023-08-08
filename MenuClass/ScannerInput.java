package MenuClass;

import java.util.Scanner;

public class ScannerInput {

    public final Scanner consoleScanner;

    private static ScannerInput uniqueElement;
    private ScannerInput()
    {
        this.consoleScanner = new Scanner(System.in);
    }

    public static ScannerInput getSingletonClass()
    {
        if(uniqueElement == null)
        {
            uniqueElement = new ScannerInput();
        }

        return uniqueElement;
    }

}
