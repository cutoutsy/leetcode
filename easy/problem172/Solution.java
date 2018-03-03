public class Solution {

    public int trailingZeroes(int n) {
        if (n < 1) {
            return 0;
        }
        int c = 0;
        while (n / 5 != 0) {
            n /= 5;
            c += n;
        }
        return c;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.trailingZeroes(1808548329));
        System.out.println(solution.trailingZeroes(625));
    }
}
