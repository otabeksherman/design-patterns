package AdapterFarm.Farm;

public interface Animal {
    public void move(Point point);
    public Animal mate(Animal partner, int id);
    public AnimalType getAnimalType();
    public Gender getGender();
}
