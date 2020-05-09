/*
 * @Author: aponder
 * @Date: 2020-05-09 11:06:07
 * @LastEditors: aponder
 * @LastEditTime: 2020-05-09 11:28:58
 * @FilePath: /leetcode-zh/easy/409.最长回文串/Solution.java
 */
/*
 * @lc app=leetcode.cn id=409 lang=java
 *
 * [409] 最长回文串
 *
 * https://leetcode-cn.com/problems/longest-palindrome/description/
 *
 * algorithms
 * Easy (54.95%)
 * Likes:    178
 * Dislikes: 0
 * Total Accepted:    47.7K
 * Total Submissions: 86.7K
 * Testcase Example:  '"abccccdd"'
 *
 * 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
 * 
 * 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
 * 
 * 注意:
 * 假设字符串的长度不会超过 1010。
 * 
 * 示例 1: 
 * 
 * 
 * 输入:
 * "abccccdd"
 * 
 * 输出:
 * 7
 * 
 * 解释:
 * 我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
 * 
 * 
 */

// @lc code=start
class Solution {
    public int longestPalindrome(String s) {
        // 大写字母和小写字母
        int[] counter = new int[52];
        int odd = 0, even = 0;
        int i;
        for (char c : s.toCharArray()) {
            i = toIndex(c);
            if (counter[i] % 2 == 0) {
                // 原来是偶数个，现在是奇数个
                odd++;
                // 不需要对 even--
                // if (counter[i] > 0) even--;
            } else { 
                even++;
                if (counter[i] > 0) odd--;
            }
            counter[i]++;
        }
        // System.out.println(even + ", " + odd);
        return 2 * even + Math.min(1, odd);
    }

    int toIndex(char c) {
        if ('a' <= c && c <= 'z') return c - 'a';
        else return 26 + (c - 'A');
    }
}
// @lc code=end

// Accepted
// 95/95 cases passed (3 ms)
// Your runtime beats 52.05 % of java submissions
// Your memory usage beats 5 % of java submissions (37.1 MB)