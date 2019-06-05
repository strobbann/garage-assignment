import java.util.ArrayList;
import java.util.Optional;

public abstract class Vehicle {

    protected String registrationNumber;

    protected Integer numberOfWheels;

    protected Integer parkinglotNumber;

    protected Color color;

    protected ArrayList<String> takenRegistrationNumbers = new ArrayList<>();

    protected static int CAR = 1;
    protected static int MOTORCYCLE = 11;
    protected static int BUS = 21;

    protected Vehicle() {

    }

    protected Vehicle(Builder builder) {
        if( !setRegistrationNumber(builder.registrationNumber) )
            throw new IllegalArgumentException("The registration number "+builder.registrationNumber+" is already taken.");
        this.numberOfWheels = Optional.ofNullable(builder.numberOfWheels).orElse(4);
        this.parkinglotNumber = builder.parkinglotNumber;
        this.color = Optional.ofNullable(builder.color).orElse(Color.PURPLE);
    }

    public abstract boolean park(Garage garage);

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public boolean setRegistrationNumber(String registrationNumber){
        for(String regnum : takenRegistrationNumbers){
            if(regnum.equalsIgnoreCase(registrationNumber)) {
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
        return  "registrationNumber='" + registrationNumber + '\'' +
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