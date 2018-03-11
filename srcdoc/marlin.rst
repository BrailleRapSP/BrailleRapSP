Marlin Firmware for Ramps or compatible
=======================================



Notes
-----
We use stadard marlin firmware to implement M3 / M4 GCode command

Board configuration
-------------------

in configuration.h 

Motherboard configuration ::

   #ifndef MOTHERBOARD
     //#define MOTHERBOARD BOARD_RAMPS_14_EFB
     #define MOTHERBOARD BOARD_RAMPS_14_SF
   #endif

Spindle / laser / pen configuration ::

   // BRAILLE RAP CONFIG
   #define SPINDLE_LASER_ENABLE
   #define SPINDLE_LASER_ENABLE_PIN  RAMPS_D8_PIN      // !!! sortie BED MOSFET
   #define SPINDLE_LASER_PWM_PIN     RAMPS_D10_PIN     // !!! sortie E0 MOSFET 
   #define SPINDLE_DIR_PIN           5                 // pin servo


Endstop configuration ::

   // Mechanical endstop with COM to ground and NC to Signal uses "false" here (most common setup).
   #define X_MIN_ENDSTOP_INVERTING false // set to true to invert the logic of the endstop.
   #define Y_MIN_ENDSTOP_INVERTING false // set to true to invert the logic of the endstop.
   #define Z_MIN_ENDSTOP_INVERTING false // set to true to invert the logic of the endstop.
   #define X_MAX_ENDSTOP_INVERTING false // set to true to invert the logic of the endstop.
   #define Y_MAX_ENDSTOP_INVERTING false // set to true to invert the logic of the endstop.
   #define Z_MAX_ENDSTOP_INVERTING false // set to true to invert the logic of the endstop.
   #define Z_MIN_PROBE_ENDSTOP_INVERTING false // set to true to invert the logic of the probe.


Motor step / mm ::

   #define DEFAULT_AXIS_STEPS_PER_UNIT   { 80, 46, 4000, 500 }

Max feedrate ::

   #define DEFAULT_MAX_FEEDRATE          { 300, 300, 5, 25 }

Acceleration ::

   #define DEFAULT_MAX_ACCELERATION      { 1500, 1500, 100, 10000 }

   #define DEFAULT_ACCELERATION          1500    // X, Y, Z and E acceleration for printing moves
   #define DEFAULT_RETRACT_ACCELERATION  1500    // E acceleration for retracts
   #define DEFAULT_TRAVEL_ACCELERATION   1500    // X, Y, Z acceleration for travel (non printing) moves

Jerk ::

   #define DEFAULT_XJERK                 5.0
   #define DEFAULT_YJERK                 5.0
   #define DEFAULT_ZJERK                  0.3
   #define DEFAULT_EJERK                  5.0


 
 




