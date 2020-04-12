/*
 * @Author: aponder
 * @Date: 2020-04-12 14:16:56
 * @LastEditors: aponder
 * @LastEditTime: 2020-04-12 14:40:00
 * @FilePath: /leetcode-zh/easy/111.二叉树的最小深度/Solution.java
 */
/*
 * @lc app=leetcode.cn id=111 lang=java
 *
 * [111] 二叉树的最小深度
 *
 * https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/description/
 *
 * algorithms
 * Easy (41.93%)
 * Likes:    241
 * Dislikes: 0
 * Total Accepted:    65.5K
 * Total Submissions: 156K
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * 给定一个二叉树，找出其最小深度。
 * 
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * 
 * 说明: 叶子节点是指没有子节点的节点。
 * 
 * 示例:
 * 
 * 给定二叉树 [3,9,20,null,null,15,7],
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 * 
 * 返回它的最小深度  2.
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
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int l = minDepth(root.left);
        int r = minDepth(root.right);
        if (l == 0) {return 1 + r;}
        else if (r == 0) {return 1 + l;};
        return 1 + Math.min(l, r);
        
    }
}
// @lc code=end

// Accepted
// 41/41 cases passed (0 ms)
// Your runtime beats 100 % of java submissions
// Your memory usage beats 5.55 % of java submissions (39.7 MB)