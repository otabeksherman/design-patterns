package AdapterFarm.Farm;

public class Cow extends AbstractAnimal{

    public Cow(int id, double weight, Gender gender) {
        super(AnimalType.COW, id, weight, gender);
    }

    public void sayMoo() {
        System.out.println("Mooooooo!");
    }

    @Override
    public Animal mate(Animal partner, int id) {
        return super.mate(partner, id);
    }
}
