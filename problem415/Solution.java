public class Solution {
    public String addStrings(String num1, String num2) {
        if (num1.length() == 0) {
            return num2;
        }
        if (num2.length() == 0) {
            return num1;
        }
        char[] chnum1 = num1.toCharArray();
        char[] chnum2 = num2.toCharArray();
        char[] res = chnum1.length > chnum2.length ? chnum1 : chnum2;
        int ca = 0;
        int index1 = chnum1.length - 1;
        int index2 = chnum2.length - 1;
        int index = index1 > index2 ? index1 : index2;
        while (index1 > -1 || index2 > -1) {
            int n1 = index1 > -1 ? chnum1[index1--] - '0' : 0;
            int n2 = index2 > -1 ? chnum2[index2--] - '0' : 0;
            int sum = n1 + n2 + ca;
            int tmp = sum % 10;
            ca = sum / 10;
            res[index--] = (char)(tmp + '0');;
        }
        if (ca == 1) {
            return 1 + String.valueOf(res);
        }
        return String.valueOf(res);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.addStrings("99", "101"));
    }
}
