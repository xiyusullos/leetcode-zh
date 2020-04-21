/*
 * @Author: aponder
 * @Date: 2020-04-21 10:20:08
 * @LastEditors: aponder
 * @LastEditTime: 2020-04-21 10:26:40
 * @FilePath: /leetcode-zh/easy/203.移除链表元素/Solution.java
 */
/*
 * @lc app=leetcode.cn id=203 lang=java
 *
 * [203] 移除链表元素
 *
 * https://leetcode-cn.com/problems/remove-linked-list-elements/description/
 *
 * algorithms
 * Easy (44.88%)
 * Likes:    373
 * Dislikes: 0
 * Total Accepted:    72.2K
 * Total Submissions: 160K
 * Testcase Example:  '[1,2,6,3,4,5,6]\n6'
 *
 * 删除链表中等于给定值 val 的所有节点。
 * 
 * 示例:
 * 
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 * 
 * 
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode p = dummy;
        while (p != null && p.next != null) {
            if (p.next.val == val) p.next = p.next.next;
            else p = p.next;
        }
        return dummy.next;
    }
}
// @lc code=end

// Accepted
// 65/65 cases passed (1 ms)
// Your runtime beats 99.91 % of java submissions
// Your memory usage beats 6.25 % of java submissions (40.8 MB)