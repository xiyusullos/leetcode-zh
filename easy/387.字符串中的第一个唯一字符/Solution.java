/*
 * @Author: aponder
 * @Date: 2020-05-07 09:15:28
 * @LastEditors: aponder
 * @LastEditTime: 2020-05-07 09:22:18
 * @FilePath: /leetcode-zh/easy/387.字符串中的第一个唯一字符/Solution.java
 */
/*
 * @lc app=leetcode.cn id=387 lang=java
 *
 * [387] 字符串中的第一个唯一字符
 *
 * https://leetcode-cn.com/problems/first-unique-character-in-a-string/description/
 *
 * algorithms
 * Easy (44.22%)
 * Likes:    210
 * Dislikes: 0
 * Total Accepted:    75.2K
 * Total Submissions: 167.8K
 * Testcase Example:  '"leetcode"'
 *
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 * 
 * 案例:
 * 
 * 
 * s = "leetcode"
 * 返回 0.
 * 
 * s = "loveleetcode",
 * 返回 2.
 * 
 * 
 * 
 * 
 * 注意事项：您可以假定该字符串只包含小写字母。
 * 
 */

// @lc code=start
class Solution {
    public int firstUniqChar(String s) {
        int[] map = new int[26];
        int length = s.length();
        char c;
        for (int i = 0; i < length; i++) {
            c = s.charAt(i);
            map[c - 'a']++;
        }

        for (int i = 0; i < length; i++) {
            c = s.charAt(i);
            if (map[c - 'a'] == 1) return i;
        }

        return -1;
    }
}
// @lc code=end

// Accepted
// 104/104 cases passed (6 ms)
// Your runtime beats 90.03 % of java submissions
// Your memory usage beats 6.12 % of java submissions (40.6 MB)