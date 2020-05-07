/*
 * @Author: aponder
 * @Date: 2020-05-07 09:26:26
 * @LastEditors: aponder
 * @LastEditTime: 2020-05-07 09:33:16
 * @FilePath: /leetcode-zh/easy/389.找不同/Solution.java
 */
/*
 * @lc app=leetcode.cn id=389 lang=java
 *
 * [389] 找不同
 *
 * https://leetcode-cn.com/problems/find-the-difference/description/
 *
 * algorithms
 * Easy (61.25%)
 * Likes:    123
 * Dislikes: 0
 * Total Accepted:    26.2K
 * Total Submissions: 42.5K
 * Testcase Example:  '"abcd"\n"abcde"'
 *
 * 给定两个字符串 s 和 t，它们只包含小写字母。
 * 
 * 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
 * 
 * 请找出在 t 中被添加的字母。
 * 
 * 
 * 
 * 示例:
 * 
 * 输入：
 * s = "abcd"
 * t = "abcde"
 * 
 * 输出：
 * e
 * 
 * 解释：
 * 'e' 是那个被添加的字母。
 * 
 * 
 */

// @lc code=start
class Solution {
    public char findTheDifference(String s, String t) {
        int result = 0;
        int ls = s.length(), lt = t.length();
        for (int i = 0; i < ls; i++) {
            result ^= s.charAt(i) - 'a';
        }
        for (int i = 0; i < lt; i++) {
            result ^= t.charAt(i) - 'a';
        }

        return (char) ('a' + result);
    }
}
// @lc code=end

// Accepted
// 54/54 cases passed (2 ms)
// Your runtime beats 78.57 % of java submissions
// Your memory usage beats 25 % of java submissions (37.6 MB)