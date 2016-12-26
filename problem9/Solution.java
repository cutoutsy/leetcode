public class Solution{
	public boolean isPalindorme(int x){
		if(x < 0){
			return false;
		}
		int palindorme = 0;
		int origin = x;
		while(x != 0){
			palindorme = palindorme * 10 + x % 10;
			x /= 10;
		}
		return palindorme == origin;
	}
	
	public static void main(String[] args){
		Solution su = new Solution();
		System.out.println(su.isPalindorme(121));
		System.out.println(su.isPalindorme(123));
	}
}
