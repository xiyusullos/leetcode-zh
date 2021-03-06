/*
 * @Author: aponder
 * @Date: 2020-06-04 21:16:31
 * @LastEditTime: 2020-06-04 21:23:11
 * @LastEditors: aponder
 * @Description: 
 * @FilePath: /leetcode-zh/medium/238.除自身以外数组的乘积/Solution.java
 */ 
/*
 * @lc app=leetcode.cn id=238 lang=java
 *
 * [238] 除自身以外数组的乘积
 *
 * https://leetcode-cn.com/problems/product-of-array-except-self/description/
 *
 * algorithms
 * Medium (68.34%)
 * Likes:    466
 * Dislikes: 0
 * Total Accepted:    59.5K
 * Total Submissions: 85.1K
 * Testcase Example:  '[1,2,3,4]'
 *
 * 给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i]
 * 之外其余各元素的乘积。
 * 
 * 
 * 
 * 示例:
 * 
 * 输入: [1,2,3,4]
 * 输出: [24,12,8,6]
 * 
 * 
 * 
 * 提示：题目数据保证数组之中任意元素的全部前缀元素和后缀（甚至是整个数组）的乘积都在 32 位整数范围内。
 * 
 * 说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
 * 
 * 进阶：
 * 你可以在常数空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。）
 * 
 */

// @lc code=start
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int left = 1, right = 1;
        int l = nums.length;
        int[] result = new int[l];
        for (int i = 0; i < l; i++) {
            result[i] = 1;
        }

        for (int i = 0; i < l; i++) {
            result[i] *= left;
            result[l - 1 - i] *= right;
            left *= nums[i];
            right *= nums[l - 1 - i];
        }
        return result;
    }

    // public int[] productExceptSelf(int[] nums) {
    //     int length = nums.length;

    //     // L 和 R 分别表示左右两侧的乘积列表
    //     int[] L = new int[length];
    //     int[] R = new int[length];

    //     int[] answer = new int[length];

    //     // L[i] 为索引 i 左侧所有元素的乘积
    //     // 对于索引为 '0' 的元素，因为左侧没有元素，所以 L[0] = 1
    //     L[0] = 1;
    //     for (int i = 1; i < length; i++) {
    //         L[i] = nums[i - 1] * L[i - 1];
    //     }

    //     // R[i] 为索引 i 右侧所有元素的乘积
    //     // 对于索引为 'length-1' 的元素，因为右侧没有元素，所以 R[length-1] = 1
    //     R[length - 1] = 1;
    //     for (int i = length - 2; i >= 0; i--) {
    //         R[i] = nums[i + 1] * R[i + 1];
    //     }

    //     // 对于索引 i，除 nums[i] 之外其余各元素的乘积就是左侧所有元素的乘积乘以右侧所有元素的乘积
    //     for (int i = 0; i < length; i++) {
    //         answer[i] = L[i] * R[i];
    //     }

    //     return answer;
    // }
}
// @lc code=end

// Accepted
// 18/18 cases passed (1 ms)
// Your runtime beats 100 % of java submissions
// Your memory usage beats 11.76 % of java submissions (48.6 MB)

// Accepted
// 18/18 cases passed (1 ms)
// Your runtime beats 100 % of java submissions
// Your memory usage beats 11.76 % of java submissions (48.3 MB)