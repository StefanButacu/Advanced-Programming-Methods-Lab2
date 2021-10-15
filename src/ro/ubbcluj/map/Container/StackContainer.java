package ro.ubbcluj.map.Container;

import ro.ubbcluj.map.model.Task;
// superclass with size attr
// and size() + isEmpty() methods

public class StackContainer extends DynamicContainer implements Container {

    private Task[] tasks;

    public StackContainer() {
        super();
        tasks = new Task[10];

    }

    /**
     * Removes the last added element
     * @return - null if the stack is empty
     *          - last task otherwise
     */
    @Override
    public Task remove() {
        if (size == 0)
            return null;
        Task t = tasks[size - 1];
        size--;
        return t;
    }

    /**
     * Adds a new task to the container
     * @param task - Task type
     */
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

}
