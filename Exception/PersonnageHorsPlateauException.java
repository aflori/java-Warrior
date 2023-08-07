package Exception;

public class PersonnageHorsPlateauException extends Exception{

    public PersonnageHorsPlateauException()
    {
        super("La case maximale du plateau a été franchi");
    }
}
