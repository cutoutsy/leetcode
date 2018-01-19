public class Solution {
    public int[] constructRectangle(int area){
        int sqrt = (int) Math.sqrt(area);
        int[] result = new int[2];
        for (int i = sqrt; i > 0 ; i--) {
            if(area%i == 0){
                result[0] = area/i;
                result[1] = i;
                break;
            }
        }

        return result;
    }

    public static void main(String[] args){
        int area = 6;
        Solution solution = new Solution();
        int[] re = solution.constructRectangle(area);
        for (int i = 0; i < re.length; i++) {
            System.out.print(re[i]+" ");
        }
        System.out.println();
    }
}
