package ro.ubbcluj.map.Tests;

import org.junit.jupiter.api.Test;
import ro.ubbcluj.map.Container.QueueContainer;
import ro.ubbcluj.map.model.MessageTask;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class QueueContainerTest {
    MessageTask m1 = new MessageTask("1", "Feedback lab1", "Ai obtinut 9.60", "Gigi", "Ana", LocalDateTime.of(2021,5,10,9,14));
    MessageTask m2 = new MessageTask("2", "Feedback lab2", "Ai obtinut 1.60", "Stef", "Cami", LocalDateTime.of(2020,1,30,1,25));
    MessageTask m3 = new MessageTask("3", "Feedback lab3", "Ai obtinut 2.60", "Mircea", "Iancu", LocalDateTime.of(2021,12,10,22,14));
    MessageTask m4 = new MessageTask("4", "Feedback lab4", "Ai obtinut 10, Felicitari", "Florin", "Ana", LocalDateTime.of(2021,5,23,9,14));
    MessageTask m5 = new MessageTask("5", "Feedback lab5", "Ai obtinut 9", "Adi", "Geo", LocalDateTime.of(2021,7,14,9,14));
    MessageTask[] tasks = new MessageTask[]{m1,m2,m3,m4,m5};


    @Test
    void remove() {
        QueueContainer Q = new QueueContainer();
        assertNull(Q.remove());
        for(MessageTask m: tasks)
            Q.add(m);
        for(int i = 1; i <=5 ; i++){
            assertEquals(Q.remove().getTaskId(), Integer.toString(i));
        }
        assertNull(Q.remove());

    }

    @Test
    void add() {
        QueueContainer Q = new QueueContainer();
        for(int i = 0 ; i < 5; i++){
            for(MessageTask m: tasks)
                Q.add(m);
        }
        assertEquals(Q.size(), 25);
    }

    @Test
    void size() {
        QueueContainer Q = new QueueContainer();
        assertEquals(Q.size(), 0);
        for(int i = 0 ; i < 5; i++){
            for(MessageTask m: tasks)
                Q.add(m);
            assertEquals(Q.size(), (i+1)* 5);
        }
        assertEquals(Q.size(), 25);
        for(int i = 1; i <= 25; i++)
            Q.remove();
        assertEquals(Q.size(), 0);
    }

    @Test
    void isEmpty() {
        QueueContainer Q = new QueueContainer();
        assertTrue(Q.isEmpty());
        for(int i = 0 ; i < 5; i++){
            for(MessageTask m: tasks)
                Q.add(m);
        }
        assertFalse(Q.isEmpty());
        for(int i = 1; i <= 25; i++)
            Q.remove();
        assertTrue(Q.isEmpty());
    }
}