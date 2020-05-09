/*
 * @Author: aponder
 * @Date: 2020-05-09 10:20:53
 * @LastEditors: aponder
 * @LastEditTime: 2020-05-09 10:40:19
 * @FilePath: /leetcode-zh/easy/404.左叶子之和/Solution.java
 */
/*
 * @lc app=leetcode.cn id=404 lang=java
 *
 * [404] 左叶子之和
 *
 * https://leetcode-cn.com/problems/sum-of-left-leaves/description/
 *
 * algorithms
 * Easy (54.34%)
 * Likes:    147
 * Dislikes: 0
 * Total Accepted:    23.9K
 * Total Submissions: 43.9K
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * 计算给定二叉树的所有左叶子之和。
 * 
 * 示例：
 * 
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 * 
 * 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
 * 
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
class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        return sumLeft(root, false);
    }

    int sumLeft(TreeNode node, boolean isLeft) {
        if (node == null) return 0;;
        
        int val = 0;
        if (isLeft && node.left == null && node.right == null) return node.val;
        else return sumLeft(node.left, true) + sumLeft(node.right, false);
    }
}
// @lc code=end

// Accepted
// 102/102 cases passed (0 ms)
// Your runtime beats 100 % of java submissions
// Your memory usage beats 5.26 % of java submissions (38 MB)