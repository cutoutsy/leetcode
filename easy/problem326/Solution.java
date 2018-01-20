public class Solution {

    public boolean isPowerOfThree(int n) {
        return n > 0 && (Math.pow(3, 19) % n == 0);
    }

    public boolean isPowerOfThree1(int n) {
        return (Math.log10(n) / Math.log10(3)) % 1 == 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isPowerOfThree1(-3));
    }
}
