package ro.ubbcluj.map.factory;

import ro.ubbcluj.map.Container.Container;
import ro.ubbcluj.map.Container.Strategy;

public interface Factory {

    Container createContainer(Strategy st);
}
