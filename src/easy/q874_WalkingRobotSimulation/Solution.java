package easy.q874_WalkingRobotSimulation;

import java.util.HashSet;

/**
 * @author Todd
 * https://leetcode.com/problems/walking-robot-simulation/description/
 */
public class Solution {
	/**
	 * https://leetcode-cn.com/problems/walking-robot-simulation/solution/java-mo-ni-xing-zou-ji-qi-ren-si-lu-qing-2olk/
	 * @param commands
	 * @param obstacles
	 * @return
	 */
	public int robotSim(int[] commands, int[][] obstacles) {
		int maxDistance = 0;
		// N E S W
		int[] dx = new int[] {0, 1, 0, -1};
		int[] dy = new int[] {1, 0, -1, 0};
		int x = 0;
		int y = 0;
		int direction = 0;
		HashSet<String> obstaclesSet = new HashSet<>();
		for(int i = 0; i < obstacles.length; i++) {
			obstaclesSet.add(obstacles[i][0] + "," + obstacles[i][1]);
		}
		
		for(int i = 0; i < commands.length; i++) {
			if(commands[i] == -1) {
				direction += 1;
			}else if(commands[i] == -2) {
				direction += 3;
			}else if(commands[i] >= 1) {
				for(int j = 0; j < commands[i]; j++) {
					int nextX = x + dx[direction % 4];
					int nextY = y + dy[direction % 4];
					if(obstaclesSet.contains(nextX + "," + nextY)) {
						break;
					}else {
						x = nextX;
						y = nextY;
						maxDistance = Math.max(maxDistance, x * x + y * y);
					}
				}
			}
		}
		return maxDistance;
	}
}
