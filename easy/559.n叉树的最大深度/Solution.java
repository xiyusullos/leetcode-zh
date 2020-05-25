/*
 * @Author: aponder
 * @Date: 2020-05-25 22:24:58
 * @LastEditTime: 2020-05-25 22:28:42
 * @LastEditors: aponder
 * @Description: 
 * @FilePath: /leetcode-zh/easy/559.n叉树的最大深度/Solution.java
 */ 
import javafx.scene.Node;

/*
 * @lc app=leetcode.cn id=559 lang=java
 *
 * [559] N叉树的最大深度
 *
 * https://leetcode-cn.com/problems/maximum-depth-of-n-ary-tree/description/
 *
 * algorithms
 * Easy (68.85%)
 * Likes:    87
 * Dislikes: 0
 * Total Accepted:    23.2K
 * Total Submissions: 33.4K
 * Testcase Example:  '[1,null,3,2,4,null,5,6]'
 *
 * 给定一个 N 叉树，找到其最大深度。
 * 
 * 最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。
 * 
 * 例如，给定一个 3叉树 :
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 我们应返回其最大深度，3。
 * 
 * 说明:
 * 
 * 
 * 树的深度不会超过 1000。
 * 树的节点总不会超过 5000。
 * 
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public int maxDepth(Node root) {
        if (root == null) return 0;
        int depth = 0;
        for (Node child : root.children) {
            int d = maxDepth(child);
            if (d > depth) depth = d;
        }
        return 1 + depth;
    }
}
// @lc code=end

// Accepted
// 37/37 cases passed (0 ms)
// Your runtime beats 100 % of java submissions
// Your memory usage beats 6.67 % of java submissions (40.2 MB)