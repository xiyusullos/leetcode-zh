/*
 * @Author: aponder
 * @Date: 2020-05-05 14:20:17
 * @LastEditors: aponder
 * @LastEditTime: 2020-05-05 14:27:45
 * @FilePath: /leetcode-zh/easy/371.两整数之和/Solution.java
 */
/*
 * @lc app=leetcode.cn id=371 lang=java
 *
 * [371] 两整数之和
 *
 * https://leetcode-cn.com/problems/sum-of-two-integers/description/
 *
 * algorithms
 * Easy (54.24%)
 * Likes:    240
 * Dislikes: 0
 * Total Accepted:    27.5K
 * Total Submissions: 50.4K
 * Testcase Example:  '1\n2'
 *
 * 不使用运算符 + 和 - ​​​​​​​，计算两整数 ​​​​​​​a 、b ​​​​​​​之和。
 * 
 * 示例 1:
 * 
 * 输入: a = 1, b = 2
 * 输出: 3
 * 
 * 
 * 示例 2:
 * 
 * 输入: a = -2, b = 3
 * 输出: 1
 * 
 */

// @lc code=start
class Solution {
    public int getSum(int a, int b) {
        // return a + b;
        return b == 0 ? a : getSum(a ^ b, (a & b) << 1);
    }
}
// @lc code=end

// Accepted
// 13/13 cases passed (0 ms)
// Your runtime beats 100 % of java submissions
// Your memory usage beats 8 % of java submissions (36.8 MB)