package salesTax;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


public class ConsoleMainTest {
    @Test
    public void test_should_return_a_main_object() throws Exception {
        ConsoleMain consoleMain = new ConsoleMain(new Parser());
        assertNotNull(consoleMain);
    }

    @Test
    public void test_should_print_bill_with_tax_give_an_receipt_string() throws Exception {
        ConsoleMain consoleMain = new ConsoleMain(new Parser());
        String bill = consoleMain.generateBill("1 book at 12.49");
        String expectedBill="1 book: 12.49\n" +
                "Sales Taxes: 0.00\n" +
                "Total: 12.49";
        assertEquals(expectedBill,bill);
    }
}
