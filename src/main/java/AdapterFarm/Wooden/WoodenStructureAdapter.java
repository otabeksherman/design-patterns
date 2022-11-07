package AdapterFarm.Wooden;

import AdapterFarm.Farm.Animal;
import AdapterFarm.Farm.AnimalType;
import AdapterFarm.Farm.Gender;
import AdapterFarm.Farm.Point;

public class WoodenStructureAdapter implements Animal {
    WoodenStructures woodenStructures;

    public WoodenStructureAdapter(WoodenStructures woodenStructures) {
        this.woodenStructures = woodenStructures;
    }
    @Override
    public void move(Point point) {
        woodenStructures.roll();
    }

    @Override
    public Animal mate(Animal partner, int id) {
        return new WoodenStructureAdapter(woodenStructures.replicate());
    }

    @Override
    public AnimalType getAnimalType() {
        return null;
    }

    @Override
    public Gender getGender() {
        return null;
    }
}
