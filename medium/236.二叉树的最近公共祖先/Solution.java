/*
 * @Author: aponder
 * @Date: 2020-05-10 13:05:09
 * @LastEditors: aponder
 * @LastEditTime: 2020-05-10 22:18:43
 * @FilePath: /leetcode-zh/medium/236.二叉树的最近公共祖先/Solution.java
 */
/*
 * @lc app=leetcode.cn id=236 lang=java
 *
 * [236] 二叉树的最近公共祖先
 *
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/description/
 *
 * algorithms
 * Medium (61.15%)
 * Likes:    514
 * Dislikes: 0
 * Total Accepted:    71.7K
 * Total Submissions: 114.3K
 * Testcase Example:  '[3,5,1,6,2,0,8,null,null,7,4]\n5\n1'
 *
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * 
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x
 * 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * 
 * 例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]
 * 
 * 
 * 
 * 
 * 
 * 示例 1:
 * 
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出: 3
 * 解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
 * 
 * 
 * 示例 2:
 * 
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * 输出: 5
 * 解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
 * 
 * 
 * 
 * 
 * 说明:
 * 
 * 
 * 所有节点的值都是唯一的。
 * p、q 为不同节点且均存在于给定的二叉树中。
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

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    TreeNode(int x, TreeNode left, TreeNode right) {
        val = x;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return String.valueOf(val);
    }
}

class TreeNodeInfo {
    TreeNode node;
    TreeNodeInfo prev;
    TreeNodeInfo next;

    TreeNodeInfo(TreeNode node, TreeNodeInfo prev, TreeNodeInfo next) {
        this.node = node;
        this.prev = prev;
        this.next = next;
    }
    @Override
    public String toString() {
        if (node == null) {
            return "";
        } else {
            return node.toString();
        }
    }
}

// class Solution {
//     public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//         TreeNodeInfo l1 = findPath(root, p), l2 = findPath(root, q);
        
//         // 遍历2次
//         TreeNodeInfo p1 = l1, p2 = l2;
//         while (p1 != null) {
//             p2 = l2;
//             while (p2 != null) {
//                 if (p1.node == p2.node) return p1.node;
//                 p2 = p2.prev;
//             }
//             p1 = p1.prev;
//         }
//         return null;
//     }

//     TreeNodeInfo findPath(TreeNode root, TreeNode node) {
//         if (root == null)
//             return null;

//         TreeNodeInfo tni = new TreeNodeInfo(root, null, null);
//         if (root.val == node.val)
//             return tni;

//         TreeNodeInfo left = findPath(root.left, node);
//         if (left != null) {
//             left.prev = tni;
//             return left;
//         }
//         TreeNodeInfo right = findPath(root.right, node);
//         if (right != null) {
//             right.prev = tni;
//             return right;
//         }

//         return null;
//     }

//     public static void main(String[] args) {
//         TreeNode root = new TreeNode(
//             3,
//             new TreeNode(5, new TreeNode(6), new TreeNode(2, new TreeNode(7), new TreeNode(4))),
//             new TreeNode(1, new TreeNode(0), new TreeNode(8))
//         );
//         TreeNode p = new TreeNode(5);
//         TreeNode q = new TreeNode(4);

//         // TreeNode node = new Solution().lowestCommonAncestor(root, p, q);

//         TreeNodeInfo path = new Solution().findPath(root, q);
//         System.out.println(path);
//     }
// }

class Solution {

    private TreeNode ans;

    public Solution() {
        this.ans = null;
    }

    private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return false;
        boolean lson = dfs(root.left, p, q);
        boolean rson = dfs(root.right, p, q);
        if ((lson && rson) || ((root.val == p.val || root.val == q.val) && (lson || rson))) {
            ans = root;
        } 
        return lson || rson || (root.val == p.val || root.val == q.val);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.dfs(root, p, q);
        return this.ans;
    }
}

// @lc code=end

// Accepted
// 31/31 cases passed (7 ms)
// Your runtime beats 99.88 % of java submissions
// Your memory usage beats 5.71 % of java submissions (41.6 MB)