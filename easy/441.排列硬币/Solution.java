/*
 * @Author: aponder
 * @Date: 2020-05-12 12:43:18
 * @LastEditors: aponder
 * @LastEditTime: 2020-05-12 12:59:17
 * @FilePath: /leetcode-zh/easy/441.排列硬币/Solution.java
 */
/*
 * @lc app=leetcode.cn id=441 lang=java
 *
 * [441] 排列硬币
 *
 * https://leetcode-cn.com/problems/arranging-coins/description/
 *
 * algorithms
 * Easy (40.40%)
 * Likes:    55
 * Dislikes: 0
 * Total Accepted:    20.1K
 * Total Submissions: 49.2K
 * Testcase Example:  '5'
 *
 * 你总共有 n 枚硬币，你需要将它们摆成一个阶梯形状，第 k 行就必须正好有 k 枚硬币。
 * 
 * 给定一个数字 n，找出可形成完整阶梯行的总行数。
 * 
 * n 是一个非负整数，并且在32位有符号整型的范围内。
 * 
 * 示例 1:
 * 
 * 
 * n = 5
 * 
 * 硬币可排列成以下几行:
 * ¤
 * ¤ ¤
 * ¤ ¤
 * 
 * 因为第三行不完整，所以返回2.
 * 
 * 
 * 示例 2:
 * 
 * 
 * n = 8
 * 
 * 硬币可排列成以下几行:
 * ¤
 * ¤ ¤
 * ¤ ¤ ¤
 * ¤ ¤
 * 
 * 因为第四行不完整，所以返回3.
 * 
 * 
 */

// @lc code=start
class Solution {
    public int arrangeCoins(int n) {
        // (1+k)*k/2 ≤ n
        // (1+k)*k ≤ 2n
        // k^2+k+1/4 ≤ 2n+1/4
        // k+1/2 ≤ sqrt(2n+1/4)
        double m = n;
        m = 2 * m + 0.25;
        return (int) (Math.sqrt(m) - 0.5);
    }
}
// @lc code=end

// Accepted
// 1336/1336 cases passed (1 ms)
// Your runtime beats 100 % of java submissions
// Your memory usage beats 16.67 % of java submissions (36.8 MB)