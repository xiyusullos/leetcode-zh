/*
 * @Author: aponder
 * @Date: 2020-04-14 19:57:36
 * @LastEditors: aponder
 * @LastEditTime: 2020-04-14 21:40:30
 * @FilePath: /leetcode-zh/easy/125.验证回文串/Solution.java
 */
/*
 * @lc app=leetcode.cn id=125 lang=java
 *
 * [125] 验证回文串
 *
 * https://leetcode-cn.com/problems/valid-palindrome/description/
 *
 * algorithms
 * Easy (43.16%)
 * Likes:    178
 * Dislikes: 0
 * Total Accepted:    94.9K
 * Total Submissions: 219.4K
 * Testcase Example:  '"A man, a plan, a canal: Panama"'
 *
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * 
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 * 
 * 示例 1:
 * 
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 
 * 
 * 示例 2:
 * 
 * 输入: "race a car"
 * 输出: false
 * 
 * 
 */

// @lc code=start
class Solution {
    // 方法 1
    // public boolean isPalindrome(String s) {
    //     String str = "";
    //     int d = 'a' - 'A';
    //     for (char c : s.toCharArray()) {
    //         if ('0'<= c && c <= '9') {
    //             str += c;
    //         } else if ('A'<= c && c <= 'Z') {
    //             str += (char) (c + d);
    //         } else if ('a' <= c && c <= 'z') {
    //             str += c;
    //         }
    //     }
    //     // System.out.println(str);

    //     int l = str.length();
    //     for (int i = 0; i < l / 2; i++) {
    //         if (str.charAt(i) != str.charAt(l - i - 1)) {
    //             return false;
    //         }
    //     }

    //     return true;
    // }

    public boolean isPalindrome(String s) {
        int l = s.length();
        if (l <= 1) {
            return true;
        }

        int i = 0, j = l - 1;
        int r1, r2;
        int d = 'a' - 'A';
        char a, b;
        while (i < j) {
            // 找到下一个字母或数字
            r1 = isNumericAndAlphabetic(s.charAt(i));
            while (r1 == 0) {
                i++;
                if (i >= j) {return true;}
                r1 = isNumericAndAlphabetic(s.charAt(i));
            }
            r2 = isNumericAndAlphabetic(s.charAt(j));
            while (r2 == 0) {
                j--;
                if (i >= j) {return true;}
                r2 = isNumericAndAlphabetic(s.charAt(j));
            }
            
            a = s.charAt(i);
            b = s.charAt(j);
            // 相同：都是数字，都是大写字母，都是小写字母
            if (a == b) {
                i++; j--;
            } else if (r1 == 2 && r2 == 3 && a + d == b) { // a 大写，b 小写
                i++; j--;
            } else if (r1 == 3 && r2 == 2 && a == b + d) { // a 小写，b 大写
                i++; j--;
            } else {
                return false;
            }
        }

        return true;
    }
    
    int isNumericAndAlphabetic(char c) {
        if ('0' <= c && c <= '9') {return 1;}
        if ('A' <= c && c <= 'Z') {return 2;}
        if ('a' <= c && c <= 'z') {return 3;}
        return 0;
    }
}
// @lc code=end

// 方法 1
// Accepted
// 476/476 cases passed (335 ms)
// Your runtime beats 5 % of java submissions
// Your memory usage beats 7.14 % of java submissions (40.9 MB)

// 方法 2
// Accepted
// 476/476 cases passed (2 ms)
// Your runtime beats 99.88 % of java submissions
// Your memory usage beats 7.14 % of java submissions (39.7 MB)