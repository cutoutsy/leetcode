import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public String[] findRestaurant(String[] list1, String[] list2){
        int minIndexSum = list1.length+list2.length-2;
        List<String> reList = new ArrayList<String>();
        for (int i = 0; i < list1.length; i++) {
            for (int j = 0; j < list2.length; j++) {
                if (list1[i].equals(list2[j])){
                    if (i+j == minIndexSum){
                        reList.add(list1[i]);
                    }
                    if (i+j < minIndexSum){
                        minIndexSum = i+j;
                        reList.clear();
                        reList.add(list1[i]);
                    }
                }
            }
        }

        return  reList.toArray(new String[reList.size()]);
    }

    public static void main(String[] args) {
        String[] list1 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String[] list2 = {"Piatti", "The Grill at Torrey Pines", "hungry Hunter Steakhouse", "Shogun"};
        String[] list3 = {"KFC", "Shogun", "Burger King"};
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.findRestaurant(list1, list2)));
        System.out.println(Arrays.toString(solution.findRestaurant(list1, list3)));
    }
}
