package ro.ubbcluj.map.Container;

import ro.ubbcluj.map.model.Task;

public class QueueContainer implements Container {

    Task[] tasks;
    int prim;
    int ultim;
    int size;

    QueueContainer(){
        tasks = new Task[10];
        prim = 0;
        ultim = 0;
    }


    @Override
    public Task remove() {
        if(size == 0)
            return null;
        Task t = tasks[prim];
        prim++;
        return t;
    }

    @Override
    public void add(Task task) {
        if(ultim == tasks.length)
            resize();
        tasks[ultim] = task;
        ultim++;

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
        return false;
    }
}
