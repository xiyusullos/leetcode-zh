/*
 * @lc app=leetcode.cn id=69 lang=java
 *
 * [69] x 的平方根
 *
 * https://leetcode-cn.com/problems/sqrtx/description/
 *
 * algorithms
 * Easy (37.63%)
 * Likes:    341
 * Dislikes: 0
 * Total Accepted:    112.1K
 * Total Submissions: 297.8K
 * Testcase Example:  '4'
 *
 * 实现 int sqrt(int x) 函数。
 * 
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * 
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 * 
 * 示例 1:
 * 
 * 输入: 4
 * 输出: 2
 * 
 * 
 * 示例 2:
 * 
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842..., 
 * 由于返回类型是整数，小数部分将被舍去。
 * 
 * 
 */

// @lc code=start
class Solution {
    public int mySqrt(int x) {
        // x >= 0
        if (x == 0 || x == 1) {
            return x;
        }

        int min = 0, max = x / 2 + 1;  // 1^2 == 1
        int a, b;
        int i = (min + max) / 2;
        while (min < max) {
            a = x / i;
            b = x / (i + 1);
            // 数字较大
            if (a < i && b < i + 1) {
                // 太大
                max = i - 1;
                // d = a - b;
            } else if (a > i && b >= i + 1) {
                // 太小
                min = i + 1;
                // d = a - b;
            } else if (a == i || (a == i + 1 && b == i)) {
                return i;
            } else {
                // 数字较小
                a = i * i;
                b = (i + 1) * (i + 1);
                if (a <= x && x < b) {
                    // 刚好
                    return i;
                } else if (b <= x) {
                    // 太小
                    min = i + 1;
                    // i = (i + max + 1) / 2;
                } else {
                    // 太大
                    max = i - 1;
                    // i = (i + min) / 2;
                }
            }
            i = (min + max) / 2;
        }
        return i;
    }

    public static void main(String[] args) {
        System.out.println((new Solution()).mySqrt(8));
    }
}
// @lc code=end

// Accepted
// 1017/1017 cases passed (2 ms)
// Your runtime beats 75.27 % of java submissions
// Your memory usage beats 5.06 % of java submissions (37.2 MB)