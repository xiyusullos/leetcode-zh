/*
 * @Author: aponder
 * @Date: 2020-04-11 11:58:59
 * @LastEditors: aponder
 * @LastEditTime: 2020-04-11 12:54:32
 * @FilePath: /leetcode-zh/easy/110.平衡二叉树/Solution.java
 */
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
 * @lc app=leetcode.cn id=110 lang=java
 *
 * [110] 平衡二叉树
 *
 * https://leetcode-cn.com/problems/balanced-binary-tree/description/
 *
 * algorithms
 * Easy (51.02%)
 * Likes:    286
 * Dislikes: 0
 * Total Accepted:    65.2K
 * Total Submissions: 127.6K
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * 
 * 本题中，一棵高度平衡二叉树定义为：
 * 
 * 
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 * 
 * 
 * 示例 1:
 * 
 * 给定二叉树 [3,9,20,null,null,15,7]
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 * 
 * 返回 true 。
 * 
 * 示例 2:
 * 
 * 给定二叉树 [1,2,2,3,3,null,null,4,4]
 * 
 * ⁠      1
 * ⁠     / \
 * ⁠    2   2
 * ⁠   / \
 * ⁠  3   3
 * ⁠ / \
 * ⁠4   4
 * 
 * 
 * 返回 false 。
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
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        // if (isLeaf(root)) {
        //     return true;
        // }
        
        Queue<TreeNode> q1 = new LinkedList<>();
        // Stack<TreeNode> stack = new Stack<>();
        q1.offer(root);
        // stack.push(root);
        while (true) {
            if (q1.isEmpty()) {
                break;
            }

            TreeNode node = q1.poll();
            int d = height(node.left) - height(node.right);
            if (d > 1 || d < -1) {
                return false;
            }
            if (node.left != null) {
                q1.offer(node.left);
                // stack.push(node.left);
            }
            if (node.right != null) {
                q1.offer(node.right);
                // stack.push(node.right);
            }
        }

        // while (!stack.isEmpty()) {
        //     TreeNode node = stack.pop();
        //     int d = height(node.left) - height(node.right);
        //     if (d > 1 || d < -1) {
        //         return false;
        //     }
        // }

        return true;
    }

    int height(TreeNode root) {
        if (root == null) {
            return 0;
        } else if (isLeaf(root)) {
            return 1;
        } else {
            return 1 + Math.max(height(root.left), height(root.right));
        }
    }

    boolean isLeaf(TreeNode root) {
        return root.left == null && root.right == null;
    }
}
// @lc code=end

// Accepted
// 227/227 cases passed (2 ms)
// Your runtime beats 17.13 % of java submissions
// Your memory usage beats 22.88 % of java submissions (39.9 MB)