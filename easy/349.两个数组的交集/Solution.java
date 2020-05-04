/*
 * @Author: aponder
 * @Date: 2020-05-04 10:33:52
 * @LastEditors: aponder
 * @LastEditTime: 2020-05-04 10:52:17
 * @FilePath: /leetcode-zh/easy/349.两个数组的交集/Solution.java
 */
import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=349 lang=java
 *
 * [349] 两个数组的交集
 *
 * https://leetcode-cn.com/problems/intersection-of-two-arrays/description/
 *
 * algorithms
 * Easy (68.66%)
 * Likes:    178
 * Dislikes: 0
 * Total Accepted:    65K
 * Total Submissions: 94.1K
 * Testcase Example:  '[1,2,2,1]\n[2,2]'
 *
 * 给定两个数组，编写一个函数来计算它们的交集。
 * 
 * 示例 1:
 * 
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2]
 * 
 * 
 * 示例 2:
 * 
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [9,4]
 * 
 * 说明:
 * 
 * 
 * 输出结果中的每个元素一定是唯一的。
 * 我们可以不考虑输出结果的顺序。
 * 
 * 
 */

// @lc code=start
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int i : nums1) {
            set1.add(i);
        }
        for (int i : nums2) {
            set2.add(i);
        }

        set1.retainAll(set2);
        int n = set1.size();
        int[] nums = new int[n];
        int i = 0;
        for (Integer integer : set1) {
            nums[i++] = integer;
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{4,9,5};
        int[] nums2 = new int[]{9,4,9,8,4};
        new Solution().intersection(nums1, nums2);
    }
}
// @lc code=end

// Accepted
// 60/60 cases passed (4 ms)
// Your runtime beats 65.54 % of java submissions
// Your memory usage beats 5.72 % of java submissions (40.1 MB)