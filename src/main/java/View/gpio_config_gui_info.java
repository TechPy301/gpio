package View;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;

import java.util.EventListener;


public class gpio_config_gui_info {

    HBox hBox_main = new HBox();

    HBox gpui_num_hBox = new HBox();
    Label gpio_num_title = new Label("num:");
    TextField gpio_num_input = new TextField();

    HBox gpio_name_hBox = new HBox();
    Label gpio_name_title = new Label("name:");
    TextField gpio_name_input = new TextField();

    HBox gpio_dir_hbox = new HBox();
    Label gpio_dir_title = new Label("dir:");
    ToggleGroup gpio_dir_radio_bt_group = new ToggleGroup();
    RadioButton gpio_output = new RadioButton("output");
    RadioButton gpio_input = new RadioButton("input");

    HBox gpio_pull_hbox = new HBox();
    Label gpio_pull_title = new Label("pull:");
    ToggleGroup gpio_pull_radio_bt_group = new ToggleGroup();
    RadioButton gpio_pull_h = new RadioButton("H");
    RadioButton gpio_pull_l = new RadioButton("L");

    HBox gpio_init_value_hbox = new HBox();
    Label gpio_init_value_title = new Label("init:");
    ToggleGroup gpio_init_radio_bt_group = new ToggleGroup();
    RadioButton gpio_init_h = new RadioButton("H");
    RadioButton gpio_init_l = new RadioButton("L");

