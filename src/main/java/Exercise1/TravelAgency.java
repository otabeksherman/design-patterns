package Exercise1;

import Exercise1.Vehicles.*;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class TravelAgency {

    private static TravelAgency instance;
    private final int numOfAllVehicles = 16;
    private HashMap<Vehicle, Passenger> assignedVehicles = new HashMap<>();
    private HashMap<VehicleType, Integer> availableVehicles = new HashMap<>();

    public static TravelAgency getInstance() {
        if (instance == null) {
            instance = new TravelAgency();
        }
        return instance;
    }

    private TravelAgency() {
        availableVehicles.put(VehicleType.PLANE, 1);
        availableVehicles.put(VehicleType.BUS, 4);
        availableVehicles.put(VehicleType.TAXI, 8);
        availableVehicles.put(VehicleType.BOAT, 3);
    }

    public void assignPassenger(Passenger passenger) {
        if (assignedVehicles.size() == numOfAllVehicles) {
            System.out.println("All vehicles used, invoking transport method of all vehicles.");
            for (Map.Entry<Vehicle, Passenger> entry : assignedVehicles.entrySet()) {
                entry.getKey().transport(entry.getValue());
            }
        } else {
            Vehicle vehicle = createVehicle(passenger.getFavoriteVehicle());
            vehicle.transport(passenger);
            assignedVehicles.put(vehicle, passenger);
        }
    }

    private Vehicle createVehicle(VehicleType vehicleType) {
        int amount;
        switch (vehicleType) {
            case BUS:
                amount = availableVehicles.get(VehicleType.BUS);
                if (amount > 0) {
                    availableVehicles.put(VehicleType.BUS, amount - 1);
                    return new Bus();
                } else {
                    return createVehicle(getRandomVehicleType(List.of(
                            VehicleType.TAXI, VehicleType.BOAT, VehicleType.PLANE)));
                }
            case TAXI:
                amount = availableVehicles.get(VehicleType.TAXI);
                if (amount > 0) {
                    availableVehicles.put(VehicleType.TAXI, amount - 1);
                    return new Taxi();
                } else {
                    return createVehicle(getRandomVehicleType(List.of(
                            VehicleType.BUS, VehicleType.BOAT, VehicleType.PLANE)));
                }
            case BOAT:
                amount = availableVehicles.get(VehicleType.BOAT);
                if (amount > 0) {
                    availableVehicles.put(VehicleType.BOAT, amount - 1);
                    return new Boat();
                } else {
                    return createVehicle(getRandomVehicleType(List.of(
                            VehicleType.BUS, VehicleType.TAXI, VehicleType.PLANE)));
                }
            case PLANE:
                amount = availableVehicles.get(VehicleType.PLANE);
                if (amount > 0) {
                    availableVehicles.put(VehicleType.PLANE, amount - 1);
                    return new Plane();
                } else {
                   return createVehicle(getRandomVehicleType(List.of(
                           VehicleType.BUS, VehicleType.BOAT, VehicleType.TAXI)));
                }
        }
        return null;
    }

    private VehicleType getRandomVehicleType(List<VehicleType> vehicleTypes) {
        int index = ThreadLocalRandom.current().nextInt(vehicleTypes.size());
        return vehicleTypes.get(index);
    }
}
