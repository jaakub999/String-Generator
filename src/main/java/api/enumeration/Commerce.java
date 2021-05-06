package api.enumeration;

public enum Commerce {
    PRODUCT("Product name", "Nazwa produktu"),
    CODE("Promotion code", "Kod promocyjny");

    private final String eng;
    private final String pl;

    private Commerce(String eng, String pl) {
        this.eng = eng;
        this.pl = pl;
    }

    public String getEng() {
        return eng;
    }

    public String getPl() {
        return pl;
    }
}
