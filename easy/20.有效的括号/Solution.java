import java.util.Stack;

/*
 * @lc app=leetcode.cn id=20 lang=java
 *
 * [20] 有效的括号
 *
 * https://leetcode-cn.com/problems/valid-parentheses/description/
 *
 * algorithms
 * Easy (41.26%)
 * Likes:    1472
 * Dislikes: 0
 * Total Accepted:    239.5K
 * Total Submissions: 580.3K
 * Testcase Example:  '"()"'
 *
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * 
 * 有效字符串需满足：
 * 
 * 
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 
 * 
 * 注意空字符串可被认为是有效字符串。
 * 
 * 示例 1:
 * 
 * 输入: "()"
 * 输出: true
 * 
 * 
 * 示例 2:
 * 
 * 输入: "()[]{}"
 * 输出: true
 * 
 * 
 * 示例 3:
 * 
 * 输入: "(]"
 * 输出: false
 * 
 * 
 * 示例 4:
 * 
 * 输入: "([)]"
 * 输出: false
 * 
 * 
 * 示例 5:
 * 
 * 输入: "{[]}"
 * 输出: true
 * 
 */

// @lc code=start
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        int l = s.length();
        for (int i = 0; i < l; i++) {
            char c = s.charAt(i);
            // 当前是左括号，入栈
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                // 是右括号，出栈；并且看出栈的左括号是否与当前右括号匹配（即与之对应的左括号）
                //   此时栈已经为空，肯定为无效括号
                if (stack.empty()) {
                    return false;
                }
                char left = stack.pop();
                if (
                    (left == '(' && c == ')')
                    || (left == '{' && c == '}')
                    || (left == '[' && c == ']')
                ) {
                    continue;
                } else {
                    return false;
                }
            }
        }
        // 最后，栈为空，则全部匹配
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isValid("([)]"));
    }
}
// @lc code=end
