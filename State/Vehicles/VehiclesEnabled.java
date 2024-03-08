package Pelican.State.Vehicles;

import Pelican.Context;
import Pelican.Constants.PedestrianSignal;
import Pelican.State.State;

/**
 * The VehiclesEnabled class represents the state where vehicle signal is enabled.
 * It manages the pedestrian signal and transitions to the VehiclesGreen state.
 */
public class VehiclesEnabled extends State {

  /**
     * Constructs a new VehiclesEnabled state with the specified context.
     * @param context The context in which the state operates.
     */
  public VehiclesEnabled(Context context) {
    super(context);
  }

  /**
     * Executes actions upon entry into the VehiclesEnabled state.
     * Signals pedestrians to not walk and transitions to the VehiclesGreen state.
     */
  @Override
  public void entry() {
    signalPedestrians(PedestrianSignal.DONT_WALK);
    this.context.setState(new VehiclesGreen(context));
  }

  /**
     * Returns a string representation of the VehiclesEnabled state.
     * @return The string representation of the state.
     */
  @Override
  public String toString() {
    return "VehiclesEnabled";
  }
}
