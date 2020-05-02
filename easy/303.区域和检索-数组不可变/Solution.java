import java.util.HashMap;
import java.util.Map;

/*
 * @Author: aponder
 * @Date: 2020-05-02 10:44:33
 * @LastEditors: aponder
 * @LastEditTime: 2020-05-02 11:20:52
 * @FilePath: /leetcode-zh/easy/303.区域和检索-数组不可变/Solution.java
 */
/*
 * @lc app=leetcode.cn id=303 lang=java
 *
 * [303] 区域和检索 - 数组不可变
 *
 * https://leetcode-cn.com/problems/range-sum-query-immutable/description/
 *
 * algorithms
 * Easy (60.82%)
 * Likes:    155
 * Dislikes: 0
 * Total Accepted:    36.8K
 * Total Submissions: 60K
 * Testcase Example:  '["NumArray","sumRange","sumRange","sumRange"]\n[[[-2,0,3,-5,2,-1]],[0,2],[2,5],[0,5]]'
 *
 * 给定一个整数数组  nums，求出数组从索引 i 到 j  (i ≤ j) 范围内元素的总和，包含 i,  j 两点。
 * 
 * 示例：
 * 
 * 给定 nums = [-2, 0, 3, -5, 2, -1]，求和函数为 sumRange()
 * 
 * sumRange(0, 2) -> 1
 * sumRange(2, 5) -> -1
 * sumRange(0, 5) -> -3
 * 
 * 说明:
 * 
 * 
 * 你可以假设数组不可变。
 * 会多次调用 sumRange 方法。
 * 
 * 
 */

// @lc code=start
class NumArray {
    int[] nums;
    public NumArray(int[] nums) {
        this.nums = nums;
    }
    
    public int sumRange(int i, int j) {
        int l = nums.length;
        int sum = 0;
        for (int k = i; k <= j && k < l; k++) {
            sum += nums[k];
        }
        return sum;
    }
}
/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */
// @lc code=end

// Accepted
// 16/16 cases passed (89 ms)
// Your runtime beats 14.04 % of java submissions
// Your memory usage beats 39.13 % of java submissions (42.9 MB)