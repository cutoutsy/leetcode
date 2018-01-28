import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int numJewelsInStones(String J, String S) {
        int ans = 0;
        Set<Character> jSet = new HashSet<Character>();
        char[] charJ = J.toCharArray();
        char[] charS = S.toCharArray();
        for (int i = 0; i < charJ.length; i++) {
            jSet.add(charJ[i]);
        }
        for (char ele : charS) {
            if (jSet.contains(ele)) {
                ans++;
            }
        }
        return ans;
    }
}
