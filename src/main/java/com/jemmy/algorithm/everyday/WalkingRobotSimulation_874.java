package com.jemmy.algorithm.everyday;

import java.util.HashSet;
import java.util.Set;

/**
 * 874. 模拟行走机器人
 *
 * 机器人在一个无限大小的网格上行走，从点 (0, 0) 处开始出发，面向北方。该机器人可以接收以下三种类型的命令：
 *
 * -2：向左转 90 度
 * -1：向右转 90 度
 * 1 <= x <= 9：向前移动 x 个单位长度
 * 在网格上有一些格子被视为障碍物。
 *
 * 第 i 个障碍物位于网格点  (obstacles[i][0], obstacles[i][1])
 *
 * 机器人无法走到障碍物上，它将会停留在障碍物的前一个网格方块上，但仍然可以继续该路线的其余部分。
 *
 * 返回从原点到机器人所有经过的路径点（坐标为整数）的最大欧式距离的平方。
 *
 *  
 *
 * 示例 1：
 *
 * 输入: commands = [4,-1,3], obstacles = []
 * 输出: 25
 * 解释: 机器人将会到达 (3, 4)
 * 示例 2：
 *
 * 输入: commands = [4,-1,4,-2,4], obstacles = [[2,4]]
 * 输出: 65
 * 解释: 机器人在左转走到 (1, 8) 之前将被困在 (1, 4) 处
 *  
 *
 * 提示：
 *
 * 0 <= commands.length <= 10000
 * 0 <= obstacles.length <= 10000
 * -30000 <= obstacle[i][0] <= 30000
 * -30000 <= obstacle[i][1] <= 30000
 * 答案保证小于 2 ^ 31
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/walking-robot-simulation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhujiang.cheng
 * @since 2020/7/22
 */
public class WalkingRobotSimulation_874 {

    public int robotSim(int[] commands, int[][] obstacles) {
        // Clarification, 机器人直行、左转、右转，遇到障碍物会停在障碍物前面，求距离原点最大的路径点
        // 方案1 - 模拟法，遍历每个命令，左转/右转，单步行进
        // 使用数组保存 方向和坐标的关系
        // 使用集合保存 障碍物（使用坐标字符串 x-y 表示)
        // 时间复杂度：O(n)
        // 空间复杂度: O(1)

        int x = 0, y = 0, di = 0;
        int[] dx = new int[] {0, 1, 0, -1};
        int[] dy = new int[] {1, 0, -1, 0};

        Set<String> obstacleSet = new HashSet<>();
        for (int[] obstacle : obstacles) {
            obstacleSet.add(obstacle[0] + "-" + obstacle[1]);
        }

        int maxDistance = 0;

        for (int i = 0; i < commands.length; i++) {
            switch (commands[i]) {
                case -1:
                    // 右转
                    di = (di + 1) % 4;
                    break;
                case -2:
                    // 左转
                    di = (di + 3) % 4;
                    break;
                default:
                    // 单步行走 commands[i] 步
                    for (int j = 0; j < commands[i]; j++) {
                        int xTemp = dx[di] + x;
                        int yTemp = dy[di] + y;

                        if (!obstacleSet.contains(xTemp + "-" + yTemp)) {
                            x = xTemp;
                            y = yTemp;
                            maxDistance = Math.max(maxDistance, x * x + y * y);
                        }
                    }
                    break;
            }
        }

        return maxDistance;
    }

    public int robotSimTwo(int[] commands, int[][] obstacles) {
        // Clarification, 机器人直行、左转、右转，遇到障碍物会停在障碍物前面，求距离原点最大的路径点
        // 方案2 - 模拟法，遍历每个命令，左转/右转，单步行进
        // 使用数组保存 方向和坐标的关系
        // 使用集合保存 障碍物（使用 x 左移16为 + y 表示)
        // 时间复杂度：O(n)
        // 空间复杂度: O(1)

        int x = 0, y = 0, di = 0;
        int[] dx = new int[] {0, 1, 0, -1};
        int[] dy = new int[] {1, 0, -1, 0};

        Set<Long> obstacleSet = new HashSet<>();
        for (int[] obstacle : obstacles) {
            // << 16必须用括号括起来，否则结果不对
            long key = ((obstacle[0] + 30000) << 16) + (obstacle[1] + 30000);
            obstacleSet.add(key);
        }

        int maxDistance = 0;

        for (int i = 0; i < commands.length; i++) {
            switch (commands[i]) {
                case -1:
                    // 右转
                    di = (di + 1) % 4;
                    break;
                case -2:
                    // 左转
                    di = (di + 3) % 4;
                    break;
                default:
                    // 单步行走 commands[i] 步
                    for (int j = 0; j < commands[i]; j++) {
                        int xTemp = dx[di] + x;
                        int yTemp = dy[di] + y;

                        long value = (xTemp + 30000 << 16) + yTemp + 30000;
                        if (!obstacleSet.contains(value)) {
                            x = xTemp;
                            y = yTemp;
                            maxDistance = Math.max(maxDistance, x * x + y * y);
                        }
                    }
                    break;
            }
        }

        return maxDistance;
    }
}
