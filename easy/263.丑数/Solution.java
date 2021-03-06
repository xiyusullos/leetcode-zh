/*
 * @Author: aponder
 * @Date: 2020-04-29 12:46:41
 * @LastEditors: aponder
 * @LastEditTime: 2020-04-29 12:53:03
 * @FilePath: /leetcode-zh/easy/263.丑数/Solution.java
 */
/*
 * @lc app=leetcode.cn id=263 lang=java
 *
 * [263] 丑数
 *
 * https://leetcode-cn.com/problems/ugly-number/description/
 *
 * algorithms
 * Easy (49.03%)
 * Likes:    120
 * Dislikes: 0
 * Total Accepted:    30.7K
 * Total Submissions: 62.4K
 * Testcase Example:  '6'
 *
 * 编写一个程序判断给定的数是否为丑数。
 * 
 * 丑数就是只包含质因数 2, 3, 5 的正整数。
 * 
 * 示例 1:
 * 
 * 输入: 6
 * 输出: true
 * 解释: 6 = 2 × 3
 * 
 * 示例 2:
 * 
 * 输入: 8
 * 输出: true
 * 解释: 8 = 2 × 2 × 2
 * 
 * 
 * 示例 3:
 * 
 * 输入: 14
 * 输出: false 
 * 解释: 14 不是丑数，因为它包含了另外一个质因数 7。
 * 
 * 说明：
 * 
 * 
 * 1 是丑数。
 * 输入不会超过 32 位有符号整数的范围: [−2^31,  2^31 − 1]。
 * 
 * 
 */

// @lc code=start
class Solution {
    public boolean isUgly(int num) {
        if (num <= 0) return false;
        if (num == 1) return true;

        int[] factors = new int[] { 2, 3, 5 };
        for (int f : factors) {
            while (num % f == 0) {
                num /= f;
            }
        }
        return num == 1;
    }
}
// @lc code=end

// Accepted
// 1012/1012 cases passed (1 ms)
// Your runtime beats 100 % of java submissions
// Your memory usage beats 5.55 % of java submissions (36.7 MB)