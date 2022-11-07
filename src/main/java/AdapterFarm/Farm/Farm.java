package AdapterFarm.Farm;

import java.util.*;

public class Farm {

    private HashMap<Integer, Animal> animals;
    private Set<Integer> animalIds;
    private Random random;
    private final int ID_UPPER_BOUND = 10000000;

    public Farm() {
        this.animals = new HashMap<>();
        this.animalIds = new HashSet<>();
        this.random = new Random();
    }

    public static Farm createFarm() {
        return new Farm();
    }

    public void acquire(AnimalType animalType) {
        int newId = generateId();
        Animal animal = AnimalFactory.acquireAnimal(animalType, newId);
        addNewAnimal(animal, newId);
    }

    public void mate(Animal animal1, Animal animal2) {
        int newId = generateId();
        Animal animal = animal1.mate(animal2, newId);
        addNewAnimal(animal, newId);
    }

    public void addNewAnimal(Animal animal, int newId) {
        if (animal != null) {
            animals.put(newId, animal);
            animalIds.add(newId);
            System.out.println("New animal added!" + animal.toString());
        } else {
            System.out.println("New animal didn't added");
        }
    }

    public Animal getAnimal(int id) {
        return animals.get(id);
    }

    private int generateId() {
        int newId;
        do {
            newId = random.nextInt(ID_UPPER_BOUND);
        } while(animalIds.contains(newId));
        return newId;
    }

    public void printAnimals() {
        animals.forEach((k, v) -> System.out.println(v.toString()));
    }
}
