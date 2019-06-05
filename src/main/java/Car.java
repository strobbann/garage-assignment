import java.util.Optional;

public class Car extends Vehicle{

    private Integer cylinderVolume;

    private Car(Builder builder) {
        super(builder);
        this.cylinderVolume = Optional.ofNullable(builder.cylinderVolume).orElse(1600);
    }

    public boolean park(Garage garage){
        /*
        go through the garage, when we find an empty slot, we park the vehicle there.
         */
        int emptySlot = garage.findParkingLot(Vehicle.CAR);
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
    public String toString(){
        return super.toString()+'\''+", cc: "+cylinderVolume;
    }

    public static class Builder extends Vehicle.Builder<Builder> {
        private Integer cylinderVolume;

        public Builder withCylinderVolume(Integer cylinderVolume) {
            this.cylinderVolume = cylinderVolume;
            return this;
        }

        @Override
        public Vehicle build() {
            return new Car(this);
        }
    }

}