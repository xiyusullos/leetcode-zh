/*
 * @Author: aponder
 * @Date: 2020-06-01 23:32:27
 * @LastEditTime: 2020-06-01 23:55:08
 * @LastEditors: aponder
 * @Description: 
 * @FilePath: /leetcode-zh/easy/665.非递减数列/Solution.java
 */
/*
 * @lc app=leetcode.cn id=665 lang=java
 *
 * [665] 非递减数列
 *
 * https://leetcode-cn.com/problems/non-decreasing-array/description/
 *
 * algorithms
 * Easy (22.08%)
 * Likes:    266
 * Dislikes: 0
 * Total Accepted:    19.2K
 * Total Submissions: 86.4K
 * Testcase Example:  '[4,2,3]'
 *
 * 给你一个长度为 n 的整数数组，请你判断在 最多 改变 1 个元素的情况下，该数组能否变成一个非递减数列。
 * 
 * 我们是这样定义一个非递减数列的： 对于数组中所有的 i (0 <= i <= n-2)，总满足 nums[i] <= nums[i + 1]。
 * 
 * 
 * 
 * 示例 1:
 * 
 * 输入: nums = [4,2,3]
 * 输出: true
 * 解释: 你可以通过把第一个4变成1来使得它成为一个非递减数列。
 * 
 * 
 * 示例 2:
 * 
 * 输入: nums = [4,2,1]
 * 输出: false
 * 解释: 你不能在只改变一个元素的情况下将其变为非递减数列。
 * 
 * 
 * 
 * 
 * 说明：
 * 
 * 
 * 1 <= n <= 10 ^ 4
 * - 10 ^ 5 <= nums[i] <= 10 ^ 5
 * 
 * 
 */

// @lc code=start
class Solution {
    int l;
    public boolean checkPossibility(int[] nums) {
        l = nums.length;
        if (l <= 2)
            return true;
        
        int count = 0;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i] > nums[i+1]){
                count++;
                if(count > 1){
                    break;
                }
                if(i-1 >=0&&nums[i-1] > nums[i+1]){
                    nums[i+1] = nums[i];
                }else{
                    nums[i] = nums[i+1];
                }
            }
        }
        return count <= 1;
    }

    // boolean enlarge(int[] nums) {
    //     int countChange = 0;
    //     int prev = nums[0];
    //     for (int i = 1; i < l; i++) {
    //         if (prev > nums[i]) {
    //             countChange++;
    //             if (countChange > 1)
    //                 return false;
    //         } else {
    //             prev = nums[i];
    //         }
    //     }

    //     return true;
    // }

    // boolean reduce(int[] nums) {
    //     int countChange = 0;
    //     int prev = nums[0];
    //     for (int i = 1; i < l; i++) {
    //         if (prev > nums[i]) {
    //             countChange++;
    //             if (countChange > 1)
    //                 return false;
    //         }
    //         prev = nums[i];
    //     }

    //     return true;
    // }
}
// @lc code=end

// Accepted
// 325/325 cases passed (1 ms)
// Your runtime beats 99.89 % of java submissions
// Your memory usage beats 16.67 % of java submissions (41.2 MB)