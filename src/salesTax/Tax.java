package salesTax;

public class Tax extends Money{
    public Tax(double amount) {
        super(round(amount));
    }

    private static double round(double amount) {
        return Math.ceil(amount * 20) / 20;
    }
}
