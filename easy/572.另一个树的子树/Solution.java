/*
 * @Author: aponder
 * @Date: 2020-05-07 10:03:56
 * @LastEditors: aponder
 * @LastEditTime: 2020-05-07 10:27:34
 * @FilePath: /leetcode-zh/easy/572.另一个树的子树/Solution.java
 */
/*
 * @lc app=leetcode.cn id=572 lang=java
 *
 * [572] 另一个树的子树
 *
 * https://leetcode-cn.com/problems/subtree-of-another-tree/description/
 *
 * algorithms
 * Easy (44.16%)
 * Likes:    206
 * Dislikes: 0
 * Total Accepted:    23K
 * Total Submissions: 50.7K
 * Testcase Example:  '[3,4,5,1,2]\n[4,1,2]'
 *
 * 给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s
 * 也可以看做它自身的一棵子树。
 * 
 * 示例 1:
 * 给定的树 s:
 * 
 * 
 * ⁠    3
 * ⁠   / \
 * ⁠  4   5
 * ⁠ / \
 * ⁠1   2
 * 
 * 
 * 给定的树 t：
 * 
 * 
 * ⁠  4 
 * ⁠ / \
 * ⁠1   2
 * 
 * 
 * 返回 true，因为 t 与 s 的一个子树拥有相同的结构和节点值。
 * 
 * 示例 2:
 * 给定的树 s：
 * 
 * 
 * ⁠    3
 * ⁠   / \
 * ⁠  4   5
 * ⁠ / \
 * ⁠1   2
 * ⁠   /
 * ⁠  0
 * 
 * 
 * 给定的树 t：
 * 
 * 
 * ⁠  4
 * ⁠ / \
 * ⁠1   2
 * 
 * 
 * 返回 false。
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
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (t == null) return true;
        if (s == null) return false;

        return isSameTree(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    boolean isSameTree(TreeNode t1, TreeNode t2) {
        if ((t1 == null) != (t2 == null)) return false;
        
        if (t1 != null) {
            return t1.val == t2.val && isSameTree(t1.left, t2.left) && isSameTree(t1.right, t2.right);
        }
        
        return true;
    }
}
// @lc code=end

// Accepted
// 176/176 cases passed (8 ms)
// Your runtime beats 51.16 % of java submissions
// Your memory usage beats 40 % of java submissions (40.3 MB)