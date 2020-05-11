/*
 * @Author: aponder
 * @Date: 2020-05-11 11:18:28
 * @LastEditors: aponder
 * @LastEditTime: 2020-05-11 11:22:49
 * @FilePath: /leetcode-zh/easy/434.字符串中的单词数/Solution.java
 */
/*
 * @lc app=leetcode.cn id=434 lang=java
 *
 * [434] 字符串中的单词数
 *
 * https://leetcode-cn.com/problems/number-of-segments-in-a-string/description/
 *
 * algorithms
 * Easy (34.35%)
 * Likes:    51
 * Dislikes: 0
 * Total Accepted:    16K
 * Total Submissions: 45.8K
 * Testcase Example:  '"Hello, my name is John"'
 *
 * 统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符。
 * 
 * 请注意，你可以假定字符串里不包括任何不可打印的字符。
 * 
 * 示例:
 * 
 * 输入: "Hello, my name is John"
 * 输出: 5
 * 解释: 这里的单词是指连续的不是空格的字符，所以 "Hello," 算作 1 个单词。
 * 
 * 
 */

// @lc code=start
class Solution {
    public int countSegments(String s) {
        boolean previousIsNotSpace = false;
        int count = 0;
        for (char c: s.toCharArray()) {
            if (previousIsNotSpace && c == ' ') {
                count++;
                previousIsNotSpace = false;
            }

            previousIsNotSpace = c != ' ';
        }

        if (previousIsNotSpace) count++;

        return count;
    }
}
// @lc code=end

// Accepted
// 26/26 cases passed (0 ms)
// Your runtime beats 100 % of java submissions
// Your memory usage beats 14.29 % of java submissions (37.6 MB)