/*
 * @Author: aponder
 * @Date: 2020-05-28 22:56:02
 * @LastEditTime: 2020-05-28 22:58:37
 * @LastEditors: aponder
 * @Description: 
 * @FilePath: /leetcode-zh/easy/589.n叉树的前序遍历/Solution.java
 */ 
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=589 lang=java
 *
 * [589] N叉树的前序遍历
 *
 * https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/description/
 *
 * algorithms
 * Easy (72.75%)
 * Likes:    78
 * Dislikes: 0
 * Total Accepted:    27.4K
 * Total Submissions: 37.4K
 * Testcase Example:  '[1,null,3,2,4,null,5,6]'
 *
 * 给定一个 N 叉树，返回其节点值的前序遍历。
 * 
 * 例如，给定一个 3叉树 :
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 返回其前序遍历: [1,3,5,6,2,4]。
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
    public List<Integer> preorder(Node root) {
        if (root != null) {
            list.add(root.val);
            for (Node child : root.children) {
                preorder(child);
            }
        }
        return list;
    }
}
// @lc code=end

// Accepted
// 37/37 cases passed (1 ms)
// Your runtime beats 97.55 % of java submissions
// Your memory usage beats 50 % of java submissions (40.3 MB)