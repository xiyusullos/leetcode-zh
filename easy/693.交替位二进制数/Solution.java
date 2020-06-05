/*
 * @Author: aponder
 * @Date: 2020-06-05 23:38:12
 * @LastEditTime: 2020-06-05 23:42:09
 * @LastEditors: aponder
 * @Description: 
 * @FilePath: /leetcode-zh/easy/693.交替位二进制数/Solution.java
 */ 
/*
 * @lc app=leetcode.cn id=693 lang=java
 *
 * [693] 交替位二进制数
 *
 * https://leetcode-cn.com/problems/binary-number-with-alternating-bits/description/
 *
 * algorithms
 * Easy (60.47%)
 * Likes:    64
 * Dislikes: 0
 * Total Accepted:    13.7K
 * Total Submissions: 22.7K
 * Testcase Example:  '5'
 *
 * 给定一个正整数，检查他是否为交替位二进制数：换句话说，就是他的二进制数相邻的两个位数永不相等。
 * 
 * 示例 1:
 * 
 * 
 * 输入: 5
 * 输出: True
 * 解释:
 * 5的二进制数是: 101
 * 
 * 
 * 示例 2:
 * 
 * 
 * 输入: 7
 * 输出: False
 * 解释:
 * 7的二进制数是: 111
 * 
 * 
 * 示例 3:
 * 
 * 
 * 输入: 11
 * 输出: False
 * 解释:
 * 11的二进制数是: 1011
 * 
 * 
 * 示例 4:
 * 
 * 
 * 输入: 10
 * 输出: True
 * 解释:
 * 10的二进制数是: 1010
 * 
 * 
 */

// @lc code=start
class Solution {
    public boolean hasAlternatingBits(int n) {
        n = (n ^ (n >> 1));
        return (n & ((long)n + 1)) == 0;
    }
}
// @lc code=end

// Accepted
// 204/204 cases passed (0 ms)
// Your runtime beats 100 % of java submissions
// Your memory usage beats 14.29 % of java submissions (36.5 MB)