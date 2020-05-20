/*
 * @lc app=leetcode.cn id=1371 lang=java
 *
 * [1371] 每个元音包含偶数次的最长子字符串
 *
 * https://leetcode-cn.com/problems/find-the-longest-substring-containing-vowels-in-even-counts/description/
 *
 * algorithms
 * Medium (41.90%)
 * Likes:    87
 * Dislikes: 0
 * Total Accepted:    3.8K
 * Total Submissions: 7.1K
 * Testcase Example:  '"eleetminicoworoep"'
 *
 * 给你一个字符串 s ，请你返回满足以下条件的最长子字符串的长度：每个元音字母，即 'a'，'e'，'i'，'o'，'u'
 * ，在子字符串中都恰好出现了偶数次。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：s = "eleetminicoworoep"
 * 输出：13
 * 解释：最长子字符串是 "leetminicowor" ，它包含 e，i，o 各 2 个，以及 0 个 a，u 。
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：s = "leetcodeisgreat"
 * 输出：5
 * 解释：最长子字符串是 "leetc" ，其中包含 2 个 e 。
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：s = "bcbcbc"
 * 输出：6
 * 解释：这个示例中，字符串 "bcbcbc" 本身就是最长的，因为所有的元音 a，e，i，o，u 都出现了 0 次。
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= s.length <= 5 x 10^5
 * s 只包含小写英文字母。
 * 
 * 
 */

// @lc code=start
class Solution {
    public int findTheLongestSubstring(String s) {
        int length = s.length();
        // 前m项个元音字母的次数
        int[][] m = new int[length + 1][5];
        m[0] = new int[5];
        int i = 1;
        for (char c : s.toCharArray()) {
            for (int j = 0; j < 5; j++) {
                m[i][j] = m[i-1][j];
            }
            if (c == 'a') m[i][0]++;
            else if (c == 'e') m[i][1]++;
            else if (c == 'i') m[i][2]++;
            else if (c == 'o') m[i][3]++;
            else if (c == 'u') m[i][4]++;
            i++;
        }

        // for (int j = 0; j <= length; j++) {
        //     System.out.println(j + ": " + "a=" + m[j][0]
        //         + ", e=" + m[j][1]
        //         + ", i=" + m[j][2]
        //         + ", o=" + m[j][3]
        //         + ", u=" + m[j][4]
        //     );
        // }

        int l = length;
        while (l >= 1) {
            for (int j = 0; j + l <= length; j++) {   
                // 元音字母次数全为偶数
                boolean is_valid = true;
                for (int k = 0; k < 5; k++) {
                    if ((m[j + l][k] - m[j][k]) % 2 !=0) {
                        is_valid = false;
                        break;
                    }
                }
                if (is_valid) return l;
            }
            l--;
        }

        return 0;
    }
}
// @lc code=end

// Accepted
// 53/53 cases passed (84 ms)
// Your runtime beats 27.39 % of java submissions
// Your memory usage beats 100 % of java submissions (75.1 MB)