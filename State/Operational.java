package Pelican.State;

import Pelican.Context;
import Pelican.Constants.PedestrianSignal;
import Pelican.Constants.VehicleSignal;
import Pelican.State.Vehicles.VehiclesEnabled;

/**
 * The Operational class represents the initial operational state of the system.
 * It initializes the vehicle and pedestrian signals and transitions to the VehiclesEnabled state.
 */

public class Operational extends State {
  /**
     * Constructs a new Operational state with the specified context.
     * Initializes the vehicle signal to red and the pedestrian signal to don't walk.
     * @param context The context in which the state operates.
     */

  public Operational(Context context) {
    super(context);
    State.vehicleSignal = VehicleSignal.RED; // Initialize vehicle signal to red
    State.pedestrianSignal = PedestrianSignal.DONT_WALK; // Initialize pedestrian signal to don't walk
  }

   /**
     * Executes actions upon entry into the Operational state.
     * Transitions to the VehiclesEnabled state.
     */
  @Override
  public void entry() {
    this.context.setState(new VehiclesEnabled(context));
  }

  /**
     * Returns a string representation of the Operational state.
     * @return The string representation of the state.
     */
  @Override
  public String toString() {
    return "Operational";
  }
}
