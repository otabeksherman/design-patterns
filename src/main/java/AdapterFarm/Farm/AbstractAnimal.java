package AdapterFarm.Farm;

public abstract class AbstractAnimal implements Animal {
    private AnimalType animalType;
    private int id;
    private Gender gender;
    private double weight;
    private Point point;


    public AbstractAnimal(AnimalType animalType, int id, double weight, Gender gender) {
        this.animalType = animalType;
        this.id = id;
        this.gender = gender;
        this.weight = weight;
        this.point = new Point(0, 0);
    }

    @Override
    public void move(Point newPoint) {
        this.point.moveAnimal(newPoint);
    }

    @Override
    public Animal mate(Animal partner, int id) {
        if (this.animalType == partner.getAnimalType() && this.gender != partner.getGender()) {
            return AnimalFactory.createAnimal(this.animalType, id);
        }
        return  null;
    }

    public AnimalType getAnimalType() {
        return this.animalType;
    }

    public Gender getGender() {
        return this.gender;
    }

    @Override
    public String toString() {
        return "AbstractAnimal{" +
                "animalType=" + animalType +
                ", id=" + id +
                ", gender=" + gender +
                ", weight=" + weight +
                ", point=" + point +
                '}';
    }
}
