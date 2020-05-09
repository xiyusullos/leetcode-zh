/*
 * @Author: aponder
 * @Date: 2020-05-09 10:42:05
 * @LastEditors: aponder
 * @LastEditTime: 2020-05-09 10:59:17
 * @FilePath: /leetcode-zh/easy/405.数字转换为十六进制数/Solution.java
 */
/*
 * @lc app=leetcode.cn id=405 lang=java
 *
 * [405] 数字转换为十六进制数
 *
 * https://leetcode-cn.com/problems/convert-a-number-to-hexadecimal/description/
 *
 * algorithms
 * Easy (49.91%)
 * Likes:    68
 * Dislikes: 0
 * Total Accepted:    10.8K
 * Total Submissions: 21.4K
 * Testcase Example:  '26'
 *
 * 给定一个整数，编写一个算法将这个数转换为十六进制数。对于负整数，我们通常使用 补码运算 方法。
 * 
 * 注意:
 * 
 * 
 * 十六进制中所有字母(a-f)都必须是小写。
 * 
 * 十六进制字符串中不能包含多余的前导零。如果要转化的数为0，那么以单个字符'0'来表示；对于其他情况，十六进制字符串中的第一个字符将不会是0字符。 
 * 给定的数确保在32位有符号整数范围内。
 * 不能使用任何由库提供的将数字直接转换或格式化为十六进制的方法。
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入:
 * 26
 * 
 * 输出:
 * "1a"
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入:
 * -1
 * 
 * 输出:
 * "ffffffff"
 * 
 * 
 */

// @lc code=start
class Solution {
    public String toHex(int num) {
        char[] map = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
        if (num == 0) return "0";
        
        StringBuilder sb = new StringBuilder();
        if (num > 0) {
            while (num != 0) {
                sb.append(map[num % 16]);
                num /= 16;
            }
        } else {
            int bits = 8;
            num++;
            while (num != 0) {
                bits--;
                // num 是负数，取余后还是负数，所以这里 +
                sb.append(map[15 + num % 16]);
                num /= 16;
            }

            while (bits-- > 0) {
                sb.append('f');
            }
        }
        
        return sb.reverse().toString();
    }
}
// @lc code=end

// Accepted
// 100/100 cases passed (0 ms)
// Your runtime beats 100 % of java submissions
// Your memory usage beats 10 % of java submissions (37.1 MB)