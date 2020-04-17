/*
 * @Author: aponder
 * @Date: 2020-04-17 12:36:10
 * @LastEditors: aponder
 * @LastEditTime: 2020-04-17 12:48:41
 * @FilePath: /leetcode-zh/medium/55.跳跃游戏/Solution.java
 */
/*
 * @lc app=leetcode.cn id=55 lang=java
 *
 * [55] 跳跃游戏
 *
 * https://leetcode-cn.com/problems/jump-game/description/
 *
 * algorithms
 * Medium (38.57%)
 * Likes:    582
 * Dislikes: 0
 * Total Accepted:    89.1K
 * Total Submissions: 226.9K
 * Testcase Example:  '[2,3,1,1,4]'
 *
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * 
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 
 * 判断你是否能够到达最后一个位置。
 * 
 * 示例 1:
 * 
 * 输入: [2,3,1,1,4]
 * 输出: true
 * 解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
 * 
 * 
 * 示例 2:
 * 
 * 输入: [3,2,1,0,4]
 * 输出: false
 * 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
 * 
 * 
 */

// @lc code=start
class Solution {
    public boolean canJump(int[] nums) {
        return canJumpTo(nums, nums.length - 1);
    }

    // 从后往前跳
    boolean canJumpTo(int[] nums, int destination) {
        if (destination == 0) { return true; }

        for (int i = destination - 1; i >= 0; i--) {
            if (nums[i] >= destination - i) { return canJumpTo(nums, i); }
        }
        return false;
    }
}
// @lc code=end

// Accepted
// 75/75 cases passed (1 ms)
// Your runtime beats 99.93 % of java submissions
// Your memory usage beats 7.81 % of java submissions (43 MB)