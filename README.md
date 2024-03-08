# Sysc3303--PELICAN-STATE-MACHINE

Assignment 3 — State Machines

Bundhoo Khooshav Nikhil 
101132063


Pelican State Machine

This state machine models a pedestrian crossing similar to the one found at Colonel By Drive and the University of Ottawa.

Overview:

The "Pelican" (Pedestrian Light Controlled crossing) state machine is designed to simulate the behaviour of a pedestrian crossing system.
It manages the states of both pedestrian and vehicle signals, ensuring safe and efficient traffic flow.

File Structure:

    * src/: This directory contains the source code of the project
    * Pelican/: This directory contains the main classes of the PELICAN system.
    * Constants/: This directory contains the constants used in the PELICAN system.
    * PedestrianSignal.java: Defines the pedestrian signal states.
    * Timeout.java: Defines the timeout durations for the different states.
    * VehicleSignal.java: Defines the vehicle signal states.
    * State/: This directory contains the state classes for the PELICAN system.
    * Pedestrians/: This directory contains the pedestrian state classes.
    * PedestriansEnabled.java: Defines the PedestriansEnabled state.
    * PedestriansFlash.java: Defines the PedestriansFlash state.
    * PedestriansWalk.java: Defines the PedestriansWalk state.
    * Vehicles/: This directory contains the vehicle state classes.
    * VehiclesEnabled.java: Defines the VehiclesEnabled state.
    * VehiclesGreen.java: Defines the VehiclesGreen state.
    * VehiclesGreenInt.java: Defines the VehiclesGreenInt state.
    * VehiclesYellow.java: Defines the VehiclesYellow state.
    * Operational.java: Defines the Operational state.
    * State.java: Defines the base State class.
    * Context.java: Contains the Context class, which manages the state of the PELICAN system.
    * ContextTest.java: Contains the ContextTest class, which tests the PELICAN system.


Instructions:
* Run the main method in the ContextTest class.


Question 1:
* Every time PedestriansFlash timeouts and re-enters the state, pedestrianFlashCtr is set to 7, causing an infinite loop.
* To fix it, pedestrianFlashCtr is persisted across PedestriansFlash timeouts.

Question 2:
* Since isPedestrianWaiting flag is always set to false in VehiclesGreen state's entry, it would overwrite the flag's value in the scenario where a PEDESTRIAN_WAITING event occurs between the states PedestriansFlash and VehiclesGreen (given the pedestrian chose not to cross).
