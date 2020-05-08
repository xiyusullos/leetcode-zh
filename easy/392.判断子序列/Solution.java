/*
 * @Author: aponder
 * @Date: 2020-05-08 10:52:45
 * @LastEditors: aponder
 * @LastEditTime: 2020-05-08 11:03:58
 * @FilePath: /leetcode-zh/easy/392.判断子序列/Solution.java
 */
/*
 * @lc app=leetcode.cn id=392 lang=java
 *
 * [392] 判断子序列
 *
 * https://leetcode-cn.com/problems/is-subsequence/description/
 *
 * algorithms
 * Easy (48.62%)
 * Likes:    167
 * Dislikes: 0
 * Total Accepted:    37.7K
 * Total Submissions: 77K
 * Testcase Example:  '"abc"\n"ahbgdc"'
 *
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 * 
 * 你可以认为 s 和 t 中仅包含英文小写字母。字符串 t 可能会很长（长度 ~= 500,000），而 s 是个短字符串（长度 <=100）。
 * 
 * 
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 * 
 * 示例 1:
 * s = "abc", t = "ahbgdc"
 * 
 * 返回 true.
 * 
 * 示例 2:
 * s = "axc", t = "ahbgdc"
 * 
 * 返回 false.
 * 
 * 后续挑战 :
 * 
 * 如果有大量输入的 S，称作S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T
 * 的子序列。在这种情况下，你会怎样改变代码？
 * 
 * 致谢:
 * 
 * 特别感谢 @pbrother 添加此问题并且创建所有测试用例。
 * 
 */

// @lc code=start
class Solution {
    // 方法 1
    // public boolean isSubsequence(String s, String t) {
    //     int ls = s.length(), lt = t.length();
    //     if (ls == 0) return true;
    //     if (ls > lt) return false;

    //     int j = 0;
    //     for (int i = 0; i < lt; i++) {
    //         if (s.charAt(j) == t.charAt(i)) j++;
    //         if (j == ls) return true;
    //     }

    //     return false;
    // }

    public boolean isSubsequence(String s, String t) {
        int index = -1;
        for (char c : s.toCharArray()) {
            index = t.indexOf(c, index + 1);
            if (index == -1) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end

// 方法 1
// Accepted
// 14/14 cases passed (9 ms)
// Your runtime beats 55.38 % of java submissions
// Your memory usage beats 100 % of java submissions (43.1 MB)

// 方法 2
// Accepted
// 14/14 cases passed (1 ms)
// Your runtime beats 96.31 % of java submissions
// Your memory usage beats 100 % of java submissions (43 MB)