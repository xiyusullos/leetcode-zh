/*
 * @Author: aponder
 * @Date: 2020-06-03 23:29:26
 * @LastEditTime: 2020-06-03 23:43:25
 * @LastEditors: aponder
 * @Description: 
 * @FilePath: /leetcode-zh/easy/682.棒球比赛/Solution.java
 */ 
import java.util.Stack;

/*
 * @lc app=leetcode.cn id=682 lang=java
 *
 * [682] 棒球比赛
 *
 * https://leetcode-cn.com/problems/baseball-game/description/
 *
 * algorithms
 * Easy (66.43%)
 * Likes:    125
 * Dislikes: 0
 * Total Accepted:    21.6K
 * Total Submissions: 32.4K
 * Testcase Example:  '["5","2","C","D","+"]'
 *
 * 你现在是棒球比赛记录员。
 * 给定一个字符串列表，每个字符串可以是以下四种类型之一：
 * 1.整数（一轮的得分）：直接表示您在本轮中获得的积分数。
 * 2. "+"（一轮的得分）：表示本轮获得的得分是前两轮有效 回合得分的总和。
 * 3. "D"（一轮的得分）：表示本轮获得的得分是前一轮有效 回合得分的两倍。
 * 4. "C"（一个操作，这不是一个回合的分数）：表示您获得的最后一个有效 回合的分数是无效的，应该被移除。
 * 
 * 每一轮的操作都是永久性的，可能会对前一轮和后一轮产生影响。
 * 你需要返回你在所有回合中得分的总和。
 * 
 * 示例 1:
 * 
 * 输入: ["5","2","C","D","+"]
 * 输出: 30
 * 解释: 
 * 第1轮：你可以得到5分。总和是：5。
 * 第2轮：你可以得到2分。总和是：7。
 * 操作1：第2轮的数据无效。总和是：5。
 * 第3轮：你可以得到10分（第2轮的数据已被删除）。总数是：15。
 * 第4轮：你可以得到5 + 10 = 15分。总数是：30。
 * 
 * 
 * 示例 2:
 * 
 * 输入: ["5","-2","4","C","D","9","+","+"]
 * 输出: 27
 * 解释: 
 * 第1轮：你可以得到5分。总和是：5。
 * 第2轮：你可以得到-2分。总数是：3。
 * 第3轮：你可以得到4分。总和是：7。
 * 操作1：第3轮的数据无效。总数是：3。
 * 第4轮：你可以得到-4分（第三轮的数据已被删除）。总和是：-1。
 * 第5轮：你可以得到9分。总数是：8。
 * 第6轮：你可以得到-4 + 9 = 5分。总数是13。
 * 第7轮：你可以得到9 + 5 = 14分。总数是27。
 * 
 * 
 * 注意：
 * 
 * 
 * 输入列表的大小将介于1和1000之间。
 * 列表中的每个整数都将介于-30000和30000之间。
 * 
 * 
 */

// @lc code=start
class Solution {
    public int calPoints(String[] ops) {
        int point = 0;
        Stack<Integer> stack = new Stack();
        for (String op : ops) {
            if (op.equals("C")) {
                int n = stack.pop();
                point -= n;
            } else if (op.equals("+")) {
                int n1 = stack.pop();
                int n2 = stack.peek();
                stack.push(n1);
                int n = n1 + n2;
                stack.push(n);
                point += n;
            } else if (op.equals("D")) {
                int n1 = stack.peek();
                int n = 2 * n1;
                stack.push(n);
                point += n;
            } else {
                int n = Integer.parseInt(op);
                point += n;
                stack.push(n);
            }
        }
        return point;
    }
}
// @lc code=end

// Accepted
// 39/39 cases passed (3 ms)
// Your runtime beats 84.84 % of java submissions
// Your memory usage beats 25 % of java submissions (39.3 MB)