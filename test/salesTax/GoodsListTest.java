package salesTax;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GoodsListTest {
    @Test
    public void test_should_return_total_price_including_tax_and_total_tax_given_goodslist() throws Exception {
        Good chocolate = createGood("chocolate", 10, 1);
        Good perfume1 = createGood("1 imported bottle of perfume", 47, 1);
        GoodsList goodsList = new GoodsList();
        goodsList.add(chocolate).add(perfume1);

        assertEquals(goodsList.getTotalPriceIncludeTaxes(), new Money(59));
        assertEquals(goodsList.getTotalTaxes(), new Tax(2));

    }

    private Good createGood(String name, double price, double taxAmount) {
        Good good = mock(Good.class);
        Tax tax = mock(Tax.class);
        when(tax.getAmount()).thenReturn(taxAmount);
        Money priceIncludeTax = mock(Money.class);
        when(priceIncludeTax.getAmount()).thenReturn(price+taxAmount);
        when(good.getTax()).thenReturn(tax);
        when(good.getPriceIncludeTax()).thenReturn(priceIncludeTax);
        return good;
    }
}
