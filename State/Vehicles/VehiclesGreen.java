package Pelican.State.Vehicles;

import Pelican.Context;
import Pelican.Constants.Timeout;
import Pelican.Constants.VehicleSignal;
import Pelican.State.State;

/**
 * The VehiclesGreen class represents the state where vehicle signal is green.
 * It manages the vehicle signal and transitions to other states based on events.
 */
public class VehiclesGreen extends State {
  boolean isPedestrianWaiting; // Flag indicating if a pedestrian is waiting

  /**
     * Constructs a new VehiclesGreen state with the specified context.
     * @param context The context in which the state operates.
     */
  public VehiclesGreen(Context context) {
    super(context);
  }

  /**
     * Executes actions upon entry into the VehiclesGreen state.
     * Sets a timer for the green signal duration, signals vehicles to proceed, and initializes pedestrian waiting flag.
     */
  @Override
  public synchronized void entry() {
    SetTimer(Timeout.VEHICLES_GREEN);
    signalVehicles(VehicleSignal.GREEN);
    isPedestrianWaiting = false;
  }

  /**
     * Executes actions upon exit from the VehiclesGreen state.
     * Stops the timer.
     */
  @Override
  public void exit() {
    KillTimer();
  }

   /**
     * Handles the pedestrian waiting event in the VehiclesGreen state.
     * Sets the pedestrian waiting flag.
     * @return The current state.
     */
  @Override
  public State handlePedestrianWaiting() {
    isPedestrianWaiting = true;
    return this;
  }

  /**
     * Handles the timeout event in the VehiclesGreen state.
     * Transitions to either VehiclesYellow or VehiclesGreenInt state based on pedestrian waiting flag.
     * @return The next state after handling the timeout event.
     */
  @Override
  public State handleTimeout() {
    if (isPedestrianWaiting) {
      return new VehiclesYellow(context);
    }

    return new VehiclesGreenInt(context);
  }

  /**
     * Returns a string representation of the VehiclesGreen state.
     * @return The string representation of the state.
     */
  @Override
  public String toString() {
    return "VehiclesGreen";
  }
}
