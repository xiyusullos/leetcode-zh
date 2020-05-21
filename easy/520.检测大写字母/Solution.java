/*
 * @Author: aponder
 * @Date: 2020-05-21 09:25:56
 * @LastEditTime: 2020-05-21 09:34:57
 * @LastEditors: aponder
 * @Description: 
 * @FilePath: /leetcode-zh/easy/520.检测大写字母/Solution.java
 */ 
/*
 * @lc app=leetcode.cn id=520 lang=java
 *
 * [520] 检测大写字母
 *
 * https://leetcode-cn.com/problems/detect-capital/description/
 *
 * algorithms
 * Easy (55.03%)
 * Likes:    87
 * Dislikes: 0
 * Total Accepted:    20.3K
 * Total Submissions: 36.7K
 * Testcase Example:  '"USA"'
 *
 * 给定一个单词，你需要判断单词的大写使用是否正确。
 * 
 * 我们定义，在以下情况时，单词的大写用法是正确的：
 * 
 * 
 * 全部字母都是大写，比如"USA"。
 * 单词中所有字母都不是大写，比如"leetcode"。
 * 如果单词不只含有一个字母，只有首字母大写， 比如 "Google"。
 * 
 * 
 * 否则，我们定义这个单词没有正确使用大写字母。
 * 
 * 示例 1:
 * 
 * 
 * 输入: "USA"
 * 输出: True
 * 
 * 
 * 示例 2:
 * 
 * 
 * 输入: "FlaG"
 * 输出: False
 * 
 * 
 * 注意: 输入是由大写和小写拉丁字母组成的非空单词。
 * 
 */

// @lc code=start
class Solution {
    public boolean detectCapitalUse(String word) {
        int length = word.length();
        if (length <= 1) return true;

        char c = word.charAt(0);
        boolean isFirstCapital = 'A' <= c && c <= 'Z';
        c = word.charAt(1);
        boolean isPreviousCapital = 'A' <= c && c <= 'Z';
        boolean isCurrentCapital;
        for (int i = 2; i < length; i++) {
            c = word.charAt(i);
            isCurrentCapital = 'A' <= c && c <= 'Z';
            if (isPreviousCapital != isCurrentCapital) {
                return false;
            }
        }

        return isFirstCapital || isFirstCapital == isPreviousCapital;
    }
}
// @lc code=end

// Accepted
// 550/550 cases passed (1 ms)
// Your runtime beats 100 % of java submissions
// Your memory usage beats 25 % of java submissions (37.9 MB)