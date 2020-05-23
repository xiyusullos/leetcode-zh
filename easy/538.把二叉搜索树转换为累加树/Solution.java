/*
 * @Author: aponder
 * @Date: 2020-05-23 11:16:02
 * @LastEditTime: 2020-05-23 11:49:22
 * @LastEditors: aponder
 * @Description: 
 * @FilePath: /leetcode-zh/easy/538.把二叉搜索树转换为累加树/Solution.java
 */ 
import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=538 lang=java
 *
 * [538] 把二叉搜索树转换为累加树
 *
 * https://leetcode-cn.com/problems/convert-bst-to-greater-tree/description/
 *
 * algorithms
 * Easy (60.06%)
 * Likes:    251
 * Dislikes: 0
 * Total Accepted:    25.7K
 * Total Submissions: 41.9K
 * Testcase Example:  '[5,2,13]'
 *
 * 给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater
 * Tree)，使得每个节点的值是原来的节点值加上所有大于它的节点值之和。
 * 
 * 
 * 
 * 例如：
 * 
 * 输入: 原始二叉搜索树:
 * ⁠             5
 * ⁠           /   \
 * ⁠          2     13
 * 
 * 输出: 转换为累加树:
 * ⁠            18
 * ⁠           /   \
 * ⁠         20     13
 * 
 * 
 * 
 * 
 * 注意：本题和 1038:
 * https://leetcode-cn.com/problems/binary-search-tree-to-greater-sum-tree/ 相同
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
    // public TreeNode convertBST(TreeNode root) {
    //     convertRight(root);
    //     convertLeft(root);

    //     return root;
    // }

    // int convertRight(TreeNode node) {
    //     if (node == null) return 0;

    //     node.val += convertRight(node.right);
    //     return node.val;
    // }

    // void convertLeft(TreeNode node) {
    //     if (node != null && node.left != null) {   
    //         TreeNode leftChild = node.left;
    //         leftChild.val += node.val + (leftChild.right != null ? leftChild.right.val : 0);

    //         if (node.left.right != null) {
    //             node.left.right.val += node.val;
    //         }

    //         convertLeft(leftChild);
    //     }
    // }

    List<Integer> list = new ArrayList<>();
    public TreeNode convertBST(TreeNode root) {
        preOrder1(root);
        accumalate();
        preOrder2(root);
        return root;
    }

    void preOrder1(TreeNode node) {
        if (node != null) {
            preOrder1(node.left);
            list.add(node.val);
            preOrder1(node.right);
        }
    }

    void accumalate() {
        for (int i = list.size() - 2; i > -1; i--) {
            list.set(i, list.get(i) + list.get(i + 1));
        }
    }

    int i = 0;
    void preOrder2(TreeNode node) {
        if (node != null) {
            preOrder2(node.left);
            node.val = list.get(i++);
            preOrder2(node.right);
        }
    }
}
// @lc code=end

// Accepted
// 212/212 cases passed (3 ms)
// Your runtime beats 12.75 % of java submissions
// Your memory usage beats 80 % of java submissions (39.7 MB)