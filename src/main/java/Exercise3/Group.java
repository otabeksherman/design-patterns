package Exercise3;

public class Group implements Appliance {
    private int id;
    private int size;

    public Group(int id, int size) {
        this.id = id;
        this.size = size;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public int getId() {
        return this.id;
    }
}
