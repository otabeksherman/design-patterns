package Exercise3;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Appliance> appliances = new ArrayList<>();
        appliances.add(new User(1, "UseName1", "afwgfes"));
        appliances.add(new Asset(2, "UseName2", 100));
        appliances.add(new Group(3, 10));
        appliances.add(new User(4, "UseName1", "afw4363635gfes"));

        ExportToJsonVisitor visitor = new ExportToJsonVisitor();
        for (Appliance appliance : appliances) {
            appliance.accept(visitor);
        }
    }
}
