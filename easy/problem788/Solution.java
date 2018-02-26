public class Solution {
    public int rotatedDigits(int N) {
        int ans = 0;
        for (int i = 2; i <= N; i++) {
            if (isGood(i)) {
                ans++;
            }
        }
        return ans;
    }

    private boolean isGood(int num) {
        int[] rotate = {0, 1, 5, -1, -1, 2, 9, -1, 8, 6};
        int rotateNum = 0;
        int origin = num;
        int count = 0;
        while (num != 0) {
            int dig = num % 10;
            if (rotate[dig] == -1) {
                return false;
            }
            dig = rotate[dig];
            rotateNum = (int) (count == 0 ? dig : dig * Math.pow(10, count) + rotateNum);
            count++;
            num = num / 10;
        }
        return origin != rotateNum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.rotatedDigits(10));
    }
}
