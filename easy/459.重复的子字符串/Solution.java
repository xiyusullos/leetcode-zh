/*
 * @Author: aponder
 * @Date: 2020-05-14 13:14:59
 * @LastEditors: aponder
 * @LastEditTime: 2020-05-14 13:37:14
 * @FilePath: /leetcode-zh/easy/459.重复的子字符串/Solution.java
 */
import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=459 lang=java
 *
 * [459] 重复的子字符串
 *
 * https://leetcode-cn.com/problems/repeated-substring-pattern/description/
 *
 * algorithms
 * Easy (46.01%)
 * Likes:    205
 * Dislikes: 0
 * Total Accepted:    18.1K
 * Total Submissions: 38.7K
 * Testcase Example:  '"abab"'
 *
 * 给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。
 * 
 * 示例 1:
 * 
 * 
 * 输入: "abab"
 * 
 * 输出: True
 * 
 * 解释: 可由子字符串 "ab" 重复两次构成。
 * 
 * 
 * 示例 2:
 * 
 * 
 * 输入: "aba"
 * 
 * 输出: False
 * 
 * 
 * 示例 3:
 * 
 * 
 * 输入: "abcabcabcabc"
 * 
 * 输出: True
 * 
 * 解释: 可由子字符串 "abc" 重复四次构成。 (或者子字符串 "abcabc" 重复两次构成。)
 * 
 * 
 */

// @lc code=start
class Solution {
    String theS;
    int theLength;
    public boolean repeatedSubstringPattern(String s) {
        theS = s;
        theLength = theS.length();

        int maxCharNum = theLength / 2;
        for (int i = 1; i <= maxCharNum; i++) {
            if (theLength % i != 0) continue;
            if (isComposedBy(i)) return true;
        }

        return false;
    }

    boolean isComposedBy(int charNum) {
        for (int i = 0; i < charNum; i++) {
            for (int j = i + charNum; j < theLength; j += charNum) {
                if (theS.charAt(j) != theS.charAt(i)) return false;
            }
        }
        return true;
    }
}
// @lc code=end

// Accepted
// 120/120 cases passed (11 ms)
// Your runtime beats 91.66 % of java submissions
// Your memory usage beats 14.29 % of java submissions (40.3 MB)