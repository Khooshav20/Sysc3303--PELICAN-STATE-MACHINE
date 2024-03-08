package Pelican.State.Vehicles;

import Pelican.Context;
import Pelican.State.State;

/**
 * The VehiclesGreenInt class represents the state where the vehicle signal is in an intermediate green state.
 * This state occurs when there is no pedestrian waiting, and the green signal for vehicles is extended.
 */
public class VehiclesGreenInt extends State {

  /**
     * Constructs a new VehiclesGreenInt state with the specified context.
     * @param context The context in which the state operates.
     */
  public VehiclesGreenInt(Context context) {
    super(context);
  }

  /**
     * Handles the pedestrian waiting event in the VehiclesGreenInt state.
     * This event transitions to the VehiclesYellow state.
     * @return The next state after handling the pedestrian waiting event.
     */

  @Override
  public State handlePedestrianWaiting() {
    return new VehiclesYellow(context);
  }

  /**
     * Returns a string representation of the VehiclesGreenInt state.
     * @return The string representation of the state.
     */
  @Override
  public String toString() {
    return "VehiclesGreenInt";
  }
}
