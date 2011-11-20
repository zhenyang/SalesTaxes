package salesTax;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


public class ConsoleMainTest {

    private ConsoleMain consoleMain;

    @Before
    public void setUp() throws Exception {
        consoleMain = new ConsoleMain(new Parser());
    }

    @Test
    public void test_should_return_a_main_object() throws Exception {
        assertNotNull(consoleMain);
    }

    @Test
    public void test_should_print_bill_with_tax_give_an_receipt_string() throws Exception {
        String input = "1 book at 12.49";
        String actualBill = consoleMain.generateBill(input);
        String expectedBill="1 book: 12.49\n" +
                "Sales Taxes: 0.00\n" +
                "Total: 12.49";
        assertEquals(expectedBill,actualBill);
    }

    @Test
    public void test_should_print_receipt_with_sales_tax_and_total() throws Exception {
        String input = "1 book at 12.49\n" +
                "1 music CD at 14.99\n" +
                "1 chocolate bar at 0.85";
        String expectedBill = "1 book: 12.49\n" +
                "1 music CD: 16.49\n" +
                "1 chocolate bar: 0.85\n" +
                "Sales Taxes: 1.50\n" +
                "Total: 29.83";
        String actualBill = consoleMain.generateBill(input);
        assertEquals(expectedBill, actualBill);
    }
}
