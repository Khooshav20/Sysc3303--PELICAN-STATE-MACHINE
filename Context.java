package Pelican;

import Pelican.State.State;

/**
 * The Context class represents the context in which the state machine operates.
 * It manages the current state and facilitates state transitions based on events.
 */


public class Context {
  private State currentState;

  /**
     * Constructs a new Context object.
     * Initializes the context with the initial state.
     */
    
  public Context() {
    setState(State.start(this));
  }

  /**
     * Retrieves the current state of the context.
     * @return The current state of the context.
     */
  public State getState() {
    return currentState;
  }

   /**
     * Sets the new state of the context.
     * Executes the exit action of the current state and the entry action of the new state.
     * @param newState The new state to set.
     */
  public void setState(State newState) {
    if (currentState == newState) {
      return;
    }

    System.out.println("State: " + currentState + " -> " + newState);
    // If the new state is the same as the current state, no action needed
    if (currentState != null) {
      currentState.exit();
    }

    currentState = newState; // Set the new state
    currentState.entry();
  }

    /**
     * Notifies the context that a pedestrian is waiting.
     * Initiates the handling of the pedestrian waiting event by the current state.
     */

  public void pedestrianWaiting() {
    setState(currentState.handlePedestrianWaiting());
  }

    /**
     * Notifies the context that a timeout event has occurred.
     * Initiates the handling of the timeout event by the current state.
     */
  public void timeout() {
    setState(currentState.handleTimeout());
  }
}
