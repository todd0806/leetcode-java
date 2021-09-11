package medium.q050_PowXN;

/**
 * @author Todd https://leetcode.com/problems/powx-n/
 */
public class Solution {
	public double myPow(double x, int n) {
		if(n == 0) {
			return 1;
		} if (n == Integer.MIN_VALUE){
			x = x * x;
			n = n/2;
		}else if (n < 0) {
			n = -n;
			x = 1/x;
		}
		
		if(n %2 == 0) {
			return myPow(x * x, n / 2); 
		}else {
			return myPow(x * x, n / 2) * x; 
		}
	}
	
}
