/*
 * @Author: aponder
 * @Date: 2020-06-03 23:56:03
 * @LastEditTime: 2020-06-03 23:57:49
 * @LastEditors: aponder
 * @Description: 
 * @FilePath: /leetcode-zh/medium/837.新-21-点/Solution.java
 */ 
/*
 * @lc app=leetcode.cn id=837 lang=java
 *
 * [837] 新21点
 *
 * https://leetcode-cn.com/problems/new-21-game/description/
 *
 * algorithms
 * Medium (40.93%)
 * Likes:    184
 * Dislikes: 0
 * Total Accepted:    13.3K
 * Total Submissions: 32.2K
 * Testcase Example:  '10\n1\n10'
 *
 * 爱丽丝参与一个大致基于纸牌游戏 “21点” 规则的游戏，描述如下：
 * 
 * 爱丽丝以 0 分开始，并在她的得分少于 K 分时抽取数字。 抽取时，她从 [1, W] 的范围中随机获得一个整数作为分数进行累计，其中 W 是整数。
 * 每次抽取都是独立的，其结果具有相同的概率。
 * 
 * 当爱丽丝获得不少于 K 分时，她就停止抽取数字。 爱丽丝的分数不超过 N 的概率是多少？
 * 
 * 示例 1：
 * 
 * 输入：N = 10, K = 1, W = 10
 * 输出：1.00000
 * 说明：爱丽丝得到一张卡，然后停止。
 * 
 * 示例 2：
 * 
 * 输入：N = 6, K = 1, W = 10
 * 输出：0.60000
 * 说明：爱丽丝得到一张卡，然后停止。
 * 在 W = 10 的 6 种可能下，她的得分不超过 N = 6 分。
 * 
 * 示例 3：
 * 
 * 输入：N = 21, K = 17, W = 10
 * 输出：0.73278
 * 
 * 提示：
 * 
 * 
 * 0 <= K <= N <= 10000
 * 1 <= W <= 10000
 * 如果答案与正确答案的误差不超过 10^-5，则该答案将被视为正确答案通过。
 * 此问题的判断限制时间已经减少。
 * 
 * 
 */

// @lc code=start
class Solution {
    // public double new21Game(int N, int K, int W) {
    // }

    public double new21Game(int N, int K, int W) {
        if (K == 0) {
            return 1.0;
        }
        double[] dp = new double[K + W];
        for (int i = K; i <= N && i < K + W; i++) {
            dp[i] = 1.0;
        }
        dp[K - 1] = 1.0 * Math.min(N - K + 1, W) / W;
        for (int i = K - 2; i >= 0; i--) {
            dp[i] = dp[i + 1] - (dp[i + W + 1] - dp[i + 1]) / W;
        }
        return dp[0];
    }
}
// @lc code=end

// Accepted
// 146/146 cases passed (4 ms)
// Your runtime beats 96.23 % of java submissions
// Your memory usage beats 100 % of java submissions (39.5 MB)