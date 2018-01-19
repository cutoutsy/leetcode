public class Solution {
    public String complexNumberMultiply(String a, String b) {
        int real1 = Integer.valueOf(a.split("\\+")[0]);
        int real2 = Integer.valueOf(b.split("\\+")[0]);

        int imaginary1 = Integer.valueOf(a.split("\\+")[1].split("i")[0]);
        int imaginary2 = Integer.valueOf(b.split("\\+")[1].split("i")[0]);

        return (real1*real2+imaginary1*imaginary2*(-1)) + "+" +(real1*imaginary2+real2*imaginary1)+"i";
    }

    public static void main(String[] args) {
        String a1 = "1+1i", b1 = "1+1i";
        String a2 = "1+-1i", b2 = "1+-1i";
        Solution solution = new Solution();
        System.out.println(solution.complexNumberMultiply(a1, b1));
        System.out.println(solution.complexNumberMultiply(a2, b2));
    }
}
