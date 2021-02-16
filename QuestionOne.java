//Written by Andrew Duerr
//Array.sort() has nlogn performance
//since the sorted array need only be looked over once,
//the overall performance is O(nlogn)

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class QuestionOne {
    public static void main(String[] args) throws Exception {
        List<Integer> unsorted = List.of(1,7,2,3,19,5);
        List<Integer> sorted = funnySort(unsorted);
        System.out.println(sorted);
    }

    static List<Integer> funnySort(List<Integer> unsorted){
        List<Integer> sorted = new ArrayList<Integer>();
        Integer[] unsortedArray = convertListToArray(unsorted);
        //Int array can be sorted by Arrays sort
        Arrays.sort(unsortedArray);

        //pointers to front and back end of array
        int front = 0;
        int end = unsorted.size()-1;

        //continue through array adding two at a time from end and front
        while(front < end){
            //if there's not enough left, take less
            if(end - front < 4){
                sorted.add(unsortedArray[end--]);
                if(end > front){
                    sorted.add(unsortedArray[end--]);
                }
                if(front < end){
                    sorted.add(unsortedArray[front++]);
                }
                if(front == end){
                    sorted.add(unsortedArray[front++]);
                }
            }
            else{
                sorted.add(unsortedArray[end--]);
                sorted.add(unsortedArray[end--]);
                sorted.add(unsortedArray[front++]);
                sorted.add(unsortedArray[front++]);
            }

        }
        return sorted;
    }

    static Integer[] convertListToArray(List<Integer> intList) {
        //Takes a generic integer list and turns it into an Int array
        Integer[] temp = new Integer[intList.size()];
        for(int i = 0; i < intList.size(); i++){
            temp[i] = intList.get(i);
        }
        return temp;
    }
}
