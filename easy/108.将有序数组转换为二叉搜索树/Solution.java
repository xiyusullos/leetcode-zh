/*
 * @Author: aponder
 * @Date: 2020-04-11 10:59:02
 * @LastEditors: aponder
 * @LastEditTime: 2020-04-11 11:57:19
 * @FilePath: /leetcode-zh/easy/108.将有序数组转换为二叉搜索树/Solution.java
 */
/*
 * @lc app=leetcode.cn id=108 lang=java
 *
 * [108] 将有序数组转换为二叉搜索树
 *
 * https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/description/
 *
 * algorithms
 * Easy (70.15%)
 * Likes:    383
 * Dislikes: 0
 * Total Accepted:    60K
 * Total Submissions: 85.5K
 * Testcase Example:  '[-10,-3,0,5,9]'
 *
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 * 
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 * 
 * 示例:
 * 
 * 给定有序数组: [-10,-3,0,5,9],
 * 
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 * 
 * ⁠     0
 * ⁠    / \
 * ⁠  -3   9
 * ⁠  /   /
 * ⁠-10  5
 * 
 * 
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
    @Override
    public String toString() {
        return "" + val;
    }
}
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        int length = nums.length;
        return insertNode(nums, 0, length - 1);
    }

    TreeNode insertNode(int[] nums, int i, int j) {
        //   0  1  2  3  4
        // -10  3  0  5  9
        int c = (i + j + 1) / 2;
        if (i == j) {
            return new TreeNode(nums[j]);
        } else if (i > j) {
            return null;
        } else {
            TreeNode root = new TreeNode(nums[c]);
            root.left = insertNode(nums, i, c - 1);
            root.right = insertNode(nums, c + 1, j);
            return root;
        }
    }

    public static void main(String[] args) {
        new Solution().sortedArrayToBST(new int[]{-10,-3,0,5,9});
    }
}
// @lc code=end

// Accepted
// 32/32 cases passed (0 ms)
// Your runtime beats 100 % of java submissions
// Your memory usage beats 5.44 % of java submissions (39.7 MB)