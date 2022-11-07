package AdapterFarm.Farm;

import java.util.Objects;

public class Farmer {

    public static Farmer createFarmer() {
        return new Farmer();
    }

    public void moveAnimal(Animal animal, Point point) {
        animal.move(point);
        System.out.println("Animal moved to " + point);
    }

    public void requestAnimal(Farm farm, int id) {
        Animal animal = Objects.requireNonNull(farm.getAnimal(id));
        System.out.println("Requested animal " + animal);
    }
}
