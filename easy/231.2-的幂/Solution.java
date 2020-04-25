/*
 * @Author: aponder
 * @Date: 2020-04-25 11:10:06
 * @LastEditors: aponder
 * @LastEditTime: 2020-04-25 11:50:01
 * @FilePath: /leetcode-zh/easy/231.2-的幂/Solution.java
 */
/*
 * @lc app=leetcode.cn id=231 lang=java
 *
 * [231] 2的幂
 *
 * https://leetcode-cn.com/problems/power-of-two/description/
 *
 * algorithms
 * Easy (47.83%)
 * Likes:    184
 * Dislikes: 0
 * Total Accepted:    56.1K
 * Total Submissions: 116.9K
 * Testcase Example:  '1'
 *
 * 给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
 * 
 * 示例 1:
 * 
 * 输入: 1
 * 输出: true
 * 解释: 2^0 = 1
 * 
 * 示例 2:
 * 
 * 输入: 16
 * 输出: true
 * 解释: 2^4 = 16
 * 
 * 示例 3:
 * 
 * 输入: 218
 * 输出: false
 * 
 */

// @lc code=start
class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n == 1) return true;
        // 奇数肯定不是，除了 1
        if ((n & 1) == 1 || n < 1) return false;
        
        while (n > 1) {
            if (n / 2 * 2 != n) {
                return false;
            }
            n /= 2;
        }
        return true;
    }
}
// @lc code=end

// Accepted
// 1108/1108 cases passed (1 ms)
// Your runtime beats 100 % of java submissions
// Your memory usage beats 6.9 % of java submissions (36.9 MB)