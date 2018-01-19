import java.util.ArrayList;
import java.util.List;

public class Solution412 {
    public List<String> fizzBuzz(int n){
        List<String> reList = new ArrayList<>();
        for (int i = 1; i <= n; i++){
            if(i % 3 == 0 && i % 5 ==0){
                reList.add("FizzBuzz");
            }else if(i % 3 == 0){
                reList.add("Fizz");
            }else if(i % 5 == 0){
                reList.add("Buzz");
            }else{
                reList.add(String.valueOf(i));
            }
        }
        return reList;
    }

    public static void main(String[] args){
        Solution412 solution412 = new Solution412();
        List<String> re = solution412.fizzBuzz(15);
        for (int i = 0; i < re.size(); i++){
            System.out.println(re.get(i));
        }
    }
}