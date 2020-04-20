import java.util.HashMap;
import java.util.Map;

/*
 * @Author: aponder
 * @Date: 2020-04-20 13:34:31
 * @LastEditors: aponder
 * @LastEditTime: 2020-04-20 21:36:05
 * @FilePath: /leetcode-zh/easy/198.打家劫舍/Solution.java
 */
/*
 * @lc app=leetcode.cn id=198 lang=java
 *
 * [198] 打家劫舍
 *
 * https://leetcode-cn.com/problems/house-robber/description/
 *
 * algorithms
 * Easy (44.15%)
 * Likes:    747
 * Dislikes: 0
 * Total Accepted:    101.3K
 * Total Submissions: 228.7K
 * Testcase Example:  '[1,2,3,1]'
 *
 * 
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * 
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 * 
 * 示例 1:
 * 
 * 输入: [1,2,3,1]
 * 输出: 4
 * 解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 * 偷窃到的最高金额 = 1 + 3 = 4 。
 * 
 * 示例 2:
 * 
 * 输入: [2,7,9,3,1]
 * 输出: 12
 * 解释: 偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 * 偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 * 
 * 
 */

// @lc code=start
class Solution {
    public int rob(int[] nums) {
        // 7,3,2,9,7,1,4
        // 1,6,4,7,8
        // 2,6,5,3,7
        // 1,2,3: 1,3; 2;
        // 1,2,3,4: 1,3: 2:4; 1,4;
        // 1,2,3,4,5: 1,3,5; 1,4; 2,4: 2,5;
        // 1,2,3,4,5,6: 1,3,5; 1,3,6; 1,4,6; 1,4; 2,4: 2,5;

        return rob(nums, nums.length - 1);
    }

    // 方法 1
    // int rob(int[] nums, int i, int l) {
    // int remain = l - i;
    // if (remain < 1)
    // return 0;
    // if (remain == 1)
    // return nums[i];
    // else if (remain == 2)
    // return Math.max(nums[i], nums[i + 1]);
    // else {
    // return Math.max(nums[i] + rob(nums, i + 2, l), nums[i + 1] + rob(nums, i + 3,
    // l));
    // }
    // }

    // 方法 2
    // int rob(int[] nums, int i) {
    // if (i < 0)
    // return 0;
    // if (i == 0)
    // return nums[i];
    // // else if (i == 1)
    // // return Math.max(nums[0], nums[1]);
    // else {
    // // 1: n1
    // // 2: max(n1, n2)
    // // 3: max(n1+n3, n2)
    // // => f(i) = max(f(i-2)+ni, f(i-1))
    // return Math.max(nums[i] + rob(nums, i - 2), rob(nums, i - 1));
    // }
    // }

    Map<Integer, Integer> robMap = new HashMap<>();

    // 方法 3
    int rob(int[] nums, int i) {
        if (i < 0)
            return 0;
        if (i == 0)
            return nums[i];
        // else if (i == 1)
        //     return Math.max(nums[0], nums[1]);
        else {
            if (robMap.get(i) == null) {
                robMap.put(i, Math.max(nums[i] + rob(nums, i - 2), rob(nums, i - 1)));
            }
            
            return robMap.get(i);
        }
    }

    public static void main(String[] args) {
        new Solution().rob(new int[] { 7, 3, 2, 9, 7, 1, 4 });
    }
}
// @lc code=end

// 方法 1
// Time Limit Exceeded
// 59/69 cases passed (N/A)
// Testcase
// [226,174,214,16,218,48,153,131,128,17,157,142,88,43,37,157,43,221,191,68,206,23,225,82,54,118,111,46,80,49,245,63,25,194,72,80,143,55,209,18,55,122,65,66,177,101,63,201,172,130,103,225,142,46,86,185,62,138,212,192,125,77,223,188,99,228,90,25,193,211,84,239,119,234,85,83,123,120,131,203,219,10,82,35,120,180,249,106,37,169,225,54,103,55,166,124]

// 方法 2
// Time Limit Exceeded
// 56/69 cases passed (N/A)
// Testcase
// [114,117,207,117,235,82,90,67,143,146,53,108,200,91,80,223,58,170,110,236,81,90,222,160,165,195,187,199,114,235,197,187,69,129,64,214,228,78,188,67,205,94,205,169,241,202,144,240]

// 方法 3
// Accepted
// 69/69 cases passed (1 ms)
// Your runtime beats 6.09 % of java submissions
// Your memory usage beats 6.52 % of java submissions (37.5 MB)