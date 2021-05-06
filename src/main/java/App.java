import api.Controller;
import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Stage stage = new Stage();
        stage.setTitle("Generator");
        Controller controller = new Controller(stage);
        controller.stage.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
