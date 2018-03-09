public class Solution {
    public int arrangeCoins(int n) {
        int i = 1;
        while (n >= 0) {
            n -= i;
            if (n < 0) {
                break;
            }
            i++;
        }
        return i - 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.arrangeCoins(1));
        System.out.println(solution.arrangeCoins(5));
        System.out.println(solution.arrangeCoins(8));
    }
}
