package medium.q204_CountPrimes;
// https://leetcode.com/problems/count-primes/
public class Solution {
	// https://leetcode.com/problems/count-primes/discuss/57588/My-simple-Java-solution
	public int countPrimes(int n) {
		boolean[] isPrimes = new boolean[n];
		int count = 0;
		for (int i = 2; i < n; i++) {
			if (isPrimes[i] == false) {
				count++;
				for (int j = 2; i * j < n; j++) {
					isPrimes[i * j] = true;
				}
			}
		}
		return count;
	}
}
