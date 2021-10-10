package ro.ubbcluj.map.factory;

import ro.ubbcluj.map.Container.Container;
import ro.ubbcluj.map.Container.StackContainer;
import ro.ubbcluj.map.Container.Strategy;

public class TaskContainerFactory implements Factory{

    private static TaskContainerFactory instance = null;

    private TaskContainerFactory(){


    };

    public static TaskContainerFactory getInstance(){
        if(instance == null)
            instance = new TaskContainerFactory();
        return instance;

    }

    @Override
    public Container createContainer(Strategy st) {
        switch(st){
            case LIFO:
                return new StackContainer();
            default:
                return null;
        }
    }
}
