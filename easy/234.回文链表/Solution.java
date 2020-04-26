import java.util.Stack;

/*
 * @Author: aponder
 * @Date: 2020-04-26 12:50:12
 * @LastEditors: aponder
 * @LastEditTime: 2020-04-26 12:59:41
 * @FilePath: /leetcode-zh/easy/234.回文链表/Solution.java
 */
/*
 * @lc app=leetcode.cn id=234 lang=java
 *
 * [234] 回文链表
 *
 * https://leetcode-cn.com/problems/palindrome-linked-list/description/
 *
 * algorithms
 * Easy (41.26%)
 * Likes:    473
 * Dislikes: 0
 * Total Accepted:    82.4K
 * Total Submissions: 198.3K
 * Testcase Example:  '[1,2]'
 *
 * 请判断一个链表是否为回文链表。
 * 
 * 示例 1:
 * 
 * 输入: 1->2
 * 输出: false
 * 
 * 示例 2:
 * 
 * 输入: 1->2->2->1
 * 输出: true
 * 
 * 
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
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
    // 方法 1: 时间 O(n)，空间 O(n)
    public boolean isPalindrome(ListNode head) {
        if (head == null) return true;

        ListNode p1 = head, p2 = head;
        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
        }

        Stack<Integer> stack = new Stack<>();
        while (p1 != null) {
            stack.push(p1.val);
            p1 = p1.next;
        }

        p1 = head;
        while (!stack.empty()) {
            if (p1.val != stack.pop()) {
                return false;
            }
            p1 = p1.next;
        }

        return true;
    }   
}
// @lc code=end

// Accepted
// 26/26 cases passed (3 ms)
// Your runtime beats 40.19 % of java submissions
// Your memory usage beats 5.41 % of java submissions (43.5 MB)