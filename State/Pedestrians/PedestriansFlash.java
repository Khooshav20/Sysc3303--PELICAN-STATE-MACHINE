package Pelican.State.Pedestrians;

import Pelican.Context;
import Pelican.Constants.PedestrianSignal;
import Pelican.Constants.Timeout;
import Pelican.State.State;
import Pelican.State.Vehicles.VehiclesEnabled;

/**
 * The PedestriansFlash class represents the state where pedestrian signal flashes before transitioning.
 * It manages the flashing behavior of the pedestrian signal and transitions to the appropriate state.
 */
public class PedestriansFlash extends State {
  private int pedestrianFlashCtr = 7;

   /**
     * Constructs a new PedestriansFlash state with the specified context.
     * @param context The context in which the state operates.
     */
  public PedestriansFlash(Context context) {
    super(context);
  }

  /**
     * Constructs a new PedestriansFlash state with the specified context and flash counter.
     * @param context The context in which the state operates.
     * @param pedestrianFlashCtr The initial value of the flash counter.
     */
  public PedestriansFlash(Context context, int pedestrianFlashCtr) {
    this(context);
    this.pedestrianFlashCtr = pedestrianFlashCtr;
  }

  /**
     * Executes actions upon entry into the PedestriansFlash state.
     * Sets a timer for the pedestrian flash duration.
     */
  @Override
  public void entry() {
    SetTimer(Timeout.PEDESTRIANS_FLASH); // Set timer for pedestrian flash duration
  }

  /**
     * Executes actions upon exit from the PedestriansFlash state.
     * Stops the timer.
     */
  @Override
  public void exit() {
    KillTimer();
  }

  /**
     * Handles the timeout event in the PedestriansFlash state.
     * Decrements the flash counter and manages pedestrian signal flashing.
     * Transitions to the appropriate state based on the flash counter.
     * @return The next state after handling the timeout event.
     */
  @Override
  public State handleTimeout() {
    pedestrianFlashCtr--;

    if (pedestrianFlashCtr > 0) {
      if ((pedestrianFlashCtr & 1) == 0) {
        signalPedestrians(PedestrianSignal.DONT_WALK); // Signal pedestrians to not walk
      } else {
        signalPedestrians(PedestrianSignal.BLANK);
      }

      return new PedestriansFlash(context, pedestrianFlashCtr);
    }

    return new VehiclesEnabled(context);
  }

    /**
     * Returns a string representation of the PedestriansFlash state.
     * @return The string representation of the state.
     */
  @Override
  public String toString() {
    return "PedestriansFlash";
  }
}
