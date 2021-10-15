package ro.ubbcluj.map.Container;

import ro.ubbcluj.map.model.Task;


// superclass with size attr
// and size() + isEmpty() methods

public class QueueContainer extends DynamicContainer implements Container {

    Task[] tasks;
    int prim;
    int ultim;

    public QueueContainer(){
        super();
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
        size--;
        return t;
    }

    @Override
    public void add(Task task) {
        if(ultim == tasks.length)
            resize();
        tasks[ultim] = task;
        ultim++;
        size++;

    }

    private void resize() {
        Task[] copyTasks = new Task[2 * tasks.length];
        // copy from the prim position
        // we have no interest on the 0... prim-1 elements
        System.arraycopy(tasks, prim, copyTasks, 0, size);
        tasks = copyTasks;
        prim = 0;
        ultim = size;

    }

}
