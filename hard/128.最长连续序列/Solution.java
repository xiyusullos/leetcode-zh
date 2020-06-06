/*
 * @Author: aponder
 * @Date: 2020-06-06 14:42:26
 * @LastEditTime: 2020-06-06 14:43:14
 * @LastEditors: aponder
 * @Description: 
 * @FilePath: /leetcode-zh/hard/128.最长连续序列/Solution.java
 */ 
/*
 * @lc app=leetcode.cn id=128 lang=java
 *
 * [128] 最长连续序列
 *
 * https://leetcode-cn.com/problems/longest-consecutive-sequence/description/
 *
 * algorithms
 * Hard (49.09%)
 * Likes:    379
 * Dislikes: 0
 * Total Accepted:    50.3K
 * Total Submissions: 100.6K
 * Testcase Example:  '[100,4,200,1,3,2]'
 *
 * 给定一个未排序的整数数组，找出最长连续序列的长度。
 * 
 * 要求算法的时间复杂度为 O(n)。
 * 
 * 示例:
 * 
 * 输入: [100, 4, 200, 1, 3, 2]
 * 输出: 4
 * 解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
 * 
 */

// @lc code=start
class Solution {
    // public int longestConsecutive(int[] nums) {

    // }

    public int longestConsecutive(int[] nums) {
        Set<Integer> num_set = new HashSet<Integer>();
        for (int num : nums) {
            num_set.add(num);
        }

        int longestStreak = 0;

        for (int num : num_set) {
            if (!num_set.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (num_set.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }
}

// @lc code=end

// Accepted
// 68/68 cases passed (5 ms)
// Your runtime beats 82.55 % of java submissions
// Your memory usage beats 8.33 % of java submissions (39.9 MB)