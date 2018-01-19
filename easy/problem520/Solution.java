import java.util.regex.Pattern;

public class Solution {
    public boolean detectCapitalUse(String word){
        String regex = "[a-z]+|[A-Z]+|^[A-Z]{1}[a-z]+";
        return Pattern.matches(regex, word);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String input1 = "USA";
        String input2 = "leetcode";
        String input3 = "Goole";
        System.out.println(solution.detectCapitalUse(input1));
        System.out.println(solution.detectCapitalUse(input2));
        System.out.println(solution.detectCapitalUse(input3));
    }
}
