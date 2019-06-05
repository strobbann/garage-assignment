import java.util.Optional;

public class Motorcycle extends Vehicle {

    String fuelType;

    private Motorcycle(Builder builder) {
        super(builder);
        this.fuelType = Optional.ofNullable(builder.fuelType).orElse("Gasoline");
    }

    @Override
    public boolean park(Garage garage) {
        int emptySlot = garage.findParkingLot(Vehicle.MOTORCYCLE);
        if(emptySlot != -1){
            garage.park(this, emptySlot);
            return true;
        }
        return false;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder extends Vehicle.Builder<Builder> {

        private String fuelType;

        public Builder withFuelType(String fuelType) {
            this.fuelType = fuelType;
            return this;
        }

        @Override
        public Vehicle build() {
            return new Motorcycle(this);
        }
    }

}
