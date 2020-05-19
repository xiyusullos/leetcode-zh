/*
 * @Author: aponder
 * @Date: 2020-05-19 16:38:33
 * @LastEditTime: 2020-05-19 16:51:53
 * @LastEditors: aponder
 * @Description: 
 * @FilePath: /leetcode-zh/easy/504.七进制数/Solution.java
 */ 
/*
 * @lc app=leetcode.cn id=504 lang=java
 *
 * [504] 七进制数
 *
 * https://leetcode-cn.com/problems/base-7/description/
 *
 * algorithms
 * Easy (48.63%)
 * Likes:    41
 * Dislikes: 0
 * Total Accepted:    12K
 * Total Submissions: 24.4K
 * Testcase Example:  '100'
 *
 * 给定一个整数，将其转化为7进制，并以字符串形式输出。
 * 
 * 示例 1:
 * 
 * 
 * 输入: 100
 * 输出: "202"
 * 
 * 
 * 示例 2:
 * 
 * 
 * 输入: -7
 * 输出: "-10"
 * 
 * 
 * 注意: 输入范围是 [-1e7, 1e7] 。
 * 
 */

// @lc code=start
class Solution {
    public String convertToBase7(int num) {
        StringBuilder sb = new StringBuilder();
        boolean isNegtive = false;
        if (num < 0) {
            isNegtive = true;
            sb.append(-(num % 7));
            num /= 7;
            num = -num;
        } else {
            sb.append(num % 7);
            num /= 7;
        }

        while (num != 0) {
            sb.append(num % 7);
            num /= 7;
        }
        if (isNegtive) sb.append('-');

        return sb.reverse().toString();
    }
}
// @lc code=end

// Accepted
// 241/241 cases passed (1 ms)
// Your runtime beats 99.67 % of java submissions
// Your memory usage beats 7.14 % of java submissions (37.5 MB)