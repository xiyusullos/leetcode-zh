/*
 * @lc app=leetcode.cn id=66 lang=java
 *
 * [66] 加一
 *
 * https://leetcode-cn.com/problems/plus-one/description/
 *
 * algorithms
 * Easy (43.62%)
 * Likes:    452
 * Dislikes: 0
 * Total Accepted:    137.5K
 * Total Submissions: 314.6K
 * Testcase Example:  '[1,2,3]'
 *
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * 
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * 
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * 
 * 示例 1:
 * 
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * 
 * 
 * 示例 2:
 * 
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 * 
 * 
 */

// @lc code=start
class Solution {
    public int[] plusOne(int[] digits) {
        int l = digits.length;
        // digits 非空
        // if (l == 0) {
        // return 0;
        // }
        int carry = 1;
        int t;
        for (int i = l - 1; i >= 0; i--) {
            t = digits[i] + carry;
            carry = t / 10;
            digits[i] = t % 10;

            if (carry == 0) {
                break;
            }
        }

        if (carry == 1) {
            int[] newDigits = new int[l + 1];
            newDigits[0] = carry;
            for (int i = 1; i < l + 1; i++) {
                newDigits[i] = digits[i - 1];
            }
            return newDigits;
        }

        return digits;
    }
}
// @lc code=end

// Accepted
// 109/109 cases passed (0 ms)
// Your runtime beats 100 % of java submissions
// Your memory usage beats 5.17 % of java submissions (38.4 MB)