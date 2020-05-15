/*
 * @Author: aponder
 * @Date: 2020-05-15 10:48:01
 * @LastEditors: aponder
 * @LastEditTime: 2020-05-15 11:05:24
 * @FilePath: /leetcode-zh/easy/463.岛屿的周长/Solution.java
 */
/*
 * @lc app=leetcode.cn id=463 lang=java
 *
 * [463] 岛屿的周长
 *
 * https://leetcode-cn.com/problems/island-perimeter/description/
 *
 * algorithms
 * Easy (65.92%)
 * Likes:    186
 * Dislikes: 0
 * Total Accepted:    16.5K
 * Total Submissions: 24.9K
 * Testcase Example:  '[[0,1,0,0],[1,1,1,0],[0,1,0,0],[1,1,0,0]]'
 *
 * 给定一个包含 0 和 1 的二维网格地图，其中 1 表示陆地 0 表示水域。
 * 
 * 网格中的格子水平和垂直方向相连（对角线方向不相连）。整个网格被水完全包围，但其中恰好有一个岛屿（或者说，一个或多个表示陆地的格子相连组成的岛屿）。
 * 
 * 岛屿中没有“湖”（“湖” 指水域在岛屿内部且不和岛屿周围的水相连）。格子是边长为 1 的正方形。网格为长方形，且宽度和高度均不超过 100
 * 。计算这个岛屿的周长。
 * 
 * 
 * 
 * 示例 :
 * 
 * 输入:
 * [[0,1,0,0],
 * ⁠[1,1,1,0],
 * ⁠[0,1,0,0],
 * ⁠[1,1,0,0]]
 * 
 * 输出: 16
 * 
 * 解释: 它的周长是下面图片中的 16 个黄色的边：
 * 
 * 
 * 
 * 
 */

// @lc code=start
class Solution {
    public int islandPerimeter(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int perimeter = 0;
        // 第一块
        if (grid[0][0] == 1) perimeter += 4;
        // 第一行
        for (int j = 1; j < n; j++) {
            if (grid[0][j] == 1) {
                perimeter += 4;
                if (grid[0][j - 1] == 1) perimeter -= 2;
            }
        }
        // 第一列
        for (int i = 1; i < m; i++) {
            if (grid[i][0] == 1) {
                perimeter += 4;
                if (grid[i - 1][0] == 1) perimeter -= 2;
            }
        }
        // 剩余的
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (grid[i][j] == 1) {
                    perimeter += 4;
                    if (grid[i][j - 1] == 1) perimeter -= 2;
                    if (grid[i - 1][j] == 1) perimeter -= 2;
                }
            }
        }

        return perimeter;
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};
        new Solution().islandPerimeter(grid);
    }
}
// @lc code=end

// Accepted
// 5833/5833 cases passed (7 ms)
// Your runtime beats 94.63 % of java submissions
// Your memory usage beats 100 % of java submissions (39.9 MB)