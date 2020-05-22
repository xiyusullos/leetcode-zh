/*
 * @Author: aponder
 * @Date: 2020-05-22 23:08:15
 * @LastEditTime: 2020-05-22 23:25:31
 * @LastEditors: aponder
 * @Description: 
 * @FilePath: /leetcode-zh/easy/530.二叉搜索树的最小绝对差/Solution.java
 */ 
/*
 * @lc app=leetcode.cn id=530 lang=java
 *
 * [530] 二叉搜索树的最小绝对差
 *
 * https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst/description/
 *
 * algorithms
 * Easy (56.18%)
 * Likes:    105
 * Dislikes: 0
 * Total Accepted:    15K
 * Total Submissions: 26.3K
 * Testcase Example:  '[1,null,3,2]'
 *
 * 给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。
 * 
 * 
 * 
 * 示例：
 * 
 * 输入：
 * 
 * ⁠  1
 * ⁠   \
 * ⁠    3
 * ⁠   /
 * ⁠  2
 * 
 * 输出：
 * 1
 * 
 * 解释：
 * 最小绝对差为 1，其中 2 和 1 的差的绝对值为 1（或者 2 和 3）。
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 树中至少有 2 个节点。
 * 本题与 783 https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/
 * 相同
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
    long previous = Integer.MIN_VALUE;
    long minimum = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        // 中序遍历
        inOrder(root);
        return (int) minimum;
    }

    void inOrder(TreeNode node) {
        if (node != null) {
            inOrder(node.left);
            minimum = Math.min(minimum, node.val - previous);
            previous = node.val;
            inOrder(node.right);
        }
    }
}
// @lc code=end

// Accepted
// 186/186 cases passed (1 ms)
// Your runtime beats 82.28 % of java submissions
// Your memory usage beats 75 % of java submissions (38.8 MB)