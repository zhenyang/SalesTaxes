package salesTax;

import org.junit.Assert;
import org.junit.Test;
import salesTax.exception.GoodNotFoundException;

import static org.junit.Assert.*;

public class RateTest {
    @Test
    public void test_should_get_rate_given_good_name() throws Exception {
        assertEquals(0.1, Rate.getRate("music CD"), 0.001);
        assertEquals(0, Rate.getRate("book"), 0.001);
        assertEquals(0, Rate.getRate("1 imported box of chocolates"), 0.001);
        assertEquals(0.1,Rate.getRate("1 imported bottle of perfume"),0.001);
        assertEquals(0,Rate.getRate("1 packet of headache pills"),0.001);
    }

    @Test(expected = GoodNotFoundException.class)
    public void test_should_throw_exception_given_not_a_good_name() throws Exception {
         Rate.getRate("not a good name");
    }
}

