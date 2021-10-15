package ro.ubbcluj.map.Container;

public class DynamicContainer {
    int size;

    public DynamicContainer() {
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
