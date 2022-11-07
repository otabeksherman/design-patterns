package AdapterFarm.Wooden;

public class WoodenHorse implements WoodenStructures {
    @Override
    public void roll() {
        System.out.println("Wooden Horse Rolling!");
    }

    @Override
    public WoodenStructures replicate() {
        return new WoodenHorse();
    }
}
