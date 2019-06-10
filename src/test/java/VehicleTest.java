import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class VehicleTest {

    @Test
    public void park() {
        Garage garage = new Garage();
        Vehicle testVehicle1 = Motorcycle.builder().withRegistrationNumber("RED987").withFuelType("Diesel").build();
        Vehicle testVehicle2 = Bus.builder().withNumberOfSeats(80).withRegistrationNumber("POD783").build();
        Vehicle testVehcile3 = Car.builder().withRegistrationNumber("IUO343").withCylinderVolume(1888).build();

        testVehicle1.park(garage);
        testVehicle2.park(garage);
        testVehcile3.park(garage);

        assertEquals(testVehicle1, garage.getVehicleByRegistrationNumber("RED987"));
        assertEquals(testVehicle2, garage.getVehicleByRegistrationNumber("POD783"));
        assertEquals(testVehcile3, garage.getVehicleByRegistrationNumber("IUO343"));
        System.out.println(garage);

    }
}
