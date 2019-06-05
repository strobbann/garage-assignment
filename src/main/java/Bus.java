import java.util.Optional;

public class Bus extends Vehicle{

    int numberOfSeats;


    private Bus(Builder builder) {
        super(builder);
        this.numberOfSeats = Optional.ofNullable(builder.numberOfSeats).orElse(40);
    }

    @Override
    //returns -1 instead of throwing exception
    public boolean park(Garage garage) {
        int emptySlot = garage.findParkingLot(Vehicle.BUS);
        if(emptySlot != -1){
            garage.park(this, emptySlot);
            return true;
        }
        return false;
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public String toString() {
        return super.toString() + "numberOfSeats=" + numberOfSeats;
    }

    public static class Builder extends Vehicle.Builder<Builder> {

        private Integer numberOfSeats;

        public Builder withNumberOfSeats(Integer numberOfSeats) {
            this.numberOfSeats = numberOfSeats;
            return this;
        }

        @Override
        public Vehicle build() {
            return new Bus(this);
        }
    }


}
