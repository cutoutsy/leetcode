public class Solution {
    public boolean isValidSerialization(String preorder){
        int positions = 1;
        String[] preorders = preorder.split(",");
        for (int i = 0; i < preorders.length; i++) {
            if(--positions < 0){
                return false;
            }
            if(!preorders[i].equals("#")){
                positions += 2;
            }
        }
        return positions==0;
    }

    public static void main(String[] args) {
        String s1 = "9,3,4,#,#,1,#,#,2,#,6,#,#";
        String s2 = "1,#";
        String s3 = "9,#,#,1";
        Solution solution = new Solution();
        System.out.println(solution.isValidSerialization(s1));
        System.out.println(solution.isValidSerialization(s2));
        System.out.println(solution.isValidSerialization(s3));
    }
}
