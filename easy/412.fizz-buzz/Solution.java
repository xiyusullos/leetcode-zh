/*
 * @Author: aponder
 * @Date: 2020-05-10 10:46:09
 * @LastEditors: aponder
 * @LastEditTime: 2020-05-10 10:51:38
 * @FilePath: /leetcode-zh/easy/412.fizz-buzz/Solution.java
 */
import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=412 lang=java
 *
 * [412] Fizz Buzz
 *
 * https://leetcode-cn.com/problems/fizz-buzz/description/
 *
 * algorithms
 * Easy (63.11%)
 * Likes:    58
 * Dislikes: 0
 * Total Accepted:    33.6K
 * Total Submissions: 53.1K
 * Testcase Example:  '1'
 *
 * 写一个程序，输出从 1 到 n 数字的字符串表示。
 * 
 * 1. 如果 n 是3的倍数，输出“Fizz”；
 * 
 * 2. 如果 n 是5的倍数，输出“Buzz”；
 * 
 * 3.如果 n 同时是3和5的倍数，输出 “FizzBuzz”。
 * 
 * 示例：
 * 
 * n = 15,
 * 
 * 返回:
 * [
 * ⁠   "1",
 * ⁠   "2",
 * ⁠   "Fizz",
 * ⁠   "4",
 * ⁠   "Buzz",
 * ⁠   "Fizz",
 * ⁠   "7",
 * ⁠   "8",
 * ⁠   "Fizz",
 * ⁠   "Buzz",
 * ⁠   "11",
 * ⁠   "Fizz",
 * ⁠   "13",
 * ⁠   "14",
 * ⁠   "FizzBuzz"
 * ]
 * 
 * 
 */

// @lc code=start
class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList<>(n);
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 != 0) list.add("Fizz");
            else if (i % 5 == 0 && i % 3 != 0) list.add("Buzz");
            else if (i % 3 == 0 && i % 5 == 0) list.add("FizzBuzz");
            else list.add(new StringBuilder().append(i).toString());
        }
        return list;
    }
}
// @lc code=end

// Accepted
// 8/8 cases passed (2 ms)
// Your runtime beats 73.03 % of java submissions
// Your memory usage beats 8.7 % of java submissions (40.7 MB)