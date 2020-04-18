/*
 * @Author: aponder
 * @Date: 2020-04-18 19:40:29
 * @LastEditors: aponder
 * @LastEditTime: 2020-04-18 19:59:06
 * @FilePath: /leetcode-zh/easy/172.阶乘后的零/Solution.java
 */
/*
 * @lc app=leetcode.cn id=172 lang=java
 *
 * [172] 阶乘后的零
 *
 * https://leetcode-cn.com/problems/factorial-trailing-zeroes/description/
 *
 * algorithms
 * Easy (39.90%)
 * Likes:    263
 * Dislikes: 0
 * Total Accepted:    33.6K
 * Total Submissions: 84.2K
 * Testcase Example:  '3'
 *
 * 给定一个整数 n，返回 n! 结果尾数中零的数量。
 * 
 * 示例 1:
 * 
 * 输入: 3
 * 输出: 0
 * 解释: 3! = 6, 尾数中没有零。
 * 
 * 示例 2:
 * 
 * 输入: 5
 * 输出: 1
 * 解释: 5! = 120, 尾数中有 1 个零.
 * 
 * 说明: 你算法的时间复杂度应为 O(log n) 。
 * 
 */

// @lc code=start
class Solution {
    public int trailingZeroes(int n) {
        // 多少个因子 5
        int p = n / 5;
        int sum = p;
        while (p > 0) {
            p /= 5;
            sum += p;
        }

        return sum;
    }
}
// @lc code=end

// Accepted
// 502/502 cases passed (1 ms)
// Your runtime beats 99.65 % of java submissions
// Your memory usage beats 5.55 % of java submissions (36.6 MB)