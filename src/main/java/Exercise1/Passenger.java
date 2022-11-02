package Exercise1;

import Exercise1.Vehicles.VehicleType;

public class Passenger {
    private String name;
    private VehicleType favoriteVehicle;

    public Passenger(String name, VehicleType vehicle) {
        this.name = name;
        this.favoriteVehicle = vehicle;
    }

    public String getName() {
        return this.name;
    }

    public VehicleType getFavoriteVehicle() {
        return this.favoriteVehicle;
    }
}
