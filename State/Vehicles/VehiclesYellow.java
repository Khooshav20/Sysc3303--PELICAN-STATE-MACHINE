package Pelican.State.Vehicles;

import Pelican.Context;
import Pelican.Constants.Timeout;
import Pelican.Constants.VehicleSignal;
import Pelican.State.State;
import Pelican.State.Pedestrians.PedestriansEnabled;

/**
 * The VehiclesYellow class represents the state where the vehicle signal is yellow.
 * This state occurs as a transition phase between green and red signals for vehicles.
 */

public class VehiclesYellow extends State {
  /**
     * Constructs a new VehiclesYellow state with the specified context.
     * @param context The context in which the state operates.
     */
  public VehiclesYellow(Context context) {
    super(context);
  }

  /**
     * Executes actions upon entry into the VehiclesYellow state.
     * Sets a timer for the yellow signal duration and signals vehicles to prepare to stop.
     */
  @Override
  public void entry() {
    SetTimer(Timeout.VEHICLES_YELLOW);
    signalVehicles(VehicleSignal.YELLOW);
  }

  /**
     * Executes actions upon exit from the VehiclesYellow state.
     * Stops the timer.
     */
  @Override
  public void exit() {
    KillTimer();
  }

  /**
     * Handles the timeout event in the VehiclesYellow state.
     * This event transitions to the PedestriansEnabled state.
     * @return The next state after handling the timeout event.
     */
  @Override
  public State handleTimeout() {
    return new PedestriansEnabled(context);
  }

  /**
     * Returns a string representation of the VehiclesYellow state.
     * @return The string representation of the state.
     */
  @Override
  public String toString() {
    return "VehiclesYellow";
  }
}
