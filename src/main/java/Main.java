public class Main {

    public static void main(String[] args){
        Garage garage = new Garage();
        Vehicle car = Motorcycle.builder().withRegistrationNumber("AA123").build();
        System.out.println(car);
    }

}
