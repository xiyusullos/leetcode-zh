/*
 * @lc app=leetcode.cn id=23 lang=java
 *
 * [23] 合并K个排序链表
 *
 * https://leetcode-cn.com/problems/merge-k-sorted-lists/description/
 *
 * algorithms
 * Hard (49.70%)
 * Likes:    610
 * Dislikes: 0
 * Total Accepted:    106.9K
 * Total Submissions: 210.3K
 * Testcase Example:  '[[1,4,5],[1,3,4],[2,6]]'
 *
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 * 
 * 示例:
 * 
 * 输入:
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
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
    public ListNode mergeKLists(ListNode[] lists) {
        int k = lists.length;
        if (k == 0) return null;
        
        ListNode head = new ListNode(0);
        ListNode p = head;
        ListNode minNode = null;
        int minI = 0;
        int n = 0;
        while (n < k) {
            minNode = null;
            for (int i = 0; i < k; i++) {
                if (lists[i] != null) {
                    if (minNode == null) {
                        minNode = lists[i];
                        minI = i;
                    } else if (lists[i].val < minNode.val) {
                        minNode = lists[i];
                        minI = i;
                    }
                }
            }
            
            if (minNode == null) break;

            p.next = minNode;
            p = p.next;
            lists[minI] = lists[minI].next;
            if (lists[minI] == null) n++;
        }
        return head.next;
    }
}
// @lc code=end

// Accepted
// 131/131 cases passed (351 ms)
// Your runtime beats 6.77 % of java submissions
// Your memory usage beats 51.47 % of java submissions (41.7 MB)