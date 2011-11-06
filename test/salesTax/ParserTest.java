package salesTax;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class ParserTest {
    @Test
    public void test_should_parse_receipt_with_one_good_to_goods_list() throws Exception {
        Parser parser = new Parser();
        GoodsList goodsList = parser.parseToList("1 book at 12.49");
        assertEquals("1 book: 12.49", goodsList.goodList.get(0).outputInfor());
    }

    @Test
    public void test_should_parse_receipt_with_multiple_goods_to_goods_list() throws Exception {
        Parser parser = new Parser();
        GoodsList goodsList = parser.parseToList("1 imported bottle of perfume at 27.99\n" +
                "1 bottle of perfume at 18.99\n" +
                "1 packet of headache pills at 9.75\n" +
                "1 box of imported chocolates at 11.25");
        assertEquals("1 imported bottle of perfume: 32.19", goodsList.goodList.get(0).outputInfor());
        assertEquals("1 bottle of perfume: 20.89", goodsList.goodList.get(1).outputInfor());
        assertEquals("1 packet of headache pills: 9.75", goodsList.goodList.get(2).outputInfor());
        assertEquals("1 imported box of chocolates: 11.85", goodsList.goodList.get(3).outputInfor());
    }
}
