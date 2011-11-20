package salesTax;

public enum Rate {
    NONE_BASIC_TAX("noneBasicTax", 0), BASIC_TAX("basicTax", 0.1),
    IMPORTED_TAX("importedTax", 0.05), NONE_IMPORTED_TAX("noneImportedTax", 0);

    private String name;
    private double rate;


    Rate(String name, double rate) {

        this.name = name;
        this.rate = rate;
    }

    public double getRate() {
        return rate;
    }
}
