public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0 || prices == null) {
            return 0;
        }
        int answer = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > min) {
                answer = Math.max(prices[i] - min, answer);
            } else {
                min = prices[i];
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] input1 = {7, 1, 5, 3, 6, 4};
        int[] input2 = {7, 6, 4, 3, 1};
        System.out.println(solution.maxProfit(input1));
        System.out.println(solution.maxProfit(input2));
    }
}
