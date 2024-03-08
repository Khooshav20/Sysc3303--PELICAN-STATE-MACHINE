package Pelican.State;

import Pelican.Context;
import Pelican.Constants.PedestrianSignal;
import Pelican.Constants.VehicleSignal;

public abstract class State {
  protected Context context;
  protected static VehicleSignal vehicleSignal;
  protected static PedestrianSignal pedestrianSignal;
  private Thread timer;


  /**
     * Constructs a new State with the specified context.
     * @param context The context in which the state operates.
     */
  public State(Context context) {
    this.context = context;
  }

  /**
     * Returns the initial state of the system.
     * @param context The context in which the state operates.
     * @return The initial state of the system.
     */
  public static State start(Context context) {
    return new Operational(context);
  }

  /**
     * Executes actions upon entry into the state.
     */
  public void entry() {
  };

  /**
     * Executes actions upon exit from the state.
     */
  public void exit() {
  };

  /**
     * Signals pedestrians with the specified signal.
     * @param signal The pedestrian signal to be set.
     */
  public void signalPedestrians(PedestrianSignal signal) {
    if (pedestrianSignal == signal) {
      return;
    }

    System.out.println("Pedestrian signal: " + pedestrianSignal + " -> " + signal);
    pedestrianSignal = signal;
  }

  /**
     * Signals vehicles with the specified signal.
     * @param signal The vehicle signal to be set.
     */
  public void signalVehicles(VehicleSignal signal) {
    if (vehicleSignal == signal) {
      return;
    }

    System.out.println("Vehicle signal: " + vehicleSignal + " -> " + signal);
    vehicleSignal = signal;
  }

   /**
     * Sets a timer with the specified duration.
     * @param duration The duration of the timer in seconds.
     */
  protected void SetTimer(int duration) {
    timer = new Thread(() -> {
      try {
        Thread.sleep(duration * 1000);
        timer = null;
        this.context.timeout();
      } catch (InterruptedException e) {
      }
    });

    timer.start();
  };

  protected void KillTimer() {
    if (timer != null) {
      timer.interrupt();
    }
  }

  /**
     * Handles the pedestrian waiting event.
     * @return The next state after handling the event.
     */
  public State handlePedestrianWaiting() {
    return this;
  }

  /**
     * Handles the timeout event.
     * @return The next state after handling the event.
     */
  public State handleTimeout() {
    return this;
  }
}
