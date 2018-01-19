public class Solution {
    public int countBinarySubstrings(String s) {
        int ans = 0;
        char[] chas = s.toCharArray();
        int[] nums = new int[2];
        char pre = chas[0] == '0' ? '1' : '0';
        char cur = 0;
        for (int i = 0; i < chas.length; i++) {
            cur = chas[i];
            if (i - 1 > -1 && cur != chas[i - 1]) {
                nums[cur - '0'] = 0;
                pre = cur == '0' ? '1' : '0';
            }
            nums[cur - '0'] += 1;
            if (nums[cur - '0'] != 0 && nums[cur - '0'] <= nums[pre - '0']) {
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "00110011";
        String s1 = "10101";
        String s2 = "00100";
        Solution solution = new Solution();
        System.out.println(solution.countBinarySubstrings(s));
        System.out.println(solution.countBinarySubstrings(s1));
        System.out.println(solution.countBinarySubstrings(s2));
    }
}
