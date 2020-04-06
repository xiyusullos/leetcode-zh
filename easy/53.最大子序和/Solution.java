/*
 * @lc app=leetcode.cn id=53 lang=java
 *
 * [53] 最大子序和
 *
 * https://leetcode-cn.com/problems/maximum-subarray/description/
 *
 * algorithms
 * Easy (49.97%)
 * Likes:    1784
 * Dislikes: 0
 * Total Accepted:    195.1K
 * Total Submissions: 390.2K
 * Testcase Example:  '[-2,1,-3,4,-1,2,1,-5,4]'
 *
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 
 * 示例:
 * 
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 
 * 
 * 进阶:
 * 
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 * 
 */

// @lc code=start
class Solution {
    public int maxSubArray(int[] nums) {
        // N + 1
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }
        int i = 0;
        int sum = nums[0], possibleSum = nums[0];
        int currentNum; // 当前的数
        for (i = 1; i < length; i++) {
            currentNum = nums[i];
            possibleSum += currentNum;
            if (possibleSum > sum && possibleSum > currentNum) {
                // possibleSum 最大
                sum = possibleSum;
            } else if (currentNum >= possibleSum) {
                if (currentNum >= sum) {
                    // currentNum 最大
                    sum = currentNum;
                }
                possibleSum = currentNum;
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        int[] nums;
        // nums = new int[] { 8, -19, 5, -4, 20 };
        nums = new int[] { 0, 3, -1 };

        System.out.println((new Solution()).maxSubArray(nums));
    }
}
// @lc code=end

// Accepted
// 202/202 cases passed (1 ms)
// Your runtime beats 97.14 % of java submissions
// Your memory usage beats 18.41 % of java submissions (39.6 MB)