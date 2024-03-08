package Pelican.State.Pedestrians;

import Pelican.Context;
import Pelican.Constants.PedestrianSignal;
import Pelican.Constants.Timeout;
import Pelican.State.State;

/**
 * The PedestriansWalk class represents the state where pedestrians are allowed to walk.
 * It manages the pedestrian signal to indicate walking and transitions to PedestriansFlash state upon timeout.
 */
public class PedestriansWalk extends State {

  /**
     * Constructs a new PedestriansWalk state with the specified context.
     * @param context The context in which the state operates.
     */
  public PedestriansWalk(Context context) {
    super(context);
  }

   /**
     * Executes actions upon entry into the PedestriansWalk state.
     * Sets a timer for the pedestrian walk duration and signals pedestrians to walk.
     */
  @Override
  public void entry() {
    SetTimer(Timeout.PEDESTRIANS_WALK);
    signalPedestrians(PedestrianSignal.WALK);
  }

  /**
     * Executes actions upon exit from the PedestriansWalk state.
     * Stops the timer.
     */
  @Override
  public void exit() {
    KillTimer();
  }

    /**
     * Handles the timeout event in the PedestriansWalk state.
     * Transitions to the PedestriansFlash state.
     * @return The next state after handling the timeout event.
     */
  @Override
  public State handleTimeout() {
    return new PedestriansFlash(context);
  }

  /**
     * Returns a string representation of the PedestriansWalk state.
     * @return The string representation of the state.
     */
  @Override
  public String toString() {
    return "PedestriansWalk";
  }
}
