/*
 * @Author: aponder
 * @Date: 2020-05-14 12:27:32
 * @LastEditors: aponder
 * @LastEditTime: 2020-05-14 12:48:33
 * @FilePath: /leetcode-zh/easy/453.最小移动次数使数组元素相等/Solution.java
 */
import java.util.Arrays;
import java.util.Collections;

/*
 * @lc app=leetcode.cn id=453 lang=java
 *
 * [453] 最小移动次数使数组元素相等
 *
 * https://leetcode-cn.com/problems/minimum-moves-to-equal-array-elements/description/
 *
 * algorithms
 * Easy (53.49%)
 * Likes:    111
 * Dislikes: 0
 * Total Accepted:    10.5K
 * Total Submissions: 19.5K
 * Testcase Example:  '[1,2,3]'
 *
 * 给定一个长度为 n 的非空整数数组，找到让数组所有元素相等的最小移动次数。每次移动将会使 n - 1 个元素增加 1。
 * 
 * 
 * 
 * 示例:
 * 
 * 输入:
 * [1,2,3]
 * 
 * 输出:
 * 3
 * 
 * 解释:
 * 只需要3次移动（注意每次移动会增加两个元素的值）：
 * 
 * [1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
 * 
 * 
 */

// @lc code=start
class Solution {
    public int minMoves(int[] nums) {
        Arrays.sort(nums);

        int length = nums.length;
        int count = 0;
        int minI = 0, maxI = length - 1;
        for (int i = length - 1; i >= 1; i--) {
            count += nums[i] - nums[minI];
        }

        return count;
    }
}
// @lc code=end

// Accepted
// 84/84 cases passed (14 ms)
// Your runtime beats 29.5 % of java submissions
// Your memory usage beats 66.67 % of java submissions (40.3 MB)