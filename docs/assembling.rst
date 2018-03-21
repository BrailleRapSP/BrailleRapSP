Assembling guide
================

Consider from 2 up to 4 hours to achieve this build.
You won't need specific knowledge but some basic tools like:

* hallen keys and socket wrench for 2.5, 3, 4 and 5mm bolts and nuts
* a nose plier 
* wood glue
* tape
* a threader (for printed parts receiving screws)
* a multimeter to test the endstops (optional)


Machining the embossing "stylus"
----------------------------
The embossing tool is made of an M3 screw, machined with a dremel like tool. the tip of the tool need to be smooth (avoid sharp tip that will tear the embossed material)

Assemble the embossing tool
---------------------------
#. Screw the brace on the electro-magnet axle. 
#. Screw embossing "stylus" in the brace.
#. lock the sylus with a counter lock nut.

	.. image :: ./IMG/electromagnet.png
		:align: center

Prepare top paper roll drive
------------------------------
We use epoxy glue to stick the sand paper on abs printed parts. Epoxy don't stick on ABS so we prepare the parts with light sanding and cyanoacrilat glue. Be careful with cyanoacrilat glue, don't stick your finger. Will start assembly with this part to let the glue gets dry.
 
#. Print 3 paper roll **link to stl**.
#. Laser cut some piece of 180 sand paper.
#. Tap the screw hole with an M3 tap. 
	.. image :: ./IMG/tap_upper_rol_2018_03_18_2929.JPG
		:align: center
		:alt: Tap the screw hole with an M3 tap. 
#. Sand printed roll with sand Paper N°4 to scratch the printed surface where you want to stick sand paper.
	.. image :: ./IMG/sand_roll_2018_03_18_2932.JPG
		:align: center
#. "Paint" the printed parts with cyanoacrilat glue, let it dry.
	.. image :: ./IMG/cyano_roll_2018_03_18_2934.JPG
		:align: center
#. Glue a piece of 180 sand paper on the part with bi-component epoxy glue.
	.. image :: ./IMG/epoxy_glue_roll2018_03_18_2936.JPG
		:align: center
#. Fix the sand paper on roll with some rubber band. Let the roll dry for about 24h depending of the epoxy glue you've used (we used standard epoxy and let the roll dry for about 24 hours)
	.. image :: ./IMG/rubber_band_roll2018_03_18_2937.JPG
		:align: center
	
	
Prepare bottom paper roll drive
-------------------------------

#. Print 3 paper roll **link to stl**.
#. Tap the screw hole with an m3 tap.
	.. image :: ./IMG/tap_bottom_roll2018_03_18_2927.JPG
		:align: center
#. Put an O-ring on the roll throat.
	.. image :: ./IMG/oring_roll2018_03_18_2930.JPG
		:align: center

Laser cut the box
-----------------
Material
You will need 3 sheets of plywood 5mm thick , 600 mm x 400mm.


Use the dxf files in https://github.com/BrailleRapSP/BrailleRapSP/tree/master/lasercut to lasercut the 3 sheets.



Assemble the box
-------------------
Depending on the lasercutter used, you may want to sand the cutted parts before starting assembly.
    .. image :: ./IMG/sanding_box2018_03_21_2946-2017-01-27.JPG

Prepare the sides of the box on a flat surface.
	.. image :: ./IMG/flat_lasercut2018_03_18_2917.JPG
			:align: center
Start to glue left right and back sides of the box on the bottom side with wood glue, 
		.. image :: ./IMG/3sides_box_2018_03_18_2918.JPG
			:align: center
then glue the front side. 
	.. image :: ./IMG/4sides_box2018_03_18_2919.JPG
			:align: center

Assemble the 4 sides and the bottom, sticking them together with masking tape.

===================================================== ====================================================== ============================================
.. image :: ./IMG/bluetape_box12018_03_18_2938.JPG    .. image :: ./IMG/bluetape_box22018_03_18_2939.JPG     .. image :: ./IMG/bluetape_box32018_03_18_2940.JPG
			                                                 
