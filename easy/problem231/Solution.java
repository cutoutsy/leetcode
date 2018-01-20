
public class Solution {

    public boolean isPowerOfTwo(int n) {
        return n > 0 && Integer.bitCount(n)==1;
    }

    public boolean isPowerOfTwo1(int n) {
        return n > 0 && (n & (n -1)) == 0;
    }

    public boolean isPowerOfTwo2(int n) {
        return n>0 && (Math.pow(2, 30) % n == 0);
    }

    public static void main(String[] args) {
        int n = -2147483648;
        Solution solution = new Solution();
        System.out.println(solution.isPowerOfTwo(n));
    }
}
