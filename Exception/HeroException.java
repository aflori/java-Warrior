package Exception;

public class HeroException extends Exception{
    public HeroException(Exception e){
        super(e);
    }
    public HeroException(String str) {
        super(str);
    }
}
