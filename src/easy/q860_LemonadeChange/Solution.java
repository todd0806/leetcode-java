package easy.q860_LemonadeChange;

/**
 * @author Todd https://leetcode.com/problems/lemonade-change/description/
 */
public class Solution {

	/**
	 * https://leetcode-cn.com/problems/lemonade-change/solution/860-ning-meng-shui-zhao-ling-du-gan-jue-zpbdp/
	 * @param bills
	 * @return
	 */
	public boolean lemonadeChange(int[] bills) {
		int five = 0;
		int ten = 0;
		for (int i = 0; i < bills.length; i++) {
			if (bills[i] == 5) {
				five++;
			} else if (bills[i] == 10) {
				if (five > 0) {
					five--;
					ten++;
					continue;
				}
				return false;
			} else if (bills[i] == 20) {
				if (five > 0 && ten > 0) {
					five--;
					ten--;
					continue;
				}
				if (five >= 3) {
					five -= 3;
					continue;
				}
				return false;
			}
		}
		return true;
	}
}
