public enum PrizeTypes {
    STANDARD_GOAT1("STANDARD_GOAT1"),
    STANDARD_GOAT2("STANDARD_GOAT2"),
    CAR("CAR"),
    GOOD_GOAT("GOOD_GOAT"),
    BAD_GOAD("BAD_GOAD");

    private String name;

    private PrizeTypes(String name)
    {
        this.name = name;
    }
}
