/*
 * @Author: aponder
 * @Date: 2020-05-08 12:38:04
 * @LastEditors: aponder
 * @LastEditTime: 2020-05-08 13:14:37
 * @FilePath: /leetcode-zh/medium/221.最大正方形/Solution.java
 */
/*
 * @lc app=leetcode.cn id=221 lang=java
 *
 * [221] 最大正方形
 *
 * https://leetcode-cn.com/problems/maximal-square/description/
 *
 * algorithms
 * Medium (39.39%)
 * Likes:    350
 * Dislikes: 0
 * Total Accepted:    40K
 * Total Submissions: 97.4K
 * Testcase Example:  '[["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]'
 *
 * 在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
 * 
 * 示例:
 * 
 * 输入: 
 * 
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 * 
 * 输出: 4
 * 
 */

// @lc code=start
class Solution {
    char[][] theMatrix;
    int row = 0 , column = 0;;
    public int maximalSquare(char[][] matrix) {
        int max = 0;
        row = matrix.length;
        if (row == 0) return max;

        theMatrix = matrix;
        
        column = matrix[0].length;
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (matrix[i][j] == '1') {
                    int area = maxArea(i, j);
                    if (area > max) max = area;
                }
            }
        }
        
        return max;
    }

    int maxArea(int x, int y) {
        int maxM = -1, maxN = -1;
        // 所有行
        for (int i = x; i < row; i++) {
            if (maxM != -1 && i - x >= maxM) break;
            int m = 0;
            for (int j = y; j < column; j++) {
                if (theMatrix[i][j] == '1') m++;
                else break;
            }
            if (maxM == -1) maxM = m;
            else if (m != 0 && m < maxM) maxM = m;
        }
        // 所有列
        for (int j = y; j < column; j++) {
            if (maxN != -1 && j - y >= maxN) break;
            if (j - y >= maxM) break;
            int n = 0;
            for (int i = x; i < row; i++) {
                if (theMatrix[i][j] == '1') n++;
                else break;
            }
            if (maxN == -1) maxN = n;
            else if (n != 0 && n < maxN) maxN = n;
        }

        int s = Math.min(maxM, maxN);
        return s * s;
    }

    public static void main(String[] args) {
        char[][] matrix = new char[][]{
            {'1', '0', '1', '0', '0',},
            {'1', '0', '1', '1', '1',},
            {'1', '1', '1', '1', '1',},
            {'1', '0', '0', '1', '0',},
        };
        new Solution().maximalSquare(matrix);
    }
}
// @lc code=end

// Accepted
// 69/69 cases passed (15 ms)
// Your runtime beats 5.3 % of java submissions
// Your memory usage beats 12.5 % of java submissions (43.5 MB)