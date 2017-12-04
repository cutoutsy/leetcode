public class Solution {
    public boolean hasAlternatingBits(int n) {
        int k = n ^ (n >> 1);
        while (k != 0) {
            if ((k & 1) == 0) {
                return false;
            }
            k >>= 1;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.hasAlternatingBits(5));
        System.out.println(solution.hasAlternatingBits(4));
        System.out.println(solution.hasAlternatingBits(7));
        System.out.println(solution.hasAlternatingBits(11));
        System.out.println(solution.hasAlternatingBits(10));
    }
}
