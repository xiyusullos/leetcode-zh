/*
 * @Author: aponder
 * @Date: 2020-05-03 10:14:22
 * @LastEditors: aponder
 * @LastEditTime: 2020-05-03 10:15:50
 * @FilePath: /leetcode-zh/easy/342.4-的幂/Solution.java
 */
/*
 * @lc app=leetcode.cn id=342 lang=java
 *
 * [342] 4的幂
 *
 * https://leetcode-cn.com/problems/power-of-four/description/
 *
 * algorithms
 * Easy (48.33%)
 * Likes:    106
 * Dislikes: 0
 * Total Accepted:    23.5K
 * Total Submissions: 48.4K
 * Testcase Example:  '16'
 *
 * 给定一个整数 (32 位有符号整数)，请编写一个函数来判断它是否是 4 的幂次方。
 * 
 * 示例 1:
 * 
 * 输入: 16
 * 输出: true
 * 
 * 
 * 示例 2:
 * 
 * 输入: 5
 * 输出: false
 * 
 * 进阶：
 * 你能不使用循环或者递归来完成本题吗？
 * 
 */

// @lc code=start
class Solution {
    public boolean isPowerOfFour(int num) {
        int k = 4;
        if (num <= 0) return false;
        while (num > 1) {
            int t = num / k;
            if (t * k != num) return false;
            num = t;
        }
        return true;
    }
}
// @lc code=end

// Accepted
// 1060/1060 cases passed (1 ms)
// Your runtime beats 100 % of java submissions
// Your memory usage beats 7.69 % of java submissions (37 MB)