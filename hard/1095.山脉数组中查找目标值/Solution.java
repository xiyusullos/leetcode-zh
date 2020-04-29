/*
 * @Author: aponder
 * @Date: 2020-04-29 12:58:03
 * @LastEditors: aponder
 * @LastEditTime: 2020-04-29 13:49:36
 * @FilePath: /leetcode-zh/hard/1095.山脉数组中查找目标值/Solution.java
 */
/*
 * @lc app=leetcode.cn id=1095 lang=java
 *
 * [1095] 山脉数组中查找目标值
 *
 * https://leetcode-cn.com/problems/find-in-mountain-array/description/
 *
 * algorithms
 * Hard (30.88%)
 * Likes:    44
 * Dislikes: 0
 * Total Accepted:    5.7K
 * Total Submissions: 15.6K
 * Testcase Example:  '[1,2,3,4,5,3,1]\n3'
 *
 * （这是一个 面试问题 ）
 * 
 * 给你一个 山脉数组 mountainArr，请你返回能够使得 mountainArr.get(index) == target 的最小下标 index
 * 值。
 * 
 * 如果不存在这样的下标 index，就请返回 -1。
 * 
 * 
 * 
 * 何为山脉数组？如果数组 A 是一个山脉数组的话，那它满足如下条件：
 * 
 * 首先，A.length >= 3
 * 
 * 其次，在 0 < i < A.length - 1 条件下，存在 i 使得：
 * 
 * 
 * A[0] < A[1] < ... A[i-1] < A[i]
 * A[i] > A[i+1] > ... > A[A.length - 1]
 * 
 * 
 * 
 * 
 * 你将 不能直接访问该山脉数组，必须通过 MountainArray 接口来获取数据：
 * 
 * 
 * MountainArray.get(k) - 会返回数组中索引为k 的元素（下标从 0 开始）
 * MountainArray.length() - 会返回该数组的长度
 * 
 * 
 * 
 * 
 * 注意：
 * 
 * 对 MountainArray.get 发起超过 100 次调用的提交将被视为错误答案。此外，任何试图规避判题系统的解决方案都将会导致比赛资格被取消。
 * 
 * 为了帮助大家更好地理解交互式问题，我们准备了一个样例
 * “答案”：https://leetcode-cn.com/playground/RKhe3ave，请注意这 不是一个正确答案。
 * 
 * 
 * 
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：array = [1,2,3,4,5,3,1], target = 3
 * 输出：2
 * 解释：3 在数组中出现了两次，下标分别为 2 和 5，我们返回最小的下标 2。
 * 
 * 示例 2：
 * 
 * 输入：array = [0,1,2,4,2,1], target = 3
 * 输出：-1
 * 解释：3 在数组中没有出现，返回 -1。
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 3 <= mountain_arr.length() <= 10000
 * 0 <= target <= 10^9
 * 0 <= mountain_arr.get(index) <= 10^9
 * 
 * 
 */

// @lc code=start
/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int length = mountainArr.length();
        int l = 1, h = length - 2;
        int m = 0, center = 0;
        while (l <= h) {
            m = l + (h - l) / 2;
            int mid = mountainArr.get(m);
            // if (mid == target) return m;

            int midRight = mountainArr.get(m + 1);
            int midLeft = mountainArr.get(m - 1);
            if (midLeft < mid && mid > midRight) {
                center = m;
                break;
            } else if (mid < midRight) l = m + 1;
            else h = m - 1;
        }

        int result = findLeft(target, mountainArr, 0, center);
        if (result == -1) {
            result = findRight(target, mountainArr, center, length - 1);
        }

        return result;
    }

    int findLeft(int target, MountainArray mountainArr, int l, int h) {
        if (l > h) return -1;

        int m = l + (h - l) / 2;
        int mid = mountainArr.get(m);
        if (mid == target) return m;

        if (target < mid) return findLeft(target, mountainArr, l, m - 1);
        else return findLeft(target, mountainArr, m + 1, h);
    }

    int findRight(int target, MountainArray mountainArr, int l, int h) {
        if (l > h) return -1;

        int m = l + (h - l) / 2;
        int mid = mountainArr.get(m);
        if (mid == target) return m;

        if (target > mid) return findRight(target, mountainArr, l, m - 1);
        else return findRight(target, mountainArr, m + 1, h);
    }
}
// @lc code=end

// Accepted
// 77/77 cases passed (0 ms)
// Your runtime beats 100 % of java submissions
// Your memory usage beats 100 % of java submissions (39.7 MB)