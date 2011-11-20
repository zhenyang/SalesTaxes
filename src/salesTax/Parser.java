package salesTax;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

public class Parser {

    public GoodsList parseToList(String receipt) throws Exception {
        BufferedReader reader = new BufferedReader(new StringReader(receipt));
        String line;
        GoodsList goodsList = new GoodsList();
        while (null != (line = reader.readLine())) {
            Good good = parseGood(line);
            goodsList.add(good);
        }
        return goodsList;  //To change body of created methods use File | Settings | File Templates.
    }

    public Good parseGood(String receipt) throws Exception {
        String[] strings = receipt.split(" at");
        String name = strings[0];

        double price = Double.parseDouble(strings[1]);
        Rate importedTax = createImportedTax(name);
        Rate basicTax = createBasicTax(name);
        name = rearrangeName(name, importedTax);

        return new Good(name, price, importedTax, basicTax);
    }

    private String rearrangeName(String name, Rate importedTax) {
        if (importedTax == Rate.IMPORTED_TAX) {
            name = name.replace("imported ", "");
            int insertIndex = name.indexOf(" ") + 1;
            name = new StringBuffer(name).insert(insertIndex, "imported ").toString();
        }
        return name;
    }

    private Rate createBasicTax(String name) {
        if (name.contains("book") || name.contains("chocolate") || name.contains("pill")) {
            return Rate.NONE_BASIC_TAX;
        } else {
            return Rate.BASIC_TAX;
        }
    }

    private Rate createImportedTax(String name) {
        if (name.contains("imported")) {
            return Rate.IMPORTED_TAX;
        } else {
            return Rate.NONE_IMPORTED_TAX;
        }
    }
}
