/*
 * @Author: aponder
 * @Date: 2020-04-17 11:02:16
 * @LastEditors: aponder
 * @LastEditTime: 2020-04-17 11:26:40
 * @FilePath: /leetcode-zh/easy/168.excel表列名称/Solution.java
 */
/*
 * @lc app=leetcode.cn id=168 lang=java
 *
 * [168] Excel表列名称
 *
 * https://leetcode-cn.com/problems/excel-sheet-column-title/description/
 *
 * algorithms
 * Easy (37.24%)
 * Likes:    210
 * Dislikes: 0
 * Total Accepted:    23.8K
 * Total Submissions: 63.8K
 * Testcase Example:  '1'
 *
 * 给定一个正整数，返回它在 Excel 表中相对应的列名称。
 * 
 * 例如，
 * 
 * ⁠   1 -> A
 * ⁠   2 -> B
 * ⁠   3 -> C
 * ⁠   ...
 * ⁠   26 -> Z
 * ⁠   27 -> AA
 * ⁠   28 -> AB 
 * ⁠   ...
 * 
 * 
 * 示例 1:
 * 
 * 输入: 1
 * 输出: "A"
 * 
 * 
 * 示例 2:
 * 
 * 输入: 28
 * 输出: "AB"
 * 
 * 
 * 示例 3:
 * 
 * 输入: 701
 * 输出: "ZY"
 * 
 * 
 */

// @lc code=start
class Solution {
    // 26 进制转换 (StringBuilder 效率比 String 高)
    public String convertToTitle(int n) {
        if (n <= 0) return "";
        StringBuilder sb = new StringBuilder();
        // String r = "";
        do {
            sb.insert(0, (char) ('A' + (n - 1) % 26));
            // r = (char) ('A' + (n - 1) % 26) + r;
            n = (n - 1) / 26 ;
        } while (n > 0);
        
        return sb.toString();
        // return r;
    }
}
// @lc code=end

// String
// Accepted
// 18/18 cases passed (9 ms)
// Your runtime beats 12.16 % of java submissions
// Your memory usage beats 14.29 % of java submissions (37.5 MB)

// StringBuilder
// Accepted
// 18/18 cases passed (0 ms)
// Your runtime beats 100 % of java submissions
// Your memory usage beats 14.29 % of java submissions (37 MB)