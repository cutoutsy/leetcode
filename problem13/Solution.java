import java.util.*;
/**
 * 罗马数字规则简明：
 * 1. 罗马单个数字共有7个，即I、V、X、L、C、D、M
 * 2. 一个罗马数字重复几次，就表示这个数的几倍。但同一数码不能出现三次以上
 * 3. 遵循右加左减的规则
 *    左减数字有限制，仅限于I、X、C
 *    左减时不可跨越一个位数
 *    左减数字必须为1位，比如8写成VIII，而非IIX
 */
public class Solution{
	public int romanToInt(String s){
		if(s.length() <= 0){
			return 0;
		}
		int result = 0;
		Map<Character, Integer> romanIntHash = new HashMap<>();
		romanIntHash.put('I', 1);
		romanIntHash.put('V', 5);
		romanIntHash.put('X', 10);
		romanIntHash.put('L', 50);
		romanIntHash.put('C', 100);
		romanIntHash.put('D', 500);
		romanIntHash.put('M', 1000);
		int current = 0;
		int pre = romanIntHash.get(s.charAt(0));
		int temp = pre;
		for(int i = 1; i < s.length(); i++){
			current = romanIntHash.get(s.charAt(i));
			if(current == pre){
				temp += current;
			}
			if(current > pre){
				temp = current - temp;
			}
			if(current < pre){
				result += temp;
				temp = current;
			}
			pre = current;
		}
		result += temp;
		return result;
	}

	public static void main(String[] args){
		Solution su = new Solution();
		System.out.println(su.romanToInt("III"));
		System.out.println(su.romanToInt("IIV"));
		System.out.println(su.romanToInt("XI"));
	}
}
