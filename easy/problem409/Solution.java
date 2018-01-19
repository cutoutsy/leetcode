import java.util.HashSet;

public class Solution {
    public int longestPalindrome(String s) {
        HashSet<Character> alphabet = new HashSet<>();
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            if (alphabet.contains(s.charAt(i))){
                ans += 2;
                alphabet.remove(s.charAt(i));
            } else {
                alphabet.add(s.charAt(i));
            }
        }
        int plus = alphabet.size() > 0 ? 1 : 0;
        return ans + plus;
    }

    public static void main(String[] args) {
        String s = "abccccdd";
        Solution solution = new Solution();
        System.out.println(solution.longestPalindrome(s));
    }
}
