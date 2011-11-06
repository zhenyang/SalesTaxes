package salesTax;

public class Good {
    private String name;
    private double price;
    private boolean imported;

    public Good(String name, double price, boolean imported) throws Exception {
        this.name = name;
        this.price = price;
        this.imported = imported;
        if (price <= 0) throw new Exception();
        modifySequenceOfName();
    }

    private void modifySequenceOfName() {
        if (this.imported) {
            this.name = this.name.replace("imported ", "");
            int insertIndex = this.name.indexOf(" ") + 1;
            this.name = new StringBuffer(this.name).insert(insertIndex, "imported ").toString();
        }
    }

    public double getPriceIncludeTax() {
        return price + getTax();
    }

    public double getTax() {
        double rate = 0;
        if (imported) rate = 0.05;
        try {
            rate += Rate.getRate(name);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return round(price * rate);
    }

    private double round(double value) {
        return Math.ceil(value * 20) / 20;
    }

    public String outputInfor() {
        return name + ": " + String.format("%.2f", getPriceIncludeTax());
    }
}
