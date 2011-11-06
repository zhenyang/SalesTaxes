package salesTax;

import org.junit.Assert;
import org.junit.Test;

public class GoodsListTest {
    @Test
    public void test_should_return_total_price_including_tax_given_goodslist() throws Exception {
        Good chocolate = new Good("1 imported box of chocolates", 10.00, true);
        Good perfume1 = new Good("1 imported bottle of perfume", 47.50, true);
        GoodsList goodsList = new GoodsList();
        goodsList.add(chocolate).add(perfume1);

        Assert.assertEquals(65.15, goodsList.getTotalPriceIncludeTaxes(), 0.001);

    }

    @Test
    public void test_should_return_total_taxes_given_goodslist() throws Exception {

        Good perfume1 = new Good("1 imported bottle of perfume", 27.99, true);
        Good perfume2 = new Good("1 bottle of perfume ", 18.99, false);
        Good pill = new Good("1 packet of headache pills", 9.75, false);
        Good chocolate = new Good("1 box of imported chocolates", 11.25, true);
        GoodsList goodsList = new GoodsList();
        goodsList.add(chocolate).add(pill).add(perfume1).add(perfume2);

        Assert.assertEquals(6.70, goodsList.getTotalTaxes(), 0.001);
        Assert.assertEquals(74.68, goodsList.getTotalPriceIncludeTaxes(), 0.001);

    }

}
