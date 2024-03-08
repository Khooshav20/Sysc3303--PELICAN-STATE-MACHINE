package Pelican;

import Pelican.State.Pedestrians.PedestriansEnabled;
import Pelican.State.Pedestrians.PedestriansFlash;
import Pelican.State.Pedestrians.PedestriansWalk;
import Pelican.State.Vehicles.VehiclesGreen;
import Pelican.State.Vehicles.VehiclesGreenInt;
import Pelican.State.Vehicles.VehiclesYellow;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContextTest {

  // Test scenario: No pedestrians waiting
  @Test
  public void testNoPedestrians() {
    // Create a new context
    Context context = new Context();

    sleep(50);// Wait for a short duration
    assertInstanceOf(VehiclesGreen.class, context.getState(), "State should be VehiclesGreen");

    sleep(10050); // Wait for another duration
    assertInstanceOf(VehiclesGreenInt.class, context.getState(), "State should be VehiclesGreenInt");

    sleep(5000); // Wait for another duration
    assertInstanceOf(VehiclesGreenInt.class, context.getState(), "State should be VehiclesGreenInt");

    sleep(5000); // Wait for another duration
    assertInstanceOf(VehiclesGreenInt.class, context.getState(), "State should be VehiclesGreenInt");

    sleep(5000); // Wait for another duration
    assertInstanceOf(VehiclesGreenInt.class, context.getState(), "State should be VehiclesGreenInt");
  }

  // Test scenario: Pedestrians waiting during VehiclesGreen
  @Test
  public void testPedestriansWaitingDuringVehiclesGreen() {
    Context context = new Context();
    sleep(50); // Wait for a short duration
    // Ensure that the initial state is VehiclesGreen
    assertInstanceOf(VehiclesGreen.class, context.getState(), "State should be VehiclesGreen");

    context.pedestrianWaiting(); // Indicate that pedestrians are waiting
    // Ensure that the state remains as VehiclesGreen
    assertInstanceOf(VehiclesGreen.class, context.getState(), "State should be VehiclesGreen");

    sleep(10050); // Wait for another duration
    // Ensure that the state transitions to VehiclesYellow
    assertInstanceOf(VehiclesYellow.class, context.getState(), "State should be VehiclesYellow");

    sleep(3050); // Wait for another duration
    // Ensure that the state transitions to PedestriansWalk
    assertInstanceOf(PedestriansWalk.class, context.getState(), "State should be PedestriansWalk");

    sleep(15050); // Wait for another duration
    // Ensure that the state transitions to PedestriansFlash
    assertInstanceOf(PedestriansFlash.class, context.getState(), "State should be PedestriansFlash");

    sleep(14050); // Wait for another duration
    // Ensure that the state transitions back to VehiclesGreen
    assertInstanceOf(VehiclesGreen.class, context.getState(), "State should be VehiclesGreen");
  }

  // Test scenario: Pedestrians waiting during VehiclesGreenInt
  @Test
  public void testPedestriansWaitingDuringVehiclesGreenInt() {
    Context context = new Context();
    sleep(50);
    // Ensure that the initial state is VehiclesGreen
    assertInstanceOf(VehiclesGreen.class, context.getState(), "State should be VehiclesGreen");

    sleep(10050);
    // Ensure that the state transitions to VehiclesGreenInt
    assertInstanceOf(VehiclesGreenInt.class, context.getState(), "State should be VehiclesGreenInt");

    // Indicate that pedestrians are waiting
    context.pedestrianWaiting();
    sleep(50); 
    assertInstanceOf(VehiclesYellow.class, context.getState(), "State should be VehiclesYellow");

    sleep(3050);
    assertInstanceOf(PedestriansWalk.class, context.getState(), "State should be PedestriansWalk");

    sleep(15050);
    assertInstanceOf(PedestriansFlash.class, context.getState(), "State should be PedestriansFlash");

    sleep(14050);
    assertInstanceOf(VehiclesGreen.class, context.getState(), "State should be VehiclesGreen");
  }

  // Test scenario: Two Pedestrians waiting during VehiclesGreen
  @Test
  public void testTwoPedestriansWaiting() {
    // Create a new context
    Context context = new Context();
    sleep(50);
    // Ensure that the state remains as VehiclesGreen
    assertInstanceOf(VehiclesGreen.class, context.getState(), "State should be VehiclesGreen");

    // Indicate that one pedestrian is waiting
    context.pedestrianWaiting();
    sleep(50);
    assertInstanceOf(VehiclesGreen.class, context.getState(), "State should be VehiclesGreen");

    // Indicate that another pedestrian is waiting
    context.pedestrianWaiting();
    sleep(10050);
    // Ensure that the state transitions to VehiclesYellow
    assertInstanceOf(VehiclesYellow.class, context.getState(), "State should be VehiclesYellow");

    sleep(3050);
    // Ensure that the state transitions to PedestriansWalk
    assertInstanceOf(PedestriansWalk.class, context.getState(), "State should be PedestriansWalk");

    sleep(15050);
    // Ensure that the state transitions to PedestriansFlash
    assertInstanceOf(PedestriansFlash.class, context.getState(), "State should be PedestriansFlash");

    sleep(14050);
    // Ensure that the state transitions back to VehiclesGreen
    assertInstanceOf(VehiclesGreen.class, context.getState(), "State should be VehiclesGreen");
  }

// Helper method to sleep for a given duration
  private static void sleep(int duration) {
    try {
      Thread.sleep(duration);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

}
