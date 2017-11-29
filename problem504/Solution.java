public class Solution {
    public String convertToBase7(int num) {
        if (num == 0) {
            return "0";
        }
        StringBuffer ans = new StringBuffer();
        String pre = "";
        if (num < 0) {
            pre = "-";
        }
        ans.append(pre);
        String res = mod(Math.abs(num), 7);
        for (int i = res.length() - 1; i >= 0; i--) {
            ans.append(res.charAt(i));
        }
        return ans.toString();
    }

    public String mod(int num, int base) {
        StringBuffer sb = new StringBuffer();
        while (num != 0) {
            int remainder = num % base;
            sb.append(String.valueOf(remainder));
            num = num / base;

        }
        return sb.toString();
    }


    public static void main(String[] args) {
        Solution504 solution = new Solution504();
        System.out.println(solution.convertToBase7(-7));
        System.out.println(solution.convertToBase7(100));
    }
}
