/*
 * @Author: aponder
 * @Date: 2020-05-02 12:15:12
 * @LastEditors: aponder
 * @LastEditTime: 2020-05-02 12:17:26
 * @FilePath: /leetcode-zh/easy/326.3-的幂/Solution.java
 */
/*
 * @lc app=leetcode.cn id=326 lang=java
 *
 * [326] 3的幂
 *
 * https://leetcode-cn.com/problems/power-of-three/description/
 *
 * algorithms
 * Easy (46.73%)
 * Likes:    102
 * Dislikes: 0
 * Total Accepted:    43.9K
 * Total Submissions: 93.8K
 * Testcase Example:  '27'
 *
 * 给定一个整数，写一个函数来判断它是否是 3 的幂次方。
 * 
 * 示例 1:
 * 
 * 输入: 27
 * 输出: true
 * 
 * 
 * 示例 2:
 * 
 * 输入: 0
 * 输出: false
 * 
 * 示例 3:
 * 
 * 输入: 9
 * 输出: true
 * 
 * 示例 4:
 * 
 * 输入: 45
 * 输出: false
 * 
 * 进阶：
 * 你能不使用循环或者递归来完成本题吗？
 * 
 */

// @lc code=start
class Solution {
    public boolean isPowerOfThree(int n) {
        if (n <= 0) return false;
        while (n > 1) {
            int t = n / 3;
            if (t * 3 != n) return false;
            n = t;
        }
        return true;
    }
}
// @lc code=end

// Accepted
// 21038/21038 cases passed (14 ms)
// Your runtime beats 99.9 % of java submissions
// Your memory usage beats 8.7 % of java submissions (39.1 MB)