public class Solution {
    public boolean isPowerOfFour(int num) {
        return (Math.log10(num) / Math.log10(4)) % 1 == 0;
    }

    private String convert(int num) {
        int base = 4;
        StringBuffer str = new StringBuffer();
        while ((num / 4) != 0) {
            str.append(num / 4);
            num = num % 4;
        }
        str.append(num);
        return str.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isPowerOfFour(5));
        System.out.println(solution.isPowerOfFour(16));
    }
}
