/*
 * @Author: aponder
 * @Date: 2020-05-27 23:44:10
 * @LastEditTime: 2020-05-27 23:46:39
 * @LastEditors: aponder
 * @Description: 
 * @FilePath: /leetcode-zh/medium/974.和可被-k-整除的子数组/Solution.java
 */ 
/*
 * @lc app=leetcode.cn id=974 lang=java
 *
 * [974] 和可被 K 整除的子数组
 *
 * https://leetcode-cn.com/problems/subarray-sums-divisible-by-k/description/
 *
 * algorithms
 * Medium (37.51%)
 * Likes:    155
 * Dislikes: 0
 * Total Accepted:    18.9K
 * Total Submissions: 42K
 * Testcase Example:  '[4,5,0,-2,-3,1]\n5'
 *
 * 给定一个整数数组 A，返回其中元素之和可被 K 整除的（连续、非空）子数组的数目。
 * 
 * 
 * 
 * 示例：
 * 
 * 输入：A = [4,5,0,-2,-3,1], K = 5
 * 输出：7
 * 解释：
 * 有 7 个子数组满足其元素之和可被 K = 5 整除：
 * [4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2,
 * -3]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= A.length <= 30000
 * -10000 <= A[i] <= 10000
 * 2 <= K <= 10000
 * 
 * 
 */

// @lc code=start
class Solution {
    // public int subarraysDivByK(int[] A, int K) {

    // }

    public int subarraysDivByK(int[] A, int K) {
        Map<Integer, Integer> record = new HashMap<>();
        record.put(0, 1);
        int sum = 0, ans = 0;
        for (int elem: A) {
            sum += elem;
            // 注意 Java 取模的特殊性，当被除数为负数时取模结果为负数，需要纠正
            int modulus = (sum % K + K) % K;
            int same = record.getOrDefault(modulus, 0);
            ans += same;
            record.put(modulus, same + 1);
        }
        return ans;
    }
}
// @lc code=end

// Accepted
// 73/73 cases passed (22 ms)
// Your runtime beats 38.9 % of java submissions
// Your memory usage beats 100 % of java submissions (46.4 MB)