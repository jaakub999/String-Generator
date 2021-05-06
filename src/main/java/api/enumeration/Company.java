package api.enumeration;

public enum Company {
    PHRASE("Cathphrase", "Hasło"),
    NAME("Name", "Nazwa");

    private final String eng;
    private final String pl;

    private Company(String eng, String pl) {
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