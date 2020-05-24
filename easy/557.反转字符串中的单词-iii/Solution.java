import java.util.Stack;

/*
 * @Author: aponder
 * @Date: 2020-05-24 21:44:28
 * @LastEditTime: 2020-05-24 21:54:49
 * @LastEditors: aponder
 * @Description: 
 * @FilePath: /leetcode-zh/easy/557.反转字符串中的单词-iii/Solution.java
 */ 
/*
 * @lc app=leetcode.cn id=557 lang=java
 *
 * [557] 反转字符串中的单词 III
 *
 * https://leetcode-cn.com/problems/reverse-words-in-a-string-iii/description/
 *
 * algorithms
 * Easy (70.08%)
 * Likes:    179
 * Dislikes: 0
 * Total Accepted:    55.5K
 * Total Submissions: 78.6K
 * Testcase Example:  '"Let\'s take LeetCode contest"'
 *
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 * 
 * 示例 1:
 * 
 * 
 * 输入: "Let's take LeetCode contest"
 * 输出: "s'teL ekat edoCteeL tsetnoc" 
 * 
 * 
 * 注意：在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
 * 
 */

// @lc code=start
class Solution {
    // 方法 1
    // public String reverseWords(String s) {
    //     StringBuilder result = new StringBuilder();
    //     StringBuilder word = new StringBuilder();
    //     for (char c : s.toCharArray()) {
    //         if (c == ' ') {
    //             result.append(word.reverse()).append(c);
    //             word = new StringBuilder();
    //         } else {
    //             word.append(c);
    //         }
    //     }

    //     result.append(word.reverse());
    //     return result.toString();
    // }

    // 方法 2
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                while (!stack.empty()) {
                    sb.append(stack.pop());
                }
                sb.append(' ');
            } else {
                stack.push(c);
            }   
        }

        while (!stack.empty()) {
            sb.append(stack.pop());
        }

        return sb.toString();
    }
}
// @lc code=end

// Accepted
// 30/30 cases passed (10 ms)
// Your runtime beats 41.67 % of java submissions
// Your memory usage beats 5 % of java submissions (40.7 MB)

// Accepted
// 30/30 cases passed (29 ms)
// Your runtime beats 15.72 % of java submissions
// Your memory usage beats 5 % of java submissions (40.6 MB)