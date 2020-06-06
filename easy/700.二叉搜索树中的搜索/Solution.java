/*
 * @Author: aponder
 * @Date: 2020-06-06 13:11:31
 * @LastEditTime: 2020-06-06 13:13:55
 * @LastEditors: aponder
 * @Description: 
 * @FilePath: /leetcode-zh/easy/700.二叉搜索树中的搜索/Solution.java
 */ 
/*
 * @lc app=leetcode.cn id=700 lang=java
 *
 * [700] 二叉搜索树中的搜索
 *
 * https://leetcode-cn.com/problems/search-in-a-binary-search-tree/description/
 *
 * algorithms
 * Easy (73.63%)
 * Likes:    60
 * Dislikes: 0
 * Total Accepted:    25.2K
 * Total Submissions: 34.2K
 * Testcase Example:  '[4,2,7,1,3]\n2'
 *
 * 给定二叉搜索树（BST）的根节点和一个值。 你需要在BST中找到节点值等于给定值的节点。 返回以该节点为根的子树。 如果节点不存在，则返回 NULL。
 * 
 * 例如，
 * 
 * 
 * 给定二叉搜索树:
 * 
 * ⁠       4
 * ⁠      / \
 * ⁠     2   7
 * ⁠    / \
 * ⁠   1   3
 * 
 * 和值: 2
 * 
 * 
 * 你应该返回如下子树:
 * 
 * 
 * ⁠     2     
 * ⁠    / \   
 * ⁠   1   3
 * 
 * 
 * 在上述示例中，如果要找的值是 5，但因为没有节点值为 5，我们应该返回 NULL。
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
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null;

        if (root.val == val) return root;

        if (val < root.val) return searchBST(root.left, val);
        if (val > root.val) return searchBST(root.right, val);

        return null;
    }
}
// @lc code=end

// Accepted
// 36/36 cases passed (0 ms)
// Your runtime beats 100 % of java submissions
// Your memory usage beats 9.09 % of java submissions (40.1 MB)