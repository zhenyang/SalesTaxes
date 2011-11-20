package salesTax;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class TaxTest {
    @Test
    public void test_should_rounded_up_to_nearest_0point05() throws Exception {
        Tax roundedTax = new Tax(1.499);
        Tax tax = new Tax(1.5);
        assertEquals(tax,roundedTax);
    }
}
