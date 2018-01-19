import java.util.Arrays;

public class Solution {

    public int maximumGap(int[] nums) {
        int n = nums.length;
        if(n < 2) return 0;
        int min = nums[0], max = nums[0];
        for (int i = 0; i < n; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        if (min == max) return 0;

        boolean[] empty = new boolean[n+1];
        Arrays.fill(empty, true);
        int[]  pmax = new int[n+1];
        int[]  pmin = new int[n+1];

        for (int i = 0; i < n; i++) {
            int index = (int)(mul(nums[i]-min, n+1)/(max - min));
            if(index > n){
                index = n;
            }
            if (empty[index]){
                empty[index] = false;
                pmax[index] = pmin[index] = nums[i];
            }else{
                pmax[index] = Math.max(nums[i], pmax[index]);
                pmin[index] = Math.min(nums[i], pmin[index]);
            }
        }

        int last = -1, answer = 0;
        for (int i = 0; i <= n; i++) {
            if(!empty[i]) {
                if (last < 0) {
                    last = pmax[i];
                } else {
                    answer = Math.max(answer, pmin[i] - last);
                    last = pmax[i];
                }
            }
        }

        return answer;
    }

    long mul(long x, long y){
        return x * y;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 10};
        Solution solution = new Solution();
        System.out.println(solution.maximumGap(nums));
    }
}
