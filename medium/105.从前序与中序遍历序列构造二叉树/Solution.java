/*
 * @Author: aponder
 * @Date: 2020-05-22 23:37:00
 * @LastEditTime: 2020-05-23 01:25:49
 * @LastEditors: aponder
 * @Description: 
 * @FilePath: /leetcode-zh/medium/105.从前序与中序遍历序列构造二叉树/Solution.java
 */ 
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=105 lang=java
 *
 * [105] 从前序与中序遍历序列构造二叉树
 *
 * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/
 *
 * algorithms
 * Medium (64.73%)
 * Likes:    496
 * Dislikes: 0
 * Total Accepted:    79.7K
 * Total Submissions: 119K
 * Testcase Example:  '[3,9,20,15,7]\n[9,3,15,20,7]'
 *
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 * 
 * 注意:
 * 你可以假设树中没有重复的元素。
 * 
 * 例如，给出
 * 
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 
 * 返回如下的二叉树：
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
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
    TreeNode(int x) { val = x; }
    @Override
    public String toString() {
        return String.valueOf(val);
    }
}
class Solution {
    // Map<Integer, Integer> preMap;
    Map<Integer, Integer> inMap;
    int[] preorder;
    int[] inorder;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // 前序遍历 先树根，再左孩子？再右孩子
        // 中序遍历 先左孩子，再树根，再右孩子
        int length = preorder.length;
        if (length == 0) return null;

        this.preorder = preorder;
        this.inorder = inorder;
        // preMap = new HashMap<>(length);
        inMap = new HashMap<>(length);
        for (int i = 0; i < length; i++) {
            // preMap.put(preorder[i], i);
            inMap.put(inorder[i], i);
        }
        
        return insert(0, length - 1, 0, length - 1);
    }

    TreeNode insert(int preI, int preJ, int inI, int inJ) {
        if (preI > preJ) return null;

        TreeNode root = new TreeNode(preorder[preI]);
        if (preI == preJ) return root;
            
        int inMid = inMap.get(preorder[preI]);
        int length = inMid - inI;
        root.left = insert(preI + 1, length + preI, inI, inMid - 1);
        root.right = insert(length + preI + 1, preJ, inMid + 1, inJ);

        return root;
    }

    public static void main(String[] args) {
        new Solution().buildTree(new int[]{3,9,20,15,7}, new int[]{9,3,15,20,7});
        // new Solution().buildTree(new int[]{1,2}, new int[]{2,1});
        // new Solution().buildTree(new int[]{1,2,3}, new int[]{3,2,1});
        // new Solution().buildTree(new int[]{1,2,3}, new int[]{2,3,1});
    }
}
// @lc code=end

// Accepted
// 203/203 cases passed (3 ms)
// Your runtime beats 78.73 % of java submissions
// Your memory usage beats 83.33 % of java submissions (39.4 MB)