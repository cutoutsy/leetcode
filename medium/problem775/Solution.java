public class Solution {
    public boolean isIdealPermutation(int[] A) {
        int local = 0;
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] > A[i+1]) {
                local++;
            }
        }
        int[] maxOfLeft = new int[A.length];
        maxOfLeft[0] = A[0];
        int[] minOfRight = new int[A.length];
        minOfRight[A.length - 1] = A[A.length - 1];
        for (int i = 1; i < A.length; i++) {
            maxOfLeft[i] = A[i] > maxOfLeft[i - 1] ? A[i] : maxOfLeft[i - 1];
        }
        for (int i = A.length - 2; i >= 0; i--) {
            minOfRight[i] = A[i] < minOfRight[i + 1] ? A[i] : minOfRight[i + 1];
        }
        for (int i = 0; i < A.length - 1; i++) {
            if (maxOfLeft[i] > minOfRight[i + 1] && (maxOfLeft[i] != A[i] || minOfRight[i+1] != A[i+1])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] A1 = {1, 0, 2};
        int[] A2 = {1, 2, 0};
        int[] A3 = {0, 1};
        Solution solution = new Solution();
        System.out.println(solution.isIdealPermutation(A1));
        System.out.println(solution.isIdealPermutation(A2));
        System.out.println(solution.isIdealPermutation(A3));
    }
}
