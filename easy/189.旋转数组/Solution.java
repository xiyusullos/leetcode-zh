/*
 * @Author: aponder
 * @Date: 2020-04-19 15:06:08
 * @LastEditors: aponder
 * @LastEditTime: 2020-04-19 23:00:14
 * @FilePath: /leetcode-zh/easy/189.旋转数组/Solution.java
 */
import java.util.Arrays;

/*
 * @Author: aponder
 * @Date: 2020-04-19 15:06:08
 * @LastEditors: aponder
 * @LastEditTime: 2020-04-19 22:21:12
 * @FilePath: /leetcode-zh/easy/189.旋转数组/Solution.java
 */
/*
 * @lc app=leetcode.cn id=189 lang=java
 *
 * [189] 旋转数组
 *
 * https://leetcode-cn.com/problems/rotate-array/description/
 *
 * algorithms
 * Easy (40.97%)
 * Likes:    552
 * Dislikes: 0
 * Total Accepted:    117.4K
 * Total Submissions: 285.2K
 * Testcase Example:  '[1,2,3,4,5,6,7]\n3'
 *
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 * 
 * 示例 1:
 * 
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 * 
 * 
 * 示例 2:
 * 
 * 输入: [-1,-100,3,99] 和 k = 2
 * 输出: [3,99,-1,-100]
 * 解释: 
 * 向右旋转 1 步: [99,-1,-100,3]
 * 向右旋转 2 步: [3,99,-1,-100]
 * 
 * 说明:
 * 
 * 
 * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 * 要求使用空间复杂度为 O(1) 的 原地 算法。
 * 
 * 
 */

// @lc code=start
class Solution {
    public void rotate(int[] nums, int k) {
        int length = nums.length;
        k %= length;
        if (k == 0) return;

        int lastI = length - 1;
        int count = 0;
        int initI = lastI;
        while (count < length) {
            int i = initI;
            int temp = nums[initI];
            int prevI = (length + i - k) % length;
            while (prevI != initI) {
                count++;
                nums[i] = nums[prevI];
                i = prevI;
                prevI = (length + i - k) % length;
            }
            nums[i] = temp;
            count++;
            initI--;
        }
    }
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6};
        int k = 2;
        // int[] nums = new int[]{1,2,3,4,5,6,7};
        // int k = 3;
        new Solution().rotate(nums, k);
        System.out.println(Arrays.toString(nums));
    }
}
// @lc code=end

// Accepted
// 34/34 cases passed (0 ms)
// Your runtime beats 100 % of java submissions
// Your memory usage beats 7.14 % of java submissions (40.3 MB)