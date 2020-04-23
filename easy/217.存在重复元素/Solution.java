/*
 * @Author: aponder
 * @Date: 2020-04-23 12:42:14
 * @LastEditors: aponder
 * @LastEditTime: 2020-04-23 12:45:10
 * @FilePath: /leetcode-zh/easy/217.存在重复元素/Solution.java
 */
import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=217 lang=java
 *
 * [217] 存在重复元素
 *
 * https://leetcode-cn.com/problems/contains-duplicate/description/
 *
 * algorithms
 * Easy (51.97%)
 * Likes:    236
 * Dislikes: 0
 * Total Accepted:    128.3K
 * Total Submissions: 246.3K
 * Testcase Example:  '[1,2,3,1]'
 *
 * 给定一个整数数组，判断是否存在重复元素。
 * 
 * 如果任意一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
 * 
 * 
 * 
 * 示例 1:
 * 
 * 输入: [1,2,3,1]
 * 输出: true
 * 
 * 示例 2:
 * 
 * 输入: [1,2,3,4]
 * 输出: false
 * 
 * 示例 3:
 * 
 * 输入: [1,1,1,3,3,4,3,2,4,2]
 * 输出: true
 * 
 */

// @lc code=start
class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
        }
        return nums.length != set.size();
    }
}
// @lc code=end

// Accepted
// 18/18 cases passed (7 ms)
// Your runtime beats 72.58 % of java submissions
// Your memory usage beats 6.98 % of java submissions (47.4 MB)