public class Solution {
    public boolean isAnagram(String s, String t){
        if(s.length() != t.length()) return false;
        int[] alphabets = new int[26];
        for (int i = 0; i < s.length(); i++) {
            ++alphabets[s.charAt(i) -'a'];
        }
        for (int i = 0; i < t.length(); i++) {
            if(--alphabets[t.charAt(i)-'a'] < 0)
                return  false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s1 = "anagram", t1 = "nagaram";
        String s2 = "rat", t2 = "cat";
        Solution solution = new Solution();
        System.out.println(solution.isAnagram(s1, t1));
        System.out.println(solution.isAnagram(s2, t2));
    }
}
