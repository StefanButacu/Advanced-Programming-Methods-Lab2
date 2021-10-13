package ro.ubbcluj.map.model;

import java.time.LocalDateTime;
import java.util.Arrays;

public class MessageTaskPrinter {
    public static void main(String[] arg){
        MessageTask m1 = new MessageTask("1", "Feedback lab1", "Ai obtinut 9.60", "Gigi", "Ana", LocalDateTime.of(2021,5,10,9,14));
        MessageTask m2 = new MessageTask("2", "Feedback lab2", "Ai obtinut 1.60", "Stef", "Cami", LocalDateTime.of(2020,1,30,1,25));
        MessageTask m3 = new MessageTask("3", "Feedback lab3", "Ai obtinut 2.60", "Mircea", "Iancu", LocalDateTime.of(2021,12,10,22,14));
        MessageTask m4 = new MessageTask("4", "Feedback lab4", "Ai obtinut 10, Felicitari", "Florin", "Ana", LocalDateTime.of(2021,5,23,9,14));
        MessageTask m5 = new MessageTask("5", "Feedback lab5", "Ai obtinut 9", "Adi", "Geo", LocalDateTime.of(2021,7,14,9,14));
        MessageTask[] msgTasks = new MessageTask[]{m1,m2,m3,m4,m5};
        System.out.println(Arrays.toString(msgTasks));

    }
}
