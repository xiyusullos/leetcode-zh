/*
 * @Author: aponder
 * @Date: 2020-05-27 23:53:59
 * @LastEditTime: 2020-05-28 00:00:44
 * @LastEditors: aponder
 * @Description: 
 * @FilePath: /leetcode-zh/easy/581.最短无序连续子数组/Solution.java
 */ 
import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=581 lang=java
 *
 * [581] 最短无序连续子数组
 *
 * https://leetcode-cn.com/problems/shortest-unsorted-continuous-subarray/description/
 *
 * algorithms
 * Easy (34.39%)
 * Likes:    301
 * Dislikes: 0
 * Total Accepted:    26.9K
 * Total Submissions: 77.7K
 * Testcase Example:  '[2,6,4,8,10,9,15]'
 *
 * 给定一个整数数组，你需要寻找一个连续的子数组，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
 * 
 * 你找到的子数组应是最短的，请输出它的长度。
 * 
 * 示例 1:
 * 
 * 
 * 输入: [2, 6, 4, 8, 10, 9, 15]
 * 输出: 5
 * 解释: 你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
 * 
 * 
 * 说明 :
 * 
 * 
 * 输入的数组长度范围在 [1, 10,000]。
 * 输入的数组可能包含重复元素 ，所以升序的意思是<=。
 * 
 * 
 */

// @lc code=start
class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int[] nums_ = nums.clone();
        Arrays.sort(nums_);
        int l = nums.length;
        int start = 0, end = l - 1;
        for (int i = 0; i < l; i++) {
            if (nums[i] == nums_[i]) start++;
            else break;
        }
        for (int i = l - 1; i > start; i--) {
            if (nums[i] == nums_[i]) end--;
            else break;
        }

        return end - start + 1;
    }
    // public int findUnsortedSubarray(int[] nums) {
    //     int[] snums = nums.clone();
    //     Arrays.sort(snums);
    //     int start = snums.length, end = 0;
    //     for (int i = 0; i < snums.length; i++) {
    //         if (snums[i] != nums[i]) {
    //             start = Math.min(start, i);
    //             end = Math.max(end, i);
    //         }
    //     }
    //     return (end - start >= 0 ? end - start + 1 : 0);
    // }
}
// @lc code=end

// Accepted
// 307/307 cases passed (7 ms)
// Your runtime beats 63.46 % of java submissions
// Your memory usage beats 14.29 % of java submissions (40.9 MB)