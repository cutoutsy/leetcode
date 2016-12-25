public class Solution{
	public int reverse(int x){
		int re = 0;
		StringBuffer sb = new StringBuffer();
		if(x < 0){
			sb.append("-");
			x = Math.abs(x);
		}
		
		String stringX = String.valueOf(x);
		for(int i = stringX.length()-1; i >= 0; i--){
			sb.append(stringX.charAt(i));
		}
		
		try{
			re = Integer.valueOf(sb.toString());
		}catch(Exception ex){
			re = 0;
		}
		return re;
	}
	
	public static void main(String[] args){
		Solution su = new Solution();
		System.out.println(su.reverse(123));
		System.out.println(su.reverse(-123));
		System.out.println(su.reverse(100));
		System.out.println(su.reverse(1000000003));
	}
}
