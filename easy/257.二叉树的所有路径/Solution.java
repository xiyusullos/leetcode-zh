/*
 * @Author: aponder
 * @Date: 2020-04-28 09:29:57
 * @LastEditors: aponder
 * @LastEditTime: 2020-04-28 10:19:53
 * @FilePath: /leetcode-zh/easy/257.二叉树的所有路径/Solution.java
 */
import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=257 lang=java
 *
 * [257] 二叉树的所有路径
 *
 * https://leetcode-cn.com/problems/binary-tree-paths/description/
 *
 * algorithms
 * Easy (63.21%)
 * Likes:    248
 * Dislikes: 0
 * Total Accepted:    34K
 * Total Submissions: 53.5K
 * Testcase Example:  '[1,2,3,null,5]'
 *
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 * 
 * 说明: 叶子节点是指没有子节点的节点。
 * 
 * 示例:
 * 
 * 输入:
 * 
 * ⁠  1
 * ⁠/   \
 * 2     3
 * ⁠\
 * ⁠ 5
 * 
 * 输出: ["1->2->5", "1->3"]
 * 
 * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
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
    List<String> list = new ArrayList<>();

    // 方法 1
    // public List<String> binaryTreePaths(TreeNode root) {
    //     if (root == null) return list;
        
    //     String s = "" + root.val;
    //     if (root.left == null && root.right == null) {
    //         list.add(s);
    //     } else {
    //         if (root.left != null) leafPath(root.left, s);
    //         if (root.right != null) leafPath(root.right, s);
    //     }

    //     return list;
    // }

    // void leafPath(TreeNode node, String s) {
    //     if (node.left == null && node.right == null) {
    //         list.add(s + "->" + node.val);
    //     } else {
    //         s += "->" + node.val;
    //         if (node.left != null) leafPath(node.left, s);
    //         if (node.right != null) leafPath(node.right, s);
    //     }
    // }

    // 方法 2
    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) return list;
        
        StringBuilder sb = new StringBuilder();
        leafPath(root, sb);

        return list;
    }

    void leafPath(TreeNode node, StringBuilder sb) {
        if (node.left == null && node.right == null) {
            sb.append("->" + node.val);
            sb.delete(0, 2);
            list.add(sb.toString());
        } else {
            sb.append("->" + node.val);
            // System.out.println(sb.toString());
            if (node.left != null) leafPath(node.left, new StringBuilder(sb.toString()));
            if (node.right != null) leafPath(node.right, new StringBuilder(sb.toString()));
        }
    }
}
// @lc code=end

// 方法 1
// Accepted
// 209/209 cases passed (14 ms)
// Your runtime beats 15.07 % of java submissions
// Your memory usage beats 7.69 % of java submissions (40.2 MB)

// 方法 2
// Accepted
// 209/209 cases passed (8 ms)
// Your runtime beats 49.82 % of java submissions
// Your memory usage beats 7.69 % of java submissions (39.8 MB)