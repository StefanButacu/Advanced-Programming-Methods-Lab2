package ro.ubbcluj.map;

import ro.ubbcluj.map.Container.Container;
import ro.ubbcluj.map.Container.Strategy;
import ro.ubbcluj.map.factory.Factory;
import ro.ubbcluj.map.factory.TaskContainerFactory;
import ro.ubbcluj.map.model.MessageTask;

import java.time.LocalDateTime;

public class Main {

    public static MessageTask[] createMessageTaskArray(){
        MessageTask t1=new MessageTask("1","Feedback lab1",
                "Ai obtinut 9.60","Gigi", "Ana", LocalDateTime.now());
        MessageTask t2=new MessageTask("2","Feedback lab1",
                "Ai obtinut 5.60","Gigi", "Ana", LocalDateTime.now());
        MessageTask t3=new MessageTask("3","Feedback lab3",
                "Ai obtinut 10","Gigi", "Ana", LocalDateTime.now());
        return new MessageTask[]{t1,t2,t3};
    }
    public static void main(String[] args) {
        MessageTask[] l=createMessageTaskArray();
        for (MessageTask messageTask : l) {
            System.out.println(messageTask);
        }
        Factory fabrica = TaskContainerFactory.getInstance();
        Container container = fabrica.createContainer(Strategy.LIFO);
        container.add(l[0]);
        System.out.println(container.remove());
    }

}
