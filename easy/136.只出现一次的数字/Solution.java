/*
 * @Author: aponder
 * @Date: 2020-04-14 21:43:00
 * @LastEditors: aponder
 * @LastEditTime: 2020-04-14 22:13:30
 * @FilePath: /leetcode-zh/easy/136.只出现一次的数字/Solution.java
 */
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=136 lang=java
 *
 * [136] 只出现一次的数字
 *
 * https://leetcode-cn.com/problems/single-number/description/
 *
 * algorithms
 * Easy (66.16%)
 * Likes:    1158
 * Dislikes: 0
 * Total Accepted:    175.3K
 * Total Submissions: 264.3K
 * Testcase Example:  '[2,2,1]'
 *
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * 
 * 说明：
 * 
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * 
 * 示例 1:
 * 
 * 输入: [2,2,1]
 * 输出: 1
 * 
 * 
 * 示例 2:
 * 
 * 输入: [4,1,2,1,2]
 * 输出: 4
 * 
 */

// @lc code=start
class Solution {
    // 方法 1：集合 add, remove
    // public int singleNumber(int[] nums) {
    //     Set<Integer> set = new HashSet<>();
    //     int l = nums.length;
    //     for (int i = 0; i < l; i++) {
    //         if (set.contains(nums[i])) {
    //             set.remove(nums[i]);
    //         } else {
    //             set.add(nums[i]);
    //         }
    //     }
    //     return set.toArray(new Integer[0])[0];
    // }

    // 方法 2：XOR 位操作 a⊕b⊕a = (a⊕a)⊕b = 0⊕b = b
    public int singleNumber(int[] nums) {
        int l = nums.length;
        int sum = 0;
        for (int i = 0; i < l; i++) {
            sum ^= nums[i];
        }

        return sum;
    }
}
// @lc code=end

// 方法 1
// Accepted
// 16/16 cases passed (9 ms)
// Your runtime beats 27.6 % of java submissions
// Your memory usage beats 11.43 % of java submissions (40 MB)

// 方法 2
// Accepted
// 16/16 cases passed (1 ms)
// Your runtime beats 99.7 % of java submissions
// Your memory usage beats 5.71 % of java submissions (40.6 MB)