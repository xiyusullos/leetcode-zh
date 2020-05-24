/*
 * @Author: aponder
 * @Date: 2020-05-24 21:35:48
 * @LastEditTime: 2020-05-24 21:43:45
 * @LastEditors: aponder
 * @Description: 
 * @FilePath: /leetcode-zh/easy/551.学生出勤记录-i/Solution.java
 */ 
/*
 * @lc app=leetcode.cn id=551 lang=java
 *
 * [551] 学生出勤记录 I
 *
 * https://leetcode-cn.com/problems/student-attendance-record-i/description/
 *
 * algorithms
 * Easy (51.03%)
 * Likes:    39
 * Dislikes: 0
 * Total Accepted:    14.6K
 * Total Submissions: 28.4K
 * Testcase Example:  '"PPALLP"'
 *
 * 给定一个字符串来代表一个学生的出勤记录，这个记录仅包含以下三个字符：
 * 
 * 
 * 'A' : Absent，缺勤
 * 'L' : Late，迟到
 * 'P' : Present，到场
 * 
 * 
 * 如果一个学生的出勤记录中不超过一个'A'(缺勤)并且不超过两个连续的'L'(迟到),那么这个学生会被奖赏。
 * 
 * 你需要根据这个学生的出勤记录判断他是否会被奖赏。
 * 
 * 示例 1:
 * 
 * 输入: "PPALLP"
 * 输出: True
 * 
 * 
 * 示例 2:
 * 
 * 输入: "PPALLL"
 * 输出: False
 * 
 * 
 */

// @lc code=start
class Solution {
    public boolean checkRecord(String s) {
        int chanceA = 1;
        int chanceL = 2;
        for (char c : s.toCharArray()) {
            if (c == 'A') {
                if (chanceA == 0) return false;
                chanceA--;;
                chanceL = 2;
            }
            else if (c == 'L') {
                if (chanceL == 0) return false;
                chanceL--;
            } else {
                chanceL = 2;
            }
        }

        return true;
    }
}
// @lc code=end

// Accepted
// 113/113 cases passed (1 ms)
// Your runtime beats 59.75 % of java submissions
// Your memory usage beats 7.69 % of java submissions (37.4 MB)