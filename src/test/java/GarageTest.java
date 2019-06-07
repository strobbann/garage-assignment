import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class GarageTest {

    @Rule
    public ExpectedException ex = ExpectedException.none();

    @Test
    public void park() {
        Garage testGarage = new Garage();
        Vehicle testVehicle1 = Car.builder().withRegistrationNumber("QWE001").build();
        Vehicle testVehicle2 = Car.builder().withRegistrationNumber("QWE002").build();
        Vehicle testVehicle3 = Car.builder().withRegistrationNumber("QWE003").build();
        Vehicle testVehicle4 = Car.builder().withRegistrationNumber("QWE004").build();
        Vehicle testVehicle5 = Car.builder().withRegistrationNumber("QWE005").withCylinderVolume(1400).build();

        Vehicle testVehicle6 = Bus.builder().withRegistrationNumber("RTY412").withNumberOfSeats(30).build();

        Vehicle testMotorbike1 = Motorcycle.builder().withRegistrationNumber("DSL007").build();
        //Vehicle testMotorbike1 = new Motorcycle("DSL007", "gasoline");


        testGarage.park(testVehicle6, testGarage.findParkingLot(testVehicle6.getVehicleType()));
        testGarage.park(testVehicle1, testGarage.findParkingLot(testVehicle1.getVehicleType()));
        testGarage.park(testVehicle2, testGarage.findParkingLot(testVehicle2.getVehicleType()));
        testGarage.park(testVehicle3, testGarage.findParkingLot(testVehicle3.getVehicleType()));
        testGarage.park(testVehicle4, testGarage.findParkingLot(testVehicle4.getVehicleType()));
        testGarage.park(testVehicle5, testGarage.findParkingLot(testVehicle5.getVehicleType()));
        testGarage.park(testMotorbike1, testGarage.findParkingLot(testMotorbike1.getVehicleType()));
/*
        for(int i=1; i<=96; i++){
            testGarage.park(new EmptyVehicle(), 1);
        }
*/
        testGarage.unpark("QWE003");
        testGarage.unpark("QWE004");

        /*
        assertSame( testVehicle1, testGarage.getVehicleByRegistrationNumber("QWE001"));
        assertSame(testMotorbike1, testGarage.getVehicleByRegistrationNumber("DSL007"));
        assertSame(testVehicle6, testGarage.getVehicleByRegistrationNumber("RTY412"));
        assertSame(testVehicle3, testGarage.getVehicleByRegistrationNumber("QWE003"));
        */

        System.out.println(testGarage);
    }

    @Test
    public void unpark() {
        Garage testGarage = new Garage();
        Vehicle testVehicle1 = Car.builder().withRegistrationNumber("QWE542").build();
        Vehicle testVehicle2 = Bus.builder().withRegistrationNumber("RTY412").withNumberOfSeats(30).build();

        testGarage.park(testVehicle1, testGarage.findParkingLot(testVehicle1.getVehicleType()));
        testGarage.park(testVehicle2, testGarage.findParkingLot(testVehicle2.getVehicleType()));

        System.out.println(testGarage);

        testGarage.unpark(testVehicle2);

        assertSame(testVehicle1, testGarage.getVehicleByRegistrationNumber("QWE542"));

        ex.expectMessage("Registration number not exist");
        ex.expect(IllegalArgumentException.class);
        testGarage.getVehicleByRegistrationNumber("RTY412");

    }

    @Test
    public void getVehicleByRegistrationNumber() {
        Garage testGarage = new Garage();
        Vehicle testVehicle1 = Car.builder().withRegistrationNumber("ASD124").build();
        Vehicle testVehicle2 = Motorcycle.builder().withRegistrationNumber("ASD123").build();

        testGarage.park(testVehicle1, testGarage.findParkingLot(testVehicle1.getVehicleType()));
        testGarage.park(testVehicle2, testGarage.findParkingLot(testVehicle2.getVehicleType()));

        assertSame(testVehicle2, testGarage.getVehicleByRegistrationNumber("ASD123"));
    }

    @Test
    public void getVehicles() {
    }

    @Test
    public void getTypesParked() {
    }

    @Test
    public void setMaxCapacity() {
    }

    @Test
    public void save() {
    }

    @Test
    public void load() {
    }
}