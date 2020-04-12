/*
 * @Author: aponder
 * @Date: 2020-04-12 14:41:29
 * @LastEditors: aponder
 * @LastEditTime: 2020-04-12 14:52:45
 * @FilePath: /leetcode-zh/easy/112.路径总和/Solution.java
 */
/*
 * @lc app=leetcode.cn id=112 lang=java
 *
 * [112] 路径总和
 *
 * https://leetcode-cn.com/problems/path-sum/description/
 *
 * algorithms
 * Easy (49.33%)
 * Likes:    275
 * Dislikes: 0
 * Total Accepted:    66.6K
 * Total Submissions: 134.7K
 * Testcase Example:  '[5,4,8,11,null,13,4,7,2,null,null,null,1]\n22'
 *
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 * 
 * 说明: 叶子节点是指没有子节点的节点。
 * 
 * 示例: 
 * 给定如下二叉树，以及目标和 sum = 22，
 * 
 * ⁠             5
 * ⁠            / \
 * ⁠           4   8
 * ⁠          /   / \
 * ⁠         11  13  4
 * ⁠        /  \      \
 * ⁠       7    2      1
 * 
 * 
 * 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
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
class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        // if (root.val > sum) {
        //     return false;
        // } else 
        // val 可能为负数
        if (root.val == sum && isLeaf(root)) {
            return true;
        } else {
            boolean l = hasPathSum(root.left, sum - root.val);
            if (l) {return true;}
            boolean r = hasPathSum(root.right, sum - root.val);
            if (r) {return true;}
        }

        return false;
    }

    boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }
}
// @lc code=end

// Accepted
// 114/114 cases passed (0 ms)
// Your runtime beats 100 % of java submissions
// Your memory usage beats 5.71 % of java submissions (39.8 MB)