/*
 * @Author: aponder
 * @Date: 2020-05-13 13:40:28
 * @LastEditors: aponder
 * @LastEditTime: 2020-05-13 13:54:11
 * @FilePath: /leetcode-zh/easy/448.找到所有数组中消失的数字/Solution.java
 */
import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=448 lang=java
 *
 * [448] 找到所有数组中消失的数字
 *
 * https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array/description/
 *
 * algorithms
 * Easy (57.46%)
 * Likes:    341
 * Dislikes: 0
 * Total Accepted:    36.6K
 * Total Submissions: 63.1K
 * Testcase Example:  '[4,3,2,7,8,2,3,1]'
 *
 * 给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。
 * 
 * 找到所有在 [1, n] 范围之间没有出现在数组中的数字。
 * 
 * 您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。
 * 
 * 示例:
 * 
 * 
 * 输入:
 * [4,3,2,7,8,2,3,1]
 * 
 * 输出:
 * [5,6]
 * 
 * 
 */

// @lc code=start
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int length = nums.length;
        boolean[] shown = new boolean[length];
        for (int i : nums) {
            shown[i - 1] = true;
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            if (!shown[i]) {
                result.add(i + 1);
            }
        }

        return result;
    }
}
// @lc code=end

// Accepted
// 34/34 cases passed (4 ms)
// Your runtime beats 99.84 % of java submissions
// Your memory usage beats 37.5 % of java submissions (49.1 MB)