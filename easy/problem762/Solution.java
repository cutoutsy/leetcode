public class Solution {
    public int countPrimeSetBits(int L, int R) {
        int count = 0;
        for (int i = L; i <= R; i++) {
            count += isPrime(ones(i)) ? 1 : 0;
        }
        return count;
    }

    public int ones(int num) {
        int count = 0;
        while (num != 0) {
            count += (num & 1) != 0 ? 1 : 0;
            num >>= 1;
        }
        return count;
    }

    public boolean isPrime(int num) {
        boolean ans = true;
        if (num == 1) {
            return false;
        }
        for (int i = 2; i <= (int)Math.sqrt(num); i++) {
            if (num % i == 0) {
                ans = false;
                break;
            }
        }
        return ans;
    }

    /**
     * 使用动态规划计算整数二进制形式中1的个数
     * @param num
     * @return
     */
    public int[] countBits(int num) {
        if (num == 0) {
            return new int[1];
        }
        int[] dp = new int[num+1];

        dp[0] = 0;
        dp[1] = 1;

        for(int i=2;i<=num;i++){
            dp[i] = dp[i >> 1] + dp[i & 1];
        }
        return dp;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countPrimeSetBits(6, 10));
        System.out.println(solution.countPrimeSetBits(10, 15));
        System.out.println(solution.countPrimeSetBits(990, 1048));
    }
}
