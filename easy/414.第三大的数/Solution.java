/*
 * @Author: aponder
 * @Date: 2020-05-10 10:59:47
 * @LastEditors: aponder
 * @LastEditTime: 2020-05-10 11:38:45
 * @FilePath: /leetcode-zh/easy/414.第三大的数/Solution.java
 */
import java.util.Stack;

/*
 * @lc app=leetcode.cn id=414 lang=java
 *
 * [414] 第三大的数
 *
 * https://leetcode-cn.com/problems/third-maximum-number/description/
 *
 * algorithms
 * Easy (34.71%)
 * Likes:    126
 * Dislikes: 0
 * Total Accepted:    25.5K
 * Total Submissions: 72.9K
 * Testcase Example:  '[3,2,1]'
 *
 * 给定一个非空数组，返回此数组中第三大的数。如果不存在，则返回数组中最大的数。要求算法时间复杂度必须是O(n)。
 * 
 * 示例 1:
 * 
 * 
 * 输入: [3, 2, 1]
 * 
 * 输出: 1
 * 
 * 解释: 第三大的数是 1.
 * 
 * 
 * 示例 2:
 * 
 * 
 * 输入: [1, 2]
 * 
 * 输出: 2
 * 
 * 解释: 第三大的数不存在, 所以返回最大的数 2 .
 * 
 * 
 * 示例 3:
 * 
 * 
 * 输入: [2, 2, 3, 1]
 * 
 * 输出: 1
 * 
 * 解释: 注意，要求返回第三大的数，是指第三大且唯一出现的数。
 * 存在两个值为2的数，它们都排第二。
 * 
 * 
 */

// @lc code=start
class Solution {
    public int thirdMax(int[] nums) {
        long m1, m2, m3;
        m1 = m2 = m3 = Long.MIN_VALUE;
        for (int num : nums) {
            if (num > m1) {
                m3 = m2;
                m2 = m1;
                m1 = num;
            } else if (num > m2 && num < m1) {
                m3 = m2;
                m2 = num;
            } else if (num > m3 && num < m2) m3 = num;
        }
        // System.out.println("" + m1 + ", " + m2 + ", " + m3);
        return m3 != Long.MIN_VALUE ? (int) m3 : (int) m1;
    }
}
// @lc code=end

// Accepted
// 26/26 cases passed (3 ms)
// Your runtime beats 54.1 % of java submissions
// Your memory usage beats 11.11 % of java submissions (39.7 MB)

// Accepted
// 26/26 cases passed (0 ms)
// Your runtime beats 100 % of java submissions
// Your memory usage beats 11.11 % of java submissions (39.9 MB)