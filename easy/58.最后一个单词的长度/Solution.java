/*
 * @lc app=leetcode.cn id=58 lang=java
 *
 * [58] 最后一个单词的长度
 *
 * https://leetcode-cn.com/problems/length-of-last-word/description/
 *
 * algorithms
 * Easy (32.84%)
 * Likes:    183
 * Dislikes: 0
 * Total Accepted:    79.6K
 * Total Submissions: 242K
 * Testcase Example:  '"Hello World"'
 *
 * 给定一个仅包含大小写字母和空格 ' ' 的字符串 s，返回其最后一个单词的长度。如果字符串从左向右滚动显示，那么最后一个单词就是最后出现的单词。
 * 
 * 如果不存在最后一个单词，请返回 0 。
 * 
 * 说明：一个单词是指仅由字母组成、不包含任何空格字符的 最大子字符串。
 * 
 * 
 * 
 * 示例:
 * 
 * 输入: "Hello World"
 * 输出: 5
 * 
 * 
 */

// @lc code=start
class Solution {
    public int lengthOfLastWord(String s) {
        // String[] words = s.trim().split("\\s");
        // int length = words.length;
        // if (length == 0) {
        //     return 0;
        // } else {
        //     return words[length - 1].length();
        // }
        // Accepted
        // 59/59 cases passed (5 ms)
        // Your runtime beats 7.3 % of java submissions
        // Your memory usage beats 5.1 % of java submissions (38.3 MB)

        int l = s.length();
        if (l == 0) {
            return 0;
        }

        int countSpace = 0;
        char c;
        for (int i = l - 1; i >= 0; i--) {
            c = s.charAt(i);
            if (c == ' ') {
                countSpace++;
            } else {
                break;
            }
        }

        // String word = "";
        int countWord = 0;
        for (int i = l - 1 - countSpace; i >= 0; i--) {
            c = s.charAt(i);
            if (c != ' ') {
                // word += c;
                countWord++;
            } else {
                break;
            }
        }

        return countWord;
    }
}
// @lc code=end

// Accepted
// 59/59 cases passed (0 ms)
// Your runtime beats 100 % of java submissions
// Your memory usage beats 5.1 % of java submissions (37.8 MB)