public class Solution {
    public int minCostClimbingStairs(int[] cost) {
        for(int i = cost.length-3; i >= 0; i--){
            cost[i] = cost[i] + Math.min(cost[i + 1], cost[i + 2]);
        }
        return Math.min(cost[0], cost[1]);
    }

    public int minCostClimbingStairs1(int[] cost) {
        int[] dp = new int[cost.length + 1];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < dp.length; i++) {
            int cur = i == cost.length ? 0 : cost[i];
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cur;
        }
        return dp[cost.length];
    }

    public int minCostClimbingStairs2(int[] cost) {
        int a = cost[0];
        int b = cost[1];
        int ans = Math.min(a, b);
        for (int i = 2; i <= cost.length; i++) {
            int cur = i == cost.length ? 0 : cost[i];
            ans = Math.min(a, b) + cur;
            a = b;
            b = ans;
        }
        return ans;
    }

    public int minCost(int[] cost, int start) {
        int[] dp = new int[cost.length + 1];
        dp[start] = 0;
        dp[start + 1] = cost[start];
        for (int i = start + 2; i < dp.length; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        return dp[cost.length];
    }

    public static void main(String[] args) {
        int[] cost = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        int[] cost1 = {10, 15, 20};
        int[] cost2 = {0, 0, 1, 1};
        Solution solution = new Solution();
        System.out.println(solution.minCostClimbingStairs(cost));
        System.out.println(solution.minCostClimbingStairs(cost1));
        System.out.println(solution.minCostClimbingStairs(cost2));
    }
}
