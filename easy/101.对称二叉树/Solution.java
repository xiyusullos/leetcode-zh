import java.util.LinkedList;
import java.util.Queue;

/*
 * @Author: aponder
 * @Date: 2020-04-09 10:16:47
 * @LastEditors: aponder
 * @LastEditTime: 2020-04-09 11:42:46
 * @FilePath: /leetcode-zh/easy/101.对称二叉树/Solution.java
 */
/*
 * @lc app=leetcode.cn id=101 lang=java
 *
 * [101] 对称二叉树
 *
 * https://leetcode-cn.com/problems/symmetric-tree/description/
 *
 * algorithms
 * Easy (50.67%)
 * Likes:    708
 * Dislikes: 0
 * Total Accepted:    119.5K
 * Total Submissions: 235.6K
 * Testcase Example:  '[1,2,2,3,4,4,3]'
 *
 * 给定一个二叉树，检查它是否是镜像对称的。
 * 
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 * 
 * ⁠   1
 * ⁠  / \
 * ⁠ 2   2
 * ⁠/ \ / \
 * 3  4 4  3
 * 
 * 
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 * 
 * ⁠   1
 * ⁠  / \
 * ⁠ 2   2
 * ⁠  \   \
 * ⁠  3    3
 * 
 * 
 * 说明:
 * 
 * 如果你可以运用递归和迭代两种方法解决这个问题，会很加分。
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
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
class Solution {
    // // 递归法
    // public boolean isSymmetric(TreeNode root) {
    //     if (root == null) {
    //         return true;
    //     }
    //     // 一边有，一边没有
    //     if ((root.left == null) != (root.right == null)) {
    //         return false;
    //     }
        
    //     // 两边都有
    //     return isSymmetric(root.left, root.right);
    // }

    // boolean isSymmetric(TreeNode l, TreeNode r) {
    //     if (l == null && r == null) {
    //         return true;
    //     }
    //     if ((l == null) != (r == null)) {
    //         return false;
    //     }

    //     boolean flag = l.val == r.val;
    //     return flag && isSymmetric(l.left, r.right) && isSymmetric(l.right, r.left);
    // }

    // 迭代法
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        // 一边有，一边没有
        if ((root.left == null) != (root.right == null)) {
            return false;
        }
        
        // 两边都有
        Queue<TreeNode> queueLeft = new LinkedList<>();
        Queue<TreeNode> queueRight = new LinkedList<>();
        queueLeft.offer(root.left);
        queueRight.offer(root.right);
        TreeNode left, right;
        while (true) {
            if (queueLeft.isEmpty() != queueRight.isEmpty()) {
                return false;
            }

            if (queueLeft.isEmpty() && queueRight.isEmpty()) {
                break;
            }

            left = queueLeft.poll();
            right = queueRight.poll();

            // 一边有，一边没有
            if ((left == null) != (right == null)) {
                return false;
            }
            // 节点非空
            if (left != null && right != null) {
                // 数值不相等
                if (left.val != right.val) {
                    return false;
                }
                
                // 非叶子节点
                boolean isNotSame = false; // left 和 right 中，是否其中一个为叶子节点，另一个为非叶子节点
                if (left.left != null || left.right != null) {
                    queueLeft.offer(left.left);
                    queueLeft.offer(left.right);
                    isNotSame = !isNotSame;
                }
                if (right.left != null || right.right != null) {
                    queueRight.offer(right.right);
                    queueRight.offer(right.left);
                    isNotSame = !isNotSame;
                }

                if (isNotSame) {
                    return false;
                }
            }
        }
        return true;
    }
}
// @lc code=end

// 递归
// Accepted
// 195/195 cases passed (1 ms)
// Your runtime beats 45.9 % of java submissions
// Your memory usage beats 41.6 % of java submissions (37.7 MB)

// 迭代法
// Accepted
// 195/195 cases passed (1 ms)
// Your runtime beats 45.9 % of java submissions
// Your memory usage beats 9.64 % of java submissions (39.2 MB)