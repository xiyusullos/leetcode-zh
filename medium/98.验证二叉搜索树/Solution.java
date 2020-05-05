/*
 * @Author: aponder
 * @Date: 2020-05-05 14:34:05
 * @LastEditors: aponder
 * @LastEditTime: 2020-05-05 15:12:22
 * @FilePath: /leetcode-zh/medium/98.验证二叉搜索树/Solution.java
 */
/*
 * @lc app=leetcode.cn id=98 lang=java
 *
 * [98] 验证二叉搜索树
 *
 * https://leetcode-cn.com/problems/validate-binary-search-tree/description/
 *
 * algorithms
 * Medium (29.64%)
 * Likes:    552
 * Dislikes: 0
 * Total Accepted:    106.6K
 * Total Submissions: 348.5K
 * Testcase Example:  '[2,1,3]'
 *
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * 
 * 假设一个二叉搜索树具有如下特征：
 * 
 * 
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 
 * 
 * 示例 1:
 * 
 * 输入:
 * ⁠   2
 * ⁠  / \
 * ⁠ 1   3
 * 输出: true
 * 
 * 
 * 示例 2:
 * 
 * 输入:
 * ⁠   5
 * ⁠  / \
 * ⁠ 1   4
 *     / \
 *     3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 * 根节点的值为 5 ，但是其右子节点值为 4 。
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
    TreeNode(int x, TreeNode l, TreeNode r) {
        val = x;
        left = l;
		right = r;
    }
}
class Solution {
    Integer previous = null;
    public boolean isValidBST(TreeNode root) {
        // // [5,3,7,1,6,null,null]
        // // ⁠    5
        // // ⁠   / \
        // // ⁠  3   7
        // //  / \
        // // 1   6
        // if (root == null) return true;
        // else {
        //     boolean l = root.left == null || root.left != null && root.left.val < root.val;
        //     boolean r = root.right == null || root.right != null && root.right.val > root.val;

        //     return l && r && isValidBST(root.left) && isValidBST(root.right);
        // }
        if (root == null) return true;
        return inOrder(root);
    }

    boolean inOrder(TreeNode node) {
        boolean l = node.left == null || inOrder(node.left);
        if (previous != null && node.val <= previous) return false;
        previous = node.val;
        boolean r = node.right == null || inOrder(node.right);
        return l && r;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(
            5,
            new TreeNode(3, new TreeNode(1), new TreeNode(6)),
            new TreeNode(7)
        );
        new Solution().isValidBST(root);
    }
}
// @lc code=end

// Accepted
// 75/75 cases passed (0 ms)
// Your runtime beats 100 % of java submissions
// Your memory usage beats 5.8 % of java submissions (39.8 MB)