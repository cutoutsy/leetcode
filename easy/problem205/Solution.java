import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<Character, Character>();
        Set<Character> maped = new HashSet<Character>();
        char[] charS = s.toCharArray();
        char[] charT = t.toCharArray();
        for (int i = 0; i < charS.length; i++) {
            if (map.keySet().contains(charS[i])) {
                if (map.get(charS[i]) != charT[i]) {
                    return false;
                }
            } else {
                if (maped.contains(charT[i])) {
                    return false;
                }
                map.put(charS[i], charT[i]);
                maped.add(charT[i]);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isIsomorphic("egg", "add"));
        System.out.println(solution.isIsomorphic("foo", "bar"));
        System.out.println(solution.isIsomorphic("paper", "title"));
        System.out.println(solution.isIsomorphic("a", "b"));
        System.out.println(solution.isIsomorphic("ab", "aa"));
    }
}
