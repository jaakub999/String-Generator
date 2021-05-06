package api;

import api.enumeration.*;
import com.github.javafaker.Faker;
import java.util.Locale;

public class Service {
    private Faker faker;
    private Locale locale;

    public Service() {
        locale = new Locale("en");
        faker = new Faker(locale);
    }

    public void switchLanguage() {
        Locale lang = null;

        if (locale.getLanguage().equals("en"))
            lang = new Locale("pl");

        else
            lang = new Locale("en");

        setLocale(lang);
        faker = new Faker(locale);
    }

    public String generatePerson(String person) {
        String result = null;

        if (person.equals(Person.NAME.getEng()) || person.equals(Person.NAME.getPl()))
            result = faker.name().firstName();

        else if (person.equals(Person.SURNAME.getEng()) || person.equals(Person.SURNAME.getPl()))
            result = faker.name().lastName();

        else if (person.equals(Person.NICKNAME.getEng()) || person.equals(Person.NICKNAME.getPl()))
            result = faker.name().username();

        else if (person.equals(Person.HERO.getEng()) || person.equals(Person.HERO.getPl()))
            result = faker.superhero().name();

        return result;
    }

    public String generateInternet(String internet) {
        String result = null;

        if (internet.equals(Internet.MAC.getEng()) || internet.equals(Internet.MAC.getPl()))
            result = faker.internet().macAddress();

        else if (internet.equals(Internet.DOMAIN.getEng()) || internet.equals(Internet.DOMAIN.getPl()))
            result = faker.internet().domainName();

        else if (internet.equals(Internet.IPV4.getEng()) || internet.equals(Internet.IPV4.getPl()))
            result = faker.internet().ipV4Address();

        else if (internet.equals(Internet.IPV6.getEng()) || internet.equals(Internet.IPV6.getPl()))
            result = faker.internet().ipV6Address();

        else if (internet.equals(Internet.EMAIL.getEng()) || internet.equals(Internet.EMAIL.getPl()))
            result = faker.internet().emailAddress();

        return result;
    }

    public String generateCompany(String company) {
        String result = null;

        if (company.equals(Company.NAME.getEng()) || company.equals(Company.NAME.getPl()))
            result = faker.company().name();

        else if (company.equals(Company.PHRASE.getEng()) || company.equals(Company.PHRASE.getPl()))
            result = faker.company().catchPhrase();

        return result;
    }

    public String generateCommerce(String commerce) {
        String result = null;

        if (commerce.equals(Commerce.PRODUCT.getEng()) || commerce.equals(Commerce.PRODUCT.getPl()))
            result = faker.commerce().productName();

        else if (commerce.equals(Commerce.CODE.getEng()) || commerce.equals(Commerce.CODE.getPl()))
            result = faker.commerce().promotionCode();

        return result;
    }

    public String generateOther(String other) {
        String result = null;

        if (other.equals(Other.PHONE.getEng()) || other.equals(Other.PHONE.getPl()))
            result = faker.phoneNumber().phoneNumber();

        else if (other.equals(Other.BOOK.getEng()) || other.equals(Other.BOOK.getPl()))
            result = faker.book().title();

        else if (other.equals(Other.TEAM.getEng()) || other.equals(Other.TEAM.getPl()))
            result = faker.team().name();

        else if (other.equals(Other.ID.getEng()) || other.equals(Other.ID.getPl()))
            result = faker.idNumber().invalid();

        return result;
    }

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }
}