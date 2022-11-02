package Exercise1.Vehicles;

import Exercise1.Passenger;

public class Boat implements Vehicle {
    @Override
    public void transport(Passenger passenger) {
        System.out.println(String.format("%s gets a Boat", passenger.getName()));
    }
}
