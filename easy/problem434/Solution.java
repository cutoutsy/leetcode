public class Solution {
    public int countSegments(String s) {
        int ans = 0;
        char[] charS = s.toCharArray();
        int count = 0;
        for (int i = 0; i < charS.length; i++) {
            if (' ' != charS[i]) {
                count++;
            } else if (' ' == charS[i]) {
                ans += count > 0 ? 1 : 0;
                count = 0;
            }
        }
        ans += count > 0 ? 1 : 0;
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "Hello, my name is John";
        System.out.println(solution.countSegments(s));
    }
}
