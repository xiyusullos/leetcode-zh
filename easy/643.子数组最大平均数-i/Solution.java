/*
 * @Author: aponder
 * @Date: 2020-05-30 23:31:24
 * @LastEditTime: 2020-05-30 23:32:00
 * @LastEditors: aponder
 * @Description: 
 * @FilePath: /leetcode-zh/easy/643.子数组最大平均数-i/Solution.java
 */ 
/*
 * @lc app=leetcode.cn id=643 lang=java
 *
 * [643] 子数组最大平均数 I
 *
 * https://leetcode-cn.com/problems/maximum-average-subarray-i/description/
 *
 * algorithms
 * Easy (38.16%)
 * Likes:    91
 * Dislikes: 0
 * Total Accepted:    14.6K
 * Total Submissions: 38K
 * Testcase Example:  '[1,12,-5,-6,50,3]\n4'
 *
 * 给定 n 个整数，找出平均数最大且长度为 k 的连续子数组，并输出该最大平均数。
 * 
 * 示例 1:
 * 
 * 输入: [1,12,-5,-6,50,3], k = 4
 * 输出: 12.75
 * 解释: 最大平均数 (12-5-6+50)/4 = 51/4 = 12.75
 * 
 * 
 * 
 * 
 * 注意:
 * 
 * 
 * 1 <= k <= n <= 30,000。
 * 所给数据范围 [-10,000，10,000]。
 * 
 * 
 */

// @lc code=start
class Solution {
    // public double findMaxAverage(int[] nums, int k) {

    // }

    public double findMaxAverage(int[] nums, int k) {
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        for (int i = 1; i < nums.length; i++)
        sum[i] = sum[i - 1] + nums[i];
        double res = sum[k - 1] * 1.0 / k;
        for (int i = k; i < nums.length; i++) {
            res = Math.max(res, (sum[i] - sum[i - k]) * 1.0 / k);
        }
        return res;
    }
}
// @lc code=end

// Accepted
// 123/123 cases passed (5 ms)
// Your runtime beats 49.95 % of java submissions
// Your memory usage beats 16.67 % of java submissions (44.2 MB)