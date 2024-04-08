public class Ship {
    private String name;
    private int size;
    private boolean isHorizontal;
    private int[] position;

    public Ship(String name, int size) {
        this.name = name;
        this.size = size;
        position = new int[size];
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }

    public boolean isHorizontal() {
        return isHorizontal;
    }

    public void setHorizontal(boolean horizontal) {
        isHorizontal = horizontal;
    }

    public int[] getPosition() {
        return position;
    }

    public void setPosition(int[] position) {
        this.position = position;
    }
}