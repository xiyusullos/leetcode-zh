/*
 * @Author: aponder
 * @Date: 2020-04-09 08:55:26
 * @LastEditors: aponder
 * @LastEditTime: 2020-04-09 10:14:15
 * @FilePath: /leetcode-zh/easy/100.相同的树/Solution.java
 */

import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=100 lang=java
 *
 * [100] 相同的树
 *
 * https://leetcode-cn.com/problems/same-tree/description/
 *
 * algorithms
 * Easy (57.02%)
 * Likes:    340
 * Dislikes: 0
 * Total Accepted:    77.2K
 * Total Submissions: 135.3K
 * Testcase Example:  '[2,2,3]\n[1,2,3]'2 *
 * 给定两个二叉树，编写一个函数来检验它们是否相同。
 * 
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 * 
 * 示例 1:
 * 
 * 输入:       1         1
 * ⁠         / \       / \
 * ⁠        2   3     2   3
 * 
 * ⁠       [1,2,3],   [1,2,3]
 * 
 * 输出: true
 * 
 * 示例 2:
 * 
 * 输入:      1          1
 * ⁠         /           \
 * ⁠        2             2
 * 
 * ⁠       [1,2],     [1,null,2]
 * 
 * 输出: false
 * 
 * 
 * 示例 3:
 * 
 * 输入:       1         1
 * ⁠         / \       / \
 * ⁠        2   1     1   2
 * 
 * ⁠       [1,2,1],   [1,1,2]
 * 
 * 输出: false
 * 
 * 
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if ((p == null) != (q == null)) {
            return false;
        }

        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        queue1.offer(p);
        queue2.offer(q);
        while (true) {
            // 一个为空，另一个非空，返回不相同
            if (queue1.isEmpty() != queue2.isEmpty()) {
                return false;
            }

            if (queue1.isEmpty() && queue2.isEmpty()) {
                break;
            }

            if ((p.right == null) != (q.right == null) || (p.left == null) != (q.left == null)) {
                return false;
            }

            // 左右孩子节点放入队列
            if (p.right != null) {queue1.offer(p.right);}
            if (p.left != null) {queue1.offer(p.left);}
            if (q.right != null) {queue2.offer(q.right);}
            if (q.left != null) {queue2.offer(q.left);}

            // queue1.offer(p.right);
            // queue1.offer(p.left);
            // queue2.offer(q.right);
            // queue2.offer(q.left);

            p = queue1.poll();
            q = queue2.poll();
            if ((p == null) != (q == null)) {
                return false;
            }
            if (p != null && q != null && p.val != q.val) {
                return false;
            }
        }

        return true;
    }
}
// @lc code=end

// Accepted
// 57/57 cases passed (0 ms)
// Your runtime beats 100 % of java submissions
// Your memory usage beats 5.06 % of java submissions (37.2 MB)