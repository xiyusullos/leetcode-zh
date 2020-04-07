/*
 * @Author: aponder
 * @Date: 2020-04-07 17:10:25
 * @LastEditors: aponder
 * @LastEditTime: 2020-04-07 17:18:39
 * @FilePath: /leetcode-zh/easy/83.删除排序链表中的重复元素/Solution.java
 */
/*
 * @lc app=leetcode.cn id=83 lang=java
 *
 * [83] 删除排序链表中的重复元素
 *
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/description/
 *
 * algorithms
 * Easy (49.80%)
 * Likes:    284
 * Dislikes: 0
 * Total Accepted:    88.7K
 * Total Submissions: 178K
 * Testcase Example:  '[1,1,2]'
 *
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 * 
 * 示例 1:
 * 
 * 输入: 1->1->2
 * 输出: 1->2
 * 
 * 
 * 示例 2:
 * 
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        } 
        
        ListNode p = head;
        while (p.next != null) {
            if (p.next.val == p.val) {
                p.next = p.next.next;
            } else {
                p = p.next;
            }
        }
        return head;
    }
}
// @lc code=end

// Accepted
// 165/165 cases passed (1 ms)
// Your runtime beats 87.3 % of java submissions
// Your memory usage beats 5.12 % of java submissions (39.6 MB)