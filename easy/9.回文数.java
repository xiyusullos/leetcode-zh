/*
 * @lc app=leetcode.cn id=9 lang=java
 *
 * [9] 回文数
 *
 * https://leetcode-cn.com/problems/palindrome-number/description/
 *
 * algorithms
 * Easy (57.27%)
 * Likes:    981
 * Dislikes: 0
 * Total Accepted:    284.2K
 * Total Submissions: 496.2K
 * Testcase Example:  '121'
 *
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * 
 * 示例 1:
 * 
 * 输入: 121
 * 输出: true
 * 
 * 
 * 示例 2:
 * 
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 
 * 
 * 示例 3:
 * 
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 * 
 * 
 * 进阶:
 * 
 * 你能不将整数转为字符串来解决这个问题吗？
 * 
 */

// @lc code=start
class Solution {
    public boolean isPalindrome(int x) {
        // 负数不是
        if (x < 0) {
            return false;
        }
        // 0-9 都是
        if ( x < 10) {
            return true;
        }

        // 0结尾的不是
        if ( x % 10 == 0) {
            return false;
        }

        int t = x;
        int y = 0;
        while (t / 10 != 0) {
            y += t % 10;
            y *= 10;
            t /= 10;
        }

        return y + t == x;
    }
}
// @lc code=end

