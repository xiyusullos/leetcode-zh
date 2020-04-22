/*
 * @Author: aponder
 * @Date: 2020-04-22 21:51:04
 * @LastEditors: aponder
 * @LastEditTime: 2020-04-22 22:56:51
 * @FilePath: /leetcode-zh/easy/205.同构字符串/Solution.java
 */
import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=205 lang=java
 *
 * [205] 同构字符串
 *
 * https://leetcode-cn.com/problems/isomorphic-strings/description/
 *
 * algorithms
 * Easy (47.24%)
 * Likes:    187
 * Dislikes: 0
 * Total Accepted:    35.1K
 * Total Submissions: 74.2K
 * Testcase Example:  '"egg"\n"add"'
 *
 * 给定两个字符串 s 和 t，判断它们是否是同构的。
 * 
 * 如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。
 * 
 * 所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。
 * 
 * 示例 1:
 * 
 * 输入: s = "egg", t = "add"
 * 输出: true
 * 
 * 
 * 示例 2:
 * 
 * 输入: s = "foo", t = "bar"
 * 输出: false
 * 
 * 示例 3:
 * 
 * 输入: s = "paper", t = "title"
 * 输出: true
 * 
 * 说明:
 * 你可以假设 s 和 t 具有相同的长度。
 * 
 */

// @lc code=start
class Solution {
    public boolean isIsomorphic(String s, String t) {
        int ls = s.length(), lt = t.length();
        if (ls != lt) return false;

        Map<Character, Character> map1 = new HashMap<>();
        Map<Character, Character> map2 = new HashMap<>();
        for (int i = 0; i < ls; i++) {
            char a = s.charAt(i);
            char b = t.charAt(i);
            if (!map1.containsKey(a)) {
                map1.put(a, b);
            } else {
                if (b != map1.get(a)) {
                    return false;
                }
            }
            if (!map2.containsKey(b)) {
                map2.put(b, a);
            } else {
                if (a != map2.get(b)) {
                    return false;
                }
            }
        }
        return true;
    }
}
// @lc code=end

// Accepted
// 32/32 cases passed (20 ms)
// Your runtime beats 21.27 % of java submissions
// Your memory usage beats 5.88 % of java submissions (40.1 MB)