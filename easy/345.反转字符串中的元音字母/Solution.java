
/*
 * @Author: aponder
 * @Date: 2020-05-03 12:20:49
 * @LastEditors: aponder
 * @LastEditTime: 2020-05-03 12:46:35
 * @FilePath: /leetcode-zh/easy/345.反转字符串中的元音字母/Solution.java
 */
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/*
 * @lc app=leetcode.cn id=345 lang=java
 *
 * [345] 反转字符串中的元音字母
 *
 * https://leetcode-cn.com/problems/reverse-vowels-of-a-string/description/
 *
 * algorithms
 * Easy (49.56%)
 * Likes:    84
 * Dislikes: 0
 * Total Accepted:    33.3K
 * Total Submissions: 67K
 * Testcase Example:  '"hello"'
 *
 * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 * 
 * 示例 1:
 * 
 * 输入: "hello"
 * 输出: "holle"
 * 
 * 
 * 示例 2:
 * 
 * 输入: "leetcode"
 * 输出: "leotcede"
 * 
 * 说明:
 * 元音字母不包含字母"y"。
 * 
 */

// @lc code=start
class Solution {
    Set<Character> vowelSet = new HashSet<>(10){{
        add('a');
        add('e');
        add('i');
        add('o');
        add('u');
        add('A');
        add('E');
        add('I');
        add('O');
        add('U');
    }};

    public String reverseVowels(String s) {
        Stack<Character> stack = new Stack<>();
        char[] cs = s.toCharArray();
        for (char c : cs) {
            if (vowelSet.contains(c))
                stack.push(c);
        }
        StringBuilder sb = new StringBuilder();
        for (char c : cs) {
            if (vowelSet.contains(c))
                sb.append(stack.pop());
            else
                sb.append(c);
        }

        return sb.toString();
    }
}
// @lc code=end

// Accepted
// 481/481 cases passed (12 ms)
// Your runtime beats 15.81 % of java submissions
// Your memory usage beats 10 % of java submissions (41.6 MB)