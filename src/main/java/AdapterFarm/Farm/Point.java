package AdapterFarm.Farm;

public class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void moveAnimal(Point point) {
        moveAnimal(point.x, point.y);
    }

    public void moveAnimal(int newX, int newY) {
        this.x = newX;
        this.y = newY;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
