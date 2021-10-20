package ro.ubbcluj.map.Decorator;

import ro.ubbcluj.map.Runner.TaskRunner;

public class DelayTaskRunnerDecorator extends AbstractTaskRunnerDecorator {
    public DelayTaskRunnerDecorator(TaskRunner taskRunner) {
        super(taskRunner);
    }

    /**
     * Executes task with delay of 3000 miliseconds
     */
    public void executeOneTask(){
        try{
            Thread.sleep(3000);
            super.executeOneTask();
        }catch(InterruptedException e){
            e.printStackTrace();

        }
    }
}
