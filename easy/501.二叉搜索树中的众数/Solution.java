/*
 * @Author: aponder
 * @Date: 2020-05-19 16:11:45
 * @LastEditTime: 2020-05-19 16:48:27
 * @LastEditors: aponder
 * @Description: 
 * @FilePath: /leetcode-zh/easy/501.二叉搜索树中的众数/Solution.java
 */ 
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=501 lang=java
 *
 * [501] 二叉搜索树中的众数
 *
 * https://leetcode-cn.com/problems/find-mode-in-binary-search-tree/description/
 *
 * algorithms
 * Easy (44.20%)
 * Likes:    105
 * Dislikes: 0
 * Total Accepted:    13.3K
 * Total Submissions: 29.7K
 * Testcase Example:  '[1,null,2,2]'
 *
 * 给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。
 * 
 * 假定 BST 有如下定义：
 * 
 * 
 * 结点左子树中所含结点的值小于等于当前结点的值
 * 结点右子树中所含结点的值大于等于当前结点的值
 * 左子树和右子树都是二叉搜索树
 * 
 * 
 * 例如：
 * 给定 BST [1,null,2,2],
 * 
 * ⁠  1
 * ⁠   \
 * ⁠    2
 * ⁠   /
 * ⁠  2
 * 
 * 
 * 返回[2].
 * 
 * 提示：如果众数超过1个，不需考虑输出顺序
 * 
 * 进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内）
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
    List<Integer> modes = new ArrayList<>();
    Map<Integer, Integer> map = new HashMap<>();
    int count = 0;
    int maxCount = 0;
    public int[] findMode(TreeNode root) {
        inOrder(root);

        for (Integer k : map.keySet()) {
            if (map.get(k) == maxCount) modes.add(k);
        }
        int[] result = new int[modes.size()];
        int i = 0;
        for (int mode : modes) {
            result[i++] = mode;
        }
        return result;
    }

    void inOrder(TreeNode node) {
        if (node != null) {
            count = 1 + map.getOrDefault(node.val, 0);
            if (count > maxCount) maxCount = count;
            map.put(node.val, count);
            inOrder(node.left);
            inOrder(node.right);
        }
    }
}
// @lc code=end

// Accepted
// 25/25 cases passed (6 ms)
// Your runtime beats 26.03 % of java submissions
// Your memory usage beats 9.52 % of java submissions (41.8 MB)