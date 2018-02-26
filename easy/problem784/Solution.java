import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<String> ans = new ArrayList<String>();
    public List<String> letterCasePermutation(String S) {
        process(S.toCharArray(), 0);
        return ans;
    }

    private void process(char[] s, int i) {
        if (i > s.length - 1) {
            ans.add(String.valueOf(s));
            return;
        }
        if (Character.isDigit(s[i])) {
            process(s, i + 1);
        } else {
            process(s, i + 1);
            s[i] = s[i] > 96 ? (char) (s[i] - 32) : (char) (s[i] + 32);
            process(s, i + 1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> ans = solution.letterCasePermutation("a1b2");
        for (String item : ans) {
            System.out.println(item);
        }
    }
}
