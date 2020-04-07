/*
 * @Author: aponder
 * @Date: 2020-04-07 17:20:54
 * @LastEditors: aponder
 * @LastEditTime: 2020-04-07 18:16:28
 * @FilePath: /leetcode-zh/medium/3.无重复字符的最长子串/Solution.java
 */
/*
 * @lc app=leetcode.cn id=3 lang=java
 *
 * [3] 无重复字符的最长子串
 *
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/description/
 *
 * algorithms
 * Medium (33.63%)
 * Likes:    3425
 * Dislikes: 0
 * Total Accepted:    419K
 * Total Submissions: 1.2M
 * Testcase Example:  '"abcabcbb"'
 *
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * 
 * 示例 1:
 * 
 * 输入: "abcabcbb"
 * 输出: 3 
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 
 * 
 * 示例 2:
 * 
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 
 * 
 * 示例 3:
 * 
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * 
 * 
 */

// @lc code=start
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int length = s.length();
        if (length <= 1) {
            return length;
        }

        String substring = "";
        int maxLength = 0;
        int possibleLength = 0;
        int index;
        char currentChar;
        String str;
        for (int i = 0; i < length; i++) {
            currentChar = s.charAt(i);
            index = substring.indexOf("" + currentChar);
            if (index > -1) {
                // 有重复的
                maxLength = Math.max(maxLength, possibleLength);
                str = substring.substring(index + 1);
                possibleLength = str.length() + 1;
                substring = str + currentChar;
            } else {
                // 没有重复的
                substring += currentChar;
                possibleLength++;
            }
        }

        return Math.max(maxLength, possibleLength);
    }

    boolean charInString(char c, String s) {
        for (char t : s.toCharArray()) {
            if (c == t) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println((new Solution()).lengthOfLongestSubstring("dvdf"));
    }
}
// @lc code=end

// Accepted
// 987/987 cases passed (31 ms)
// Your runtime beats 20 % of java submissions
// Your memory usage beats 5.04 % of java submissions (40.1 MB)