package salesTax.exception;

public class GoodNotFoundException extends Exception{
    @Override
    public String getMessage() {
        return "Good not found!";
    }
}
