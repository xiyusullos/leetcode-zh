/*
 * @lc app=leetcode.cn id=28 lang=java
 *
 * [28] 实现 strStr()
 *
 * https://leetcode-cn.com/problems/implement-strstr/description/
 *
 * algorithms
 * Easy (39.65%)
 * Likes:    405
 * Dislikes: 0
 * Total Accepted:    149K
 * Total Submissions: 375.9K
 * Testcase Example:  '"hello"\n"ll"'
 *
 * 实现 strStr() 函数。
 * 
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置
 * (从0开始)。如果不存在，则返回  -1。
 * 
 * 示例 1:
 * 
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * 
 * 
 * 示例 2:
 * 
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 * 
 * 
 * 说明:
 * 
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 * 
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 * 
 */

// @lc code=start
class Solution {
    public int strStr(String haystack, String needle) {
        // 当 needle 是空字符串时，返回 0
        if (needle.equals("")) {
            return 0;
        }
        int haystackLength = haystack.length();
        int needleLength = needle.length();
        // needle 比 haystack 要长，直接返回 -1
        if (needleLength > haystackLength) {
            return -1;
        }

        for (int i = 0; i < haystackLength; i++) {
            // needle 比 haystack 剩下的 要长，直接返回 -1
            if (needleLength > haystackLength - i) {
                return -1;
            }
            // int k = -1;  // 下个待比较的位置
            for (int j = 0; j < needleLength; j++) {
                if (haystack.charAt(i + j) == needle.charAt(j)) {
                    if (j == needleLength - 1) {
                        return i;
                    }
                    // if (haystack.charAt(i + k) == needle.charAt(0)) {
                    //     k++;
                    // }
                } else {
                    // todo: 优化
                    // i += Math.max(0, k);
                    break;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        String haystack = "mississippi", needle = "pi";
        System.out.println((new Solution()).strStr(haystack, needle));
    }
}
// @lc code=end

// Accepted
// 74/74 cases passed (2 ms)
// Your runtime beats 56.48 % of java submissions
// Your memory usage beats 5.06 % of java submissions (38.2 MB)