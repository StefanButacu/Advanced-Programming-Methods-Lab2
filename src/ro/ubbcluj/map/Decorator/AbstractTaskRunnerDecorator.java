package ro.ubbcluj.map.Decorator;


import ro.ubbcluj.map.Runner.TaskRunner;
import ro.ubbcluj.map.model.Task;

public abstract class AbstractTaskRunnerDecorator implements TaskRunner {
    private TaskRunner taskRunner;


    public AbstractTaskRunnerDecorator(TaskRunner taskRunner){
        this.taskRunner = taskRunner;

    }

    @Override
    public void executeOneTask() {
        taskRunner.executeOneTask();
    }

    @Override
    public void executeAll() {
        while(!taskRunner.hasTask())
            executeOneTask();

        //taskRunner.executeAll();
    }

    @Override
    public void addTask(Task t) {
        taskRunner.addTask(t);
    }

    @Override
    public boolean hasTask() {
        return taskRunner.hasTask();
    }
}
