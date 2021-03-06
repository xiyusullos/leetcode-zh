/*
 * @Author: aponder
 * @Date: 2020-05-18 19:51:25
 * @LastEditTime: 2020-05-18 20:26:38
 * @LastEditors: aponder
 * @Description: 
 * @FilePath: /leetcode-zh/easy/496.下一个更大元素-i/Solution.java
 */
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/*
 * @lc app=leetcode.cn id=496 lang=java
 *
 * [496] 下一个更大元素 I
 *
 * https://leetcode-cn.com/problems/next-greater-element-i/description/
 *
 * algorithms
 * Easy (63.63%)
 * Likes:    199
 * Dislikes: 0
 * Total Accepted:    30.6K
 * Total Submissions: 47.7K
 * Testcase Example:  '[4,1,2]\n[1,3,4,2]'
 *
 * 给定两个 没有重复元素 的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。找到 nums1 中每个元素在 nums2
 * 中的下一个比其大的值。
 * 
 * nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。如果不存在，对应位置输出 -1 。
 * 
 * 
 * 
 * 示例 1:
 * 
 * 输入: nums1 = [4,1,2], nums2 = [1,3,4,2].
 * 输出: [-1,3,-1]
 * 解释:
 * ⁠   对于num1中的数字4，你无法在第二个数组中找到下一个更大的数字，因此输出 -1。
 * ⁠   对于num1中的数字1，第二个数组中数字1右边的下一个较大数字是 3。
 * ⁠   对于num1中的数字2，第二个数组中没有下一个更大的数字，因此输出 -1。
 * 
 * 示例 2:
 * 
 * 输入: nums1 = [2,4], nums2 = [1,2,3,4].
 * 输出: [3,-1]
 * 解释:
 * 对于 num1 中的数字 2 ，第二个数组中的下一个较大数字是 3 。
 * ⁠   对于 num1 中的数字 4 ，第二个数组中没有下一个更大的数字，因此输出 -1 。
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * nums1和nums2中所有元素是唯一的。
 * nums1和nums2 的数组大小都不超过1000。
 * 
 * 
 */

// @lc code=start
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        int l1 = nums1.length;
        int l2 = nums2.length;
        if (l1 == 0) return new int[0];
        int a,b;
        for (int i = 0; i < l2; i++) {
            a = nums2[i];
            while (!stack.empty() && a > stack.peek())
                map.put(stack.pop(), a);
            stack.push(a);
            
            // System.out.println(a + "->" + b);
            // map.put(a, b);
            // 神奇的BUG
            // map.put(nums2[i], nums2[i + i]);
        }
        while (!stack.empty()) {
            map.put(stack.pop(), -1);
        }

        int[] results = new int[l1];
        int nextNum;
        for (int i = 0; i < l1; i++) {
            nextNum = map.get(nums1[i]);
            if (nextNum > nums1[i]) results[i] = nextNum;
            else results[i] = -1;
        }

        return results;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{4,1,2};
        int[] nums2 = new int[]{1,3,4,2};
        new Solution().nextGreaterElement(nums1, nums2);
    }
}
// @lc code=end

