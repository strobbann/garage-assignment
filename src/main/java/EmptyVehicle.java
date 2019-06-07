public class EmptyVehicle extends Vehicle {

    private EmptyVehicle() {
        super();
    }
    @Override
    public boolean park(Garage garage) {
        return false;
    }

    @Override
    public VehicleType getVehicleType() {
        return VehicleType.EMPTYVEHICLE;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder extends Vehicle.Builder<Builder> {

        @Override
        public Vehicle build() {
            return new EmptyVehicle();
        }
    }
}
