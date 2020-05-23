/*
 * @Author: aponder
 * @Date: 2020-05-23 10:31:06
 * @LastEditTime: 2020-05-23 11:03:30
 * @LastEditors: aponder
 * @Description: 
 * @FilePath: /leetcode-zh/easy/532.数组中的k-diff数对/Solution.java
 */ 
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=532 lang=java
 *
 * [532] 数组中的K-diff数对
 *
 * https://leetcode-cn.com/problems/k-diff-pairs-in-an-array/description/
 *
 * algorithms
 * Easy (34.15%)
 * Likes:    78
 * Dislikes: 0
 * Total Accepted:    15.1K
 * Total Submissions: 44.2K
 * Testcase Example:  '[3,1,4,1,5]\n2'
 *
 * 给定一个整数数组和一个整数 k, 你需要在数组里找到不同的 k-diff 数对。这里将 k-diff 数对定义为一个整数对 (i, j), 其中 i 和
 * j 都是数组中的数字，且两数之差的绝对值是 k.
 * 
 * 示例 1:
 * 
 * 
 * 输入: [3, 1, 4, 1, 5], k = 2
 * 输出: 2
 * 解释: 数组中有两个 2-diff 数对, (1, 3) 和 (3, 5)。
 * 尽管数组中有两个1，但我们只应返回不同的数对的数量。
 * 
 * 
 * 示例 2:
 * 
 * 
 * 输入:[1, 2, 3, 4, 5], k = 1
 * 输出: 4
 * 解释: 数组中有四个 1-diff 数对, (1, 2), (2, 3), (3, 4) 和 (4, 5)。
 * 
 * 
 * 示例 3:
 * 
 * 
 * 输入: [1, 3, 1, 5, 4], k = 0
 * 输出: 1
 * 解释: 数组中只有一个 0-diff 数对，(1, 1)。
 * 
 * 
 * 注意:
 * 
 * 
 * 数对 (i, j) 和数对 (j, i) 被算作同一数对。
 * 数组的长度不超过10,000。
 * 所有输入的整数的范围在 [-1e7, 1e7]。
 * 
 * 
 */

// @lc code=start
class Solution {
    // 方法 1
    // public int findPairs(int[] nums, int k) {
    //     if (k < 0) return 0;
        
    //     int length = nums.length;
    //     Set<String> set = new HashSet<>();
    //     for (int i = 0; i < length - 1; i++) {
    //         for (int j = i + 1; j < length; j++) {
    //             if (nums[i] + k == nums[j]) {
    //                 set.add(nums[i] + "," + nums[j]);
    //             } else if (nums[j] + k == nums[i]) {
    //                 set.add(nums[j] + "," + nums[i]);
    //             }
    //         }
    //     }

    //     return set.size();
    // }

    public int findPairs(int[] nums, int k) {
        if (k < 0) return 0;
        
        int length = nums.length;
        // <num, count>
        Map<Integer, Integer> map = new HashMap<>(length);
        for (int num : nums) {
            map.put(num, 1 + map.getOrDefault(num, 0));
        }
        if (k == 0) {
            int count = 0;
            for (int key : map.keySet()) {
                if (map.get(key) > 1) count++;
            }
            return count;
        }

        Set<Integer> set = new HashSet<>(length);
        for (int key : map.keySet()) {
            if (map.containsKey(key + k)) set.add(key);
            if (map.containsKey(key - k)) set.add(key - k);
        }

        return set.size();
    }

    public static void main(String[] args) {
        new Solution().findPairs(new int[]{3,1,4,1,5}, 2);
    }
}
// @lc code=end

// 方法 1
// Accepted
// 72/72 cases passed (402 ms)
// Your runtime beats 18.85 % of java submissions
// Your memory usage beats 14.29 % of java submissions (40.6 MB)

// 方法 2
// Accepted
// 72/72 cases passed (16 ms)
// Your runtime beats 47.92 % of java submissions
// Your memory usage beats 14.29 % of java submissions (40.7 MB)