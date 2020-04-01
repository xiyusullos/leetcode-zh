/*
 * @lc app=leetcode.cn id=21 lang=java
 *
 * [21] 合并两个有序链表
 *
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/description/
 *
 * algorithms
 * Easy (60.66%)
 * Likes:    918
 * Dislikes: 0
 * Total Accepted:    216.9K
 * Total Submissions: 357.4K
 * Testcase Example:  '[1,2,4]\n[1,3,4]'
 *
 * 将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 * 
 * 示例：
 * 
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode newList = new ListNode(0); // 头节点
        ListNode p1 = l1, p2 = l2, p3 = newList;

        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                p3.next = p1;
                p1 = p1.next;
            } else {
                p3.next = p2;
                p2 = p2.next;
            }
            p3 = p3.next;
        }
        // 如果l1有剩余，将l1全部加在newList后面
        if (p1 != null) {
            p3.next = p1;
        }
        // 如果l2有剩余，将l2全部加在newList后面
        if (p2 != null) {
            p3.next = p2;
        }

        // 忽略头结点
        return newList.next;
    }
}
// @lc code=end

// Accepted
// 208/208 cases passed (1 ms)
// Your runtime beats 76.75 % of java submissions
// Your memory usage beats 43.4 % of java submissions (39.7 MB)