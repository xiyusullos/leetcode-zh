
/*
 * @Author: aponder
 * @Date: 2020-05-01 12:34:30
 * @LastEditors: aponder
 * @LastEditTime: 2020-05-01 13:38:53
 * @FilePath: /leetcode-zh/medium/22.括号生成/Solution.java
 */
import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=22 lang=java
 *
 * [22] 括号生成
 *
 * https://leetcode-cn.com/problems/generate-parentheses/description/
 *
 * algorithms
 * Medium (73.74%)
 * Likes:    987
 * Dislikes: 0
 * Total Accepted:    121.2K
 * Total Submissions: 161K
 * Testcase Example:  '3'
 *
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * 
 * 
 * 
 * 示例：
 * 
 * 输入：n = 3
 * 输出：[
 * ⁠      "((()))",
 * ⁠      "(()())",
 * ⁠      "(())()",
 * ⁠      "()(())",
 * ⁠      "()()()"
 * ⁠    ]
 * 
 * 
 */

// @lc code=start
class Solution {
    List<String> list = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        if (n == 0)
            return list;

        nextParenthesis(new StringBuilder(2 * n), n, n);

        return list;
    }

    void nextParenthesis(StringBuilder sb, int remainIn, int remainOut) {
        if (remainIn == 0) {
            for (int i = 0; i < remainOut; i++) {
                sb.append(')');
            }
            list.add(sb.toString());
            sb.delete(sb.length() - 1 - remainOut, sb.length() - 1);
        } else {
            nextParenthesis(sb.append('('), remainIn - 1, remainOut);
            sb.deleteCharAt(sb.length() - 1);
            if (remainOut > remainIn) {
                nextParenthesis(sb.append(')'), remainIn, remainOut - 1);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    public static void main(String[] args) {
        new Solution().generateParenthesis(3);
    }
}
// @lc code=end

// Accepted
// 8/8 cases passed (1 ms)
// Your runtime beats 97.95 % of java submissions
// Your memory usage beats 5.26 % of java submissions (39.8 MB)