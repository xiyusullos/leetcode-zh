/*
 * @Author: aponder
 * @Date: 2020-05-06 20:43:45
 * @LastEditors: aponder
 * @LastEditTime: 2020-05-06 20:52:50
 * @FilePath: /leetcode-zh/easy/374.猜数字大小/Solution.java
 */
/*
 * @lc app=leetcode.cn id=374 lang=java
 *
 * [374] 猜数字大小
 *
 * https://leetcode-cn.com/problems/guess-number-higher-or-lower/description/
 *
 * algorithms
 * Easy (43.53%)
 * Likes:    58
 * Dislikes: 0
 * Total Accepted:    21.7K
 * Total Submissions: 49.5K
 * Testcase Example:  '10\n6'
 *
 * 我们正在玩一个猜数字游戏。 游戏规则如下：
 * 我从 1 到 n 选择一个数字。 你需要猜我选择了哪个数字。
 * 每次你猜错了，我会告诉你这个数字是大了还是小了。
 * 你调用一个预先定义好的接口 guess(int num)，它会返回 3 个可能的结果（-1，1 或 0）：
 * 
 * -1 : 我的数字比较小
 * ⁠1 : 我的数字比较大
 * ⁠0 : 恭喜！你猜对了！
 * 
 * 
 * 
 * 
 * 示例 :
 * 
 * 输入: n = 10, pick = 6
 * 输出: 6
 * 
 */

// @lc code=start
/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is lower than the guess number
 *			      1 if num is higher than the guess number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int l = 0, r = n;
        int m = l + (r - l) / 2;
        while (l <= r) {
            m = l + (r - l) / 2;
            int result = guess(m);
            // System.out.println("guess: " + m + ", result: " + result);
            if (result == 0) return m;
            else if (result > 0) l = m + 1;
            else r = m - 1;
        }
        return m;
    }
}
// @lc code=end

// Accepted
// 25/25 cases passed (0 ms)
// Your runtime beats 100 % of java submissions
// Your memory usage beats 10 % of java submissions (35.8 MB)