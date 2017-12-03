public class Solution {
    public String toHex(int num) {
        if (num == 0) {
            return "0";
        }
        StringBuffer sb = new StringBuffer();
        while (num != 0) {
            int remainder = num & (16 - 1);
            if (remainder < 10) {
                sb.append(String.valueOf(remainder));
            } else {
                sb.append((char) ('a' + (remainder - 10)));
            }
            num = num >>> 4;

        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.toHex(-1));
        System.out.println(solution.toHex(26));
    }
}
