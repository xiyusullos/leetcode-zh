/*
 * @Author: aponder
 * @Date: 2020-04-30 10:40:16
 * @LastEditors: aponder
 * @LastEditTime: 2020-04-30 11:05:12
 * @FilePath: /leetcode-zh/easy/278.第一个错误的版本/Solution.java
 */
/*
 * @lc app=leetcode.cn id=278 lang=java
 *
 * [278] 第一个错误的版本
 *
 * https://leetcode-cn.com/problems/first-bad-version/description/
 *
 * algorithms
 * Easy (37.77%)
 * Likes:    160
 * Dislikes: 0
 * Total Accepted:    45.2K
 * Total Submissions: 118.2K
 * Testcase Example:  '5\n4'
 *
 * 
 * 你是产品经理，目前正在带领一个团队开发新的产品。不幸的是，你的产品的最新版本没有通过质量检测。由于每个版本都是基于之前的版本开发的，所以错误的版本之后的所有版本都是错的。
 * 
 * 假设你有 n 个版本 [1, 2, ..., n]，你想找出导致之后所有版本出错的第一个错误的版本。
 * 
 * 你可以通过调用 bool isBadVersion(version) 接口来判断版本号 version
 * 是否在单元测试中出错。实现一个函数来查找第一个错误的版本。你应该尽量减少对调用 API 的次数。
 * 
 * 示例:
 * 
 * 给定 n = 5，并且 version = 4 是第一个错误的版本。
 * 
 * 调用 isBadVersion(3) -> false
 * 调用 isBadVersion(5) -> true
 * 调用 isBadVersion(4) -> true
 * 
 * 所以，4 是第一个错误的版本。 
 * 
 */

// @lc code=start
/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        if (isBadVersion(1))
            return 1;

        int l = 2, h = n;
        int m = l + (h - l) / 2;

        while (l <= h) {
            m = l + (h - l) / 2;
            boolean current = isBadVersion(m);
            // 在后面
            if (current == false) {
                l = m + 1;
                continue;
            }
            
            boolean previous = isBadVersion(m - 1);
            if (previous == false && current == true) return m;
            else h = m - 1;  // 在前面
        }

        return m;
    }
}
// @lc code=end

// Accepted
// 22/22 cases passed (30 ms)
// Your runtime beats 11.65 % of java submissions
// Your memory usage beats 8.33 % of java submissions (36.2 MB)

// Accepted
// 22/22 cases passed (21 ms)
// Your runtime beats 30.24 % of java submissions
// Your memory usage beats 8.33 % of java submissions (36.3 MB)