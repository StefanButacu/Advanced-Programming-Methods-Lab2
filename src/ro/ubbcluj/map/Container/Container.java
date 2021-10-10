package ro.ubbcluj.map.Container;

import ro.ubbcluj.map.model.Task;

public interface Container {
    Task remove();
    void add(Task task);
    int size();
    boolean isEmpty();
}
