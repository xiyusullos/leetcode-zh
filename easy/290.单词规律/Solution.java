
/*
 * @Author: aponder
 * @Date: 2020-05-01 10:52:08
 * @LastEditors: aponder
 * @LastEditTime: 2020-05-01 11:11:33
 * @FilePath: /leetcode-zh/easy/290.单词规律/Solution.java
 */
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=290 lang=java
 *
 * [290] 单词规律
 *
 * https://leetcode-cn.com/problems/word-pattern/description/
 *
 * algorithms
 * Easy (42.40%)
 * Likes:    146
 * Dislikes: 0
 * Total Accepted:    22.5K
 * Total Submissions: 53.1K
 * Testcase Example:  '"abba"\n"dog cat cat dog"'
 *
 * 给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。
 * 
 * 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。
 * 
 * 示例1:
 * 
 * 输入: pattern = "abba", str = "dog cat cat dog"
 * 输出: true
 * 
 * 示例 2:
 * 
 * 输入:pattern = "abba", str = "dog cat cat fish"
 * 输出: false
 * 
 * 示例 3:
 * 
 * 输入: pattern = "aaaa", str = "dog cat cat dog"
 * 输出: false
 * 
 * 示例 4:
 * 
 * 输入: pattern = "abba", str = "dog dog dog dog"
 * 输出: false
 * 
 * 说明:
 * 你可以假设 pattern 只包含小写字母， str 包含了由单个空格分隔的小写字母。    
 * 
 */

// @lc code=start
class Solution {
    public boolean wordPattern(String pattern, String str) {
        Map<Character, String> map1 = new HashMap<>();
        Set<String> set = new HashSet();
        int length = pattern.length();
        char[] cs = pattern.toCharArray();
        String[] words = str.split(" ");
        if (length != words.length)
            return false;

        String word = null;
        for (int i = 0; i < length; i++) {
            word = map1.get(cs[i]);
            if (word == null) {
                if (set.contains(words[i])) return false;
                map1.put(cs[i], words[i]);
                set.add(words[i]);
            } else if (!word.equals(words[i])) {    
                return false;
            }
        }
        return true;
    }
}
// @lc code=end

// Accepted
// 37/37 cases passed (1 ms)
// Your runtime beats 96.84 % of java submissions
// Your memory usage beats 10 % of java submissions (38.1 MB)