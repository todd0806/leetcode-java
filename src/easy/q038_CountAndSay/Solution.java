package easy.q038_CountAndSay;

//https://leetcode.com/problems/count-and-say/
//1.     1
//2.     11
//3.     21
//4.     1211
//5.     111221
public class Solution {

	public static void main(String[] args) {
		System.out.print(countAndSay(6));
	}

	public static String countAndSay(int n) {
		if(n <= 0) {
			return null;
		}else if(n == 1) {
			return "1";
		}
		
		String result = "1";
		for(int i = 1; i < n; i++) {
			result = doCalculate(result);
			
		}
		return result;
	}
	
	public static String doCalculate(String target) {
		int count = 1;
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < target.length(); i++) {
			if(i == 0) {
				continue;
			}
			if(target.charAt(i) == target.charAt(i-1)) {
				count++;
			}else {
				sb.append(count).append(target.charAt(i-1));
				count = 1;
			}
		}
		return sb.append(count).append(target.charAt(target.length() - 1)).toString();
	}
}
