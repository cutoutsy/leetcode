import java.util.Arrays;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int answer = 0;
        boolean[] characters = new boolean[65535];
        Arrays.fill(characters, false);
        for (int i = 0, j = 0; ;++i){
            while (j < s.length() && characters[s.charAt(j)]==false){
                characters[s.charAt(j++)] = true;
            }
            answer = Math.max(answer, j-i);
            if(j >= s.length()){
                break;
            }

            while (s.charAt(i) != s.charAt(j)){
                characters[s.charAt(i++)] = false;
            }
            characters[s.charAt(i)] = false;
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String str1 = "abcabcbb";
        String str2 = "bbbbb";
        String str3 = "pwwkew";
        System.out.println(solution.lengthOfLongestSubstring(str1));
        System.out.println(solution.lengthOfLongestSubstring(str2));
        System.out.println(solution.lengthOfLongestSubstring(str3));
    }
}
