import java.util.ArrayList;
import java.util.List;

/*
 * @Author: aponder
 * @Date: 2020-04-21 10:35:09
 * @LastEditors: aponder
 * @LastEditTime: 2020-04-21 11:23:11
 * @FilePath: /leetcode-zh/medium/1248.统计「优美子数组」/Solution.java
 */
/*
 * @lc app=leetcode.cn id=1248 lang=java
 *
 * [1248] 统计「优美子数组」
 *
 * https://leetcode-cn.com/problems/count-number-of-nice-subarrays/description/
 *
 * algorithms
 * Medium (47.55%)
 * Likes:    44
 * Dislikes: 0
 * Total Accepted:    5.9K
 * Total Submissions: 11.5K
 * Testcase Example:  '[1,1,2,1,1]\n3'
 *
 * 给你一个整数数组 nums 和一个整数 k。
 * 
 * 如果某个 连续 子数组中恰好有 k 个奇数数字，我们就认为这个子数组是「优美子数组」。
 * 
 * 请返回这个数组中「优美子数组」的数目。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：nums = [1,1,2,1,1], k = 3
 * 输出：2
 * 解释：包含 3 个奇数的子数组是 [1,1,2,1] 和 [1,2,1,1] 。
 * 
 * 
 * 示例 2：
 * 
 * 输入：nums = [2,4,6], k = 1
 * 输出：0
 * 解释：数列中不包含任何奇数，所以不存在优美子数组。
 * 
 * 
 * 示例 3：
 * 
 * 输入：nums = [2,2,2,1,2,2,1,2,2,2], k = 2
 * 输出：16
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= nums.length <= 50000
 * 1 <= nums[i] <= 10^5
 * 1 <= k <= nums.length
 * 
 * 
 */

// @lc code=start
class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        if (k <= 0)
            return 0;

        int length = nums.length;
        int countOdd = 0, countEven = 0;
        List<Integer> evens = new ArrayList<>();
        int firstI = 0, lastI = length - 1, kI;
        int countContinuousEven = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                countEven++;
                countContinuousEven++;
            } else {
                countOdd++;
                evens.add(1 + countContinuousEven);
                countContinuousEven = 0;
                lastI = i;
                if (countOdd == 1) {
                    firstI = i;
                }
                if (countOdd == k) {
                    kI = i;
                }
            }
        }

        evens.add(1 + countContinuousEven);
        
        if (k > countOdd)
            return 0;

        // [1,1,2,1,1], k = 3
        // 1,1,2,1
        // 4,3,4
        int sum = 0;
        int l = evens.size();
        for (int i = 0; i < l; i++) {
            int a = evens.get(i);
            int b = i + k < l ? evens.get(i + k) : 1;
            sum += a * b;
            if (i + k >= l - 1)
                break;
        }

        return sum;
    }

    public static void main(String[] args) {
        new Solution().numberOfSubarrays(new int[] { 2, 2, 2, 1, 2, 2, 1, 2, 2, 2 }, 1);
    }
}
// @lc code=end

// Accepted
// 38/38 cases passed (18 ms)
// Your runtime beats 34.88 % of java submissions
// Your memory usage beats 100 % of java submissions (47.6 MB)