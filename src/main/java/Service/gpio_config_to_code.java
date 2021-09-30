package Service;

import java.util.ArrayList;
import java.util.List;

public class gpio_config_to_code {
    List<GPIO> gpio_list = new ArrayList<>();

    public gpio_config_to_code(List<GPIO> gpio_list){
        this.gpio_list = gpio_list;
        System.out.println(this.gpio_list.toString());
    }

}
