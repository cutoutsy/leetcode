public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0 || strs == null) return "";
        String ans = strs[0];
        for (int i = 1; i < strs.length; i++) {
            if (!strs[i].startsWith(ans)) {
                int count = 0;
                int len = ans.length() > strs[i].length() ? strs[i].length() : ans.length();
                for (int j = 0; j < len; j++) {
                    if (ans.charAt(j) == strs[i].charAt(j)) {
                        count++;
                    } else {
                        break;
                    }
                }
                ans = ans.substring(0, count);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String[] strs = {"aca","cba"};
        Solution solution = new Solution();
        System.out.println(solution.longestCommonPrefix(strs));
    }
}
