/*
 * @Author: aponder
 * @Date: 2020-04-29 12:29:51
 * @LastEditors: aponder
 * @LastEditTime: 2020-04-29 12:36:20
 * @FilePath: /leetcode-zh/easy/258.各位相加/Solution.java
 */
/*
 * @lc app=leetcode.cn id=258 lang=java
 *
 * [258] 各位相加
 *
 * https://leetcode-cn.com/problems/add-digits/description/
 *
 * algorithms
 * Easy (66.08%)
 * Likes:    238
 * Dislikes: 0
 * Total Accepted:    37K
 * Total Submissions: 55.7K
 * Testcase Example:  '38'
 *
 * 给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。
 * 
 * 示例:
 * 
 * 输入: 38
 * 输出: 2 
 * 解释: 各位相加的过程为：3 + 8 = 11, 1 + 1 = 2。 由于 2 是一位数，所以返回 2。
 * 
 * 
 * 进阶:
 * 你可以不使用循环或者递归，且在 O(1) 时间复杂度内解决这个问题吗？
 * 
 */

// @lc code=start
class Solution {
    // 方法 1: 递归
    public int addDigits(int num) {
        if (num < 10) {
            return num;
        }
        int n = 0;
        while (num > 0) {
            n += num % 10;
            num /= 10;
        }
        return addDigits(n);
    }
}
// @lc code=end

// 方法 1: 递归
// Accepted
// 1101/1101 cases passed (1 ms)
// Your runtime beats 100 % of java submissions
// Your memory usage beats 8 % of java submissions (36.9 MB)