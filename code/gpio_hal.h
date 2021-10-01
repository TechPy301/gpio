#ifndef GPIO_HAL
#define GPIO_HAL


//start for door gpio define----------------------------------------------------------
//for pin_1 gpio api define
void init_pin_1(void);
void set_pin_1_output_h(void);
void set_pin_1_output_l(void);
void set_pin_1_input(void);
uint8_t read_pin_1(void);
void set_pin_1_pull_up(void);
void set_pin_1_pull_down(void);
//for door redefine
#define init_pin_door               init_pin_1
#define set_pin_door_output_h       set_pin_1_output_h
#define set_pin_door_output_l       set_pin_1_output_l
#define set_pin_door_input          set_pin_1_input
#define read_pin_door               read_pin_1
#define set_pin_door_pull_up        set_pin_1_pull_up
#define set_pin_door_pull_down      set_pin_1_pull_down
//end for door gpio define----------------------------------------------------------


#endif
