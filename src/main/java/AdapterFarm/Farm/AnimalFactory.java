package AdapterFarm.Farm;

import java.util.Random;

public class AnimalFactory {

    private static final double NEW_SHEEP_MIN_WEIGHT_IN_KG = 3.5;
    private static final double NEW_SHEEP_MAX_WEIGHT_IN_KG = 5.4;
    private static final double SHEEP_MAX_WEIGHT_IN_KG = 160;

    private static final double NEW_HORSE_MIN_WEIGHT_IN_KG = 36;
    private static final double NEW_HORSE_MAX_WEIGHT_IN_KG = 91;
    private static final double HORSE_MAX_WEIGHT_IN_KG = 1000;

    private static final double NEW_COW_MIN_WEIGHT_IN_KG = 29;
    private static final double NEW_COW_MAX_WEIGHT_IN_KG = 40.8;
    private static final double COW_MAX_WEIGHT_IN_KG = 500;


    public static Animal acquireAnimal(AnimalType animalType, int id) {
        Gender gender = getNewbornGender();
        double weight;
        switch(animalType) {
            case COW:
                weight = generateWeight(NEW_COW_MIN_WEIGHT_IN_KG, COW_MAX_WEIGHT_IN_KG);
                return new Cow( id, weight, gender);
            case HORSE:
                weight = generateWeight(NEW_HORSE_MIN_WEIGHT_IN_KG, HORSE_MAX_WEIGHT_IN_KG);
                return new Horse(id, weight, gender);
            case SHEEP:
                weight = generateWeight(NEW_SHEEP_MIN_WEIGHT_IN_KG, SHEEP_MAX_WEIGHT_IN_KG);
                return new Sheep( id, weight, gender);
        }
        return null;
    }

    public static Animal createAnimal(AnimalType animalType, int id) {
        Gender gender = getNewbornGender();
        double weight;
        switch(animalType) {
            case COW:
                weight = generateWeight(NEW_COW_MIN_WEIGHT_IN_KG, NEW_COW_MAX_WEIGHT_IN_KG);
                return new Cow(id, weight, gender);
            case HORSE:
                weight = generateWeight(NEW_HORSE_MIN_WEIGHT_IN_KG, NEW_HORSE_MAX_WEIGHT_IN_KG);
                return new Horse(id, weight, gender);
            case SHEEP:
                weight = generateWeight(NEW_SHEEP_MIN_WEIGHT_IN_KG, NEW_SHEEP_MAX_WEIGHT_IN_KG);
                return new Sheep(id, weight, gender);
        }
        return null;
    }


    private static Gender getNewbornGender() {
        Gender[] genders = Gender.values();
        Random random = new Random();
        return genders[random.nextInt(genders.length)];
    }

    private static double generateWeight(double min, double max) {
        return (min + new Random().nextDouble() * (max - min));
    }
}
