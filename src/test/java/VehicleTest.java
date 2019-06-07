import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class VehicleTest {

    @Test
    public void park() {
        Garage garage = new Garage();
        Vehicle testVehicle1 = Motorcycle.builder().withRegistrationNumber("RED987").build();
        Vehicle testVehicle2 = Bus.builder().withRegistrationNumber("POD783").build();

        testVehicle1.park(garage);
        testVehicle2.park(garage);

        assertEquals(testVehicle1, garage.getVehicleByRegistrationNumber("RED987"));
        assertEquals(testVehicle2, garage.getVehicleByRegistrationNumber("POD783"));
        System.out.println(garage);

    }
}
