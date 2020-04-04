/*
 * @lc app=leetcode.cn id=67 lang=java
 *
 * [67] 二进制求和
 *
 * https://leetcode-cn.com/problems/add-binary/description/
 *
 * algorithms
 * Easy (52.31%)
 * Likes:    333
 * Dislikes: 0
 * Total Accepted:    73.5K
 * Total Submissions: 140.4K
 * Testcase Example:  '"11"\n"1"'
 *
 * 给定两个二进制字符串，返回他们的和（用二进制表示）。
 * 
 * 输入为非空字符串且只包含数字 1 和 0。
 * 
 * 示例 1:
 * 
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 
 * 示例 2:
 * 
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 * 
 */

// @lc code=start
class Solution {
    public String addBinary(String a, String b) {
        int base = 2;
        int la = a.length(), lb = b.length();
        int l;
        if (la >= lb) {
            l = la;
            b = repeatZero(la - lb) + b;
        } else {
            l = lb;
            a = repeatZero(lb - la) + a;
        }
        int t;
        int carry = 0;
        String result = "";
        for (int i = l - 1; i >= 0; i--) {
            t = (a.charAt(i) - '0') + (b.charAt(i) - '0') + carry;
            carry = t / base;
            result = "" + (t % 2) + result;
        }

        if (carry == 1) {
            result = "1" + result;
        }

        return result;
    }

    String repeatZero(int k) {
        String r = "";
        for (int i = 0; i < k; i++) {
            r += "0";
        }

        return r;
    }
}
// @lc code=end

// Accepted
// 294/294 cases passed (8 ms)
// Your runtime beats 12.02 % of java submissions
// Your memory usage beats 5.11 % of java submissions (40 MB)