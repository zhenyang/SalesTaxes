package salesTax;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GoodTest {

    @Test
    public void test_new_good_should_return_a_good_object() throws Exception {
        Good good = new Good("book", 3.00, Rate.NONE_IMPORTED_TAX, Rate.NONE_BASIC_TAX);

        assertEquals(Good.class, good.getClass());
    }

    @Test(expected = Exception.class)
    public void test_new_good_with_negative_price_should_throw_exception() throws Exception {
        new Good("book", -3.00, Rate.NONE_IMPORTED_TAX, Rate.NONE_BASIC_TAX);
    }

    @Test(expected = Exception.class)
    public void test_new_good_with_zero_price_should_throw_exception() throws Exception {
        new Good("book", 0.00, Rate.NONE_IMPORTED_TAX, Rate.NONE_BASIC_TAX);
    }

    @Test
    public void test_should_return_0_tax_object_given_a_book_price_is_12point49() throws Exception {
        Good good = new Good("book", 12.49, Rate.NONE_IMPORTED_TAX, Rate.NONE_BASIC_TAX);
        assertEquals(good.getTax(), new Tax(0.0));
    }

    @Test
    public void test_should_get_price_include_tax_is_12point49_given_a_book_price_is_12point49() throws Exception {
        Good good = new Good("book", 12.49, Rate.NONE_IMPORTED_TAX, Rate.NONE_BASIC_TAX);
        assertEquals(good.getPriceIncludeTax(), new Money(12.49));
    }

    @Test
    public void test_should_get_tax_is_0_given_given_a_music_CD_price_is_14p99() throws Exception {
        Good good = new Good("music CD", 14.99, Rate.NONE_IMPORTED_TAX, Rate.BASIC_TAX);
        assertEquals(good.getTax(), new Tax(1.50));
    }

    @Test
    public void test_should_get_price_include_tax_is_16p49_given_a_music_CD_price_is_14p99() throws Exception {
        Good good = new Good("music CD", 14.99, Rate.NONE_IMPORTED_TAX, Rate.BASIC_TAX);
        assertEquals(good.getPriceIncludeTax(), new Money(16.49));
    }

    @Test
    public void test_should_get_price_include_tax_given_imported_box_of_perfume_at_47p50() throws Exception {
        Good good = new Good("1 imported bottle of perfume", 47.50, Rate.IMPORTED_TAX, Rate.BASIC_TAX);
        assertEquals(good.getPriceIncludeTax(), new Money(54.65));
    }

    @Test
    public void test_should_output_information_given_imported_box_of_perfume_at_47p50() throws Exception {
        Good good = new Good("1 imported bottle of perfume", 47.50, Rate.IMPORTED_TAX, Rate.BASIC_TAX);
        assertEquals("1 imported bottle of perfume: 54.65", good.outputInfor());
    }

}
