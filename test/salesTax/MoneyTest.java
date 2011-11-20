package salesTax;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class MoneyTest {
    @Test
    public void test_new_money_should_return_a_money_object() throws Exception {
        Money money = new Money(10.0);
        assertEquals(Money.class, money.getClass());
        assertEquals(10.0, money.getAmount());
    }

    @Test
    public void test_money_should_equal_with_another_which_has_same_amount() throws Exception {
        Money ten = new Money(10.0);
        Money anotherTen = new Money(10.0);
        assertEquals(ten, anotherTen);
    }
}
