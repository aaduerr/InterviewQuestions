//Written by Andrew Duerr
//performance is O(n)

import java.util.Arrays;

public class QuestionThree {
    public static void main(String[] args) {
        String a = "zzcz";
        String b = "aaad";
        int shift = -1;

        System.out.println(isAnagram(a, b, shift));

    }

    public static boolean isAnagram(String a, String b, int x) {
        if(a.length() != b.length()){
            return false;
        }

        int[] first = new int[26];
        Arrays.fill(first,0);
        int[] second = new int[26];
        Arrays.fill(second,0);
        boolean result = true;
        int z;
        int y;
        int shift = x;
        if(shift < 0){
            shift = shift + 26;
        }

        //fill out arrays
        for(int i = 0; i < a.length(); i++){
            z = a.charAt(i);
            y = b.charAt(i);
            first[z-97]++;
            second[y-97]++;
        }

        //check arrays 3 ways: normal, 1st shifted, 2nd shifted
        for(int j = 0; j < 26; j++){
            if(first[j] != second[j]){
                result = false;
                break;
            }
        }
        //reset result, try second way
        if(result != true){
            result = true;
            for(int j = 0; j < 26; j++){
                if(first[j] != second[(j+shift)%26]){
                    result = false;
                    break;
                }
            }
            if(result != true){
                result = true;
                for (int j = 0; j < 26; j++) {
                    if (first[(j+shift)%26] != second[j]) {
                        result = false;
                        break;
                    }
                }
            }
        }
        return result;
    }
}
