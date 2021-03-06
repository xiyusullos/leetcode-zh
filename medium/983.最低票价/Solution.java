/*
 * @Author: aponder
 * @Date: 2020-05-06 21:14:19
 * @LastEditors: aponder
 * @LastEditTime: 2020-05-06 21:49:41
 * @FilePath: /leetcode-zh/medium/983.最低票价/Solution.java
 */
/*
 * @lc app=leetcode.cn id=983 lang=java
 *
 * [983] 最低票价
 *
 * https://leetcode-cn.com/problems/minimum-cost-for-tickets/description/
 *
 * algorithms
 * Medium (56.40%)
 * Likes:    180
 * Dislikes: 0
 * Total Accepted:    16.3K
 * Total Submissions: 26.2K
 * Testcase Example:  '[1,4,6,7,8,20]\n[2,7,15]'
 *
 * 在一个火车旅行很受欢迎的国度，你提前一年计划了一些火车旅行。在接下来的一年里，你要旅行的日子将以一个名为 days 的数组给出。每一项是一个从 1 到
 * 365 的整数。
 * 
 * 火车票有三种不同的销售方式：
 * 
 * 
 * 一张为期一天的通行证售价为 costs[0] 美元；
 * 一张为期七天的通行证售价为 costs[1] 美元；
 * 一张为期三十天的通行证售价为 costs[2] 美元。
 * 
 * 
 * 通行证允许数天无限制的旅行。 例如，如果我们在第 2 天获得一张为期 7 天的通行证，那么我们可以连着旅行 7 天：第 2 天、第 3 天、第 4
 * 天、第 5 天、第 6 天、第 7 天和第 8 天。
 * 
 * 返回你想要完成在给定的列表 days 中列出的每一天的旅行所需要的最低消费。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：days = [1,4,6,7,8,20], costs = [2,7,15]
 * 输出：11
 * 解释： 
 * 例如，这里有一种购买通行证的方法，可以让你完成你的旅行计划：
 * 在第 1 天，你花了 costs[0] = $2 买了一张为期 1 天的通行证，它将在第 1 天生效。
 * 在第 3 天，你花了 costs[1] = $7 买了一张为期 7 天的通行证，它将在第 3, 4, ..., 9 天生效。
 * 在第 20 天，你花了 costs[0] = $2 买了一张为期 1 天的通行证，它将在第 20 天生效。
 * 你总共花了 $11，并完成了你计划的每一天旅行。
 * 
 * 
 * 示例 2：
 * 
 * 输入：days = [1,2,3,4,5,6,7,8,9,10,30,31], costs = [2,7,15]
 * 输出：17
 * 解释：
 * 例如，这里有一种购买通行证的方法，可以让你完成你的旅行计划： 
 * 在第 1 天，你花了 costs[2] = $15 买了一张为期 30 天的通行证，它将在第 1, 2, ..., 30 天生效。
 * 在第 31 天，你花了 costs[0] = $2 买了一张为期 1 天的通行证，它将在第 31 天生效。 
 * 你总共花了 $17，并完成了你计划的每一天旅行。
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= days.length <= 365
 * 1 <= days[i] <= 365
 * days 按顺序严格递增
 * costs.length == 3
 * 1 <= costs[i] <= 1000
 * 
 * 
 */

// @lc code=start
class Solution {
    int[] costs;
    int[] memo = new int[366];
    int[] theDays = new int[366];

    public int mincostTickets(int[] days, int[] costs) {
        this.costs = costs;

        for (int d : days) theDays[d] = 1;
        return dp(1);
    }

    public int dp(int i) {
        if (i > 365) return 0;
        
        // 已经计算过了
        if (memo[i] != 0) return memo[i];
        
        if (theDays[i] == 1) {
            int c1 = dp(i + 1) + costs[0];
            int c7 = dp(i + 7) + costs[1];
            int c30 = dp(i + 30) + costs[2];

            memo[i] = Math.min(Math.min(c1, c7), c30);
        } else {
            memo[i] = dp(i + 1);
        }
        return memo[i];
    }

    public static void main(String[] args) {
        int[] days = new int[]{1,4,6,7,8,20};
        int[] costs = new int[]{2,7,15};
        new Solution().mincostTickets(days, costs);
    }
}
// @lc code=end

// Accepted
// 66/66 cases passed (3 ms)
// Your runtime beats 28.42 % of java submissions
// Your memory usage beats 100 % of java submissions (37.7 MB)