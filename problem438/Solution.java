import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> findAnagrams(String s, String p){
        List<Integer> res = new ArrayList<>();
        if (s.length() < p.length()) return res;
        int[] alphabets = new int[26];
        int nonZero = 0;
        for (char c : p.toCharArray()){
            alphabets[c-'a']++;
        }

        int left = 0, right = 0, count = p.length();

        while (right < s.length()){
            if (alphabets[s.charAt(right++)-'a']-- >= 1) count--;
            if (count == 0) res.add(left);
            if (right - left == p.length() && alphabets[s.charAt(left++)-'a']++ >= 0) count++;
        }
        return res;
    }

    public static void main(String[] args) {
        String s1= "cbaebabacd", p1 = "abc";
        String s2 = "abab", p2 = "ab";
        String s3 = "baa", p3 = "aa";
        Solution solution = new Solution();
        System.out.println(solution.findAnagrams(s1, p1));
        System.out.println(solution.findAnagrams(s2, p2));
        System.out.println(solution.findAnagrams(s3, p3));
    }
}
