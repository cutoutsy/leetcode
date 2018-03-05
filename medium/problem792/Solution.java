import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int numMatchingSubseq(String S, String[] words) {
        int ans = 0;
        Set<String> subsequenceSet = new HashSet<String>();
        int[] alphabet = new int[26];
        char[] charS = S.toCharArray();
        for (int i = 0; i < charS.length; i++) {
            alphabet[charS[i] - 'a']++;
        }
        for (int i = 0; i < words.length; i++) {
            if (subsequenceSet.contains(words[i])) {
                ans++;
            }else if(isSubsequence(charS, alphabet, words[i])) {
                subsequenceSet.add(words[i]);
                ans++;
            }
        }
        return ans;
    }

    private boolean isSubsequence(char[] charS, int[] alphabet, String word) {
        char[] charWord = word.toCharArray();
        int[] alphWord = new int[26];
        for (int i = 0; i < charWord.length; i++) {
            alphWord[charWord[i] - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (alphWord[i] > alphabet[i]) {
                return false;
            }
        }
        int m = 0;
        int n = 0;
        while (m < charS.length && n < charWord.length) {
            if (charS[m] == charWord[n]) {
                n++;
            }
            m++;
        }

        return n == charWord.length;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String S = "abcde";
        String[] words = {"a", "bb", "acd", "ace", "ace"};
        System.out.println(solution.numMatchingSubseq(S, words));
    }
}
