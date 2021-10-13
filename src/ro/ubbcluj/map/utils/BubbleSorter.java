package ro.ubbcluj.map.utils;

public class BubbleSorter extends AbstractSorter {


    @Override
    public int[] sort(int[] ints) {
        boolean isSorted = false;
        do{
            isSorted = true;
            for(int i = 0 ; i < ints.length - 1; i++){
                if(ints[i] > ints[i+1]){
                    int aux = ints[i];
                    ints[i] = ints[i+1];
                    ints[i+1] = aux;
                    isSorted = false;
                }

            }

        }while(!isSorted);
        return ints;
    }
}
