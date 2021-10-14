package ro.ubbcluj.map.Runner;

import ro.ubbcluj.map.model.Task;

public interface TaskRunner {
    /**
     * executes one task from the collection
     */
    void executeOneTask();

    /**
     * executes all tasks from the collection
     *
     */
    void executeAll();

    /**
     *  Adds a task to the collection of tasks
     * @param t - Task
     */
    void addTask(Task t);

    /**
     *
     * @return - true if there is at least one task, false otherwise
     */
    boolean hasTask();
}
