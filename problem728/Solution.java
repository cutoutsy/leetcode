import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> ans = new LinkedList<Integer>();
        for (int i = left; i <= right; i++) {
            if(isSelfDividingNumber(i)) {
                ans.add(i);
            }
        }
        return ans;
    }

    private boolean isSelfDividingNumber(int num) {
        int n = num;
        int help = 1;
        while (n / help >= 10) {
            if ((n / help) % 10 == 0) {
                return false;
            }
            help *= 10;
        }
        while (n != 0) {
            int tmp = n / help;
            if (num % tmp != 0) {
                return false;
            }
            n = n % help;
            help /= 10;
        }
        return true;
    }
}
