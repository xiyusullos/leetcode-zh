/*
 * @Author: aponder
 * @Date: 2020-04-22 12:24:19
 * @LastEditors: aponder
 * @LastEditTime: 2020-04-22 23:08:30
 * @FilePath: /leetcode-zh/easy/204.计数质数/Solution.java
 */
/*
 * @lc app=leetcode.cn id=204 lang=java
 *
 * [204] 计数质数
 *
 * https://leetcode-cn.com/problems/count-primes/description/
 *
 * algorithms
 * Easy (33.09%)
 * Likes:    331
 * Dislikes: 0
 * Total Accepted:    53.1K
 * Total Submissions: 159.3K
 * Testcase Example:  '10'
 *
 * 统计所有小于非负整数 n 的质数的数量。
 * 
 * 示例:
 * 
 * 输入: 10
 * 输出: 4
 * 解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 * 
 * 
 */

// @lc code=start
class Solution {
    public int countPrimes(int n) {
        // n ≥ 0
        // 2,3,5,7
        boolean[] isPrim = new boolean[n];
        // 将数组都初始化为 true
        Arrays.fill(isPrim, true);

        for (int i = 2; i * i < n; i++) {
            if (isPrim[i]) {
                // i 的倍数不可能是素数了
                for (int j = i * i; j < n; j += i) {
                    isPrim[j] = false;
                }
            }
        }
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrim[i]) {
                count++;
            }
        }

        return count;
    }
}
// @lc code=end
