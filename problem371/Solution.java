public class Solution {
    public int getSum(int a, int b){
        int sum;
        int carry;
        do{
            sum = a^b;
            carry = (a & b) << 1;
            a = sum;
            b = carry;
        }while (b != 0);

        return a;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        System.out.println(solution.getSum(7, 8));
    }
}
