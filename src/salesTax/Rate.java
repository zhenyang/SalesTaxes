package salesTax;

import salesTax.exception.GoodNotFoundException;

public enum Rate {
    MUSIC_CD("music CD", 0.1), BOOK("book", 0), CHOCOLATE_BAR("chocolate", 0),
    PILL("pill", 0), PERFUME("perfume", 0.1);

    private String name;
    private double rate;

    Rate(String name, double rate) {

        this.name = name;
        this.rate = rate;
    }

    public static double getRate(String goodName) throws Exception {
        for (Rate rate : Rate.values()) {
            if (goodName.contains(rate.name)) {
                return rate.rate;
            }
        }
        throw new GoodNotFoundException();
    }
}
