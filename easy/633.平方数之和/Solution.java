/*
 * @Author: aponder
 * @Date: 2020-05-29 23:53:14
 * @LastEditTime: 2020-05-29 23:54:51
 * @LastEditors: aponder
 * @Description: 
 * @FilePath: /leetcode-zh/easy/633.平方数之和/Solution.java
 */ 
/*
 * @lc app=leetcode.cn id=633 lang=java
 *
 * [633] 平方数之和
 *
 * https://leetcode-cn.com/problems/sum-of-square-numbers/description/
 *
 * algorithms
 * Easy (33.10%)
 * Likes:    114
 * Dislikes: 0
 * Total Accepted:    21.5K
 * Total Submissions: 64.6K
 * Testcase Example:  '5'
 *
 * 给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a^2 + b^2 = c。
 * 
 * 示例1:
 * 
 * 
 * 输入: 5
 * 输出: True
 * 解释: 1 * 1 + 2 * 2 = 5
 * 
 * 
 * 
 * 
 * 示例2:
 * 
 * 
 * 输入: 3
 * 输出: False
 * 
 * 
 */

// @lc code=start
class Solution {
    // public boolean judgeSquareSum(int c) {

    // }

    public boolean judgeSquareSum(int c) {
        for (long a = 0; a * a <= c; a++) {
            double b = Math.sqrt(c - a * a);
            if (b == (int) b)
                return true;
        }
        return false;
    }
}
// @lc code=end

// Accepted
// 124/124 cases passed (4 ms)
// Your runtime beats 42.64 % of java submissions
// Your memory usage beats 14.29 % of java submissions (36.2 MB)