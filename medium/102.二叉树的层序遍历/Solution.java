/*
 * @Author: aponder
 * @Date: 2020-05-13 13:54:52
 * @LastEditors: aponder
 * @LastEditTime: 2020-05-13 14:08:28
 * @FilePath: /leetcode-zh/medium/102.二叉树的层序遍历/Solution.java
 */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=102 lang=java
 *
 * [102] 二叉树的层序遍历
 *
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/description/
 *
 * algorithms
 * Medium (61.37%)
 * Likes:    487
 * Dislikes: 0
 * Total Accepted:    124.5K
 * Total Submissions: 199K
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 * 
 * 
 * 
 * 示例：
 * 二叉树：[3,9,20,null,null,15,7],
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 * 
 * 
 * 返回其层次遍历结果：
 * 
 * [
 * ⁠ [3],
 * ⁠ [9,20],
 * ⁠ [15,7]
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
class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        bfs(root, 0);

        return result;
    }

    void bfs(TreeNode node, int depth) {
        if (node == null) return;
        
        // 该高度的节点还未遍历到
        if (result.size() == depth) {
            result.add(new ArrayList<>(){{add(node.val);}});
        } else {
            result.get(depth).add(node.val);
        }

        bfs(node.left, 1 + depth);
        bfs(node.right, 1 + depth);
    }
}
// @lc code=end

// Accepted
// 34/34 cases passed (1 ms)
// Your runtime beats 91.3 % of java submissions
// Your memory usage beats 5.71 % of java submissions (39.5 MB)