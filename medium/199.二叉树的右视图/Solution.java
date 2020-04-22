/*
 * @Author: aponder
 * @Date: 2020-04-22 23:12:07
 * @LastEditors: aponder
 * @LastEditTime: 2020-04-22 23:44:07
 * @FilePath: /leetcode-zh/medium/199.二叉树的右视图/Solution.java
 */
import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=199 lang=java
 *
 * [199] 二叉树的右视图
 *
 * https://leetcode-cn.com/problems/binary-tree-right-side-view/description/
 *
 * algorithms
 * Medium (63.94%)
 * Likes:    214
 * Dislikes: 0
 * Total Accepted:    41.3K
 * Total Submissions: 64.9K
 * Testcase Example:  '[1,2,3,null,5,null,4]'
 *
 * 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 * 
 * 示例:
 * 
 * 输入: [1,2,3,null,5,null,4]
 * 输出: [1, 3, 4]
 * 解释:
 * 
 * ⁠  1            <---
 * ⁠/   \
 * 2     3         <---
 * ⁠\     \
 * ⁠ 5     4       <---
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
    // public List<Integer> rightSideView(TreeNode root) {
    //     TreeNode p = root;
    //     List<Integer> l = new ArrayList<>();
    //     while (p != null) {
    //         l.add(p.val);
    //         p = next(p);
    //     }
    //     return l;
    // }

    // TreeNode next(TreeNode node) {
    //     if (node == null) {
    //         return null;
    //     }
    //     if (node.right == null) {
    //         return node.left;
    //     } else {
    //         return node.right;
    //     }
    // }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> l = new ArrayList<>();
        if (root == null) {
            return l;
        }

        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        TreeNode p, lastP = root;
        int h = 0; // tree height
        int lastH = 1;
        q1.offer(root);
        q2.offer(1);
        while (!q1.isEmpty()) {
            p = q1.poll();
            h = q2.poll();

            if (p == null) break;

            if (p.left != null) {
                q1.offer(p.left);
                q2.offer(h + 1);
            }
            if (p.right != null) {
                q1.offer(p.right);
                q2.offer(h + 1);
            }
            if (h != lastH) {
                l.add(lastP.val);
            } else {

            }
            lastP = p;
            lastH = h;
        }
        l.add(lastP.val);

        return l;
    }
}
// @lc code=end

// Accepted
// 211/211 cases passed (2 ms)
// Your runtime beats 31.17 % of java submissions
// Your memory usage beats 5 % of java submissions (38.2 MB)