package api.enumeration;

public enum Person {
    NAME("Name", "Imię"),
    SURNAME("Surname", "Nazwisko"),
    NICKNAME("Nickname", "Pseudonim"),
    HERO("Superhero", "Superbohater");

    private final String eng;
    private final String pl;

    private Person(String eng, String pl) {
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