    HBox gpio_info_delete_hbox = new HBox();
    Button gpio_info_delete_btn = new Button("remove");
    public gpio_config_gui_info(){
        gpui_num_hBox.getChildren().addAll(gpio_num_title,gpio_num_input);
        gpio_num_input.setMaxWidth(50);
        HBox.setMargin(gpio_num_title,new Insets(4));
        HBox.setMargin(gpio_num_input,new Insets(4));

        gpio_name_hBox.getChildren().addAll(gpio_name_title,gpio_name_input);
        gpio_name_input.setMaxWidth(150);
        HBox.setMargin(gpio_name_title,new Insets(4));
        HBox.setMargin(gpio_name_input,new Insets(4));

        gpio_output.setToggleGroup(gpio_dir_radio_bt_group);
        gpio_input.setToggleGroup(gpio_dir_radio_bt_group);
        gpio_dir_hbox.getChildren().addAll(gpio_dir_title,gpio_output,gpio_input);
        HBox.setMargin(gpio_dir_title,new Insets(4));
        HBox.setMargin(gpio_output,new Insets(4));
        HBox.setMargin(gpio_input,new Insets(4));


        gpio_pull_h.setToggleGroup(gpio_pull_radio_bt_group);
        gpio_pull_l.setToggleGroup(gpio_pull_radio_bt_group);
        gpio_pull_hbox.getChildren().addAll(gpio_pull_title,gpio_pull_h,gpio_pull_l);
        HBox.setMargin(gpio_pull_title,new Insets(4));
        HBox.setMargin(gpio_pull_h,new Insets(4));
        HBox.setMargin(gpio_pull_l,new Insets(4));


        gpio_init_h.setToggleGroup(gpio_init_radio_bt_group);
        gpio_init_l.setToggleGroup(gpio_init_radio_bt_group);
        gpio_init_value_hbox.getChildren().addAll(gpio_init_value_title,gpio_init_h,gpio_init_l);
        HBox.setMargin(gpio_init_value_title,new Insets(4));
        HBox.setMargin(gpio_init_h,new Insets(4));
        HBox.setMargin(gpio_init_l,new Insets(4));

        gpio_info_delete_hbox.getChildren().addAll(gpio_info_delete_btn);
        HBox.setMargin(gpio_info_delete_btn,new Insets(4));


        hBox_main.getChildren().addAll(gpui_num_hBox,gpio_name_hBox,gpio_dir_hbox,
                gpio_pull_hbox,gpio_init_value_hbox,gpio_info_delete_hbox);

        gpui_num_hBox.setAlignment(Pos.CENTER);
        gpio_name_hBox.setAlignment(Pos.CENTER);
        gpio_dir_hbox.setAlignment(Pos.CENTER);
        gpio_pull_hbox.setAlignment(Pos.CENTER);
        gpio_init_value_hbox.setAlignment(Pos.CENTER);
        gpio_info_delete_hbox.setAlignment(Pos.CENTER);

        HBox.setMargin(gpui_num_hBox, new Insets(10));
        HBox.setMargin(gpio_name_hBox, new Insets(10));
        HBox.setMargin(gpio_dir_hbox, new Insets(10));
        HBox.setMargin(gpio_pull_hbox, new Insets(10));
        HBox.setMargin(gpio_init_value_hbox, new Insets(10));
        HBox.setMargin(gpio_info_delete_hbox, new Insets(10));

        hBox_main.setAlignment(Pos.CENTER);


        gpio_info_delete_btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        });

    }


    public HBox getGpio_info_delete_hbox() {
        return gpio_info_delete_hbox;
    }

    public void setGpio_info_delete_hbox(HBox gpio_info_delete_hbox) {
        this.gpio_info_delete_hbox = gpio_info_delete_hbox;
    }

    public Button getGpio_info_delete_btn() {
        return gpio_info_delete_btn;
    }

    public void setGpio_info_delete_btn(Button gpio_info_delete_btn) {
        this.gpio_info_delete_btn = gpio_info_delete_btn;
    }

    public HBox gethBox_main() {
        return hBox_main;
    }

    public void sethBox_main(HBox hBox_main) {
        this.hBox_main = hBox_main;
    }

    public HBox getGpui_num_hBox() {
        return gpui_num_hBox;
    }

    public void setGpui_num_hBox(HBox gpui_num_hBox) {
        this.gpui_num_hBox = gpui_num_hBox;
    }

    public Label getGpio_num_title() {
        return gpio_num_title;
    }

    public void setGpio_num_title(Label gpio_num_title) {
        this.gpio_num_title = gpio_num_title;
    }

    public TextField getGpio_num_input() {
        return gpio_num_input;
    }

    public void setGpio_num_input(TextField gpio_num_input) {
        this.gpio_num_input = gpio_num_input;
    }

    public HBox getGpio_name_hBox() {
        return gpio_name_hBox;
    }

    public void setGpio_name_hBox(HBox gpio_name_hBox) {
        this.gpio_name_hBox = gpio_name_hBox;
    }

    public Label getGpio_name_title() {
        return gpio_name_title;
    }

    public void setGpio_name_title(Label gpio_name_title) {
        this.gpio_name_title = gpio_name_title;
    }

    public TextField getGpio_name_input() {
        return gpio_name_input;
    }

    public void setGpio_name_input(TextField gpio_name_input) {
        this.gpio_name_input = gpio_name_input;
    }

    public HBox getGpio_dir_hbox() {
        return gpio_dir_hbox;
    }

    public void setGpio_dir_hbox(HBox gpio_dir_hbox) {
        this.gpio_dir_hbox = gpio_dir_hbox;
    }

    public Label getGpio_dir_title() {
        return gpio_dir_title;
    }

    public void setGpio_dir_title(Label gpio_dir_title) {
        this.gpio_dir_title = gpio_dir_title;
    }

    public ToggleGroup getGpio_dir_radio_bt_group() {
        return gpio_dir_radio_bt_group;
    }

    public void setGpio_dir_radio_bt_group(ToggleGroup gpio_dir_radio_bt_group) {
        this.gpio_dir_radio_bt_group = gpio_dir_radio_bt_group;
    }

    public RadioButton getGpio_output() {
        return gpio_output;
    }

    public void setGpio_output(RadioButton gpio_output) {
        this.gpio_output = gpio_output;
    }

    public RadioButton getGpio_input() {
        return gpio_input;
    }

    public void setGpio_input(RadioButton gpio_input) {
        this.gpio_input = gpio_input;
    }

    public HBox getGpio_pull_hbox() {
        return gpio_pull_hbox;
    }

    public void setGpio_pull_hbox(HBox gpio_pull_hbox) {
        this.gpio_pull_hbox = gpio_pull_hbox;
    }

    public Label getGpio_pull_title() {
        return gpio_pull_title;
    }

    public void setGpio_pull_title(Label gpio_pull_title) {
        this.gpio_pull_title = gpio_pull_title;
    }

    public ToggleGroup getGpio_pull_radio_bt_group() {
        return gpio_pull_radio_bt_group;
    }

    public void setGpio_pull_radio_bt_group(ToggleGroup gpio_pull_radio_bt_group) {
        this.gpio_pull_radio_bt_group = gpio_pull_radio_bt_group;
    }

    public RadioButton getGpio_pull_h() {
        return gpio_pull_h;
    }

    public void setGpio_pull_h(RadioButton gpio_pull_h) {
        this.gpio_pull_h = gpio_pull_h;
    }

    public RadioButton getGpio_pull_l() {
        return gpio_pull_l;
    }

    public void setGpio_pull_l(RadioButton gpio_pull_l) {
        this.gpio_pull_l = gpio_pull_l;
    }

    public HBox getGpio_init_value_hbox() {
        return gpio_init_value_hbox;
    }

    public void setGpio_init_value_hbox(HBox gpio_init_value_hbox) {
        this.gpio_init_value_hbox = gpio_init_value_hbox;
    }

    public Label getGpio_init_value_title() {
        return gpio_init_value_title;
    }

    public void setGpio_init_value_title(Label gpio_init_value_title) {
        this.gpio_init_value_title = gpio_init_value_title;
    }

    public ToggleGroup getGpio_init_radio_bt_group() {
        return gpio_init_radio_bt_group;
    }

    public void setGpio_init_radio_bt_group(ToggleGroup gpio_init_radio_bt_group) {
        this.gpio_init_radio_bt_group = gpio_init_radio_bt_group;
    }

    public RadioButton getGpio_init_h() {
        return gpio_init_h;
    }

    public void setGpio_init_h(RadioButton gpio_init_h) {
        this.gpio_init_h = gpio_init_h;
    }

    public RadioButton getGpio_init_l() {
        return gpio_init_l;
    }

    public void setGpio_init_l(RadioButton gpio_init_l) {
        this.gpio_init_l = gpio_init_l;
    }
}
