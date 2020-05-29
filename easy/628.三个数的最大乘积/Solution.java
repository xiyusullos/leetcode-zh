/*
 * @Author: aponder
 * @Date: 2020-05-29 23:48:22
 * @LastEditTime: 2020-05-29 23:52:42
 * @LastEditors: aponder
 * @Description: 
 * @FilePath: /leetcode-zh/easy/628.三个数的最大乘积/Solution.java
 */ 
import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=628 lang=java
 *
 * [628] 三个数的最大乘积
 *
 * https://leetcode-cn.com/problems/maximum-product-of-three-numbers/description/
 *
 * algorithms
 * Easy (49.56%)
 * Likes:    128
 * Dislikes: 0
 * Total Accepted:    19.9K
 * Total Submissions: 39.8K
 * Testcase Example:  '[1,2,3]'
 *
 * 给定一个整型数组，在数组中找出由三个数组成的最大乘积，并输出这个乘积。
 * 
 * 示例 1:
 * 
 * 
 * 输入: [1,2,3]
 * 输出: 6
 * 
 * 
 * 示例 2:
 * 
 * 
 * 输入: [1,2,3,4]
 * 输出: 24
 * 
 * 
 * 注意:
 * 
 * 
 * 给定的整型数组长度范围是[3,10^4]，数组中所有的元素范围是[-1000, 1000]。
 * 输入的数组中任意三个数的乘积不会超出32位有符号整数的范围。
 * 
 * 
 */

// @lc code=start
class Solution {
    // public int maximumProduct(int[] nums) {
    //     Arrays.sort(nums);
    //     int l = nums.length;

    //     int r1 = nums[0] * nums[1] * nums[l - 1];
    //     int r2 = nums[l-3] * nums[l-2] * nums[l-1];
    //     int r3 = nums[1] * nums[]

    // }

    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        return Math.max(nums[0] * nums[1] * nums[nums.length - 1], nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3]);
    }
}
// @lc code=end

// Accepted
// 83/83 cases passed (12 ms)
// Your runtime beats 70.78 % of java submissions
// Your memory usage beats 7.69 % of java submissions (41.8 MB)