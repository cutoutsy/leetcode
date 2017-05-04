public class Solution {
    public int findLUSlength(String a, String b){
        if(a.length() == b.length()){
            return -1;
        }else{
            return a.length() > b.length() ? a.length() : b.length();
        }
    }
}