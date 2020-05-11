/*
 * @Author: aponder
 * @Date: 2020-05-11 10:48:27
 * @LastEditors: aponder
 * @LastEditTime: 2020-05-11 11:17:46
 * @FilePath: /leetcode-zh/easy/415.字符串相加/Solution.java
 */
/*
 * @lc app=leetcode.cn id=415 lang=java
 *
 * [415] 字符串相加
 *
 * https://leetcode-cn.com/problems/add-strings/description/
 *
 * algorithms
 * Easy (49.69%)
 * Likes:    158
 * Dislikes: 0
 * Total Accepted:    32.6K
 * Total Submissions: 65.4K
 * Testcase Example:  '"0"\n"0"'
 *
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
 * 
 * 注意：
 * 
 * 
 * num1 和num2 的长度都小于 5100.
 * num1 和num2 都只包含数字 0-9.
 * num1 和num2 都不包含任何前导零。
 * 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式。
 * 
 * 
 */

// @lc code=start
class Solution {
    public String addStrings(String num1, String num2) {
        int length1 = num1.length(), length2 = num2.length();
        // 让 num1 更大，且 l 为最大的长度
        int l1, l2;
        String tempString;
        if (length1 > length2) {
            l1 = length1;
            l2 = length2;
        } else {
            l1 = length2;
            l2 = length1;
            tempString = num1;
            num1 = num2;
            num2 = tempString;
        }

        int carry = 0;
        int t;
        StringBuilder result = new StringBuilder();
        int i = 0;
        for (; i < l2; i++) {
            t = (num1.charAt(l1 - 1 - i) - '0') + (num2.charAt(l2 - 1 - i) - '0') + carry;
            carry = t / 10;
            result.append(t % 10);
        }

        for (; i < l1; i++) {
            t = (num1.charAt(l1 - 1 - i) - '0') + carry;
            carry = t / 10;
            result.append(t % 10);
        }

        if (carry == 1) result.append(carry);

        return result.reverse().toString();
    }

    public static void main(String[] args) {
        String s1, s2;
        // s1 = "9"; s2 = "99";
        s1 = "98"; s2 = "9";
        System.out.println(new Solution().addStrings(s1, s2));
    }
}
// @lc code=end

// Accepted
// 315/315 cases passed (3 ms)
// Your runtime beats 81.97 % of java submissions
// Your memory usage beats 8.33 % of java submissions (39.7 MB)

// Accepted
// 315/315 cases passed (2 ms)
// Your runtime beats 99.6 % of java submissions
// Your memory usage beats 8.33 % of java submissions (39.5 MB)