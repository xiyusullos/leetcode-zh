/*
 * @Author: aponder
 * @Date: 2020-05-25 22:30:42
 * @LastEditTime: 2020-05-25 22:32:09
 * @LastEditors: aponder
 * @Description: 
 * @FilePath: /leetcode-zh/easy/561.数组拆分-i/Solution.java
 */ 
import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=561 lang=java
 *
 * [561] 数组拆分 I
 *
 * https://leetcode-cn.com/problems/array-partition-i/description/
 *
 * algorithms
 * Easy (70.22%)
 * Likes:    163
 * Dislikes: 0
 * Total Accepted:    37.4K
 * Total Submissions: 52.8K
 * Testcase Example:  '[1,4,3,2]'
 *
 * 给定长度为 2n 的数组, 你的任务是将这些数分成 n 对, 例如 (a1, b1), (a2, b2), ..., (an, bn) ，使得从1 到
 * n 的 min(ai, bi) 总和最大。
 * 
 * 示例 1:
 * 
 * 
 * 输入: [1,4,3,2]
 * 
 * 输出: 4
 * 解释: n 等于 2, 最大总和为 4 = min(1, 2) + min(3, 4).
 * 
 * 
 * 提示:
 * 
 * 
 * n 是正整数,范围在 [1, 10000].
 * 数组中的元素范围在 [-10000, 10000].
 * 
 * 
 */

// @lc code=start
class Solution {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i++];
        }
        return sum;
    }
}
// @lc code=end

// Accepted
// 81/81 cases passed (14 ms)
// Your runtime beats 46.54 % of java submissions
// Your memory usage beats 8.33 % of java submissions (41.9 MB)