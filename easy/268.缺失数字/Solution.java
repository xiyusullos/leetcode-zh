/*
 * @Author: aponder
 * @Date: 2020-04-30 10:25:54
 * @LastEditors: aponder
 * @LastEditTime: 2020-04-30 10:33:05
 * @FilePath: /leetcode-zh/easy/268.缺失数字/Solution.java
 */
/*
 * @lc app=leetcode.cn id=268 lang=java
 *
 * [268] 缺失数字
 *
 * https://leetcode-cn.com/problems/missing-number/description/
 *
 * algorithms
 * Easy (54.96%)
 * Likes:    250
 * Dislikes: 0
 * Total Accepted:    61.6K
 * Total Submissions: 111.2K
 * Testcase Example:  '[3,0,1]'
 *
 * 给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
 * 
 * 示例 1:
 * 
 * 输入: [3,0,1]
 * 输出: 2
 * 
 * 
 * 示例 2:
 * 
 * 输入: [9,6,4,2,3,5,7,0,1]
 * 输出: 8
 * 
 * 
 * 说明:
 * 你的算法应具有线性时间复杂度。你能否仅使用额外常数空间来实现?
 * 
 */

// @lc code=start
class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int sum = (0 + n) * (n + 1) / 2;
        for (int i = 0; i < n; i++) {
            sum -= nums[i];
        }
        return sum;
    }
}
// @lc code=end

// Accepted
// 122/122 cases passed (0 ms)
// Your runtime beats 100 % of java submissions
// Your memory usage beats 6.67 % of java submissions (40.2 MB)