package api.enumeration;

public enum Internet {
    DOMAIN("Domain", "Domena"),
    EMAIL("Email address", "Adres Email"),
    IPV4("IPv4 Address", "Adres IPv4"),
    IPV6("IPv6 Address", "Adres IPv6"),
    MAC("MAC Address", "Adres MAC");

    private final String eng;
    private final String pl;

    private Internet(String eng, String pl) {
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
