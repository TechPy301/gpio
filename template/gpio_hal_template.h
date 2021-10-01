

//start for NAME gpio define----------------------------------------------------------
//for PINX gpio api define
void init_PINX(void);
void set_PINX_output_h(void);
void set_PINX_output_l(void);
void set_PINX_input(void);
uint8_t read_PINX(void);
void set_PINX_pull_up(void);
void set_PINX_pull_down(void);
//for NAME redefine
#define init_pin_NAME               init_PINX
#define set_pin_NAME_output_h       set_PINX_output_h
#define set_pin_NAME_output_l       set_PINX_output_l
#define set_pin_NAME_input          set_PINX_input
#define read_pin_NAME               read_PINX
#define set_pin_NAME_pull_up        set_PINX_pull_up
#define set_pin_NAME_pull_down      set_PINX_pull_down
//end for NAME gpio define----------------------------------------------------------


