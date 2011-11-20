package salesTax;

import org.junit.Assert;
import org.junit.Test;
import salesTax.exception.GoodNotFoundException;

import static org.junit.Assert.*;

public class RateTest {
    @Test
    public void test_should_get_correct_rate() throws Exception {
        assertEquals(0.1, Rate.BASIC_TAX.getRate(), 0.001);
        assertEquals(0, Rate.NONE_BASIC_TAX.getRate(), 0.001);
        assertEquals(0.05, Rate.IMPORTED_TAX.getRate(), 0.001);
        assertEquals(0, Rate.NONE_IMPORTED_TAX.getRate(), 0.001);
    }
}

