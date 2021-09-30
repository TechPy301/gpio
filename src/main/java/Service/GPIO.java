package Service;

import java.util.Objects;

public class GPIO {

    public static enum gpio_type { INPUT,OUTPUT; }
    public static enum pull_type { up,down; }
    public static enum init_value { hight,low; }

    gpio_type m_gpio_type;
    pull_type m_pull_type;
    init_value m_init_value;
    int m_gpio_num;
    String m_gpio_name;

    public GPIO(){

    }

    @Override
    public String toString() {
        return "\n GPIO{" +
                "m_gpio_type=" + m_gpio_type +
                ", m_pull_type=" + m_pull_type +
                ", m_init_value=" + m_init_value +
                ", m_gpio_num=" + m_gpio_num +
                ", m_gpio_name='" + m_gpio_name + '\'' +
                '}';
    }

    public int getM_gpio_num() {
        return m_gpio_num;
    }

    public void setM_gpio_num(int m_gpio_num) {
        this.m_gpio_num = m_gpio_num;
    }

    public String getM_gpio_name() {
        return m_gpio_name;
    }

    public void setM_gpio_name(String m_gpio_name) {
        this.m_gpio_name = "pin_"+this.m_gpio_num;
        if(!Objects.equals(m_gpio_name, "")) this.m_gpio_name = m_gpio_name;

    }

    public gpio_type getM_gpio_type() {
        return m_gpio_type;
    }

    public void setM_gpio_type(gpio_type m_gpio_type) {
        this.m_gpio_type = m_gpio_type;
    }

    public pull_type getM_pull_type() {
        return m_pull_type;
    }

    public void setM_pull_type(pull_type m_pull_type) {
        this.m_pull_type = m_pull_type;
    }

    public init_value getM_init_value() {
        return m_init_value;
    }

    public void setM_init_value(init_value m_init_value) {
        this.m_init_value = m_init_value;
    }
}
