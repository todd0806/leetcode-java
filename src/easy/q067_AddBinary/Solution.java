package easy.q067_AddBinary;

//https://leetcode.com/problems/add-binary/

public class Solution {

	public static void main(String[] args) {
		System.out.print(addBinary("11", "1"));
	}

	public static String addBinary(String a, String b) {
		int[] numsA = null;
		int[] numsB = null;
		
		while(b.length() != a.length()) {
			if(a.length() > b.length()) {
				b = "0".concat(b);
			}else {
				a = "0".concat(a);
			}
		}
		
		numsA = new int[a.length()];
		numsB = new int[a.length()];
		for(int i = 0; i < a.length(); i++) {
			numsA[i] = Integer.parseInt(a.substring(i, i + 1));
			numsB[i] = Integer.parseInt(b.substring(i, i + 1));
		}
		
		int carry = 0;
		for(int i = numsA.length - 1; i >= 0; i--) {
			if(numsA[i] + numsB[i] + carry == 2) {
				numsA[i] = 0;
				carry = 1;
			}else {
				numsA[i] = numsA[i] + numsB[i] + carry;
				carry = 0;
			}
		}
		StringBuilder sb = new StringBuilder();
		for(Integer i : numsA) {
			sb.append(i.toString());
		}
		if(carry > 0) {
			return "1".concat(sb.toString());
		}else {
			return sb.toString();
		}
	}
}
