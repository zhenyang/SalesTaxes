package salesTax;

import java.util.ArrayList;

public class GoodsList {
    ArrayList<Good> goodList = new ArrayList<Good>();

    public GoodsList add(Good good) {
        this.goodList.add(good);
        return this;
    }

    public double getTotalTaxes() {
        double totalTaxes = 0;

        for (Good good : goodList) {
//            totalTaxes += good.getTax();
        }
        return totalTaxes;
    }

    public double getTotalPriceIncludeTaxes() {
        double totalPrice = 0;

        for (Good good : goodList) {
//            totalPrice += good.getPriceIncludeTax();
        }
        return totalPrice;
    }
}
