public class Solution {
    public char findTheDifference(String s, String t){
        char result = 'a';
        int[] alphabets = new int[26];
        for (int i = 0; i < alphabets.length; i++){
            alphabets[i] = 0;
        }
        for (int i = 0; i < s.length(); i++) {
            int oneChar = s.charAt(i) -97;
            alphabets[oneChar]++;
        }

        for (int i = 0; i < t.length(); i++) {
            int oneChar = t.charAt(i) -97;
            alphabets[oneChar]--;
        }

        for (int i = 0; i < alphabets.length; i++){
            if(alphabets[i] == -1){
                result = (char)(i+97);
            }
        }
        return result;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        String s = "abcd";
        String t = "abcde";
        System.out.println(solution.findTheDifference(s, t));
    }
}
