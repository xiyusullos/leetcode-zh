/*
 * @Author: aponder
 * @Date: 2020-06-04 20:52:48
 * @LastEditTime: 2020-06-04 20:54:24
 * @LastEditors: aponder
 * @Description: 
 * @FilePath: /leetcode-zh/easy/687.最长同值路径/Solution.java
 */ 
/*
 * @lc app=leetcode.cn id=687 lang=java
 *
 * [687] 最长同值路径
 *
 * https://leetcode-cn.com/problems/longest-univalue-path/description/
 *
 * algorithms
 * Easy (40.28%)
 * Likes:    274
 * Dislikes: 0
 * Total Accepted:    17.1K
 * Total Submissions: 42.6K
 * Testcase Example:  '[5,4,5,1,1,5]'
 *
 * 给定一个二叉树，找到最长的路径，这个路径中的每个节点具有相同值。 这条路径可以经过也可以不经过根节点。
 * 
 * 注意：两个节点之间的路径长度由它们之间的边数表示。
 * 
 * 示例 1:
 * 
 * 输入:
 * 
 * 
 * ⁠             5
 * ⁠            / \
 * ⁠           4   5
 * ⁠          / \   \
 * ⁠         1   1   5
 * 
 * 
 * 输出:
 * 
 * 
 * 2
 * 
 * 
 * 示例 2:
 * 
 * 输入:
 * 
 * 
 * ⁠             1
 * ⁠            / \
 * ⁠           4   5
 * ⁠          / \   \
 * ⁠         4   4   5
 * 
 * 
 * 输出:
 * 
 * 
 * 2
 * 
 * 
 * 注意: 给定的二叉树不超过10000个结点。 树的高度不超过1000。
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
    // public int longestUnivaluePath(TreeNode root) {

    // }

    int res = 0;
    public int longestUnivaluePath(TreeNode root) {
        helper(root);
        return res;
    }
    
    int helper(TreeNode root){
        if(root == null) return 0;
        
        int left = helper(root.left);
        int right = helper(root.right);
        
        left = (root.left != null && root.left.val == root.val) ? left + 1 : 0;
        right = (root.right != null && root.right.val == root.val) ? right + 1 : 0;
        
        res = Math.max(res, left + right);
        return Math.max(left, right);
    }
}
// @lc code=end

// Accepted
// 71/71 cases passed (3 ms)
// Your runtime beats 88.77 % of java submissions
// Your memory usage beats 12.5 % of java submissions (42.6 MB)