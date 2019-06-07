import java.util.Optional;
import java.util.function.Predicate;

public class Motorcycle extends Vehicle {

    String fuelType;

    private Motorcycle(Builder builder) {
        super(builder);
        this.fuelType = Optional.ofNullable(builder.fuelType).orElse("Gasoline");
    }

    @Override
    public VehicleType getVehicleType() {
        return VehicleType.MOTORCYLE;
    }

    @Override
    public String toString() {
        return super.toString() + ", fuelType="+ fuelType;
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
