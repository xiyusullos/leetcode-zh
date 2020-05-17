/*
 * @Author: aponder
 * @Date: 2020-05-17 22:58:03
 * @LastEditors: aponder
 * @LastEditTime: 2020-05-17 23:01:07
 * @FilePath: /leetcode-zh/easy/485.最大连续-1-的个数/Solution.java
 */
/*
 * @lc app=leetcode.cn id=485 lang=java
 *
 * [485] 最大连续1的个数
 *
 * https://leetcode-cn.com/problems/max-consecutive-ones/description/
 *
 * algorithms
 * Easy (56.14%)
 * Likes:    95
 * Dislikes: 0
 * Total Accepted:    37.7K
 * Total Submissions: 66.7K
 * Testcase Example:  '[1,0,1,1,0,1]'
 *
 * 给定一个二进制数组， 计算其中最大连续1的个数。
 * 
 * 示例 1:
 * 
 * 
 * 输入: [1,1,0,1,1,1]
 * 输出: 3
 * 解释: 开头的两位和最后的三位都是连续1，所以最大连续1的个数是 3.
 * 
 * 
 * 注意：
 * 
 * 
 * 输入的数组只包含 0 和1。
 * 输入数组的长度是正整数，且不超过 10,000。
 * 
 * 
 */

// @lc code=start
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0, possibleCount = 0;
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (nums[i] == 1) possibleCount++;
            else {
                if (possibleCount > count) count = possibleCount;
                possibleCount = 0;
            }
        }
        if (possibleCount > count) count = possibleCount;

        return count;
    }
}
// @lc code=end

// Accepted
// 41/41 cases passed (2 ms)
// Your runtime beats 96.7 % of java submissions
// Your memory usage beats 5.26 % of java submissions (41.4 MB)