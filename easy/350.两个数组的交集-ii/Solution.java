/*
 * @Author: aponder
 * @Date: 2020-05-04 10:54:22
 * @LastEditors: aponder
 * @LastEditTime: 2020-05-04 11:06:17
 * @FilePath: /leetcode-zh/easy/350.两个数组的交集-ii/Solution.java
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=350 lang=java
 *
 * [350] 两个数组的交集 II
 *
 * https://leetcode-cn.com/problems/intersection-of-two-arrays-ii/description/
 *
 * algorithms
 * Easy (47.54%)
 * Likes:    269
 * Dislikes: 0
 * Total Accepted:    82K
 * Total Submissions: 170.5K
 * Testcase Example:  '[1,2,2,1]\n[2,2]'
 *
 * 给定两个数组，编写一个函数来计算它们的交集。
 * 
 * 示例 1:
 * 
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2,2]
 * 
 * 
 * 示例 2:
 * 
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [4,9]
 * 
 * 说明：
 * 
 * 
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
 * 我们可以不考虑输出结果的顺序。
 * 
 * 
 * 进阶:
 * 
 * 
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
 * 如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 * 
 * 
 */

// @lc code=start
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        Integer temp;
        for (int i : nums1) {
            temp = map1.getOrDefault(i, 0);
            map1.put(i, temp + 1);
        }
        for (int i : nums2) {
            temp = map2.getOrDefault(i, 0);
            map2.put(i, temp + 1);
        }
        int count = 0;
        List<Integer> list = new ArrayList<>();
        for (Integer key : map1.keySet()) {
            if (map2.containsKey(key)) {
                count = Math.min(map1.get(key), map2.get(key));
                while (count-- > 0) {
                    list.add(key);
                }
            }
        }

        int n = list.size();
        int[] nums = new int[n];
        int i = 0;
        for (int num : list) {
            nums[i++] = num;            
        }
        return nums;
    }
}
// @lc code=end

// Accepted
// 61/61 cases passed (5 ms)
// Your runtime beats 39.5 % of java submissions
// Your memory usage beats 5.13 % of java submissions (39.8 MB)