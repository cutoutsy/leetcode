import java.util.Arrays;
import java.util.Stack;

public class Solution {
    public String removeDuplicateLetters(String s) {
        int[] num = new int[26];
        Stack<Character> st = new Stack<>();
        boolean[] in = new boolean[26];
        Arrays.fill(num, 0);
        Arrays.fill(in, false);
        for (int i = 0; i < s.length(); i++) {
            ++num[s.charAt(i)-'a'];
        }
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'a';
            --num[c];
            if (!in[c]){
                while (!st.isEmpty() && st.peek() > s.charAt(i) && num[st.peek() - 'a'] > 0){
                    in[st.peek() - 'a'] = false;
                    st.pop();
                }
                st.push(s.charAt(i));
                in[c] = true;
            }
        }
        String answer = "";
        for (; !st.isEmpty(); st.pop()){
            answer = st.peek() + answer;
        }
        return answer;
    }

    public static void main(String[] args) {
        String str1 = "bcabc";
        String str2 = "cbacdcbc";
        Solution solution = new Solution();
        System.out.println(solution.removeDuplicateLetters(str1));
        System.out.println(solution.removeDuplicateLetters(str2));
    }
}
