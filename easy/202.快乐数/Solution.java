import java.util.HashSet;
import java.util.Set;

/*
 * @Author: aponder
 * @Date: 2020-04-21 10:03:42
 * @LastEditors: aponder
 * @LastEditTime: 2020-04-21 10:19:40
 * @FilePath: /leetcode-zh/easy/202.快乐数/Solution.java
 */
/*
 * @lc app=leetcode.cn id=202 lang=java
 *
 * [202] 快乐数
 *
 * https://leetcode-cn.com/problems/happy-number/description/
 *
 * algorithms
 * Easy (57.79%)
 * Likes:    279
 * Dislikes: 0
 * Total Accepted:    55.2K
 * Total Submissions: 95.2K
 * Testcase Example:  '19'
 *
 * 编写一个算法来判断一个数 n 是不是快乐数。
 * 
 * 「快乐数」定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到
 * 1。如果 可以变为  1，那么这个数就是快乐数。
 * 
 * 如果 n 是快乐数就返回 True ；不是，则返回 False 。
 * 
 * 
 * 
 * 示例：
 * 
 * 输入：19
 * 输出：true
 * 解释：
 * 1^2 + 9^2 = 82
 * 8^2 + 2^2 = 68
 * 6^2 + 8^2 = 100
 * 1^2 + 0^2 + 0^2 = 1
 * 
 * 
 */

// @lc code=start
class Solution {
    public boolean isHappy(int n) {
        if (n == 1)
            return true;
        Set<Integer> visited = new HashSet<>();
        int p = n;

        do {
            visited.add(p);
            int sum = 0;
            int t;
            while (p > 0) {
                t = p % 10;
                sum += t * t;
                p /= 10;
            }
            p = sum;
            if (visited.contains(p))
                return false;
        } while (p != 1);

        return true;
    }

    public static void main(String[] args) {
        new Solution().isHappy(2);
    }
}
// @lc code=end

// Accepted
// 401/401 cases passed (1 ms)
// Your runtime beats 99.91 % of java submissions
// Your memory usage beats 8.33 % of java submissions (36.5 MB)