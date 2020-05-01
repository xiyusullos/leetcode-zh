/*
 * @Author: aponder
 * @Date: 2020-05-01 11:43:05
 * @LastEditors: aponder
 * @LastEditTime: 2020-05-01 12:22:07
 * @FilePath: /leetcode-zh/easy/292.nim-游戏/Solution.java
 */
import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=292 lang=java
 *
 * [292] Nim 游戏
 *
 * https://leetcode-cn.com/problems/nim-game/description/
 *
 * algorithms
 * Easy (69.66%)
 * Likes:    296
 * Dislikes: 0
 * Total Accepted:    45.2K
 * Total Submissions: 65K
 * Testcase Example:  '4'
 *
 * 你和你的朋友，两个人一起玩 Nim 游戏：桌子上有一堆石头，每次你们轮流拿掉 1 - 3 块石头。 拿掉最后一块石头的人就是获胜者。你作为先手。
 * 
 * 你们是聪明人，每一步都是最优解。 编写一个函数，来判断你是否可以在给定石头数量的情况下赢得游戏。
 * 
 * 示例:
 * 
 * 输入: 4
 * 输出: false 
 * 解释: 如果堆中有 4 块石头，那么你永远不会赢得比赛；
 * 因为无论你拿走 1 块、2 块 还是 3 块石头，最后一块石头总是会被你的朋友拿走。
 * 
 * 
 */

// @lc code=start
class Solution {
    Map<Integer, Boolean> map = new HashMap<>();
    public boolean canWinNim(int n) {
        // 1,2,3, 5,6,7
        // 4, 8
        return n % 4 != 0;
    }
}
// @lc code=end

// Accepted
// 60/60 cases passed (0 ms)
// Your runtime beats 100 % of java submissions
// Your memory usage beats 6.67 % of java submissions (36.2 MB)