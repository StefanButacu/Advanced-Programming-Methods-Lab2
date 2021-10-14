package ro.ubbcluj.map.Tests;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import ro.ubbcluj.map.Container.StackContainer;
import ro.ubbcluj.map.model.MessageTask;
import ro.ubbcluj.map.model.Task;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class StackContainerTest {
    MessageTask m1 = new MessageTask("1", "Feedback lab1", "Ai obtinut 9.60", "Gigi", "Ana", LocalDateTime.of(2021,5,10,9,14));
    MessageTask m2 = new MessageTask("2", "Feedback lab2", "Ai obtinut 1.60", "Stef", "Cami", LocalDateTime.of(2020,1,30,1,25));
    MessageTask m3 = new MessageTask("3", "Feedback lab3", "Ai obtinut 2.60", "Mircea", "Iancu", LocalDateTime.of(2021,12,10,22,14));
    MessageTask m4 = new MessageTask("4", "Feedback lab4", "Ai obtinut 10, Felicitari", "Florin", "Ana", LocalDateTime.of(2021,5,23,9,14));
    MessageTask m5 = new MessageTask("5", "Feedback lab5", "Ai obtinut 9", "Adi", "Geo", LocalDateTime.of(2021,7,14,9,14));
    MessageTask[] tasks = new MessageTask[]{m1,m2,m3,m4,m5};


    @Test
    void remove() {
        StackContainer s = new StackContainer();
        assertNull(s.remove());
        s.add(new MessageTask("1", "desc", "bla", "gig", "ana", LocalDateTime.now()));
        assertEquals(s.remove().getTaskId(), "1");
        s.add(m1);
        s.add(m2);
        s.add(m3);
        assertEquals(s.remove().getTaskId(), "3");
    }

    @Test
    void add() {
        StackContainer s = new StackContainer();
        for(int j = 0 ; j < 5; j++)
            for (MessageTask task : tasks) s.add(task);
        assertEquals(s.size(), 25);
    }

    @Test
    void size() {
        StackContainer s = new StackContainer();
        assertEquals(s.size(), 0);
        for(int j = 0 ; j < 3; j++)
        {
            for (MessageTask task : tasks) s.add(task);
            assertEquals(s.size(), (j+1) * 5);
        }
        assertEquals(s.size(), 15);
    }

    @Test
    void isEmpty() {
        StackContainer s = new StackContainer();
        assertTrue(s.isEmpty());
        for(int j = 0 ; j < 3; j++)
        {
            for (MessageTask task : tasks) s.add(task);
            assertFalse(s.isEmpty());
        }
        for(int i = 0 ; i < 15; i++)
            s.remove();
        assertTrue(s.isEmpty());
    }
}