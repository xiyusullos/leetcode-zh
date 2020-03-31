/*
 * @lc app=leetcode.cn id=14 lang=java
 *
 * [14] 最长公共前缀
 *
 * https://leetcode-cn.com/problems/longest-common-prefix/description/
 *
 * algorithms
 * Easy (36.70%)
 * Likes:    924
 * Dislikes: 0
 * Total Accepted:    216.2K
 * Total Submissions: 588.6K
 * Testcase Example:  '["flower","flow","flight"]'
 *
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 
 * 如果不存在公共前缀，返回空字符串 ""。
 * 
 * 示例 1:
 * 
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 
 * 
 * 示例 2:
 * 
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 
 * 
 * 说明:
 * 
 * 所有输入只包含小写字母 a-z 。
 * 
 */

// @lc code=start
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        // 所有字符串中的最短字符串的长度
        int minLength = strs[0].length();
        for (String str : strs) {
            int l = str.length();
            if (l < minLength) {
                minLength = l;
            }
        }

        String commoPrefix = "";
        // 第i个字符（不是字符串）
        for (int i = 0; i < minLength; i++) {
            char currentChar = strs[0].charAt(i);
            // 对于每一个字符串而言，判断它们的当前的字符是否相等
            for (String str : strs) {
                if (str.charAt(i) != currentChar) {
                    return commoPrefix;
                }
            }
            commoPrefix += currentChar;
        }
        return commoPrefix;
    }
}
// @lc code=end
