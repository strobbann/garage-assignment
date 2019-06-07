import java.util.Optional;

public class Bus extends Vehicle{

    int numberOfSeats;


    private Bus(Builder builder) {
        super(builder);
        this.numberOfSeats = Optional.ofNullable(builder.numberOfSeats).orElse(40);
    }

    @Override
    public VehicleType getVehicleType() {
        return VehicleType.BUS;
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public String toString() {
        return super.toString() + ", numberOfSeats=" + numberOfSeats;
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
