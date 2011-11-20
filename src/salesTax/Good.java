package salesTax;

public class Good {
    private String name;
    private double price;
    private Rate importedTaxRate;
    private Rate basicTaxRate;

    public Good(String name, double price, Rate importedTaxRate, Rate basicTaxRate) throws Exception {
        this.name = name;
        this.price = price;
        this.importedTaxRate = importedTaxRate;
        this.basicTaxRate = basicTaxRate;
        if (price <= 0) throw new Exception();
    }

    public Money getPriceIncludeTax() {
        return new Money(price + getTax().getAmount());
    }

    public Tax getTax() {
        double baseTax = price * basicTaxRate.getRate();
        double importedTax = price * importedTaxRate.getRate();
        return new Tax(baseTax + importedTax);
    }

    public String outputInfor() {
        return name + ": " + String.format("%.2f", getPriceIncludeTax().getAmount());
    }
}
