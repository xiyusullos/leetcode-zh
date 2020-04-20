
/*
 * @Author: aponder
 * @Date: 2020-04-20 21:38:01
 * @LastEditors: aponder
 * @LastEditTime: 2020-04-20 22:21:47
 * @FilePath: /leetcode-zh/medium/200.岛屿数量/Solution.java
 */
import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=200 lang=java
 *
 * [200] 岛屿数量
 *
 * https://leetcode-cn.com/problems/number-of-islands/description/
 *
 * algorithms
 * Medium (47.90%)
 * Likes:    521
 * Dislikes: 0
 * Total Accepted:    93.3K
 * Total Submissions: 190.3K
 * Testcase Example:  '[["1","1","1","1","0"],["1","1","0","1","0"],["1","1","0","0","0"],["0","0","0","0","0"]]'
 *
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * 
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 * 
 * 此外，你可以假设该网格的四条边均被水包围。
 * 
 * 示例 1:
 * 
 * 输入:
 * 11110
 * 11010
 * 11000
 * 00000
 * 输出: 1
 * 
 * 
 * 示例 2:
 * 
 * 输入:
 * 11000
 * 11000
 * 00100
 * 00011
 * 输出: 3
 * 解释: 每座岛屿只能由水平和/或竖直方向上相邻的陆地连接而成。
 * 
 * 
 */

// @lc code=start
class Solution {
    class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        Point up() {
            return new Point(x - 1, y);
        }

        Point down() {
            return new Point(x + 1, y);
        }

        Point left() {
            return new Point(x, y - 1);
        }

        Point right() {
            return new Point(x, y + 1);
        }

        boolean isValid(int m, int n) {
            return 0 <= x && x < m && 0 <= y && y < n;
        }
    }

    char[][] grid;
    int m, n;

    void initialGrid(char[][] grid) {
        m = grid.length;
        if (m == 0)
            return;
        n = grid[0].length;
        if (n == 0)
            return;
        this.grid = new char[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                this.grid[i][j] = grid[i][j];
            }
        }
    }

    void expandsLand(Point point) {
        Point[] around = new Point[] { point.up(), point.down(), point.left(), point.right() };
        for (Point p : around) {
            if (p.isValid(m, n) && isLand(grid, p)) {
                grid[p.x][p.y] = '0';
                expandsLand(p);
            }
        }
    }

    boolean isLand(char[][] grid, Point p) {
        return grid[p.x][p.y] == '1';
    }

    // public int numIslands(char[][] grid) {
    //     initialGrid(grid);

    //     int count = 0;
    //     for (int i = 0; i < m; i++) {
    //         for (int j = 0; j < n; j++) {
    //             if (this.grid[i][j] == '1') {
    //                 expandsLand(new Point(i, j));
    //                 count++;
    //             }
    //         }
    //     }
    //     return count;
    // }

    void dfs(char[][] grid, int r, int c) {
        int nr = grid.length;
        int nc = grid[0].length;

        if (r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c] == '0') {
            return;
        }

        grid[r][c] = '0';
        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
    }


    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int nr = grid.length;
        int nc = grid[0].length;
        int num_islands = 0;
        for (int r = 0; r < nr; ++r) {
            for (int c = 0; c < nc; ++c) {
                if (grid[r][c] == '1') {
                    ++num_islands;
                    dfs(grid, r, c);
                }
            }
        }

        return num_islands;
    }
}
// @lc code=end

// Accepted
// 47/47 cases passed (7 ms)
// Your runtime beats 16.37 % of java submissions
// Your memory usage beats 6.25 % of java submissions (42.5 MB)

// Accepted
// 47/47 cases passed (2 ms)
// Your runtime beats 96.16 % of java submissions
// Your memory usage beats 6.25 % of java submissions (42.1 MB)