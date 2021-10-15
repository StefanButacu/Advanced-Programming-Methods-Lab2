package ro.ubbcluj.map.Decorator;

import ro.ubbcluj.map.Runner.TaskRunner;
import ro.ubbcluj.map.utils.Constants;

import java.time.LocalDateTime;

public class PrinterTaskRunnerDecorator extends AbstractTaskRunnerDecorator {
    public PrinterTaskRunnerDecorator(TaskRunner taskRunner) {
        super(taskRunner);
    }

    @Override
    public void executeOneTask() {
        super.executeOneTask();
        System.out.println("Am executat la ora " + LocalDateTime.now().format(Constants.DATE_TIME_FORMATTER));

    }

}
