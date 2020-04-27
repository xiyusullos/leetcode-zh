/*
 * @Author: aponder
 * @Date: 2020-04-27 10:21:39
 * @LastEditors: aponder
 * @LastEditTime: 2020-04-27 11:28:39
 * @FilePath: /leetcode-zh/medium/33.搜索旋转排序数组/Solution.java
 */
/*
 * @lc app=leetcode.cn id=33 lang=java
 *
 * [33] 搜索旋转排序数组
 *
 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array/description/
 *
 * algorithms
 * Medium (36.59%)
 * Likes:    646
 * Dislikes: 0
 * Total Accepted:    102.9K
 * Total Submissions: 277.6K
 * Testcase Example:  '[4,5,6,7,0,1,2]\n0'
 *
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * 
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * 
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * 
 * 你可以假设数组中不存在重复的元素。
 * 
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * 
 * 示例 1:
 * 
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 * 
 * 
 * 示例 2:
 * 
 * 输入: nums = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 * 
 */

// @lc code=start
class Solution {
    // 方法 1
    // public int search(int[] nums, int target) {
    //     int length = nums.length;
    //     for (int i = 0; i < length; i++) {
    //         if (target == nums[i]) return i;
    //     }
    //     return -1;
    // }

    // 方法 2
    public int search(int[] nums, int target) {
        // [5, 6, 7, 0, 1, 2, 4]
        int l = 0, h = nums.length - 1;
        int m = l + (h - l) / 2;
    
        while (l <= h) {       
            if (nums[m] == target) return m;
            // 在左边
            if (
                // low-mid 有序 且 target < mid 且 target >= low
                nums[m] > nums[l] && target < nums[m] && target >= nums[l]
                // low-mid 无序
                || nums[m] < nums[l] && (
                    target >= nums[l]
                    || target < nums[m]
                )
            ) {
                h = m - 1;
            } else {
                l = m + 1;
            }
            m = l + (h - l) / 2;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums; int t;
        nums = new int[]{4, 5, 6, 7, 8, 1, 2, 3}; t = 8;
        // nums = new int[]{4,5,6,7,0,1,2}; t = 0;
        nums = new int[]{5,1,2,3,4}; t = 1;

        int i = new Solution().search(nums, t);
        System.out.println(i);
    }
}
// @lc code=end

// 方法 1
// Accepted
// 196/196 cases passed (0 ms)
// Your runtime beats 100 % of java submissions
// Your memory usage beats 17.74 % of java submissions (39.4 MB)

// 方法 2
// Accepted
// 196/196 cases passed (0 ms)
// Your runtime beats 100 % of java submissions
// Your memory usage beats 17.74 % of java submissions (39.6 MB)