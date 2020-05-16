/*
 * @Author: aponder
 * @Date: 2020-05-16 20:41:06
 * @LastEditors: aponder
 * @LastEditTime: 2020-05-16 21:51:49
 * @FilePath: /leetcode-zh/hard/25.k-个一组翻转链表/Solution.java
 */
/*
 * @lc app=leetcode.cn id=25 lang=java
 *
 * [25] K 个一组翻转链表
 *
 * https://leetcode-cn.com/problems/reverse-nodes-in-k-group/description/
 *
 * algorithms
 * Hard (57.62%)
 * Likes:    543
 * Dislikes: 0
 * Total Accepted:    64.7K
 * Total Submissions: 107.2K
 * Testcase Example:  '[1,2,3,4,5]\n2'
 *
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * 
 * k 是一个正整数，它的值小于或等于链表的长度。
 * 
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * 
 * 
 * 
 * 示例：
 * 
 * 给你这个链表：1->2->3->4->5
 * 
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 * 
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 * 
 * 
 * 
 * 说明：
 * 
 * 
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
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
// class ListNode {
//     int val;
//     ListNode next;
//     ListNode(int x) { val = x; }
//     ListNode(int x, ListNode n) { val = x; next = n;}
//     @Override
//     public String toString() {
//         return String.valueOf(val);
//     }
// }
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k <= 1) return head;

        if (head == null) return head;

        int i = 0;
        ListNode p = head;
        ListNode head0 = p; // 每个分组的头结点
        ListNode newHead = null;
        ListNode tmp;
        ListNode front = null, rear = head;
        ListNode previousRear = null;
        ListNode reversed = null;
        boolean isEnough = false;
        while (p != null) {
            i++;
            tmp = p.next;
            p.next = front;
            front = p;
            // head0 = p.next;
            p = tmp;
            isEnough = false;
            if (i % k == 0) {
                if (i == k) newHead = front;
                else previousRear.next = front;
                rear.next = tmp;
                previousRear = rear;
                rear = rear.next;
                front = null;
                isEnough = true;
            }
        }
        if (!isEnough) {
            p = front;
            ListNode tmpFront = null;
            while (p != null) {
                tmp = p.next;
                p.next = tmpFront;
                tmpFront = p;
                p = tmp;
            }
            previousRear.next = tmpFront;
        }

        return newHead;
    }

    public static void main(String[] args) {
        // 1->2->3->4->5
        // 2->1->4->3->5
        ListNode root = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        new Solution().reverseKGroup(root, 3);
    }
}
// @lc code=end

// Accepted
// 62/62 cases passed (1 ms)
// Your runtime beats 57.31 % of java submissions
// Your memory usage beats 7.32 % of java submissions (39.8 MB)