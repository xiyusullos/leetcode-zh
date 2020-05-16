/*
 * @Author: aponder
 * @Date: 2020-05-16 19:40:21
 * @LastEditors: aponder
 * @LastEditTime: 2020-05-16 20:35:15
 * @FilePath: /leetcode-zh/easy/482.密钥格式化/Solution.java
 */
/*
 * @lc app=leetcode.cn id=482 lang=java
 *
 * [482] 密钥格式化
 *
 * https://leetcode-cn.com/problems/license-key-formatting/description/
 *
 * algorithms
 * Easy (38.90%)
 * Likes:    41
 * Dislikes: 0
 * Total Accepted:    8.3K
 * Total Submissions: 21.3K
 * Testcase Example:  '"5F3Z-2e-9-w"\n4'
 *
 * 有一个密钥字符串 S ，只包含字母，数字以及 '-'（破折号）。其中， N 个 '-' 将字符串分成了 N+1 组。
 * 
 * 给你一个数字 K，请你重新格式化字符串，除了第一个分组以外，每个分组要包含 K 个字符；而第一个分组中，至少要包含 1 个字符。两个分组之间需要用
 * '-'（破折号）隔开，并且将所有的小写字母转换为大写字母。
 * 
 * 给定非空字符串 S 和数字 K，按照上面描述的规则进行格式化。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：S = "5F3Z-2e-9-w", K = 4
 * 输出："5F3Z-2E9W"
 * 解释：字符串 S 被分成了两个部分，每部分 4 个字符；
 * 注意，两个额外的破折号需要删掉。
 * 
 * 
 * 示例 2：
 * 
 * 输入：S = "2-5g-3-J", K = 2
 * 输出："2-5G-3J"
 * 解释：字符串 S 被分成了 3 个部分，按照前面的规则描述，第一部分的字符可以少于给定的数量，其余部分皆为 2 个字符。
 * 
 * 
 * 
 * 
 * 提示:
 * 
 * 
 * S 的长度可能很长，请按需分配大小。K 为正整数。
 * S 只包含字母数字（a-z，A-Z，0-9）以及破折号'-'
 * S 非空
 * 
 * 
 * 
 * 
 */

// @lc code=start
class Solution {
    public String licenseKeyFormatting(String S, int K) {
        StringBuilder sb = new StringBuilder();
        int length = S.length();
        int n = 0;
        for (char c : S.toCharArray()) {
            if (c != '-') n++;
        }
        int numGroup = (n - 1) / K + 1;
        // int numDash = Math.min(length - n, numGroup - 1);
        int numDash = numGroup - 1;
        int numGroup1 = n - K * numDash;

        int i = 0;
        int j = 0;
        char tempC;
        for (; j < numGroup1; i++) {
            tempC = S.charAt(i);
            if (tempC != '-') {
                if ('a' <= tempC && tempC <= 'z') tempC -= 32;
                sb.append(tempC);
                j++;
            }
        }

        j = 0;
        for (; i < length; i++) {
            tempC = S.charAt(i);
            if (tempC != '-') {
                if (j % K == 0) sb.append('-');
                j++;
                if ('a' <= tempC && tempC <= 'z') tempC -= 32;
                sb.append(tempC);
            }
        }
        
        return sb.toString();
    }
}
// @lc code=end

// Accepted
// 38/38 cases passed (6 ms)
// Your runtime beats 96.65 % of java submissions
// Your memory usage beats 12.5 % of java submissions (39.8 MB)