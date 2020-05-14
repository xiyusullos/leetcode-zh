/*
 * @Author: aponder
 * @Date: 2020-05-14 12:27:32
 * @LastEditors: aponder
 * @LastEditTime: 2020-05-14 12:36:21
 * @FilePath: /leetcode-zh/easy/453.最小移动次数使数组元素相等/Solution.java
 */
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
        int length = nums.length;
        int count = 0;
        int maxI = 0, minI = 0;
        int delta = 0;
        do {
            for (int i = 0; i < length; i++) {
                if (nums[i] > nums[maxI]) maxI = i;
                if (nums[i] < nums[minI]) minI = i;
            }
            delta = nums[maxI] - nums[minI];
            count += delta;
            for (int i = 0; i < length; i++) {
                if (i != maxI) nums[i] += delta;
            }
        } while (delta != 0);

        return count;
    }
}
// @lc code=end

