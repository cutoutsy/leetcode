public class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < dp.length; i++) {
            dp[i] = dp[i-1] + dp[i - 2];
        }
        return dp[n];
    }

    public int climbStairs1(int n) {
        int a = 1;
        int b = 1;
        int ans = 0;
        for (int i = 2; i <= n; i++) {
            ans = a + b;
            a = b;
            b = ans;
        }
        return n == 1 ? 1 : ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.climbStairs1(1));
        System.out.println(solution.climbStairs1(2));
        System.out.println(solution.climbStairs1(3));
    }
}
