import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode 290: Word Pattern
 * https://leetcode.com/problems/word-pattern/description/
 * @author cutoutsy
 */
public class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        if (pattern.length() != words.length) {
            return false;
        }
        Map<Character, String> map = new HashMap<>();
        char[] charPattern = pattern.toCharArray();
        for (int i = 0; i < charPattern.length; i++) {
            if(map.containsKey(charPattern[i])) {
                if (!map.get(charPattern[i]).equals(words[i])) {
                    return false;
                }
            } else {
                if (map.values().contains(words[i])) {
                    return false;
                } else {
                    map.put(charPattern[i], words[i]);
                }
            }
        }
        return true;
    }

}
