import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int countSubstrings(String s) {
        if (s.length() < 1) {
            return 0;
        }
        int ans = s.length();

        for(int i = 0; i < s.length(); i++)
            for(int j = i + 1; j < s.length(); j++)
                if(isPalindromicString(s.substring(i, j + 1))) ans++;

        return ans;
    }

    // 判断是否是回文字符串
    public boolean isPalindromicString(String s) {
        int j = s.length() - 1;
        for (int i = 0; i <= j; i++) {
            if (s.charAt(i) != s.charAt(j--)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "aaa";
        Solution solution = new Solution();
        System.out.println(solution.countSubstrings(s));
    }
}
