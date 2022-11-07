package AdapterFarm.Farm;

public class Horse extends AbstractAnimal{

    public Horse(int id, double weight, Gender gender) {
        super(AnimalType.HORSE, id, weight, gender);
    }

    @Override
    public Animal mate(Animal partner, int id) {
        return super.mate(partner, id);
    }
}
