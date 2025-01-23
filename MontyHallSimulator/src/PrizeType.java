public enum PrizeType {
    STANDARD_GOAT1("STANDARD_GOAT1"),
    STANDARD_GOAT2("STANDARD_GOAT2"),
    CAR("CAR"),
    GOOD_GOAT("GOOD_GOAT"),
    BAD_GOAD("BAD_GOAD");

    private String name;

    private PrizeType(String name)
    {
        this.name = name;
    }
}
