package AdapterFarm.Farm;

public class Sheep extends AbstractAnimal{

    public Sheep(int id, double weight, Gender gender) {
        super(AnimalType.SHEEP, id, weight, gender);
    }

    @Override
    public Animal mate(Animal partner, int id) {
        return super.mate(partner, id);
    }
}
