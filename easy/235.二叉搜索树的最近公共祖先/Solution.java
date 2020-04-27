/*
 * @Author: aponder
 * @Date: 2020-04-27 09:53:43
 * @LastEditors: aponder
 * @LastEditTime: 2020-04-27 10:03:15
 * @FilePath: /leetcode-zh/easy/235.二叉搜索树的最近公共祖先/Solution.java
 */
/*
 * @lc app=leetcode.cn id=235 lang=java
 *
 * [235] 二叉搜索树的最近公共祖先
 *
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree/description/
 *
 * algorithms
 * Easy (63.06%)
 * Likes:    268
 * Dislikes: 0
 * Total Accepted:    51.3K
 * Total Submissions: 81.1K
 * Testcase Example:  '[6,2,8,0,4,7,9,null,null,3,5]\n2\n8'
 *
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 * 
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x
 * 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * 
 * 例如，给定如下二叉搜索树:  root = [6,2,8,0,4,7,9,null,null,3,5]
 * 
 * 
 * 
 * 
 * 
 * 示例 1:
 * 
 * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 * 输出: 6 
 * 解释: 节点 2 和节点 8 的最近公共祖先是 6。
 * 
 * 
 * 示例 2:
 * 
 * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
 * 输出: 2
 * 解释: 节点 2 和节点 4 的最近公共祖先是 2, 因为根据定义最近公共祖先节点可以为节点本身。
 * 
 * 
 * 
 * 说明:
 * 
 * 
 * 所有节点的值都是唯一的。
 * p、q 为不同节点且均存在于给定的二叉搜索树中。
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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // p 小， q 大
        if (p.val < q.val) {
            return sameAncestor(root, p, q);
        } else {
            return sameAncestor(root, q, p);
        }
    }

    TreeNode sameAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // p < q
        if (p.val <= root.val && root.val <= q.val) return root;
        else if (q.val < root.val) return sameAncestor(root.left, p, q);
        else return sameAncestor(root.right, p, q); // root.val < p.val
    }
}
// @lc code=end

// Accepted
// 27/27 cases passed (6 ms)
// Your runtime beats 99.86 % of java submissions
// Your memory usage beats 6.06 % of java submissions (40.2 MB)