package Pelican.State.Pedestrians;

import Pelican.Context;
import Pelican.Constants.VehicleSignal;
import Pelican.State.State;

/**
 * The PedestriansEnabled class represents the state where pedestrian crossing is enabled.
 * It transitions the vehicle signal to red and then transitions to the PedestriansWalk state.
 */

public class PedestriansEnabled extends State {

  /**
     * Constructs a new PedestriansEnabled state with the specified context.
     * @param context The context in which the state operates.
     */
  public PedestriansEnabled(Context context) {
    super(context);
  }

  /**
     * Executes actions upon entry into the PedestriansEnabled state.
     * Signals vehicles to stop (red signal) and transitions to PedestriansWalk state.
     */
  @Override
  public void entry() {
    signalVehicles(VehicleSignal.RED); // Signal vehicles to stop
    this.context.setState(new PedestriansWalk(context)); // Transition to PedestriansWalk state
  }

   /**
     * Returns a string representation of the PedestriansEnabled state.
     * @return The string representation of the state.
     */
  @Override
  public String toString() {
    return "PedestriansEnabled";
  }
}
