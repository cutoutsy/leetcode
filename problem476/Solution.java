public class Solution476 {
    public int findComplement(int num)
    {
        int numberLength = 32 - Integer.numberOfLeadingZeros(num);
        StringBuffer sb = new StringBuffer();
        for (int i = numberLength-1; i >= 0; i--){
            byte numByte = (byte)((num >> i) & 1);
            sb.append(String.valueOf(numByte ^ 1));
        }
        String complement = sb.toString();
        if(complement.contains("1")) {
            complement = sb.toString().substring(sb.indexOf("1"));
        }
        return Integer.parseInt(complement, 2);
    }

    public static void main(String[] args)
    {
        Solution476 solution = new Solution476();
        int result = solution.findComplement(2);
        System.out.println("Result: " + result);
    }
}
