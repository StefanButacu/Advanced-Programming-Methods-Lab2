package ro.ubbcluj.map.factory;

import ro.ubbcluj.map.Container.Container;
import ro.ubbcluj.map.Container.QueueContainer;
import ro.ubbcluj.map.Container.StackContainer;
import ro.ubbcluj.map.Container.Strategy;

public class TaskContainerFactory implements Factory{

    private static TaskContainerFactory instance = null;

    private TaskContainerFactory(){
    }

    /**
     *
     * @return - the one and only instance of this class
     */
    public static TaskContainerFactory getInstance(){
        if(instance == null)
            instance = new TaskContainerFactory();
        return instance;

    }

    @Override
    public Container createContainer(Strategy st) {
        return switch (st) {
            case LIFO -> new StackContainer();
            case FIFO -> new QueueContainer();

        };
    }
}
