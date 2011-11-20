package salesTax;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

public class Parser {

    public GoodsList parseToList(String receipt) throws IOException {
        BufferedReader reader = new BufferedReader(new StringReader(receipt));
        String line;
        GoodsList goodsList = new GoodsList();
        while (null != (line = reader.readLine())) {
            Good good = parseToGood(line);
            goodsList.add(good);
        }
        return goodsList;  //To change body of created methods use File | Settings | File Templates.
    }

    private Good parseToGood(String receipt) {
        String[] strings = receipt.split(" at");
        String name = strings[0];
        double price = Double.parseDouble(strings[1]);
        boolean imported = name.contains("imported");
        Good good = null;
        try {
            good = new Good(name, price, null, null);
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return good;
    }
}
