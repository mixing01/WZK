package lab.lab5;

public class TooFewSharesException extends Exception{
    public TooFewSharesException(String errorMessage) {
        super(errorMessage);
    }
}
