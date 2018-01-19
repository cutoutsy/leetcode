public class Solution {
    public int addDigits(int num){
        while (num >= 10) {
            int sum = 0;
            while (num > 0) {
                sum += num % 10;
                num = num / 10;
            }
            num = sum;
        }
        return num;
    }

    public int addDigits1(int num){
        if(num == 0){
            return 0;
        }
        return num%9==0 ? 9:(num%9);
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        System.out.println(solution.addDigits(38));
    }
}
