/*
 * @Author: aponder
 * @Date: 2020-05-14 13:04:31
 * @LastEditors: aponder
 * @LastEditTime: 2020-05-14 13:10:15
 * @FilePath: /leetcode-zh/easy/455.分发饼干/Solution.java
 */
import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=455 lang=java
 *
 * [455] 分发饼干
 *
 * https://leetcode-cn.com/problems/assign-cookies/description/
 *
 * algorithms
 * Easy (53.88%)
 * Likes:    162
 * Dislikes: 0
 * Total Accepted:    36.6K
 * Total Submissions: 67.4K
 * Testcase Example:  '[1,2,3]\n[1,1]'
 *
 * 假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。对每个孩子 i ，都有一个胃口值 gi
 * ，这是能让孩子们满足胃口的饼干的最小尺寸；并且每块饼干 j ，都有一个尺寸 sj 。如果 sj >= gi ，我们可以将这个饼干 j 分配给孩子 i
 * ，这个孩子会得到满足。你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。
 * 
 * 注意：
 * 
 * 你可以假设胃口值为正。
 * 一个小朋友最多只能拥有一块饼干。
 * 
 * 示例 1:
 * 
 * 
 * 输入: [1,2,3], [1,1]
 * 
 * 输出: 1
 * 
 * 解释: 
 * 你有三个孩子和两块小饼干，3个孩子的胃口值分别是：1,2,3。
 * 虽然你有两块小饼干，由于他们的尺寸都是1，你只能让胃口值是1的孩子满足。
 * 所以你应该输出1。
 * 
 * 
 * 示例 2:
 * 
 * 
 * 输入: [1,2], [1,2,3]
 * 
 * 输出: 2
 * 
 * 解释: 
 * 你有两个孩子和三块小饼干，2个孩子的胃口值分别是1,2。
 * 你拥有的饼干数量和尺寸都足以让所有孩子满足。
 * 所以你应该输出2.
 * 
 * 
 */

// @lc code=start
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int lengthG = g.length, lengthS = s.length;
        int count = 0;
        int i = 0, j = 0; // 分别指向 g, s 的下标
        while (i < lengthG && j < lengthS) {
            if (s[j] >= g[i]) {
                count++;
                i++;
                j++;
            } else { // g[i] < s[j]
                j++;
            }
        }

        return count;
    }
}
// @lc code=end

// Accepted
// 21/21 cases passed (8 ms)
// Your runtime beats 96.16 % of java submissions
// Your memory usage beats 9.52 % of java submissions (40.8 MB)