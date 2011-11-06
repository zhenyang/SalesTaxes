package salesTax;

import java.io.IOException;

public class ReceiptGenerator {

    private Parser parser;

    public ReceiptGenerator() {
        parser = new Parser();
    }

    public String generate(String input) throws IOException {
        GoodsList goodsList = parser.parseToList(input);
        String output = "";
        for (Good good : goodsList.goodList) {
            output += good.outputInfor() + "\n";
        }
        output += "Sales Taxes: " + String.format("%.2f",goodsList.getTotalTaxes()) + "\n";
        output += "Total: " + String.format("%.2f",goodsList.getTotalPriceIncludeTaxes());
        return output;
    }
}
