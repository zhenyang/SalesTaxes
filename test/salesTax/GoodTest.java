package salesTax;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GoodTest {

    @Test
    public void test_new_good_should_return_a_good_object() throws Exception {
        Good good = new Good("book", 3.00, false);

        assertEquals(Good.class, good.getClass());
    }

    @Test(expected = Exception.class)
    public void test_new_good_with_negative_price_should_throw_exception() throws Exception {
        new Good("book", -3.00, false);
    }

    @Test(expected = Exception.class)
    public void test_new_good_with_zero_price_should_throw_exception() throws Exception {
        new Good("book", 0.00, false);
    }

    @Test
    public void test_should_get_tax_is_0_given_a_book_price_is_12point49() throws Exception {
        Good good = new Good("book", 12.49, false);
        assertEquals(0, good.getTax(), 0.0001);
    }

    @Test
    public void test_should_get_price_include_tax_is_12point49_given_a_book_price_is_12point49() throws Exception {
        Good good = new Good("book", 12.49, false);
        assertEquals(12.49, good.getPriceIncludeTax(), 0.0001);
    }

    @Test
    public void test_should_get_tax_is_0_given_given_a_chocolate_bar_is_0point85() throws Exception {
        Good good = new Good("chocolate", 0.85, false);
        assertEquals(0, good.getTax(), 0.0001);
    }

    @Test
    public void test_should_get_price_include_tax_is_0point85_given_a_chocolate_bar_is_0point85() throws Exception {
        Good good = new Good("chocolate", 0.85, false);
        assertEquals(0.85, good.getPriceIncludeTax(), 0.0001);
    }

    @Test
    public void test_should_get_tax_is_0_given_given_a_music_CD_price_is_14p99() throws Exception {
        Good good = new Good("music CD", 14.99, false);
        assertEquals(1.50, good.getTax(), 0.0001);
    }

    @Test
    public void test_should_get_price_include_tax_is_16p49_given_a_music_CD_price_is_14p99() throws Exception {
        Good good = new Good("music CD", 14.99, false);
        assertEquals(16.49, good.getPriceIncludeTax(), 0.0001);
    }

    @Test
    public void test_should_get_price_include_tax_given_imported_box_of_perfume_at_47p50() throws Exception {
        Good good = new Good("1 imported bottle of perfume", 47.50, true);
        assertEquals(54.65, good.getPriceIncludeTax(), 0.001);
    }

    @Test
    public void test_should_output_information_given_imported_box_of_perfume_at_47p50() throws Exception {
        Good good = new Good("1 imported bottle of perfume", 47.50, true);
        assertEquals(54.65, good.getPriceIncludeTax(), 0.001);
        assertEquals("1 imported bottle of perfume: 54.65", good.outputInfor());
    }

    @Test
    public void test_should_make_imported_just_after_quantity_in_name() throws Exception {
        Good good = new Good("1 box of imported chocolates", 11.25, true);
        assertEquals("1 imported box of chocolates: 11.85", good.outputInfor());
    }

}
