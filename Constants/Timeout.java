
package Pelican.Constants;

/**
 * The Timeout class defines constant timeout durations used in the Pelican system.
 * It specifies the durations for vehicle signal states and pedestrian signal states.
 */

public final class Timeout {
  // Timeout duration for the VehiclesGreen state
  public static final int VEHICLES_GREEN = 10;
  // Timeout duration for the VehiclesYellow state
  public static final int VEHICLES_YELLOW = 3;
  // Timeout duration for the PedestriansWalk state
  public static final int PEDESTRIANS_WALK = 15;
  // Timeout duration for the PedestriansFlash state
  public static final int PEDESTRIANS_FLASH = 1;

  private Timeout() {
  }
}