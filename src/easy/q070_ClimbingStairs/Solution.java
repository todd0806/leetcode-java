package easy.q070_ClimbingStairs;

import java.util.HashMap;

//https://leetcode.com/problems/climbing-stairs/

public class Solution {

	public static HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	public static void main(String[] args) {
		System.out.print(climbStairs(45));
	}

	public static int climbStairs(int n) {
		if(n == 1) {
			return 1;
		}else if (n == 2) {
			return 2;
		}else if(n > 2){
			if(map.containsKey(n)) {
				return map.get(n);
			}else {
				map.put(n, climbStairs(n-1) + climbStairs(n-2));
				return map.get(n);
			}
		}else {
			return 0;
		}
	}
}
