/*
 * @Author: aponder
 * @Date: 2020-04-15 12:41:57
 * @LastEditors: aponder
 * @LastEditTime: 2020-04-15 13:14:28
 * @FilePath: /leetcode-zh/easy/155.最小栈/Solution.java
 */
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/*
 * @lc app=leetcode.cn id=155 lang=java
 *
 * [155] 最小栈
 *
 * https://leetcode-cn.com/problems/min-stack/description/
 *
 * algorithms
 * Easy (52.37%)
 * Likes:    444
 * Dislikes: 0
 * Total Accepted:    92.1K
 * Total Submissions: 175.4K
 * Testcase Example:  '["MinStack","push","push","push","getMin","pop","top","getMin"]\n[[],[-2],[0],[-3],[],[],[],[]]'
 *
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 * 
 * 
 * push(x) —— 将元素 x 推入栈中。
 * pop() —— 删除栈顶的元素。
 * top() —— 获取栈顶元素。
 * getMin() —— 检索栈中的最小元素。
 * 
 * 
 * 示例:
 * 
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 * 
 * 
 */

// @lc code=start
// class MinStack {
//     Stack<Integer> stack = new Stack<>();
//     List<Integer> mins = new LinkedList<>();

//     /** initialize your data structure here. */
//     public MinStack() {
//     }
    
//     public void push(int x) {
//         stack.push(x);
//         int i = 0;
//         for (Integer min : mins) {
//             if (x <= min) { break; }
//             i++;
//         }
//         mins.add(i, x);
//     }
    
//     public void pop() {
//         int x = stack.pop();
//         int i = 0;
//         for (Integer min : mins) {
//             if (x == min) { break; }
//             i++;
//         }
//         mins.remove(i);
//     }
    
//     public int top() {
//         // if (stack.isEmpty()) { return null; }
//         return stack.peek();
//     }
    
//     public int getMin() {
//         // if (stack.isEmpty()) { return null; }
//         return mins.get(0);
//     }
// }

class MinStack {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> mins = new Stack<>();

    /** initialize your data structure here. */
    public MinStack() {
    }
    
    public void push(int x) {
        stack.push(x);
        if (mins.isEmpty() || x <= mins.peek()) { mins.add(x); }
        else { mins.push(mins.peek()); }
    }
    
    public void pop() {
        stack.pop();
        mins.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return mins.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
// @lc code=end

// 方法 1
// Accepted
// 18/18 cases passed (277 ms)
// Your runtime beats 5.01 % of java submissions
// Your memory usage beats 16.87 % of java submissions (41.2 MB)

// 方法 2
// Accepted
// 18/18 cases passed (7 ms)
// Your runtime beats 87.55 % of java submissions
// Your memory usage beats 13.25 % of java submissions (42 MB)