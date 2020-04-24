/*
 * @Author: aponder
 * @Date: 2020-04-24 11:11:14
 * @LastEditors: aponder
 * @LastEditTime: 2020-04-24 11:27:25
 * @FilePath: /leetcode-zh/easy/219.存在重复元素-ii/Solution.java
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=219 lang=java
 *
 * [219] 存在重复元素 II
 *
 * https://leetcode-cn.com/problems/contains-duplicate-ii/description/
 *
 * algorithms
 * Easy (38.05%)
 * Likes:    160
 * Dislikes: 0
 * Total Accepted:    42.2K
 * Total Submissions: 109.8K
 * Testcase Example:  '[1,2,3,1]\n3'
 *
 * 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的
 * 绝对值 至多为 k。
 * 
 * 
 * 
 * 示例 1:
 * 
 * 输入: nums = [1,2,3,1], k = 3
 * 输出: true
 * 
 * 示例 2:
 * 
 * 输入: nums = [1,0,1,1], k = 1
 * 输出: true
 * 
 * 示例 3:
 * 
 * 输入: nums = [1,2,3,1,2,3], k = 2
 * 输出: false
 * 
 */

// @lc code=start
class Solution {
    // 方法 1
    // public boolean containsNearbyDuplicate(int[] nums, int k) {
    //     int length = nums.length;
    //     Map<Integer, List<Integer>> map = new HashMap<>();
    //     for (int i = 0; i < length; i++) {
    //         if (!map.containsKey(nums[i])) {
    //             List<Integer> list = new ArrayList<>();
    //             list.add(i);
    //             map.put(nums[i], list);
    //         } else {
    //             map.get(nums[i]).add(i);
    //         }
    //     }

    //     for (int num : map.keySet()) {
    //         List<Integer> list = map.get(num);
    //         int size = list.size();
    //         if (size >= 2) {
    //             for (int i = 0; i < size - 1; i++) {
    //                 if (list.get(i + 1) - list.get(i) <= k) {
    //                     return true;
    //                 }
    //             }
    //         }
    //     }
    //     return false;
    // }

    // 方法 2
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(nums[i])) {
                set.add(nums[i]);
            } else {
                return true;
            }

            // 若 set 大小超过了 k， 删除散列表中最旧的元素
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }
}
// @lc code=end

// 方法 1
// 23/23 cases passed (17 ms)
// Your runtime beats 36.55 % of java submissions
// Your memory usage beats 5.72 % of java submissions (49.3 MB)

// 方法 2
// Accepted
// 23/23 cases passed (11 ms)
// Your runtime beats 73.32 % of java submissions
// Your memory usage beats 14.29 % of java submissions (43.3 MB)