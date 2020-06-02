/*
 * @Author: aponder
 * @Date: 2020-06-02 23:41:26
 * @LastEditTime: 2020-06-02 23:42:38
 * @LastEditors: aponder
 * @Description: 
 * @FilePath: /leetcode-zh/easy/674.最长连续递增序列/Solution.java
 */ 
/*
 * @lc app=leetcode.cn id=674 lang=java
 *
 * [674] 最长连续递增序列
 *
 * https://leetcode-cn.com/problems/longest-continuous-increasing-subsequence/description/
 *
 * algorithms
 * Easy (44.57%)
 * Likes:    81
 * Dislikes: 0
 * Total Accepted:    25.7K
 * Total Submissions: 56.7K
 * Testcase Example:  '[1,3,5,4,7]'
 *
 * 给定一个未经排序的整数数组，找到最长且连续的的递增序列。
 * 
 * 示例 1:
 * 
 * 
 * 输入: [1,3,5,4,7]
 * 输出: 3
 * 解释: 最长连续递增序列是 [1,3,5], 长度为3。
 * 尽管 [1,3,5,7] 也是升序的子序列, 但它不是连续的，因为5和7在原数组里被4隔开。 
 * 
 * 
 * 示例 2:
 * 
 * 
 * 输入: [2,2,2,2,2]
 * 输出: 1
 * 解释: 最长连续递增序列是 [2], 长度为1。
 * 
 * 
 * 注意：数组长度不会超过10000。
 * 
 */

// @lc code=start
class Solution {
    // public int findLengthOfLCIS(int[] nums) {

    // }
    
    public int findLengthOfLCIS(int[] nums) {
        int ans = 0, anchor = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (i > 0 && nums[i-1] >= nums[i]) anchor = i;
            ans = Math.max(ans, i - anchor + 1);
        }
        return ans;
    }
}
// @lc code=end

// Accepted
// 36/36 cases passed (2 ms)
// Your runtime beats 51.38 % of java submissions
// Your memory usage beats 12.5 % of java submissions (40.3 MB)