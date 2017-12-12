package io.cutoutsy.easy;

public class Solution744 {
    public char nextGreatestLetter(char[] letters, char target) {
        char ans = 0;
        boolean[] alphabet = new boolean[26];
        for (int i = 0; i < letters.length; i++) {
            alphabet[letters[i] - 'a'] = true;
        }
        int start = target - 'a';
        for (int i = start + 1; i != start; i = (i + 1) % 26) {
            if (alphabet[i]) {
                ans = (char) (i + 'a');
                break;
            }
        }
        return ans;
    }
}
