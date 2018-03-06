public class Solution {
    public int numSubarrayBoundedMax(int[] A, int L, int R) {
        int ans = 0;
        int pre = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] > R) {
                ans += numSubarray(A, pre, i - 1, L, R);
                pre = i + 1;
            }
        }
        ans += pre <= A.length ? numSubarray(A, pre, A.length - 1, L, R) : 0;
        return ans;
    }

    private int numSubarray(int[] a, int start, int end, int L, int R) {
        int re = 0;
        if (start > end) {
            return 0;
        }
        for (int i = start; i <= end; i++) {
            int max = a[i];
            for (int j = i; j <= end; j++) {
                if (a[j] > max) {
                    max = a[j];
                }
                if (max >= L) {
                    re++;
                }
            }
        }
        return re;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] A = {2, 1, 4, 3};
        System.out.println(solution.numSubarrayBoundedMax(A, 2, 3));
    }
}
