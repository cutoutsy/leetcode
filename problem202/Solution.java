import java.util.HashSet;
import java.util.Set;

public class Solution {
    public boolean isHappy(int n) {
        if (n < 0) {
            return false;
        }
        Set<Integer> appears = new HashSet<Integer>();
        while (n != 1) {
            n = squreSum(n);
            if (appears.contains(n)) {
                return false;
            }
            appears.add(n);
        }
        return true;
    }

    private int squreSum(int n) {
        int res = 0;
        while (n != 0) {
            int num = n % 10;
            res += num * num;
            n = n / 10;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isHappy(19));
    }
}
