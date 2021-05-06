package api;

import api.enumeration.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    public final Stage stage;
    private char language;
    private final ObservableList<String> list;
    private final Service service;

    @FXML private RadioButton personRadio;
    @FXML private RadioButton companyRadio;
    @FXML private RadioButton internetRadio;
    @FXML private RadioButton commerceRadio;
    @FXML private RadioButton otherRadio;
    @FXML private Button generateButton;
    @FXML private Button langButton;
    @FXML private TextField text;
    @FXML private ComboBox<String> box;
    @FXML private Label l1;
    @FXML private Label l2;

    public Controller(Stage stage) {
        this.stage = stage;
        language = 'E';
        list = FXCollections.observableArrayList();
        service = new Service();

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui.fxml"));
            loader.setController(this);
            stage.setScene(new Scene(loader.load()));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setLanguage();

        ToggleGroup group = new ToggleGroup();
        personRadio.setToggleGroup(group);
        companyRadio.setToggleGroup(group);
        internetRadio.setToggleGroup(group);
        commerceRadio.setToggleGroup(group);
        otherRadio.setToggleGroup(group);

        list.add(Person.NAME.getEng());
        list.add(Person.SURNAME.getEng());
        list.add(Person.NICKNAME.getEng());
        list.add(Person.HERO.getEng());

        box.setItems(list);

        personRadio.setOnAction(event -> {
            list.clear();

            if (language == 'E') {
                list.add(Person.NAME.getEng());
                list.add(Person.SURNAME.getEng());
                list.add(Person.NICKNAME.getEng());
                list.add(Person.HERO.getEng());
            }

            else {
                list.add(Person.NAME.getPl());
                list.add(Person.SURNAME.getPl());
                list.add(Person.NICKNAME.getPl());
                list.add(Person.HERO.getPl());
            }

            box.setItems(list);
        });

        companyRadio.setOnAction(event -> {
            list.clear();

            if (language == 'E') {
                list.add(Company.NAME.getEng());
                list.add(Company.PHRASE.getEng());
            }

            else {
                list.add(Company.NAME.getPl());
                list.add(Company.PHRASE.getPl());
            }

            box.setItems(list);
        });

        internetRadio.setOnAction(event -> {
            list.clear();

            if (language == 'E') {
                list.add(Internet.DOMAIN.getEng());
                list.add(Internet.EMAIL.getEng());
                list.add(Internet.MAC.getEng());
                list.add(Internet.IPV4.getEng());
                list.add(Internet.IPV6.getEng());
            }

            else {
                list.add(Internet.DOMAIN.getPl());
                list.add(Internet.EMAIL.getPl());
                list.add(Internet.MAC.getPl());
                list.add(Internet.IPV4.getPl());
                list.add(Internet.IPV6.getPl());
            }

            box.setItems(list);
        });

        commerceRadio.setOnAction(event -> {
            list.clear();

            if (language == 'E') {
                list.add(Commerce.PRODUCT.getEng());
                list.add(Commerce.CODE.getEng());
            }

            else {
                list.add(Commerce.PRODUCT.getPl());
                list.add(Commerce.CODE.getPl());
            }

            box.setItems(list);
        });

        otherRadio.setOnAction(event -> {
            list.clear();

            if (language == 'E') {
                list.add(Other.BOOK.getEng());
                list.add(Other.PHONE.getEng());
                list.add(Other.TEAM.getEng());
                list.add(Other.ID.getEng());
            }

            else {
                list.add(Other.BOOK.getPl());
                list.add(Other.PHONE.getPl());
                list.add(Other.TEAM.getPl());
                list.add(Other.ID.getPl());
            }

            box.setItems(list);
        });

        langButton.setOnAction(event -> switchLanguage());
        generateButton.setOnAction(event -> generate());
    }

    private void setLanguage() {
        if (language == 'E') {
            personRadio.setText("Person");
            companyRadio.setText("Company");
            internetRadio.setText("Internet");
            commerceRadio.setText("Commerce");
            otherRadio.setText("Other");
            generateButton.setText("Generate");
            l1.setText("1st category");
            l2.setText("2nd category");
        }

        else {
            personRadio.setText("Osoba");
            companyRadio.setText("Firma");
            internetRadio.setText("Internet");
            commerceRadio.setText("Handel");
            otherRadio.setText("Inne");
            generateButton.setText("Generuj");
            l1.setText("1. kategoria");
            l2.setText("2. kategoria");
        }
    }

    private void switchLanguage() {
        service.switchLanguage();

        if (language == 'E')
            language = 'P';

        else
            language = 'E';

        setLanguage();
    }

    private void generate() {
        if (!box.getSelectionModel().isEmpty()) {
            String str = null;

            if (personRadio.isSelected()) {
                String person = box.getSelectionModel().getSelectedItem();
                str = service.generatePerson(person);
            }

            else if (companyRadio.isSelected()) {
                String company = box.getSelectionModel().getSelectedItem();
                str = service.generateCompany(company);
            }

            else if (internetRadio.isSelected()) {
                String internet = box.getSelectionModel().getSelectedItem();
                str = service.generateInternet(internet);
            }

            else if (commerceRadio.isSelected()) {
                String commerce = box.getSelectionModel().getSelectedItem();
                str = service.generateCommerce(commerce);
            }

            else if (otherRadio.isSelected()) {
                String other = box.getSelectionModel().getSelectedItem();
                str = service.generateOther(other);
            }

            text.setText(str);
        }
    }
}
