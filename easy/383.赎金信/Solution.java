/*
 * @Author: aponder
 * @Date: 2020-05-06 20:54:57
 * @LastEditors: aponder
 * @LastEditTime: 2020-05-06 21:01:28
 * @FilePath: /leetcode-zh/easy/383.赎金信/Solution.java
 */
import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=383 lang=java
 *
 * [383] 赎金信
 *
 * https://leetcode-cn.com/problems/ransom-note/description/
 *
 * algorithms
 * Easy (52.24%)
 * Likes:    90
 * Dislikes: 0
 * Total Accepted:    21.5K
 * Total Submissions: 40.6K
 * Testcase Example:  '"a"\n"b"'
 *
 * 给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，判断第一个字符串 ransom 能不能由第二个字符串 magazines
 * 里面的字符构成。如果可以构成，返回 true ；否则返回 false。
 * 
 * (题目说明：为了不暴露赎金信字迹，要从杂志上搜索各个需要的字母，组成单词来表达意思。杂志字符串中的每个字符只能在赎金信字符串中使用一次。)
 * 
 * 
 * 
 * 注意：
 * 
 * 你可以假设两个字符串均只含有小写字母。
 * 
 * canConstruct("a", "b") -> false
 * canConstruct("aa", "ab") -> false
 * canConstruct("aa", "aab") -> true
 * 
 * 
 */

// @lc code=start
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : magazine.toCharArray()) {
            map.put(c, 1 + map.getOrDefault(c, 0));
        }
        
        Integer count = null;
        for (char c : ransomNote.toCharArray()) {
            count = map.get(c);
            if (count == null || count == 0) return false;
            else {
                map.put(c, count - 1);
            }
        }

        return true;
    }
}
// @lc code=end

// Accepted
// 126/126 cases passed (19 ms)
// Your runtime beats 27.71 % of java submissions
// Your memory usage beats 8.33 % of java submissions (40.4 MB)