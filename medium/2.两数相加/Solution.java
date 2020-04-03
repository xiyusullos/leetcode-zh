/*
 * @lc app=leetcode.cn id=2 lang=java
 *
 * [2] 两数相加
 *
 * https://leetcode-cn.com/problems/add-two-numbers/description/
 *
 * algorithms
 * Medium (36.97%)
 * Likes:    4100
 * Dislikes: 0
 * Total Accepted:    371.6K
 * Total Submissions: 1M
 * Testcase Example:  '[2,4,3]\n[5,6,4]'
 *
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 
 * 示例：
 * 
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;  // 进位值
        ListNode headNode = new ListNode(0);  // 此处不一定是 0 ，可以是任何值
        ListNode p = headNode;  // 新链表的指针
        ListNode p1 = l1, p2 = l2;  // l1, l2 的指针
        int t;

        // 每一位依次相加，并进位
        while (p1 != null && p2 != null) {
            t = p1.val + p2.val + carry;
            carry = t / 10;
            p.next = new ListNode(t % 10);
            p = p.next;
            p1 = p1.next;
            p2 = p2.next;
        }
        // 补下剩下的高位数
        ListNode p3 = p1;  // 假设 p1 还有高位
        if (p2 != null) {
            p3 = p2;
        }
        
        while (p3 != null) {
            t = p3.val + carry;
            carry = t / 10;
            p.next = new ListNode(t % 10);
            p = p.next;
            p3 = p3.next;
        }

        // 最高位是否还有进位
        if (carry != 0) {
            p.next = new ListNode(carry);
        }

        return headNode.next;
    }
}
// @lc code=end

// Accepted
// 1563/1563 cases passed (3 ms)
// Your runtime beats 36.83 % of java submissions
// Your memory usage beats 96.1 % of java submissions (39.6 MB)