/*
 * @Author: aponder
 * @Date: 2020-05-04 11:09:02
 * @LastEditors: aponder
 * @LastEditTime: 2020-05-04 13:05:29
 * @FilePath: /leetcode-zh/hard/45.跳跃游戏-ii/Solution.java
 */
/*
 * @lc app=leetcode.cn id=45 lang=java
 *
 * [45] 跳跃游戏 II
 *
 * https://leetcode-cn.com/problems/jump-game-ii/description/
 *
 * algorithms
 * Hard (33.62%)
 * Likes:    482
 * Dislikes: 0
 * Total Accepted:    47.7K
 * Total Submissions: 136.9K
 * Testcase Example:  '[2,3,1,1,4]'
 *
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * 
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 * 
 * 示例:
 * 
 * 输入: [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 * 从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 * 
 * 
 * 说明:
 * 
 * 假设你总是可以到达数组的最后一个位置。
 * 
 */

// @lc code=start
class Solution {
    int[] nums;
    int[] notes;

    public int jump(int[] nums) {
        int steps = 0;
        int target = nums.length - 1;
        while (target > 0) {
            int j = target;
            for (int i = 0; i < j; i++) {
                if (nums[i] >= j - i) {
                    target = i;
                    break;
                }
            }
            steps++;
        }
        return steps;
    }
    // public int jump(int[] nums) {
    //     this.nums = nums;
    //     this.notes = new int[nums.length];

    //     // return 1;
    //     return jump(0, nums.length - 1, nums.length + 1, 0);
    // }

    // int jump(int i, int j, int possiableStep, int usedStep) {
    //     if (i >= j)
    //         return 0;
    //     int num = nums[i];
    //     if (num == 0)
    //         return nums.length;

    //     if (possiableStep <= nums.length && usedStep >= possiableStep)
    //         return nums.length;

    //     if (notes[i] == 0) {
    //         int step;
    //         int minStep = 1 + jump(i + num, j, possiableStep, 0);
    //         if (possiableStep <= nums.length && minStep >= possiableStep) return nums.length;
            
    //         if (minStep > 1) {
    //             for (int k = num - 1; k > 0; k--) {
    //                 step = 1 + jump(i + k, j, minStep, usedStep + 1);
    //                 if (step < minStep)
    //                 minStep = step;
    //             }
    //         }
    //         notes[i] = minStep;
    //     }
    //     return notes[i];
    // }

    public static void main(String[] args) {
        int[] nums;
        // nums = new int[] { 27, 26, 25, 24, 23, 22, 21, 20, 19, 18, 17, 16, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 1, 0 };
        // nums = new int[]{2,3,0,1,4};
        // nums = new int[]{5,9,3,2,1,0,2,3,3,1,0,0};
        // //                   2           8           14              22           29
        // //                   |           |           |               |             |           |  
        // nums = new int[]{2,1,9,5,9,7,6,4,8,3,2,2,2,1,9,1,7,9,7,0,7,5,8,2,1,3,2,4,1,9,5,4,0,6,1,1};

        nums = new int[]{2,3,1,1,4};

        new Solution().jump(nums);
    }
}
// @lc code=end

// Accepted
// 92/92 cases passed (297 ms)
// Your runtime beats 14.35 % of java submissions
// Your memory usage beats 5 % of java submissions (41.9 MB)