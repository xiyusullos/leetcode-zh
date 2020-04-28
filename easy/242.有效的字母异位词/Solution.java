/*
 * @Author: aponder
 * @Date: 2020-04-28 09:06:35
 * @LastEditors: aponder
 * @LastEditTime: 2020-04-28 09:17:08
 * @FilePath: /leetcode-zh/easy/242.有效的字母异位词/Solution.java
 */
import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=242 lang=java
 *
 * [242] 有效的字母异位词
 *
 * https://leetcode-cn.com/problems/valid-anagram/description/
 *
 * algorithms
 * Easy (59.22%)
 * Likes:    185
 * Dislikes: 0
 * Total Accepted:    94.6K
 * Total Submissions: 158.7K
 * Testcase Example:  '"anagram"\n"nagaram"'
 *
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * 
 * 示例 1:
 * 
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 
 * 
 * 示例 2:
 * 
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 
 * 说明:
 * 你可以假设字符串只包含小写字母。
 * 
 * 进阶:
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 * 
 */

// @lc code=start
class Solution {
    public boolean isAnagram(String s, String t) {
        int lengthS = s.length();
        int lengthT = t.length();
        if (lengthS != lengthT) return false;

        Map<Character, Integer> map = new HashMap<>(lengthS);
        for (int i = 0; i < lengthS; i++) {
            char c = s.charAt(i);
            Integer value = map.get(c);
            if (value == null) map.put(c, 1);
            else map.put(c, value + 1);
        }

        for (int i = 0; i < lengthT; i++) {
            char c = t.charAt(i);
            Integer value = map.get(c);
            if (value == null || value == 0) return false;
            map.put(c, value - 1);
        }

        return true;
    }
}
// @lc code=end

// Accepted
// 34/34 cases passed (18 ms)
// Your runtime beats 20.1 % of java submissions
// Your memory usage beats 5.66 % of java submissions (41.3 MB)