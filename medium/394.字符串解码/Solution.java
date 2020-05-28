/*
 * @Author: aponder
 * @Date: 2020-05-28 23:04:09
 * @LastEditTime: 2020-05-28 23:55:51
 * @LastEditors: aponder
 * @Description: 
 * @FilePath: /leetcode-zh/medium/394.字符串解码/Solution.java
 */ 
import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=394 lang=java
 *
 * [394] 字符串解码
 *
 * https://leetcode-cn.com/problems/decode-string/description/
 *
 * algorithms
 * Medium (49.54%)
 * Likes:    347
 * Dislikes: 0
 * Total Accepted:    41.9K
 * Total Submissions: 80K
 * Testcase Example:  '"3[a]2[bc]"'
 *
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 * 
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 * 
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 * 
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 * 
 * 示例:
 * 
 * 
 * s = "3[a]2[bc]", 返回 "aaabcbc".
 * s = "3[a2[c]]", 返回 "accaccacc".
 * s = "2[abc]3[cd]ef", 返回 "abcabccdcdcdef".
 * 
 * 
 */

// @lc code=start
class Solution {
    Map<String, String> note = new HashMap<>();
    String encodedString;
    int length;
    int idx = 0;
    public String decodeString(String s) {
        encodedString = s;
        length = s.length();

        return decode().toString();
    }

    StringBuilder decode() {
        StringBuilder result = new StringBuilder();
        
        if (idx == length) return result;
        char c = encodedString.charAt(idx);
        if (c == ']') return result;

        
        char first = encodedString.charAt(idx);
        int k = 1;
        if ('0' <= first && first <= '9') {
            // 获取数值k
            k = 0;
            for (; idx < length; idx++) {
                c = encodedString.charAt(idx);
                if ('0' <= c && c <= '9') {
                    k = k * 10 + (c - '0');
                } else {
                    break;
                }
            }
            
            // 跳过左括号
            idx++;
            StringBuilder sb = decode();
            // 跳过右括号
            idx++;

            // 拼接字符串
            // Todo: 4->2->1, 可优化
            while (k > 0) {
                result.append(sb);
                k--;
            }
        } else if (Character.isLetter(first)) {

        // } else {
            result.append(encodedString.charAt(idx++));
        }

        return result.append(decode());
    }
}
// @lc code=end

// Accepted
// 29/29 cases passed (0 ms)
// Your runtime beats 100 % of java submissions
// Your memory usage beats 7.69 % of java submissions (37.6 MB)