import java.util.ArrayList;
import java.util.List;

public class QuestionFour {
    public static void main(String[] args) {
        //set up array
        List<List<Integer>> array2D = new ArrayList<List<Integer>>();
        List<Integer> row1 = new ArrayList<Integer>();
        row1.add(1);
        row1.add(0);
        row1.add(0);
        row1.add(0);
        array2D.add(row1);
        List<Integer> row2 = new ArrayList<Integer>();
        row2.add(2);
        row2.add(5);
        row2.add(0);
        row2.add(0);
        array2D.add(row2);
        List<Integer> row3 = new ArrayList<Integer>();
        row3.add(3);
        row3.add(2);
        row3.add(1);
        row3.add(0);
        array2D.add(row3);
        List<Integer> row4 = new ArrayList<Integer>();
        row4.add(1);
        row4.add(3);
        row4.add(2);
        row4.add(1);
        array2D.add(row4);
        //===================
        
        System.out.println("Current 2D array:");
        print2DArray(array2D);
        System.out.println("\nSolution:");

        List<Integer> solution = new ArrayList<Integer>();
        List<Integer> result = highestSumList(array2D, solution, 0, 0, 0);
        System.out.println(result);
    }

    static List<Integer> highestSumList(List<List<Integer>> array2D, List<Integer> solution, int row, int col, int total) {
        //if we reached the end, stop recursion
        if(row >= array2D.size()-1){
            solution.add(array2D.get(row).get(col));
            return solution;
        }

        //otherwise, check both routes but choose best total
        if((total + array2D.get(row+1).get(col)) > (total + array2D.get(row+1).get(col+1))){
            highestSumList(array2D, solution, row+1, col,(total + array2D.get(row + 1).get(col)));
        }
        else{
            highestSumList(array2D, solution, row+1, col+1,(total + array2D.get(row + 1).get(col + 1)));
        }

        //follow recursion back, adding to the beginning since we start at the back
        solution.add(0,array2D.get(row).get(col));
        return solution;
    }

    static public void print2DArray(List<List<Integer>> array2D){
        System.out.println("[");
        for (int i = 0; i < array2D.size(); i++) {
            System.out.println(" " + array2D.get(i));
        }
        System.out.println("]");
    }
}
