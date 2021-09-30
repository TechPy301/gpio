import View.gpio_config_gui;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class gpio_gui extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        gpio_config_gui gpio_config_gui = new gpio_config_gui();
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(new Scene(gpio_config_gui.getMain_pane(), 1024, 768));
        primaryStage.show();



    }
}
