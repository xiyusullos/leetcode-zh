/*
 * @Author: aponder
 * @Date: 2020-05-05 13:45:07
 * @LastEditors: aponder
 * @LastEditTime: 2020-05-05 13:54:38
 * @FilePath: /leetcode-zh/easy/367.有效的完全平方数/Solution.java
 */
/*
 * @lc app=leetcode.cn id=367 lang=java
 *
 * [367] 有效的完全平方数
 *
 * https://leetcode-cn.com/problems/valid-perfect-square/description/
 *
 * algorithms
 * Easy (43.28%)
 * Likes:    117
 * Dislikes: 0
 * Total Accepted:    30.4K
 * Total Submissions: 70.1K
 * Testcase Example:  '16'
 *
 * 给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。
 * 
 * 说明：不要使用任何内置的库函数，如  sqrt。
 * 
 * 示例 1：
 * 
 * 输入：16
 * 输出：True
 * 
 * 示例 2：
 * 
 * 输入：14
 * 输出：False
 * 
 * 
 */

// @lc code=start
class Solution {
    public boolean isPerfectSquare(int num) {
        // x^2-2x+1 < x^2 < x^2+2x+1
        // -2x+1 < 0 < 2X+1
        if (num < 0) {
            return false;
        }

        if (num <= 1) {
            return true;
        }

        int n;
        for (int i = 2; i < num; i++) {
            n = i * i;
            if (n == num) return true;
            else if (n < num) continue;
            else return false;
        }

        return false;
    }
}
// @lc code=end

