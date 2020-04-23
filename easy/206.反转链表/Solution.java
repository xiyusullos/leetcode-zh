/*
 * @Author: aponder
 * @Date: 2020-04-23 12:23:50
 * @LastEditors: aponder
 * @LastEditTime: 2020-04-23 12:40:54
 * @FilePath: /leetcode-zh/easy/206.反转链表/Solution.java
 */
/*
 * @lc app=leetcode.cn id=206 lang=java
 *
 * [206] 反转链表
 *
 * https://leetcode-cn.com/problems/reverse-linked-list/description/
 *
 * algorithms
 * Easy (68.35%)
 * Likes:    915
 * Dislikes: 0
 * Total Accepted:    219.6K
 * Total Submissions: 320K
 * Testcase Example:  '[1,2,3,4,5]'
 *
 * 反转一个单链表。
 * 
 * 示例:
 * 
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
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
    // 方法 1: 迭代
    // public ListNode reverseList(ListNode head) {
    //     ListNode p = head;
    //     ListNode node = null;
    //     while (p != null) {
    //         ListNode temp = p.next;
    //         p.next = node;
    //         node = p;
    //         p = temp;
    //     }
    //     return node;
    // }

    // 方法 2: 递归
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode temp = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return temp;
    }
}
// @lc code=end

// 方法 1: 迭代
// Accepted
// 27/27 cases passed (0 ms)
// Your runtime beats 100 % of java submissions
// Your memory usage beats 5.06 % of java submissions (39.6 MB)

// 方法 2: 递归
// Accepted
// 27/27 cases passed (0 ms)
// Your runtime beats 100 % of java submissions
// Your memory usage beats 5.06 % of java submissions (39.9 MB)