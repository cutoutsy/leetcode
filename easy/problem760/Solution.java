import java.util.Arrays;
import java.util.HashMap;

public class Solution {
    public int[] anagramMappings(int[] A, int[] B) {
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                if (B[j] == A[i]) {
                    A[i] = j;
                    break;
                }
            }
        }
        return A;
    }

    public int[] anagramMappings1(int[] A, int[] B) {
        HashMap<Integer, Integer> bMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < B.length; i++) {
            bMap.put(B[i], i);
        }
        for (int i = 0; i < A.length; i++) {
            A[i] = bMap.get(A[i]);
        }
        return A;
    }


    public static void main(String[] args) {
        int[] A = {12, 28, 46, 32, 50};
        int[] B = {50, 12, 32, 46, 28};
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.anagramMappings1(A, B)));
    }
}
