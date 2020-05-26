/*
 * @Author: aponder
 * @Date: 2020-05-26 23:42:40
 * @LastEditTime: 2020-05-26 23:45:43
 * @LastEditors: aponder
 * @Description: 
 * @FilePath: /leetcode-zh/easy/563.二叉树的坡度/Solution.java
 */ 
/*
 * @lc app=leetcode.cn id=563 lang=java
 *
 * [563] 二叉树的坡度
 *
 * https://leetcode-cn.com/problems/binary-tree-tilt/description/
 *
 * algorithms
 * Easy (53.95%)
 * Likes:    67
 * Dislikes: 0
 * Total Accepted:    12.2K
 * Total Submissions: 22K
 * Testcase Example:  '[1,2,3]'
 *
 * 给定一个二叉树，计算整个树的坡度。
 * 
 * 一个树的节点的坡度定义即为，该节点左子树的结点之和和右子树结点之和的差的绝对值。空结点的的坡度是0。
 * 
 * 整个树的坡度就是其所有节点的坡度之和。
 * 
 * 示例:
 * 
 * 
 * 输入: 
 * ⁠        1
 * ⁠      /   \
 * ⁠     2     3
 * 输出: 1
 * 解释: 
 * 结点的坡度 2 : 0
 * 结点的坡度 3 : 0
 * 结点的坡度 1 : |2-3| = 1
 * 树的坡度 : 0 + 0 + 1 = 1
 * 
 * 
 * 注意:
 * 
 * 
 * 任何子树的结点的和不会超过32位整数的范围。
 * 坡度的值不会超过32位整数的范围。
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
    public int findTilt(TreeNode root) {
        postOrder(root);
        return tilt;
    }

    int tilt = 0;
    int postOrder(TreeNode root)
    {
        if(root==null )
            return 0;
        int left = postOrder(root.left);
        int right = postOrder(root.right);
        tilt += Math.abs(left - right);
        return left + right + root.val;
    }
}
// @lc code=end

// Accepted
// 75/75 cases passed (0 ms)
// Your runtime beats 100 % of java submissions
// Your memory usage beats 33.33 % of java submissions (39.8 MB)