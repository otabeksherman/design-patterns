package Exercise1.Vehicles;

import Exercise1.Passenger;

public class Plane implements Vehicle {
    @Override
    public void transport(Passenger passenger) {
        System.out.println(String.format("%s gets an Airplane", passenger.getName()));
    }
}
