/*
 * @Author: aponder
 * @Date: 2020-05-26 23:46:47
 * @LastEditTime: 2020-05-26 23:55:06
 * @LastEditors: aponder
 * @Description: 
 * @FilePath: /leetcode-zh/easy/566.重塑矩阵/Solution.java
 */ 
/*
 * @lc app=leetcode.cn id=566 lang=java
 *
 * [566] 重塑矩阵
 *
 * https://leetcode-cn.com/problems/reshape-the-matrix/description/
 *
 * algorithms
 * Easy (64.39%)
 * Likes:    111
 * Dislikes: 0
 * Total Accepted:    17.2K
 * Total Submissions: 26.7K
 * Testcase Example:  '[[1,2],[3,4]]\n1\n4'
 *
 * 在MATLAB中，有一个非常有用的函数 reshape，它可以将一个矩阵重塑为另一个大小不同的新矩阵，但保留其原始数据。
 * 
 * 给出一个由二维数组表示的矩阵，以及两个正整数r和c，分别表示想要的重构的矩阵的行数和列数。
 * 
 * 重构后的矩阵需要将原始矩阵的所有元素以相同的行遍历顺序填充。
 * 
 * 如果具有给定参数的reshape操作是可行且合理的，则输出新的重塑矩阵；否则，输出原始矩阵。
 * 
 * 示例 1:
 * 
 * 
 * 输入: 
 * nums = 
 * [[1,2],
 * ⁠[3,4]]
 * r = 1, c = 4
 * 输出: 
 * [[1,2,3,4]]
 * 解释:
 * 行遍历nums的结果是 [1,2,3,4]。新的矩阵是 1 * 4 矩阵, 用之前的元素值一行一行填充新矩阵。
 * 
 * 
 * 示例 2:
 * 
 * 
 * 输入: 
 * nums = 
 * [[1,2],
 * ⁠[3,4]]
 * r = 2, c = 4
 * 输出: 
 * [[1,2],
 * ⁠[3,4]]
 * 解释:
 * 没有办法将 2 * 2 矩阵转化为 2 * 4 矩阵。 所以输出原矩阵。
 * 
 * 
 * 注意：
 * 
 * 
 * 给定矩阵的宽和高范围在 [1, 100]。
 * 给定的 r 和 c 都是正数。
 * 
 * 
 */

// @lc code=start
class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int n = nums.length;
        int l = r * c;
        if (n ==0 && l != 0) return new int[][]{};
        int m = nums[0].length;
        if (n * m != l) return nums;

        int p = 0;
        // 13 -> 4x5 -> 10/5, 3
        int[][] newNums = new int[r][c];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int j_ = p % c;
                int i_ = (p - j_) / c;
                newNums[i_][j_] =  nums[i][j];
                p++;
            }
        }

        return newNums;
    }
}
// @lc code=end

// Accepted
// 56/56 cases passed (2 ms)
// Your runtime beats 82.89 % of java submissions
// Your memory usage beats 25 % of java submissions (41.1 MB)