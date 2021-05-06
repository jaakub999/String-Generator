package api.enumeration;

public enum Other {
    PHONE("Phone number", "Numer telefonu"),
    TEAM("Team", "Drużyna"),
    BOOK("Book title", "Tytuł książki"),
    ID("ID", "ID");

    private final String eng;
    private final String pl;

    private Other(String eng, String pl) {
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
