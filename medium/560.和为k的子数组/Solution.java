import java.util.HashMap;
import java.util.Map;

/*
 * @Author: aponder
 * @Date: 2020-05-15 11:08:27
 * @LastEditors: aponder
 * @LastEditTime: 2020-05-15 11:44:17
 * @FilePath: /leetcode-zh/medium/560.和为k的子数组/Solution.java
 */
/*
 * @lc app=leetcode.cn id=560 lang=java
 *
 * [560] 和为K的子数组
 *
 * https://leetcode-cn.com/problems/subarray-sum-equals-k/description/
 *
 * algorithms
 * Medium (44.54%)
 * Likes:    355
 * Dislikes: 0
 * Total Accepted:    34.1K
 * Total Submissions: 76.7K
 * Testcase Example:  '[1,1,1]\n2'
 *
 * 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
 * 
 * 示例 1 :
 * 
 * 
 * 输入:nums = [1,1,1], k = 2
 * 输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
 * 
 * 
 * 说明 :
 * 
 * 
 * 数组的长度为 [1, 20,000]。
 * 数组中元素的范围是 [-1000, 1000] ，且整数 k 的范围是 [-1e7, 1e7]。
 * 
 * 
 */

// @lc code=start
class Solution {
    // 方法 1
    // public int subarraySum(int[] nums, int k) {
    //     // 2147483647
    //     // 20000000
    //     int length = nums.length;
    //     int sum = 0;
    //     int count = 0;
    //     for (int i = 0; i < length; i++) {
    //         sum = 0;
    //         for (int j = i; j < length; j++) {
    //             sum += nums[j];
    //             if (sum == k)
    //                 count++;
    //         }
    //     }
    //     return count;
    // }

    // 方法 2
    public int subarraySum(int[] nums, int k) {
        int length = nums.length;
        int pre = 0;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // pre == k 时，加 1
        for (int i = 0; i < length; i++) {
            pre += nums[i];
            count += map.getOrDefault(pre - k, 0);
            map.put(pre, 1 + map.getOrDefault(pre, 0));
        }

        return count;
    }
}
// @lc code=end

// 方法 1
// Accepted
// 81/81 cases passed (402 ms)
// Your runtime beats 7.86 % of java submissions
// Your memory usage beats 7.69 % of java submissions (40.9 MB)

// 方法 2
// Accepted
// 81/81 cases passed (24 ms)
// Your runtime beats 60.71 % of java submissions
// Your memory usage beats 11.54 % of java submissions (40.2 MB)