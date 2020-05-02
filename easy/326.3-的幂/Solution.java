/*
 * @Author: aponder
 * @Date: 2020-05-02 12:15:12
 * @LastEditors: aponder
 * @LastEditTime: 2020-05-02 12:33:51
 * @FilePath: /leetcode-zh/easy/326.3-的幂/Solution.java
 */
/*
 * @lc app=leetcode.cn id=326 lang=java
 *
 * [326] 3的幂
 *
 * https://leetcode-cn.com/problems/power-of-three/description/
 *
 * algorithms
 * Easy (46.73%)
 * Likes:    102
 * Dislikes: 0
 * Total Accepted:    43.9K
 * Total Submissions: 93.8K
 * Testcase Example:  '27'
 *
 * 给定一个整数，写一个函数来判断它是否是 3 的幂次方。
 * 
 * 示例 1:
 * 
 * 输入: 27
 * 输出: true
 * 
 * 
 * 示例 2:
 * 
 * 输入: 0
 * 输出: false
 * 
 * 示例 3:
 * 
 * 输入: 9
 * 输出: true
 * 
 * 示例 4:
 * 
 * 输入: 45
 * 输出: false
 * 
 * 进阶：
 * 你能不使用循环或者递归来完成本题吗？
 * 
 */

// @lc code=start
class Solution {
    // 方法 1
    // public boolean isPowerOfThree(int n) {
    //     if (n <= 0) return false;
    //     while (n > 1) {
    //         int t = n / 3;
    //         if (t * 3 != n) return false;
    //         n = t;
    //     }
    //     return true;
    // }

    // 方法 2
    public boolean isPowerOfThree(int n) {
        // if (n == 1 || n == 3 || n == 9 || n == 27 || n == 81 || n == 243 || n == 729 || n == 2187 || n == 6561 || n == 19683 || n == 59049 || n == 177147 || n == 531441 || n == 1594323 || n == 4782969 || n == 14348907 || n == 43046721 || n == 129140163 || n == 387420489 || n == 1162261467) {
        //     return true;
        // } else {
        //     return false;
        // }

        if (n < 1) return false;
        else if (n == 1) return true;
        else if (n < 3) return false;
        else if (n == 3) return true;
        else if (n < 9) return false;
        else if (n == 9) return true;
        else if (n < 27) return false;
        else if (n == 27) return true;
        else if (n < 81) return false;
        else if (n == 81) return true;
        else if (n < 243) return false;
        else if (n == 243) return true;
        else if (n < 729) return false;
        else if (n == 729) return true;
        else if (n < 2187) return false;
        else if (n == 2187) return true;
        else if (n < 6561) return false;
        else if (n == 6561) return true;
        else if (n < 19683) return false;
        else if (n == 19683) return true;
        else if (n < 59049) return false;
        else if (n == 59049) return true;
        else if (n < 177147) return false;
        else if (n == 177147) return true;
        else if (n < 531441) return false;
        else if (n == 531441) return true;
        else if (n < 1594323) return false;
        else if (n == 1594323) return true;
        else if (n < 4782969) return false;
        else if (n == 4782969) return true;
        else if (n < 14348907) return false;
        else if (n == 14348907) return true;
        else if (n < 43046721) return false;
        else if (n == 43046721) return true;
        else if (n < 129140163) return false;
        else if (n == 129140163) return true;
        else if (n < 387420489) return false;
        else if (n == 387420489) return true;
        else if (n < 1162261467) return false;
        else if (n == 1162261467) return true;
        else return false;
    }
}
// @lc code=end

// 方法 1
// Accepted
// 21038/21038 cases passed (14 ms)
// Your runtime beats 99.9 % of java submissions
// Your memory usage beats 8.7 % of java submissions (39.1 MB)

// 方法 2
// Accepted
// 21038/21038 cases passed (15 ms)
// Your runtime beats 95.21 % of java submissions
// Your memory usage beats 8.7 % of java submissions (39.7 MB)