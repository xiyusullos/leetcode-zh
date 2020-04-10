/*
 * @Author: aponder
 * @Date: 2020-04-10 10:42:16
 * @LastEditors: aponder
 * @LastEditTime: 2020-04-10 12:00:29
 * @FilePath: /leetcode-zh/easy/107.二叉树的层次遍历-ii/Solution.java
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=107 lang=java
 *
 * [107] 二叉树的层次遍历 II
 *
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/description/
 *
 * algorithms
 * Easy (64.72%)
 * Likes:    216
 * Dislikes: 0
 * Total Accepted:    51K
 * Total Submissions: 78.7K
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 * 
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 * 
 * 
 * 返回其自底向上的层次遍历为：
 * 
 * [
 * ⁠ [15,7],
 * ⁠ [9,20],
 * ⁠ [3]
 * ]
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
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
// class TreeNode2 extends TreeNode {
//     int h;
//     TreeNode2(TreeNode node, int h) {
//         this.val = node.val;
//     }
// }
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        q1.offer(root);
        q2.offer(1);
        int lastLevel = 0;
        while (true) {
            if (q1.isEmpty()) {
                break;
            }

            TreeNode node = q1.poll();
            Integer l = q2.poll();
            if (lastLevel != l) {
                lastLevel = l;
                list.add(0, new ArrayList<>(){
                    {
                        add(node.val);
                    }
                });
            } else {
                list.get(0).add(node.val);
            }

            // if (!isLeaf(node)) {
                if (node.left != null) {
                    q1.offer(node.left);
                    q2.offer(l + 1);
                }
                if (node.right != null) {
                    q1.offer(node.right);
                    q2.offer(l + 1);
                }
            // }
        }

        return list;
    }

    boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }
}
// @lc code=end

// Accepted
// 34/34 cases passed (2 ms)
// Your runtime beats 35.68 % of java submissions
// Your memory usage beats 6.2 % of java submissions (39.6 MB)