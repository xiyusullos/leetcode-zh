/*
 * @Author: aponder
 * @Date: 2020-04-10 12:07:41
 * @LastEditors: aponder
 * @LastEditTime: 2020-05-21 11:02:36
 * @FilePath: /leetcode-zh/medium/5.最长回文子串/Solution.java
 */
/*
 * @lc app=leetcode.cn id=5 lang=java
 *
 * [5] 最长回文子串
 *
 * https://leetcode-cn.com/problems/longest-palindromic-substring/description/
 *
 * algorithms
 * Medium (29.22%)
 * Likes:    1987
 * Dislikes: 0
 * Total Accepted:    228.9K
 * Total Submissions: 781.5K
 * Testcase Example:  '"babad"'
 *
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * 
 * 示例 1：
 * 
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 
 * 
 * 示例 2：
 * 
 * 输入: "cbbd"
 * 输出: "bb"
 * 
 * 
 */

// @lc code=start
class Solution {
    boolean dp[][];
    int length;
    public String longestPalindrome(String s) {
        // P(i,j) = P(i+1,j−1) ∧ (Si==Sj)
        // P(i,i) = true, P(i,i+1) = Si==S i+1
        length = s.length();
        if (length == 0) return "";
        
        int max = 0;
        int possibleMax;
        int[] result = new int[2];
        int[] possibleResult = new int[2];
        for (int i = 0; i < length; i++) {
            possibleResult = longestPalindrome(s, i);
            possibleMax = possibleResult[1] - possibleResult[0];
            if (possibleMax > max) {
                max = possibleMax;
                result = possibleResult;
            }
        }

        return s.substring(result[0], 1 + result[1]);
    }

    int[] longestPalindrome(String s, int center) {
        // StringBuilder sb = new StringBuilder();
        int i,j;
        int i1 = center, j1 = center;
        i = i1; j = j1;
        while (--i > -1 && ++j < length) {
            if (s.charAt(i) != s.charAt(j)) break;
            else i1 = i; j1 = j;
        }

        int i2 = center, j2 = center + 1;
        i = i2; j = j2;
        if (i > -1 && j < length && s.charAt(i) == s.charAt(j)) {
            while (--i > -1 && ++j < length) {
                if (s.charAt(i) != s.charAt(j)) break;
                else i2 = i; j2 = j;
            }
        } else {
            j2--;
        }

        int[] result = new int[2];
        if (j1 - i1 > j2 - i2) {
            result[0] = i1;
            result[1] = j1;
        } else {
            result[0] = i2;
            result[1] = j2;
        }
        return result;
    }

    public static void main(String[] args) {
        new Solution().longestPalindrome("cbbd");
    }


    // public String longestPalindrome(String s) {
    //     int l = s.length();
    //     int i, j;
    //     if (l % 2 == 0) {
    //         i = l / 2;
    //         j = i + 1;
    //     } else {
    //         i = j = l / 2;

    //     }
    // }


    /* Time Limit Exceeded */
    // public String longestPalindrome(String s) {
    //     int l = s.length();
    //     if (l <= 1) {
    //         return s;
    //     }

    //     String result = "" + s.charAt(0);
    //     int max = 1;
    //     String substring;
    //     for (int i = 0; i < l - 1; i++) {
    //         for (int j = i + 1; j < l; j++) {
    //             substring = s.substring(i, j + 1);
    //             if (isPalindrome(substring)) {
    //                 if (j - i + 1 > max) {
    //                     max = j - i + 1;
    //                     result = substring;
    //                 }
    //             }
    //         }
    //     }

    //     return result;
    // }

    // boolean isPalindrome(String s) {
    //     int l = s.length();
    //     for (int i = 0; i < l / 2; i++) {
    //         if (s.charAt(i) != s.charAt(l - 1 - i)) {
    //             return false;
    //         }
    //     }
    //     return true;
    // }
}
// @lc code=end

// Accepted
// 103/103 cases passed (27 ms)
// Your runtime beats 86.04 % of java submissions
// Your memory usage beats 15.18 % of java submissions (39.6 MB)