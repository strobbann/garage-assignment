import java.util.ArrayList;
import java.util.Optional;

public abstract class Vehicle {

    protected String registrationNumber;

    protected Integer numberOfWheels;

    protected Integer parkinglotNumber;

    protected Color color;

    protected ArrayList<String> takenRegistrationNumbers = new ArrayList<>();


    protected Vehicle() {

    }

    public enum VehicleType {
        EMPTYVEHICLE(-1), CAR(1), MOTORCYLE(11), BUS(21);

        int type;

        VehicleType(int type) {
            this.type = type;
        }
    }

    protected Vehicle(Builder builder) {
        if (!setRegistrationNumber(builder.registrationNumber))
            throw new IllegalArgumentException("The registration number " + builder.registrationNumber + " is already taken.");
        this.numberOfWheels = Optional.ofNullable(builder.numberOfWheels).orElse(4);
        this.parkinglotNumber = builder.parkinglotNumber;
        this.color = Optional.ofNullable(builder.color).orElse(Color.PURPLE);
    }

    //returns -1 instead of throwing exception
    public boolean park(Garage garage) {
        int emptySlot = garage.findParkingLot(getVehicleType());
        if (emptySlot != -1) {
            garage.park(this, emptySlot);
            return true;
        }
        return false;
    }

    public abstract VehicleType getVehicleType();

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public boolean setRegistrationNumber(String registrationNumber) {
        for (String regnum : takenRegistrationNumbers) {
            if (regnum.equalsIgnoreCase(registrationNumber)) {
                return false;
            }
        }
        takenRegistrationNumbers.add(registrationNumber);
        this.registrationNumber = Optional.of(registrationNumber).get();
        return true;
    }

    public int getParkinglotNumber() {
        return parkinglotNumber;
    }

    public void setParkinglotNumber(int parkinglotNumber) {
        this.parkinglotNumber = parkinglotNumber;
    }

    @Override
    public String toString() {
        return "vehicleType='" + getVehicleType().name() + '\'' +
                ", registrationNumber='" + registrationNumber + '\'' +
                ", color='" + color + '\'' +
                ", numberOfWheels=" + numberOfWheels +
                ", parkinglotNumber=" + parkinglotNumber;
    }


    public static abstract class Builder<B extends Builder> {
        private String registrationNumber;

        private Integer numberOfWheels;

        private Integer parkinglotNumber;

        private Color color;

        public B withRegistrationNumber(String registrationNumber) {
            this.registrationNumber = registrationNumber;
            return (B) this;
        }

        public B withNumberOfWheels(Integer numberOfWheels) {
            this.numberOfWheels = numberOfWheels;
            return (B) this;
        }

        public B withParkingLotNumber(Integer parkinglotNumber) {
            this.parkinglotNumber = parkinglotNumber;
            return (B) this;
        }

        public B withColor(Color color) {
            this.color = color;
            return (B) this;
        }

        public abstract Vehicle build();

    }
}