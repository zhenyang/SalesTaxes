package salesTax;

import java.io.IOException;

public class ConsoleMain {

    private Parser parser;

    public ConsoleMain(Parser parser) {
        this.parser = parser;
    }

    public String generateBill(String receiptString) throws IOException {
        String result = "";
        GoodsList goodsList = parser.parseToList(receiptString);
        for (Good good : goodsList.goodList) {
            result += good.outputInfor() + "\n";
        }
        result += "Sales Taxes: " + String.format("%.2f", goodsList.getTotalTaxes()) + "\n";
        result += "Total: " + String.format("%.2f", goodsList.getTotalPriceIncludeTaxes());
        return result;
    }
}
