public class Solution496 {
    public int[] nextGreaterElement(int[] findNums, int[] nums){
        int[] results = new int[findNums.length];
        for (int i =0; i < findNums.length; i++){
            boolean find = false;
            for (int j = 0; j < nums.length; j++){
                if(nums[j] == findNums[i]){
                    for (int k = j + 1; k < nums.length; k++) {
                        if(nums[k] > findNums[i]) {
                            results[i] = nums[k];
                            find = true;
                            break;
                        }
                    }
                    break;
                }
            }
            if (!find){
                results[i] = -1;
            }
        }
        return results;
    }

    public static void main(String[] args){
        Solution496 solution496 = new Solution496();
        int[] findNums = {2, 4};
        int[] nums = {1, 2, 3, 4};
        int[] res = solution496.nextGreaterElement(findNums, nums);
        for (int i = 0; i < res.length; i++){
            System.out.println(res[i]);
        }
    }
}
