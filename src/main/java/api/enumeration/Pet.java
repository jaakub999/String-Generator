package api.enumeration;

public enum Pet {
    CAT("Cat", "Kot"),
    DOG("Dog", "Pies");

    private final String eng;
    private final String pl;

    private Pet(String eng, String pl) {
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