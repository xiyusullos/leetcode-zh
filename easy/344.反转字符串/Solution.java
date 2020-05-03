/*
 * @Author: aponder
 * @Date: 2020-05-03 10:16:59
 * @LastEditors: aponder
 * @LastEditTime: 2020-05-03 10:19:33
 * @FilePath: /leetcode-zh/easy/344.反转字符串/Solution.java
 */
/*
 * @lc app=leetcode.cn id=344 lang=java
 *
 * [344] 反转字符串
 *
 * https://leetcode-cn.com/problems/reverse-string/description/
 *
 * algorithms
 * Easy (69.72%)
 * Likes:    238
 * Dislikes: 0
 * Total Accepted:    135K
 * Total Submissions: 192.6K
 * Testcase Example:  '["h","e","l","l","o"]'
 *
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
 * 
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 * 
 * 你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：["h","e","l","l","o"]
 * 输出：["o","l","l","e","h"]
 * 
 * 
 * 示例 2：
 * 
 * 输入：["H","a","n","n","a","h"]
 * 输出：["h","a","n","n","a","H"]
 * 
 */

// @lc code=start
class Solution {
    public void reverseString(char[] s) {
        int length = s.length;
        int n = length / 2;
        char temp;
        for (int i = 0; i < n; i++) {
            temp = s[i];
            s[i] = s[length - 1 - i];
            s[length - 1 - i] = temp;
        }
    }
}
// @lc code=end

// Accepted
// 478/478 cases passed (1 ms)
// Your runtime beats 99.96 % of java submissions
// Your memory usage beats 92.73 % of java submissions (46.6 MB)