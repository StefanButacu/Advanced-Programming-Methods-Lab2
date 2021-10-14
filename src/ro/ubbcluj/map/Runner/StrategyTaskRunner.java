package ro.ubbcluj.map.Runner;

import ro.ubbcluj.map.Container.Container;
import ro.ubbcluj.map.Container.QueueContainer;
import ro.ubbcluj.map.Container.StackContainer;
import ro.ubbcluj.map.Container.Strategy;

public class StrategyTaskRunner {

    private Container container;

    StrategyTaskRunner(Strategy st){
        if(st == Strategy.LIFO)
            container = new StackContainer();
        else
            container = new QueueContainer();

    }
}
