/*
 * @Author: aponder
 * @Date: 2020-04-12 19:02:47
 * @LastEditors: aponder
 * @LastEditTime: 2020-04-12 19:07:01
 * @FilePath: /leetcode-zh/easy/119.杨辉三角-ii/Solution.java
 */
import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=119 lang=java
 *
 * [119] 杨辉三角 II
 *
 * https://leetcode-cn.com/problems/pascals-triangle-ii/description/
 *
 * algorithms
 * Easy (60.63%)
 * Likes:    138
 * Dislikes: 0
 * Total Accepted:    46.9K
 * Total Submissions: 77.3K
 * Testcase Example:  '3'
 *
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 * 
 * 
 * 
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 * 
 * 示例:
 * 
 * 输入: 3
 * 输出: [1,3,3,1]
 * 
 * 
 * 进阶：
 * 
 * 你可以优化你的算法到 O(k) 空间复杂度吗？
 * 
 */

// @lc code=start
class Solution {
    public List<Integer> getRow(int rowIndex) {
        // rowIndex 非负索引，即 rowIndex ≥ 0
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
            list = next(list);
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
// 34/34 cases passed (1 ms)
// Your runtime beats 90.74 % of java submissions
// Your memory usage beats 5.51 % of java submissions (37.2 MB)