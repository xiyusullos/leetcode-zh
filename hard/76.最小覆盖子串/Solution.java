/*
 * @Author: aponder
 * @Date: 2020-05-23 23:12:47
 * @LastEditTime: 2020-05-23 23:32:57
 * @LastEditors: aponder
 * @Description: 
 * @FilePath: /leetcode-zh/hard/76.最小覆盖子串/Solution.java
 */ 
import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=76 lang=java
 *
 * [76] 最小覆盖子串
 *
 * https://leetcode-cn.com/problems/minimum-window-substring/description/
 *
 * algorithms
 * Hard (35.61%)
 * Likes:    507
 * Dislikes: 0
 * Total Accepted:    44K
 * Total Submissions: 119.8K
 * Testcase Example:  '"ADOBECODEBANC"\n"ABC"'
 *
 * 给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字符的最小子串。
 * 
 * 示例：
 * 
 * 输入: S = "ADOBECODEBANC", T = "ABC"
 * 输出: "BANC"
 * 
 * 说明：
 * 
 * 
 * 如果 S 中不存这样的子串，则返回空字符串 ""。
 * 如果 S 中存在这样的子串，我们保证它是唯一的答案。
 * 
 * 
 */

// @lc code=start
class Solution {
    // public String minWindow(String s, String t) {
    //     Set<Character> set = new HashSet<>(t.length());
    //     for (char c : t.toCharArray()) {
    //         set.add(c);
    //     }

    //     Set<Character> target = new HashSet<>(set.size());
    //     int length = s.length();
    //     int[] indice = new int[length];
    //     int startIndex = 0, endIndex = length - 1;
    //     int a = 0;
    //     int b;

    //     char c;
    //     int idx = 0;
    //     int min = Integer.MAX_VALUE;
    //     for (int i = 0; i < length; i++) {
    //         c = s.charAt(i);
    //         if (set.contains(c)) {
    //             b = i;
    //             indice[idx++] = i;
    //             target.add(c);
    //             if (target.size() == set.size()) {
    //                 if (b - a == t.length()) return s.substring(a, b + 1);
    //             }
    //         }
    //     }
    // }

    Map<Character, Integer> ori = new HashMap<Character, Integer>();
    Map<Character, Integer> cnt = new HashMap<Character, Integer>();

    public String minWindow(String s, String t) {
        int tLen = t.length();
        for (int i = 0; i < tLen; i++) {
            char c = t.charAt(i);
            ori.put(c, ori.getOrDefault(c, 0) + 1);
        }
        int l = 0, r = -1;
        int len = Integer.MAX_VALUE, ansL = -1, ansR = -1;
        int sLen = s.length();
        while (r < sLen) {
            ++r;
            if (r < sLen && ori.containsKey(s.charAt(r))) {
                cnt.put(s.charAt(r), cnt.getOrDefault(s.charAt(r), 0) + 1);
            }
            while (check() && l <= r) {
                if (r - l + 1 < len) {
                    len = r - l + 1;
                    ansL = l;
                    ansR = l + len;
                }
                if (ori.containsKey(s.charAt(l))) {
                    cnt.put(s.charAt(l), cnt.getOrDefault(s.charAt(l), 0) - 1);
                }
                ++l;
            }
        }
        return ansL == -1 ? "" : s.substring(ansL, ansR);
    }

    public boolean check() {
        Iterator iter = ori.entrySet().iterator(); 
        while (iter.hasNext()) { 
            Map.Entry entry = (Map.Entry) iter.next(); 
            Character key = (Character) entry.getKey(); 
            Integer val = (Integer) entry.getValue(); 
            if (cnt.getOrDefault(key, 0) < val) {
                return false;
            }
        } 
        return true;
    }

}
// @lc code=end

// Accepted
// 268/268 cases passed (140 ms)
// Your runtime beats 7.38 % of java submissions
// Your memory usage beats 6.67 % of java submissions (40.7 MB)