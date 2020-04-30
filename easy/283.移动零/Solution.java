/*
 * @Author: aponder
 * @Date: 2020-04-30 11:21:24
 * @LastEditors: aponder
 * @LastEditTime: 2020-04-30 11:27:26
 * @FilePath: /leetcode-zh/easy/283.移动零/Solution.java
 */
/*
 * @lc app=leetcode.cn id=283 lang=java
 *
 * [283] 移动零
 *
 * https://leetcode-cn.com/problems/move-zeroes/description/
 *
 * algorithms
 * Easy (60.25%)
 * Likes:    571
 * Dislikes: 0
 * Total Accepted:    140.9K
 * Total Submissions: 232.4K
 * Testcase Example:  '[0,1,0,3,12]'
 *
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 
 * 示例:
 * 
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 
 * 说明:
 * 
 * 
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 * 
 * 
 */

// @lc code=start
class Solution {
    public void moveZeroes(int[] nums) {
        // 0,0,1,0,3,12
        int n = nums.length;
        int j = 0; // 非零下标
        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) nums[j++] = nums[i];
        }
        for (int i = j; i < n; i++) {
            nums[i] = 0;
        }
    }
}
// @lc code=end

// Accepted
// 21/21 cases passed (0 ms)
// Your runtime beats 100 % of java submissions
// Your memory usage beats 5.62 % of java submissions (40.4 MB)