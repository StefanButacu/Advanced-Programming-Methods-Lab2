package ro.ubbcluj.map.Runner;

import ro.ubbcluj.map.Container.Container;
import ro.ubbcluj.map.Container.QueueContainer;
import ro.ubbcluj.map.Container.StackContainer;
import ro.ubbcluj.map.Container.Strategy;
import ro.ubbcluj.map.factory.TaskContainerFactory;
import ro.ubbcluj.map.model.Task;

public class StrategyTaskRunner implements  TaskRunner{

    private Container container = null;

    public StrategyTaskRunner(Strategy st){
        container = TaskContainerFactory.getInstance().createContainer(st);
//        if(st == Strategy.LIFO)
//            this.container = new StackContainer();
//        else
//            this.container = new QueueContainer();

    }

    @Override
    public void executeOneTask() {
        if(!container.isEmpty())
            container.remove().execute();
    }

    @Override
    public void executeAll() {
        while(!container.isEmpty()){
            executeOneTask();
        }
    }

    @Override
    public void addTask(Task t) {
        container.add(t);
    }

    @Override
    public boolean hasTask() {
        return container.isEmpty();
    }
}
