package Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class gpio_config_to_code {
    List<GPIO> gpio_list = new ArrayList<>();

    public gpio_config_to_code(List<GPIO> gpio_list){
        this.gpio_list = gpio_list;
        StringBuilder temp_c = readFileContent("./template/gpio_hal_template.c");
        StringBuilder temp_h = readFileContent("./template/gpio_hal_template.h");
        StringBuilder done_c = new StringBuilder();
        done_c.append("#include \"gpio_hal.h\"\n");
        StringBuilder done_h = new StringBuilder();
        done_h.append("#ifndef GPIO_HAL\n");
        done_h.append("#define GPIO_HAL\n");
        done_c.append("#include \"my_type_def.h\"\n");
        for (GPIO gpio : this.gpio_list) {
            String tmp_c = temp_c.toString();
            String tmp_h = temp_h.toString();
            StringBuilder init_code = new StringBuilder();
            if(gpio.getM_gpio_type()==GPIO.gpio_type.OUTPUT){
                if(gpio.getM_init_value()==GPIO.init_value.hight){
                    init_code.append("\n\tset_PINX_output_h();");
                }
                else if(gpio.getM_init_value()==GPIO.init_value.low){
                    init_code.append("\n\tset_PINX_output_l();");
                }
            }
            else if(gpio.getM_gpio_type()==GPIO.gpio_type.INPUT){
                init_code.append("\n\tset_PINX_input();");
            }
            if(gpio.getM_pull_type()==GPIO.pull_type.up){
                init_code.append("\n\tset_PINX_pull_up();");
            }
            else if(gpio.getM_pull_type()==GPIO.pull_type.down){
                init_code.append("\n\tset_PINX_pull_down();");
            }
            tmp_c = tmp_c.replaceAll("init_pin_code",init_code.toString());
            tmp_c = tmp_c.replaceAll("PINX","pin_"+gpio.getM_gpio_num());
            tmp_h = tmp_h.replaceAll("PINX","pin_"+gpio.getM_gpio_num());
            tmp_h = tmp_h.replaceAll("NAME",gpio.getM_gpio_name());
            done_c.append(tmp_c);
            done_h.append(tmp_h);
        }
        done_h.append("#endif\n");
        writeFileContent(done_h,"./code/gpio_hal.h");
        writeFileContent(done_c,"./code/gpio_hal.c");
    }

    public static void writeFileContent(StringBuilder content,String path){
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter(path));
            out.write(content.toString());
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static StringBuilder readFileContent(String fileName) {
        File file = new File(fileName);
        BufferedReader reader = null;
        StringBuilder sbf = new StringBuilder();
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempStr;
            while ((tempStr = reader.readLine()) != null) {
                sbf.append(tempStr).append("\n");
            }
            reader.close();
            return sbf;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
        return sbf;
    }

}
