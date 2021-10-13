package ro.ubbcluj.map.Tests;

import org.junit.jupiter.api.Test;
import ro.ubbcluj.map.model.SortingTask;
import ro.ubbcluj.map.utils.AbstractSorter;
import ro.ubbcluj.map.utils.BubbleSorter;
import ro.ubbcluj.map.utils.QuickSorter;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SortingTaskTest {

    private int[] ints;
    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        ints = new int[] {2, 10, 23, 14, -1};
    }


    @Test
    void testBubbleSort(){
        AbstractSorter bubbleSorter = new BubbleSorter();
        bubbleSorter.sort(ints);
        assertArrayEquals(new int[]{-1,2,10,14,23}, bubbleSorter.sort(ints));
        ints = new int[]{ 0, 1 , 2, 3, 4};
        assertArrayEquals(new int[]{0,1,2,3,4}, bubbleSorter.sort(ints));

    }
    @Test
    void testQuickSort(){
        AbstractSorter quickSorter = new QuickSorter();

        assertArrayEquals(new int[]{-1,2,10,14,23}, quickSorter.sort(ints));
        ints = new int[]{ 0, 1 , 2, 3, 4};
        assertArrayEquals(new int[]{0,1,2,3,4}, quickSorter.sort(ints));
        ints = new int[] { 1, 4, -5, 30, 12, 9};
        assertArrayEquals(new int[]{-5,1,4,9,12, 30}, quickSorter.sort(ints));

        /// fail to sort this ???
        ints = new int[] {9,-1,24,51,2};
        int[] verif =  quickSorter.sort(ints);
        assertArrayEquals( new int[]{-1,2,9,24,51}, verif );

    }

    @Test
    void testSortingTaskBubble(){
        SortingTask sortingTask = new SortingTask("id", "Sorteaza", new int[] {9,-1,24,51,1}, new BubbleSorter());
        sortingTask.execute();
        assertArrayEquals(sortingTask.getSortedArray(), new int[]{-1,1,9,24,51});
    }
    @Test
    void testSortingTaskQuick(){
        SortingTask sortingTask = new SortingTask("id", "Sorteaza", new int[] {9,-1,24,51,1}, new QuickSorter());
        sortingTask.execute();
        assertArrayEquals(sortingTask.getSortedArray(), new int[]{-1,1,9,24,51});
    }


}