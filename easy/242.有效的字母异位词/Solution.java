/*
 * @Author: aponder
 * @Date: 2020-04-28 09:06:35
 * @LastEditors: aponder
 * @LastEditTime: 2020-04-28 09:26:08
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
    // 方法 1
    // public boolean isAnagram(String s, String t) {
    //     int lengthS = s.length();
    //     int lengthT = t.length();
    //     if (lengthS != lengthT) return false;

    //     Map<Character, Integer> map = new HashMap<>(lengthS);
    //     for (int i = 0; i < lengthS; i++) {
    //         char c = s.charAt(i);
    //         Integer value = map.get(c);
    //         if (value == null) map.put(c, 1);
    //         else map.put(c, value + 1);
    //     }

    //     for (int i = 0; i < lengthT; i++) {
    //         char c = t.charAt(i);
    //         Integer value = map.get(c);
    //         if (value == null || value == 0) return false;
    //         map.put(c, value - 1);
    //     }

    //     return true;
    // }

    // 方法 2
    public boolean isAnagram(String s, String t) {
        int ls = s.length(), lt = t.length();
        if (ls != lt) return false;
        
        // 26 个英文字母
        int[] counter = new int[26];
        for (int i = 0; i < ls; i++) {
            counter[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < lt; i++) {
            if (counter[t.charAt(i) - 'a']-- == 0) return false;
        }

        return true;
    }
}
// @lc code=end

// 方法 1
// Accepted
// 34/34 cases passed (15 ms)
// Your runtime beats 22.62 % of java submissions
// Your memory usage beats 5.66 % of java submissions (40.8 MB)

// 方法 2
// Accepted
// 34/34 cases passed (3 ms)
// Your runtime beats 91.09 % of java submissions
// Your memory usage beats 5.66 % of java submissions (40.1 MB)