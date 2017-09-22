import java.util.Arrays;

public class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) return s;
        // 字符串预处理
       String strend = reProcess(s);

        // manacher算法
        int[] radius = new int[strend.length()];
        // Arrays.fill(radius, 0);
        int right = 0; //回文最右边界
        int center = 0; //回文中心
        int rad = 0;
        int reCenter = 0;
        for (int i = 1; i < strend.length(); i++) {
            radius[i] = right > i ? Math.min(radius[2 * center - i], right - i): 1;
            while ((i + radius[i] < strend.length()) && strend.charAt(i + radius[i]) == strend.charAt(i - radius[i])) {
                radius[i] += 1;
            }
            if (right < i + radius[i]) {
                right = i + radius[i];
                center = i;
            }
            if (rad < radius[i]) {
                rad = radius[i];
                reCenter = i;
            }
        }
        return s.substring((reCenter - rad) / 2, (reCenter + rad) / 2 - 1);
    }

    public String reProcess(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append("$");
        for(int i = 0; i < s.length(); i++){
            sb.append("#");
            sb.append(s.charAt(i));
        }
        sb.append("#");
        return sb.toString();
    }

    public static void main(String[] args) {
        String input1 = "babad";
        String input2 = "cbbd";
        Solution solution = new Solution();
        System.out.println(solution.longestPalindrome(input1));
        System.out.println(solution.longestPalindrome(input2));
    }
}
