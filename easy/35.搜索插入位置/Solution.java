/*
 * @lc app=leetcode.cn id=35 lang=java
 *
 * [35] 搜索插入位置
 *
 * https://leetcode-cn.com/problems/search-insert-position/description/
 *
 * algorithms
 * Easy (45.35%)
 * Likes:    472
 * Dislikes: 0
 * Total Accepted:    137.6K
 * Total Submissions: 303.2K
 * Testcase Example:  '[1,3,5,6]\n5'
 *
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 
 * 你可以假设数组中无重复元素。
 * 
 * 示例 1:
 * 
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * 
 * 
 * 示例 2:
 * 
 * 输入: [1,3,5,6], 2
 * 输出: 1
 * 
 * 
 * 示例 3:
 * 
 * 输入: [1,3,5,6], 7
 * 输出: 4
 * 
 * 
 * 示例 4:
 * 
 * 输入: [1,3,5,6], 0
 * 输出: 0
 * 
 * 
 */

// @lc code=start
class Solution {
    public int searchInsert(int[] nums, int target) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        int lastI = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > target) {
                break;
            } else if (nums[i] == target) {
                return i;
            } else {
                lastI++;
            }
        }

        return lastI;
    }
}
// @lc code=end

// Accepted
// 62/62 cases passed (0 ms)
// Your runtime beats 100 % of java submissions
// Your memory usage beats 5.03 % of java submissions (39.4 MB)