===================================================== ====================================================== ============================================			         
			                  
While the glue is drying (time depends on the glue you'll use), let's start assembling the right and left supports.


Right support assembly
-----------------------

Attach the right_axes_mount.stl printed part to the X axis stepper's motor.

.. image :: ./IMG/right-axes-mount2018_03_21_2952-2017-01-27.JPG

Insert M3 bolts into the right X axis support

.. image :: ./IMG/right-axes-mountM32018_03_21_2953-2017-01-27.JPG

Add the BTR M3x14mm screws into the dedicated spaces. You should obtain this:

.. image :: ./IMG/right-axes-mount-Global2018_03_21_2955-2017-01-27.JPG


Add the coupler right onto the motor axis. Be sure to tight the screw correctly

.. image :: ./IMG/right-axes-mount-Coupler2018_03_21_2974-2017-01-27.JPG


Now it's time to install the support into the right side of the wooden chassis, using 4 BTR M4 screws. You'll add right after the KP08 according to the photo.

.. image :: ./IMG/right-axes-mount-kp08-2018_03_21_2975-2017-01-27.JPG

Be aware that KP08 parts are symetrically installed. The rings looking up for the upper part, facing down for the lower part. You should get this result:

.. image :: ./IMG/right-axes-mount-right-install2018_03_21_2980-2017-01-27.JPG

In order to perfectly align the KP08, you'll use a 8mm rod before tighten the Nylstop screws.


Left support assembly
======================

.. image :: ./IMG/Left-Mount-00-2018_03_21_2971-2017-01-27.JPG
.. image :: ./IMG/Left-Mount-01-2018_03_21_2971-2017-01-27.JPG
.. image :: ./IMG/Left-Mount-02-2018_03_21_2971-2017-01-27.JPG
.. image :: ./IMG/Left-Mount-03-2018_03_21_2971-2017-01-27.JPG
.. image :: ./IMG/Left-Mount-04-2018_03_21_2971-2017-01-27.JPG
.. image :: ./IMG/Left-Mount-05-2018_03_21_2971-2017-01-27.JPG
.. image :: ./IMG/Left-Mount-06-2018_03_21_2971-2017-01-27.JPG
.. image :: ./IMG/Left-Mount-07-2018_03_21_2971-2017-01-27.JPG
.. image :: ./IMG/Left-Mount-08-2018_03_21_2971-2017-01-27.JPG
.. image :: ./IMG/Left-Mount-09-2018_03_21_2971-2017-01-27.JPG
.. image :: ./IMG/Left-Mount-10-2018_03_21_2971-2017-01-27.JPG
.. image :: ./IMG/Left-Mount-11-2018_03_21_2971-2017-01-27.JPG
.. image :: ./IMG/Left-Mount-12-2018_03_21_2971-2017-01-27.JPG
.. image :: ./IMG/Left-Mount-13-2018_03_21_2971-2017-01-27.JPG

Position M3 bolts into the X axis' left support

Then you'll place the M3x14mm BTR screws so that the nuts stay in place

Pulley assembly

Add the pulleys on the left support 

Locked these supports using 2 M3x30mm BTR and nylstop M3 bolts

Be sure that pulley support allowing the endstop attachment is in right into the lower part

Install pulleys into dedicated supports

You should now obtain something similar to this photo

.. image :: ./IMG/Left-Mount-14-2018_03_21_2971-2017-01-27.JPG


Installing the electro-magnet
==============================

TBA, magnet sourcing is changing





Preparing Y Axis
----------------



Assembling X Axis
-----------------
...

Assembling Y Axis
-----------------

#. Put the 330 mm linear shaft beetween the left and right bottom support going throw the hole in the right side of the box. While positionning the linear shaft don't forget to string 3 O-ring paper drive.
#. Put the *400* mm linear shaft beetween the left and right top support going throw the hole in the right side of the box. While positionning the linear shaft don't forget to string 3 sand paper paper drive.



Calibrating the printer
-----------------------

Embosser
...
