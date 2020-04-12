/*
 * @Author: aponder
 * @Date: 2020-04-12 18:44:52
 * @LastEditors: aponder
 * @LastEditTime: 2020-04-12 19:00:11
 * @FilePath: /leetcode-zh/easy/118.杨辉三角/Solution.java
 */
import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=118 lang=java
 *
 * [118] 杨辉三角
 *
 * https://leetcode-cn.com/problems/pascals-triangle/description/
 *
 * algorithms
 * Easy (66.07%)
 * Likes:    279
 * Dislikes: 0
 * Total Accepted:    70.7K
 * Total Submissions: 106.9K
 * Testcase Example:  '5'
 *
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 * 
 * 
 * 
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 * 
 * 示例:
 * 
 * 输入: 5
 * 输出:
 * [
 * ⁠    [1],
 * ⁠   [1,1],
 * ⁠  [1,2,1],
 * ⁠ [1,3,3,1],
 * ⁠[1,4,6,4,1]
 * ]
 * 
 */

// @lc code=start
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> currentList = new ArrayList<>();
        for (int i = 1; i <= numRows; i++) {
            currentList = next(currentList);
            list.add(currentList);
        }
        return list;
    }

    List<Integer> next(List<Integer> list) {
        int length = list.size();
        List<Integer> l = new ArrayList<>();
        l.add(1);
        if (length == 0) {
            return l;
        }

        for (int i = 0; i < length - 1; i++) {
            l.add(list.get(i) + list.get(i + 1));
        }
        l.add(1);
        return l;
    }
}
// @lc code=end

// Accepted
// 15/15 cases passed (1 ms)
// Your runtime beats 85.19 % of java submissions
// Your memory usage beats 5.15 % of java submissions (37.5 MB)