package ro.ubbcluj.map.model;

import ro.ubbcluj.map.utils.AbstractSorter;

import java.util.Arrays;

public class SortingTask extends Task{

    private AbstractSorter sorter;
     int[] ints;
    public SortingTask(String taskId, String taskDescription, int[] ints, AbstractSorter sorter){
        super(taskId, taskDescription);
        this.ints = ints;
        this.sorter = sorter;

    }

    @Override
    public void execute() {
       this.sorter.sort(this.ints);
    }

    public int[] getSortedArray(){
        return this.ints;
    }
}
