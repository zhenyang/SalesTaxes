package salesTax;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class ReceiptGeneratorTest {

    private ReceiptGenerator receiptGenerator;

    @Before
    public void setUp() throws Exception {
        receiptGenerator = new ReceiptGenerator();
    }

    @Test
    public void test_should_print_receipt_with_sales_tax_and_total() throws Exception {
        String input = "1 book at 12.49\n" +
                "1 music CD at 14.99\n" +
                "1 chocolate bar at 0.85";
        String expectedOutput = "1 book: 12.49\n" +
                "1 music CD: 16.49\n" +
                "1 chocolate bar: 0.85\n" +
                "Sales Taxes: 1.50\n" +
                "Total: 29.83";
        String actualOutput = receiptGenerator.generate(input);
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void test_should_print_receipt_with_sales_tax_and_total_2() throws Exception {
        String input = "1 imported box of chocolates at 10.00\n" +
                "1 imported bottle of perfume at 47.50";
        String expectedOutput = "1 imported box of chocolates: 10.50\n" +
                "1 imported bottle of perfume: 54.65\n" +
                "Sales Taxes: 7.65\n" +
                "Total: 65.15";
        String actualOutput = receiptGenerator.generate(input);
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void test_should_print_receipt_with_sales_tax_and_total_3() throws Exception {
        String input = "1 imported bottle of perfume at 27.99\n" +
                "1 bottle of perfume at 18.99\n" +
                "1 packet of headache pills at 9.75\n" +
                "1 box of imported chocolates at 11.25";
        String expectedOutput = "1 imported bottle of perfume: 32.19\n" +
                "1 bottle of perfume: 20.89\n" +
                "1 packet of headache pills: 9.75\n" +
                "1 imported box of chocolates: 11.85\n" +
                "Sales Taxes: 6.70\n" +
                "Total: 74.68";
        String actualOutput = receiptGenerator.generate(input);
        assertEquals(expectedOutput, actualOutput);
    }
}
