package salesTax;

public class Money {
    private static final double EPSILON = 0.00001;
    private double amount;

    public Money(double amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Money money = (Money) o;

        if (Math.abs(money.amount - amount) > EPSILON) return false;

        return true;
    }

    @Override
    public int hashCode() {
        long temp = amount != +0.0d ? Double.doubleToLongBits(amount) : 0L;
        return (int) (temp ^ (temp >>> 32));
    }


    public double getAmount() {
        return amount;
    }
}
