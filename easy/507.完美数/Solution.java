/*
 * @Author: aponder
 * @Date: 2020-05-20 10:08:46
 * @LastEditTime: 2020-05-20 10:15:34
 * @LastEditors: aponder
 * @Description: 
 * @FilePath: /leetcode-zh/easy/507.完美数/Solution.java
 */ 
/*
 * @lc app=leetcode.cn id=507 lang=java
 *
 * [507] 完美数
 *
 * https://leetcode-cn.com/problems/perfect-number/description/
 *
 * algorithms
 * Easy (38.13%)
 * Likes:    60
 * Dislikes: 0
 * Total Accepted:    14.1K
 * Total Submissions: 36.9K
 * Testcase Example:  '28'
 *
 * 对于一个 正整数，如果它和除了它自身以外的所有正因子之和相等，我们称它为“完美数”。
 * 
 * 给定一个 整数 n， 如果他是完美数，返回 True，否则返回 False
 * 
 * 
 * 
 * 示例：
 * 
 * 输入: 28
 * 输出: True
 * 解释: 28 = 1 + 2 + 4 + 7 + 14
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 输入的数字 n 不会超过 100,000,000. (1e8)
 * 
 */

// @lc code=start
class Solution {
    public boolean checkPerfectNumber(int num) {
        if (num == 1) return false;
        int sum = 1;
        int j = num / 2;
        for (int i = 2; i <= j; i++) {
            if (num % i == 0) sum += i;
        }

        return sum == num;
    }
}
// @lc code=end

// Accepted
// 156/156 cases passed (2120 ms)
// Your runtime beats 5.06 % of java submissions
// Your memory usage beats 9.09 % of java submissions (36.8 MB)