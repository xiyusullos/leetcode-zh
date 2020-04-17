/*
 * @Author: aponder
 * @Date: 2020-04-17 11:27:53
 * @LastEditors: aponder
 * @LastEditTime: 2020-04-17 12:02:37
 * @FilePath: /leetcode-zh/easy/169.多数元素/Solution.java
 */
import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=169 lang=java
 *
 * [169] 多数元素
 *
 * https://leetcode-cn.com/problems/majority-element/description/
 *
 * algorithms
 * Easy (62.85%)
 * Likes:    565
 * Dislikes: 0
 * Total Accepted:    156.1K
 * Total Submissions: 248.1K
 * Testcase Example:  '[3,2,3]'
 *
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * 
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * 
 * 
 * 
 * 示例 1:
 * 
 * 输入: [3,2,3]
 * 输出: 3
 * 
 * 示例 2:
 * 
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 * 
 * 
 */

// @lc code=start
class Solution {
    // 方法 1
    // public int majorityElement(int[] nums) {
    //     Map<Integer, Integer> map = new HashMap<>();
    //     int l = nums.length;
    //     for (int i : nums) {
    //         if (!map.containsKey(i)) {
    //             map.put(i, 1);
    //         } else {
    //             int t = map.get(i);
    //             if (t + 1 > l / 2) return i;
    //             map.replace(i, t + 1);
    //         }
    //     }

    //     // 若 nums.length 为 1
    //     return nums[0];
    // }

    public int majorityElement(int[] nums) {
        // int count = 0;
        int vote = 0;
        Integer candidate = null;

        for (int num : nums) {
            if (vote == 0) {
                candidate = num;
            }
            if (num == candidate) {
                vote += 1;
            } else {
                vote -= 1;
            }
        }

        return candidate;
    }
}
// @lc code=end

// Accepted
// 46/46 cases passed (16 ms)
// Your runtime beats 33.61 % of java submissions
// Your memory usage beats 5.71 % of java submissions (45.1 MB)