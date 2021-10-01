package View;

import Service.GPIO;
import Service.gpio_config_to_code;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;

import java.util.ArrayList;
import java.util.List;

public class gpio_config_gui {

    BorderPane main_pane=new BorderPane();

    List<gpio_config_gui_info> gpio_config_gui_info_list = new ArrayList<>();

    HBox hBox_top = new HBox();
    Label gpio_count_title = new Label("gpio_count:");
    TextField gpio_count_input = new TextField();
    Button add_once = new Button("add");


    VBox vbox = new VBox();
    ScrollPane scrollPane = new ScrollPane();
    int gpio_counts=0;

    BackgroundFill backgroundFill = new BackgroundFill(Paint.valueOf("#8FBC8F"), new CornerRadii(20), Insets.EMPTY);
    Background background = new Background(backgroundFill);

    HBox hBox_bottom = new HBox();
    Button gpio_generate = new Button("generate");

    boolean bgc=true;
    public gpio_config_gui(){

        hBox_top.getChildren().setAll(gpio_count_title,gpio_count_input,add_once);
        HBox.setMargin(gpio_count_title,new Insets(10));
        HBox.setMargin(gpio_count_input,new Insets(10));
        HBox.setMargin(add_once,new Insets(10));
        hBox_top.setAlignment(Pos.CENTER_LEFT);

        main_pane.setTop(hBox_top);
        hBox_bottom.getChildren().add(gpio_generate);
        main_pane.setBottom(hBox_bottom);
        HBox.setMargin(gpio_generate,new Insets(10));


        gpio_generate.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                on_gpio_generate_click();
            }
        });

        add_once.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                on_gpio_count_change();
            }
        });
    }

    GPIO gpio_config_to_GPIO_obj(gpio_config_gui_info info){
        GPIO gpio = new GPIO();

        gpio.setM_gpio_num(Integer.parseInt(info.getGpio_num_input().getText()));

        gpio.setM_gpio_name(info.getGpio_name_input().getText());

        if(info.getGpio_output().isSelected()) gpio.setM_gpio_type(GPIO.gpio_type.OUTPUT);
        if(info.getGpio_input().isSelected()) gpio.setM_gpio_type(GPIO.gpio_type.INPUT);

        if(info.getGpio_pull_h().isSelected()) gpio.setM_pull_type(GPIO.pull_type.up);
        if(info.getGpio_pull_l().isSelected()) gpio.setM_pull_type(GPIO.pull_type.down);

        if(info.getGpio_init_h().isSelected()) gpio.setM_init_value(GPIO.init_value.hight);
        if(info.getGpio_init_l().isSelected()) gpio.setM_init_value(GPIO.init_value.low);

        return gpio;
    }

    void on_gpio_generate_click(){
        List<GPIO> gpio_list = new ArrayList<>();
        for (gpio_config_gui_info gpio_config_gui_info : gpio_config_gui_info_list) {
            GPIO gpio = gpio_config_to_GPIO_obj(gpio_config_gui_info);
            gpio_list.add(gpio);
        }
        gpio_config_to_code gpio_config_to_code = new gpio_config_to_code(gpio_list);
    }

    void change_gpio_list_bgc(){
        this.bgc = true;
        for (Node child : vbox.getChildren()) {
            HBox hBox = (HBox) child;
            if(this.bgc) hBox.setBackground(background);
            else hBox.setBackground(null);
            this.bgc= !this.bgc;
        }
    }

    void on_gpio_count_change(){

        gpio_counts=0;
        try {
            gpio_counts = Integer.parseInt(gpio_count_input.getText());
        }catch (Exception e){
            e.printStackTrace();
        }
        if(gpio_counts > 0){
            for (int i = 0; i < gpio_counts; i++) {
                gpio_config_gui_info tmp_gpio_config_gui_info = new gpio_config_gui_info();
                tmp_gpio_config_gui_info.getGpio_num_input().setText(i+1+"");
                tmp_gpio_config_gui_info.getGpio_name_input().setText("tmp_name_"+(i+1));
                tmp_gpio_config_gui_info.getGpio_init_h().setSelected(true);
                tmp_gpio_config_gui_info.getGpio_input().setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        tmp_gpio_config_gui_info.getGpio_pull_h().setSelected(false);
                        tmp_gpio_config_gui_info.getGpio_pull_l().setSelected(false);
                    }
                });
                tmp_gpio_config_gui_info.getGpio_output().setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        tmp_gpio_config_gui_info.getGpio_pull_h().setSelected(false);
                        tmp_gpio_config_gui_info.getGpio_pull_l().setSelected(false);
                    }
                });
                tmp_gpio_config_gui_info.getGpio_info_delete_btn().setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        gpio_config_gui_info_list.remove(tmp_gpio_config_gui_info);
                        vbox.getChildren().remove(tmp_gpio_config_gui_info.gethBox_main());
                        change_gpio_list_bgc();
                    }
                });
                gpio_config_gui_info_list.add(tmp_gpio_config_gui_info);
                vbox.getChildren().add(tmp_gpio_config_gui_info.gethBox_main());
                change_gpio_list_bgc();
            }
        }
        scrollPane.setContent(vbox);
        main_pane.setCenter(scrollPane);
    }

    public BorderPane getMain_pane() {
        return main_pane;
    }

    public void setMain_pane(BorderPane main_pane) {
        this.main_pane = main_pane;
    }

    public List<gpio_config_gui_info> getGpio_config_gui_info_list() {
        return gpio_config_gui_info_list;
    }

    public void setGpio_config_gui_info_list(List<gpio_config_gui_info> gpio_config_gui_info_list) {
        this.gpio_config_gui_info_list = gpio_config_gui_info_list;
    }

    public Label getGpio_count_title() {
        return gpio_count_title;
    }

    public void setGpio_count_title(Label gpio_count_title) {
        this.gpio_count_title = gpio_count_title;
    }

    public TextField getGpio_count_input() {
        return gpio_count_input;
    }

    public void setGpio_count_input(TextField gpio_count_input) {
        this.gpio_count_input = gpio_count_input;
    }

    public VBox getVbox() {
        return vbox;
    }

    public void setVbox(VBox vbox) {
        this.vbox = vbox;
    }

    public int getGpio_counts() {
        return gpio_counts;
    }

    public void setGpio_counts(int gpio_counts) {
        this.gpio_counts = gpio_counts;
    }
}
