public class Solution {
    public int myAtoi(String str){
        if(str == null || str.length() < 1) return 0;
        str = str.trim();

        int sign = 1;
        if (str.startsWith("+") || str.startsWith("-")) {
            if(str.startsWith("-"))
                sign = -1;
            str = str.substring(1);
        }

        int re = 0;
        for (int i = 0; i < str.length(); i++) {
            if(Character.isDigit(str.charAt(i))) {
                int c = str.charAt(i) - '0';
                if (sign > 0 && (re > Integer.MAX_VALUE / 10 || (re == Integer.MAX_VALUE /10 && c > Integer.MAX_VALUE%10))){
                    re = Integer.MAX_VALUE;
                    break;
                }else if(sign < 0 && (re > Integer.MAX_VALUE/10 || (re == Integer.MAX_VALUE/10 && c > Integer.MAX_VALUE%10+1))){
                    re = Integer.MIN_VALUE;
                    break;
                }
                re = re * 10 + c;
            }else{
                break;
            }
        }
        return sign > 0 ? re : -re;
    }

    public static void main(String[] args) {
        String str = "-1";
        Solution solution = new Solution();
		System.out.println(solution.myAtoi(str));
    }
}
