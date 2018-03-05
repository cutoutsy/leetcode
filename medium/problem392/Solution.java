public class Solution {
    public boolean isSubsequence(String s, String t) {
        char[] charS = s.toCharArray();
        char[] charT = t.toCharArray();
        int i = 0;
        int j = 0;
        while (i < s.length() && j < t.length()) {
            if (charS[i] == charT[j]) {
                i++;
            }
            j++;
        }
        return i == s.length();
    }
}
