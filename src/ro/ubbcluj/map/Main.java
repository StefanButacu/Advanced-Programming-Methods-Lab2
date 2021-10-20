package ro.ubbcluj.map;

import ro.ubbcluj.map.Container.Strategy;
import ro.ubbcluj.map.Decorator.DelayTaskRunnerDecorator;
import ro.ubbcluj.map.Decorator.PrinterTaskRunnerDecorator;
import ro.ubbcluj.map.Runner.StrategyTaskRunner;
import ro.ubbcluj.map.model.MessageTask;

import java.time.LocalDateTime;

public class Main {

    public static MessageTask[] createMessageTaskArray(){
        MessageTask t1=new MessageTask("1","Feedback lab1",
                "Ai obtinut 9.60","Gigi", "Ana", LocalDateTime.now());
        MessageTask t2=new MessageTask("2","Feedback lab1",
                "Ai obtinut 5.60","Gigi", "Ana", LocalDateTime.now());

        MessageTask m2 = new MessageTask("2", "Feedback lab2", "Ai obtinut 1.60", "Stef", "Cami", LocalDateTime.of(2020,1,30,1,25));
        MessageTask m3 = new MessageTask("3", "Feedback lab3", "Ai obtinut 2.60", "Mircea", "Iancu", LocalDateTime.of(2021,12,10,22,14));
        MessageTask m4 = new MessageTask("4", "Feedback lab4", "Ai obtinut 10, Felicitari", "Florin", "Ana", LocalDateTime.of(2021,5,23,9,14));
        MessageTask m5 = new MessageTask("5", "Feedback lab5", "Ai obtinut 9", "Adi", "Geo", LocalDateTime.of(2021,7,14,9,14));
        MessageTask[] tasks = new MessageTask[]{m2,m3,m4,m5};
        return new MessageTask[]{t1,t2,m2,m3,m4,m5};
    }

    public static void testDecorators(String[] args){

        MessageTask[] l = createMessageTaskArray();
        Strategy st = (args[0].equals("LIFO"))  ? Strategy.LIFO : Strategy.FIFO;
        testStrategy(st);
        testPrinter(st);
        testDelay(st);

    }

    private static void testDelay(Strategy st) {
        MessageTask[] l = createMessageTaskArray();
        StrategyTaskRunner tr = new StrategyTaskRunner(st);
        for(MessageTask m: l){
            tr.addTask(m);
        }

        DelayTaskRunnerDecorator dl = new DelayTaskRunnerDecorator(tr);
        dl.executeAll();
        System.out.println("Delay tasks executed!");

    }

    private static void testPrinter(Strategy st) {
        MessageTask[] l = createMessageTaskArray();
        StrategyTaskRunner tr = new StrategyTaskRunner(st);
        for(MessageTask m: l){
            tr.addTask(m);
        }
        PrinterTaskRunnerDecorator pr = new PrinterTaskRunnerDecorator(tr);
        pr.executeAll();
        System.out.println("Printer tasks executed!");
    }

    private static void testStrategy(Strategy st) {
        MessageTask[] l = createMessageTaskArray();
        StrategyTaskRunner tr = new StrategyTaskRunner(st);
        for(MessageTask m: l){
            tr.addTask(m);
        }
         tr.executeAll();
        System.out.println("Strategy tasks executed!");
    }

    public static void main(String[] args) {

        if(args.length < 1)
        {
            System.out.println("Invalid number of args");
            return;
        }
        testDecorators(args);
       }

}
