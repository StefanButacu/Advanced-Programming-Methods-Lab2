package ro.ubbcluj.map.Container;

import ro.ubbcluj.map.model.Task;

public class StackContainer implements Container {

    int size;
    private Task[] tasks;

    public StackContainer() {
        tasks = new Task[10];
        size = 0;

    }

    @Override
    public Task remove() {
        if (size == 0)
            return null;
        Task t = tasks[size - 1];
        size--;
        return t;
    }

    @Override
    public void add(Task task) {
        if (size == tasks.length)
            resize();
        tasks[size] = task;
        size++;


    }

    private void resize() {

        Task[] copyTasks = new Task[2 * tasks.length];
        System.arraycopy(tasks, 0, copyTasks, 0, size);
        tasks = copyTasks;

    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}