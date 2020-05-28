/*
 * @Author: aponder
 * @Date: 2020-05-28 22:59:34
 * @LastEditTime: 2020-05-28 23:00:47
 * @LastEditors: aponder
 * @Description: 
 * @FilePath: /leetcode-zh/easy/590.n叉树的后序遍历/Solution.java
 */ 
/*
 * @lc app=leetcode.cn id=590 lang=java
 *
 * [590] N叉树的后序遍历
 *
 * https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/description/
 *
 * algorithms
 * Easy (72.80%)
 * Likes:    70
 * Dislikes: 0
 * Total Accepted:    23.5K
 * Total Submissions: 31.9K
 * Testcase Example:  '[1,null,3,2,4,null,5,6]'
 *
 * 给定一个 N 叉树，返回其节点值的后序遍历。
 * 
 * 例如，给定一个 3叉树 :
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 返回其后序遍历: [5,6,3,2,4,1].
 * 
 * 
 * 
 * 说明: 递归法很简单，你可以使用迭代法完成此题吗?
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
    List<Integer> list = new LinkedList<>();
    public List<Integer> postorder(Node root) {
        if (root != null) {
            for (Node child : root.children) {
                postorder(child);
            }
            list.add(root.val);
        }
        return list;
    }
}
// @lc code=end

// Accepted
// 37/37 cases passed (1 ms)
// Your runtime beats 97.78 % of java submissions
// Your memory usage beats 9.09 % of java submissions (40.8 MB)