package salesTax;

import java.util.ArrayList;

public class GoodsList {
    ArrayList<Good> goodList = new ArrayList<Good>();

    public GoodsList add(Good good) {
        this.goodList.add(good);
        return this;
    }

    public Tax getTotalTaxes() {
        double totalTaxes = 0;

        for (Good good : goodList) {
            totalTaxes += good.getTax().getAmount();
        }
        return new Tax(totalTaxes);
    }

    public Money getTotalPriceIncludeTaxes() {
        double totalPrice = 0;

        for (Good good : goodList) {
            totalPrice += good.getPriceIncludeTax().getAmount();
        }
        return new Money(totalPrice);
    }
}
