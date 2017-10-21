public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1 ) {
            return 0;
        }
        int answer = 0;
        for (int i = 0; i < prices.length;i++) {
            int[] left = oneTransactionMaxProfit(prices, 0, i);
            int[] right = oneTransactionMaxProfit(prices, i, prices.length-1);

            if (right[0] == 0 ) {
                answer = Math.max(answer, left[0]);
                break;
            }
            answer = Math.max(answer, left[0] + right[0]);
            i = right[1];
            answer = Math.max(oneTransactionMaxProfit(prices, 0, i)[0] + oneTransactionMaxProfit(prices, i, prices.length - 1)[0], answer);
        }
        return answer;
    }

    public int[] oneTransactionMaxProfit(int[] prices, int begin, int end) {
        if (end - begin == 0) {
            return new int[]{0,begin, end};
        }
        int[] result = new int[3];
        int left = begin;
        int maxLeft = begin;
        int maxRight = end;
        int answer = 0;
        int min = prices[begin];
        for (int i = begin + 1; i <= end; i++) {
            if (prices[i] > min) {
                if (prices[i] - min > answer) {
                    answer = prices[i] - min;
                    maxRight = i;
                    if (maxRight > left) {
                        maxLeft = left;
                    }
                }
            } else {
                min = prices[i];
                left = i;
            }
        }
        result[0] = answer;
        result[1] = maxLeft;
        result[2] = maxRight;
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] input1 = {7, 1, 5, 3, 6, 4};
        int[] input2 = {2, 1, 4, 5, 2, 9, 7};
        System.out.println(solution.maxProfit(input1));
        System.out.println(solution.maxProfit(input2));
    }
}
