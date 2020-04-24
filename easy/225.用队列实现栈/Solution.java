/*
 * @Author: aponder
 * @Date: 2020-04-24 11:36:59
 * @LastEditors: aponder
 * @LastEditTime: 2020-04-24 11:52:01
 * @FilePath: /leetcode-zh/easy/225.用队列实现栈/Solution.java
 */
import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=225 lang=java
 *
 * [225] 用队列实现栈
 *
 * https://leetcode-cn.com/problems/implement-stack-using-queues/description/
 *
 * algorithms
 * Easy (64.29%)
 * Likes:    165
 * Dislikes: 0
 * Total Accepted:    49.1K
 * Total Submissions: 76.1K
 * Testcase Example:  '["MyStack","push","push","top","pop","empty"]\n[[],[1],[2],[],[],[]]'
 *
 * 使用队列实现栈的下列操作：
 * 
 * 
 * push(x) -- 元素 x 入栈
 * pop() -- 移除栈顶元素
 * top() -- 获取栈顶元素
 * empty() -- 返回栈是否为空
 * 
 * 
 * 注意:
 * 
 * 
 * 你只能使用队列的基本操作-- 也就是 push to back, peek/pop from front, size, 和 is empty
 * 这些操作是合法的。
 * 你所使用的语言也许不支持队列。 你可以使用 list 或者 deque（双端队列）来模拟一个队列 , 只要是标准的队列操作即可。
 * 你可以假设所有操作都是有效的（例如, 对一个空的栈不会调用 pop 或者 top 操作）。
 * 
 * 
 */

// @lc code=start
class MyStack {
    Queue<Integer> queue = new LinkedList<>();
    /** Initialize your data structure here. */
    public MyStack() {

    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        Queue<Integer> temp = new LinkedList<>();
        Integer num = queue.poll();
        while (num != null) {
            temp.offer(num);
            num = queue.poll();
        }

        queue.offer(x);
        num = temp.poll();
        while (num != null) {
            queue.offer(num);
            num = temp.poll();
        }
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue.poll();
    }
    
    /** Get the top element. */
    public int top() {
        return queue.peek();
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
// @lc code=end

// Accepted
// 16/16 cases passed (0 ms)
// Your runtime beats 100 % of java submissions
// Your memory usage beats 7.41 % of java submissions (37.5 MB)