/*
 * @Author: aponder
 * @Date: 2020-05-31 23:32:19
 * @LastEditTime: 2020-05-31 23:55:01
 * @LastEditors: aponder
 * @Description: 
 * @FilePath: /leetcode-zh/easy/661.图片平滑器/Solution.java
 */ 
/*
 * @lc app=leetcode.cn id=661 lang=java
 *
 * [661] 图片平滑器
 *
 * https://leetcode-cn.com/problems/image-smoother/description/
 *
 * algorithms
 * Easy (52.89%)
 * Likes:    49
 * Dislikes: 0
 * Total Accepted:    7.9K
 * Total Submissions: 14.8K
 * Testcase Example:  '[[1,1,1],[1,0,1],[1,1,1]]'
 *
 * 包含整数的二维矩阵 M 表示一个图片的灰度。你需要设计一个平滑器来让每一个单元的灰度成为平均灰度 (向下舍入)
 * ，平均灰度的计算是周围的8个单元和它本身的值求平均，如果周围的单元格不足八个，则尽可能多的利用它们。
 * 
 * 示例 1:
 * 
 * 
 * 输入:
 * [[1,1,1],
 * ⁠[1,0,1],
 * ⁠[1,1,1]]
 * 输出:
 * [[0, 0, 0],
 * ⁠[0, 0, 0],
 * ⁠[0, 0, 0]]
 * 解释:
 * 对于点 (0,0), (0,2), (2,0), (2,2): 平均(3/4) = 平均(0.75) = 0
 * 对于点 (0,1), (1,0), (1,2), (2,1): 平均(5/6) = 平均(0.83333333) = 0
 * 对于点 (1,1): 平均(8/9) = 平均(0.88888889) = 0
 * 
 * 
 * 注意:
 * 
 * 
 * 给定矩阵中的整数范围为 [0, 255]。
 * 矩阵的长和宽的范围均为 [1, 150]。
 * 
 * 
 */

// @lc code=start
class Solution {
    // public int[][] imageSmoother(int[][] M) {
    // int l = M.length;
    // if (l <= 1)
    // return M;

    // int a = 0;
    // // 第一行第一个
    // M[a][0] = (M[a][0] + M[a][1] + M[a + 1][0] + M[a + 1][1]) / 4;
    // // 第一行
    // for (int i = 1; i < l - l; i++) {
    // M[a][i] = (M[a][i] + M[a][i - 1] + M[a][i + 1] + M[a + 1][i - 1] + M[a +
    // 1][i] + M[a + 1][i + 1]) / 6;
    // }
    // // 第一行最后一个
    // M[a][l - 1] = (M[a][l - 1] + M[a][l - 2] + M[a + 1][l - 2] + M[a + 1][l - 1])
    // / 4;

    // for (int i = 0; i < l; i++) {
    // for (int j = 0; j < l; j++) {

    // }
    // }

    // a = l - 1;
    // // 最后一行第一个
    // M[a][0] = (M[a][0] + M[a][1] + M[a - 1][0] + M[a - 1][1]) / 4;
    // // 最后一行
    // for (int i = 1; i < l - l; i++) {
    // M[a][i] = (M[a][i] + M[a][i - 1] + M[a][i + 1] + M[a - 1][i - 1] + M[a -
    // 1][i] + M[a - 1][i + 1]) / 6;
    // }
    // // 最后一行最后一个
    // M[a][l - 1] = (M[a][l - 1] + M[a][l - 2] + M[a - 1][l - 2] + M[a - 1][l - 1])
    // / 4;
    // }

    // public int[][] imageSmoother(int[][] M) {
    //     int m = M.length;
    //     if (m <= 0) return M;
    //     int n = M[0].length;
    //     for (int i = 0; i < m; i++) {
    //         for (int j = 0; j < n; j++) {
    //             int sum = M[i][j], count = 1;
    //             if (0<= i-1 && i-1 < m  && 0<= j-1 && j-1 <n) {
    //                 sum += M[i-1][j-1];
    //                 count++;
    //             }
    //             if (0<= i-1 && i-1 < m  && 0<= j+0 && j+0 <n) {
    //                 sum += M[i-1][j+0];
    //                 count++;
    //             }
    //             if (0<= i-1 && i-1 < m  && 0<= j+1 && j+1 <n) {
    //                 sum += M[i-1][j+1];
    //                 count++;
    //             }
    //             if (0<= i+0 && i+0 < m  && 0<= j-1 && j-1 <n) {
    //                 sum += M[i+0][j-1];
    //                 count++;
    //             }
    //             // if (0<= i+0 && i+0 < l  && 0<= j+0 && j+0 <l) {
    //             //     sum += M[i+0][j+0];
    //             //     count++;
    //             // }
    //             if (0<= i+0 && i+0 < m  && 0<= j+1 && j+1 <n) {
    //                 sum += M[i+0][j+1];
    //                 count++;
    //             }
    //             if (0<= i+1 && i+1 < m  && 0<= j-1 && j-1 <n) {
    //                 sum += M[i+1][j-1];
    //                 count++;
    //             }
    //             if (0<= i+1 && i+1 < m  && 0<= j+0 && j+0 <n) {
    //                 sum += M[i+1][j+0];
    //                 count++;
    //             }
    //             if (0<= i+1 && i+1 < m  && 0<= j+1 && j+1 <n) {
    //                 sum += M[i+1][j+1];
    //                 count++;
    //             }

    //             M[i][j] = sum / count;
    //         }
    //     }
    //     return M;
    // }

    public int[][] imageSmoother(int[][] M) {
        int R = M.length, C = M[0].length;
        int[][] ans = new int[R][C];

        for (int r = 0; r < R; ++r)
            for (int c = 0; c < C; ++c) {
                int count = 0;
                for (int nr = r-1; nr <= r+1; ++nr)
                    for (int nc = c-1; nc <= c+1; ++nc) {
                        if (0 <= nr && nr < R && 0 <= nc && nc < C) {
                            ans[r][c] += M[nr][nc];
                            count++;
                        }
                    }
                ans[r][c] /= count;
            }
        return ans;
    }

}
// @lc code=end

// Accepted
// 202/202 cases passed (16 ms)
// Your runtime beats 11.13 % of java submissions
// Your memory usage beats 71.43 % of java submissions (40.7 MB)