import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    Set<List<Integer>> allSituation = new HashSet<>();
    public List<String> readBinaryWatch(int num) {
        List<String> ans = new ArrayList<>();
        if (num == 0) {
            ans.add("0:00");
            return ans;
        }
        int[] currentOn = {108, 104, 102, 101, 32, 16, 8, 4, 2, 1};
        combination(currentOn, num);
        for (List item : allSituation){
            int hour = 0;
            int min = 0;
            for (int i = 0; i < item.size(); i++){
                if ((int)item.get(i) > 100) {
                    hour += (int)item.get(i) - 100;
                } else {
                    min += (int)item.get(i);
                }
            }
            if (hour < 12 && min < 60) {
                String tempAns = String.valueOf(hour) + ":" + (min < 10 ? "0" : "") + String.valueOf(min);
                ans.add(tempAns);
            }
        }
        return ans;
    }

    public void combination(int[] array, int n) {
        combination(array, new int[n], 0, n);
    }

    public void combination(int[] array, int[] indexes, int start, int n) {
        if (n == 1) {
            for (int i = start; i < array.length; i++) {
                List prefix = generatePrefix(array, indexes);
                prefix.add(array[i]);
                allSituation.add(prefix);
            }

        } else {
            for (int i = start; i <= array.length - n; i++) {
                indexes[indexes.length - n] = i;
                combination(array, indexes, i + 1, n - 1);
            }
        }
    }

    private List<Integer> generatePrefix(int[] array, int[] indexes) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < indexes.length - 1; i++) {
            res.add(array[indexes[i]]);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> ans = solution.readBinaryWatch(2);
        System.out.println(ans.size());
        for (String item : ans){
            System.out.println(item);
        }
    }
}
