package Exercise1;

import Exercise1.Vehicles.VehicleType;

public class Main {
    public static void main(String[] args) {
        TravelAgency travelAgency = TravelAgency.getInstance();

        for (int i = 1; i < 18; i++) {
            Passenger passenger = new Passenger("Bob" + i, VehicleType.BOAT);
            travelAgency.assignPassenger(passenger);
        }
    }
}
