/*
 * @Author: aponder
 * @Date: 2020-05-11 12:28:00
 * @LastEditors: aponder
 * @LastEditTime: 2020-05-11 16:36:20
 * @FilePath: /leetcode-zh/medium/50.pow-x-n/Solution.java
 */
/*
 * @lc app=leetcode.cn id=50 lang=java
 *
 * [50] Pow(x, n)
 *
 * https://leetcode-cn.com/problems/powx-n/description/
 *
 * algorithms
 * Medium (34.30%)
 * Likes:    347
 * Dislikes: 0
 * Total Accepted:    81.1K
 * Total Submissions: 229.9K
 * Testcase Example:  '2.00000\n10'
 *
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 * 
 * 示例 1:
 * 
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 * 
 * 
 * 示例 2:
 * 
 * 输入: 2.10000, 3
 * 输出: 9.26100
 * 
 * 
 * 示例 3:
 * 
 * 输入: 2.00000, -2
 * 输出: 0.25000
 * 解释: 2^-2 = 1/2^2 = 1/4 = 0.25
 * 
 * 说明:
 * 
 * 
 * -100.0 < x < 100.0
 * n 是 32 位有符号整数，其数值范围是 [−2^31, 2^31 − 1] 。
 * 
 * 
 */

// @lc code=start
class Solution {
    public double myPow(double x, int n) {
        // 2^10
        // (2^2)^5
        if (x == 0) return 0;
        if (x == 1) return 1;
        if (n == 0) return 1;
        if (n == 1) return x;

        double result = 1;
        long p = n;
        if (n < 0) {
            x = 1 / x;
            p = -p;
        }
        double base = x;
        while (p > 0) {
            if (p % 2 == 1) result *= base;
            base *= base;
            p /= 2;
        }

        return result;
    }
}
// @lc code=end

// Accepted
// 304/304 cases passed (1 ms)
// Your runtime beats 94.5 % of java submissions
// Your memory usage beats 5.88 % of java submissions (37 MB)