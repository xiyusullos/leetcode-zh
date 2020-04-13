/*
 * @Author: aponder
 * @Date: 2020-04-13 10:06:34
 * @LastEditors: aponder
 * @LastEditTime: 2020-04-13 10:38:01
 * @FilePath: /leetcode-zh/easy/121.买卖股票的最佳时机/Solution.java
 */
/*
 * @lc app=leetcode.cn id=121 lang=java
 *
 * [121] 买卖股票的最佳时机
 *
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/description/
 *
 * algorithms
 * Easy (53.81%)
 * Likes:    896
 * Dislikes: 0
 * Total Accepted:    183.1K
 * Total Submissions: 340.1K
 * Testcase Example:  '[7,1,5,3,6,4]'
 *
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
 * 
 * 注意：你不能在买入股票前卖出股票。
 * 
 * 
 * 
 * 示例 1:
 * 
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 * ⁠    注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 * 
 * 
 * 示例 2:
 * 
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 * 
 * 
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        // [3, 10, 2, 10, 1, 6]
        int length = prices.length;
        if (length == 0) {
            return 0;
        }
        // 初始默认第 1 天买入卖出
        int buy = 0, sell = 0;
        int possibleBuy = buy, possibleSell = sell;
        for (int i = 1; i < length; i++) {
            if (prices[i] < prices[possibleBuy]) {
                possibleBuy = i;
                possibleSell = possibleBuy;
            } else if (prices[i] > prices[possibleSell]) {
                possibleSell = i;
                if (prices[possibleSell] - prices[possibleBuy] > prices[sell] - prices[buy]) {
                    buy = possibleBuy;
                    sell = possibleSell;
                }
            }
        }

        return prices[sell] - prices[buy];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxProfit(new int[]{7,1,5,3,6,4}));
    }
}
// @lc code=end

// Accepted
// 200/200 cases passed (1 ms)
// Your runtime beats 99.08 % of java submissions
// Your memory usage beats 5.73 % of java submissions (40 MB)