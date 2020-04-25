/*
 * @Author: aponder
 * @Date: 2020-04-25 11:04:22
 * @LastEditors: aponder
 * @LastEditTime: 2020-04-25 11:08:51
 * @FilePath: /leetcode-zh/easy/226.翻转二叉树/Solution.java
 */
/*
 * @lc app=leetcode.cn id=226 lang=java
 *
 * [226] 翻转二叉树
 *
 * https://leetcode-cn.com/problems/invert-binary-tree/description/
 *
 * algorithms
 * Easy (74.63%)
 * Likes:    414
 * Dislikes: 0
 * Total Accepted:    72.1K
 * Total Submissions: 96.3K
 * Testcase Example:  '[4,2,7,1,3,6,9]'
 *
 * 翻转一棵二叉树。
 * 
 * 示例：
 * 
 * 输入：
 * 
 * ⁠    4
 * ⁠  /   \
 * ⁠ 2     7
 * ⁠/ \   / \
 * 1   3 6   9
 * 
 * 输出：
 * 
 * ⁠    4
 * ⁠  /   \
 * ⁠ 7     2
 * ⁠/ \   / \
 * 9   6 3   1
 * 
 * 备注:
 * 这个问题是受到 Max Howell 的 原问题 启发的 ：
 * 
 * 谷歌：我们90％的工程师使用您编写的软件(Homebrew)，但是您却无法在面试时在白板上写出翻转二叉树这道题，这太糟糕了。
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
    public TreeNode invertTree(TreeNode root) {
        swapChildren(root);
        return root;
    }

    void swapChildren(TreeNode tree) {
        if (tree == null) return;
        TreeNode node = tree.left;
        tree.left = tree.right;
        tree.right = node;
        swapChildren(tree.left);
        swapChildren(tree.right);
    }
}
// @lc code=end

// Accepted
// 68/68 cases passed (0 ms)
// Your runtime beats 100 % of java submissions
// Your memory usage beats 6 % of java submissions (37.2 MB)