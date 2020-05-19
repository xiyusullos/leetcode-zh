/*
 * @Author: aponder
 * @Date: 2020-05-19 16:56:17
 * @LastEditTime: 2020-05-19 17:02:22
 * @LastEditors: aponder
 * @Description: 
 * @FilePath: /leetcode-zh/easy/680.验证回文字符串-ⅱ/Solution.java
 */ 
/*
 * @lc app=leetcode.cn id=680 lang=java
 *
 * [680] 验证回文字符串 Ⅱ
 *
 * https://leetcode-cn.com/problems/valid-palindrome-ii/description/
 *
 * algorithms
 * Easy (36.16%)
 * Likes:    177
 * Dislikes: 0
 * Total Accepted:    33.1K
 * Total Submissions: 84.9K
 * Testcase Example:  '"aba"'
 *
 * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
 * 
 * 示例 1:
 * 
 * 
 * 输入: "aba"
 * 输出: True
 * 
 * 
 * 示例 2:
 * 
 * 
 * 输入: "abca"
 * 输出: True
 * 解释: 你可以删除c字符。
 * 
 * 
 * 注意:
 * 
 * 
 * 字符串只包含从 a-z 的小写字母。字符串的最大长度是50000。
 * 
 * 
 */

// @lc code=start
class Solution {
    public boolean validPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        boolean isValid = true;
        int t1, t2;
        while (i < j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                isValid = false;
                break;
            }
        }

        if (!isValid) {
            isValid = true;
            // 尝试删除左边的
            t1 = i + 1;
            t2 = j;
            while (t1 < t2) {
                if (s.charAt(t1) == s.charAt(t2)) {
                    t1++;
                    t2--;
                } else {
                    isValid = false;
                    break;
                }
            }
        }

        if (!isValid) {
            isValid = true;
            // 尝试删除右边的
            t1 = i;
            t2 = j - 1;
            while (t1 < t2) {
                if (s.charAt(t1) == s.charAt(t2)) {
                    t1++;
                    t2--;
                } else {
                    isValid = false;
                    break;
                }
            }
        }

        return isValid;
    }
}
// @lc code=end

// Accepted
// 460/460 cases passed (6 ms)
// Your runtime beats 99.84 % of java submissions
// Your memory usage beats 6.67 % of java submissions (40.6 MB)