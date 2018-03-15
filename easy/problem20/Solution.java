import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Leetcode 20: Valid Parentheses
 * https://leetcode.com/problems/valid-parentheses/description/
 * @author cutoutsy@gmail.com
 */
public class Solution {
    public boolean isValid(String s) {
        char[] charS = s.toCharArray();
        Stack<Character> stack = new Stack<Character>();
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        for (int i = 0; i < charS.length; i++) {
            if (charS[i] == ')' || charS[i] == '}' || charS[i] == ']') {
                if (stack.isEmpty() || !stack.pop().equals(map.get(charS[i]))) {
                    return false;
                }
            } else {
                stack.push(charS[i]);
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s1 = "";
        String s2 = "()";
        String s3 = "(){}[]";
        String s4 = "(]";
        String s5 = "([)]";
        Solution solution = new Solution();
        System.out.println(solution.isValid(s1));
        System.out.println(solution.isValid(s2));
        System.out.println(solution.isValid(s3));
        System.out.println(solution.isValid(s4));
        System.out.println(solution.isValid(s5));
    }
}
