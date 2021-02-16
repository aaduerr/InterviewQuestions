//Written by Andrew Duerr
//the array must be looped at least once
//it may go through from it's current index to the end
//this would be O(nlogn)

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuestionTwo {
    public static void main(String[] args) {
        ArrayList<Integer> originalArray = new ArrayList<Integer>(Arrays.asList(4,3,5,2,3,8));
        distantOddNumbers(originalArray);
        System.out.println(originalArray);
    }

    public static List<Integer> distantOddNumbers(List<Integer> originalArray) {
        int evens = 0;
        int odds = 0;
        int distance = 1;
        int countEvens = 0;
        int index = 0;
        
        //count odds and evens
        for(int i = 0; i < originalArray.size(); i++){
            if(originalArray.get(i)%2 == 0){
                evens ++;
            }
            else{
                odds++;
            }
        }

        //calculate distance based on ratio of odds and evens
        distance = evens/(odds-1);
        if(distance < 1) distance = 1;

        int i = 0;
        while(i < originalArray.size()){
            //if it's the first element and it is even, swap to first odd
            if(i == 0 && originalArray.get(0) % 2 == 0){
                index = getNextOdd(0, originalArray);
                if(index >= 0){
                    swap(originalArray,0,index);
                }
                i++;
                countEvens = distance;
            }
            //if it's the last element and even, swap to next earliest odd
            else if(i == originalArray.size()-1 && originalArray.get(originalArray.size()-1) % 2 == 0){
                for(int k = originalArray.size()-1; k >= 0; k--){
                    if(originalArray.get(k) % 2 == 1){
                        swap(originalArray,originalArray.size()-1,k);
                        break;
                    }
                }
                i++;
            }
            //if the integer is odd
            else if(originalArray.get(i)%2 != 0){
                //and we want it to be odd
                if(countEvens < 1){
                    countEvens = distance;
                }
                //and we didnt want it to be odd
                else{
                    index = getNextEven(i, originalArray);
                    if(index >= 0) swap(originalArray,i,index);
                }
                i++;
            }
            //must be even
            else{
                if(countEvens >= 1){
                    countEvens--;
                }
                else{
                    index = getNextOdd(i, originalArray);
                    if(index >= 0) swap(originalArray,i,index);
                }
                i++;
            }
        }
        return originalArray;

    }

    public static int getNextEven(int j, List<Integer> a) {
        for(int i= j+1; i < a.size(); i++){
            if (a.get(i) % 2 == 0) return i;
        }
        return -1;
    }

    public static int getNextOdd(int j, List<Integer> a) {
        for (int i = j+1; i < a.size(); i++) {
            if (a.get(i) % 2 != 0)
                return i;
        }
        return -1;
    }

    public static void swap(List<Integer> a, int x, int y){
        int temp = a.get(x);
        a.set(x, a.get(y));
        a.set(y, temp);
    }
}
