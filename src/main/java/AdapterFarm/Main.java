package AdapterFarm;

import AdapterFarm.Farm.*;
import AdapterFarm.Wooden.WoodenHorse;
import AdapterFarm.Wooden.WoodenStructureAdapter;
import AdapterFarm.Wooden.WoodenStructures;

public class Main {
    public static void main(String[] args) {

        Cow cow = new Cow(1, 2, Gender.MALE);
        WoodenStructures woodenHorse = new WoodenHorse();

        Animal woodenAdapter = new WoodenStructureAdapter(woodenHorse);

        System.out.println(woodenAdapter.mate(cow, 2).getClass());
        woodenAdapter.move(new Point(1, 2));
    }
}
