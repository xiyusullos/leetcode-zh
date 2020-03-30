import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=1162 lang=java
 *
 * [1162] 地图分析
 *
 * https://leetcode-cn.com/problems/as-far-from-land-as-possible/description/
 *
 * algorithms
 * Medium (44.84%)
 * Likes:    89
 * Dislikes: 0
 * Total Accepted:    18.2K
 * Total Submissions: 39.5K
 * Testcase Example:  '[[1,0,1],[0,0,0],[1,0,1]]'
 *
 * 你现在手里有一份大小为 N x N 的『地图』（网格） grid，上面的每个『区域』（单元格）都用 0 和 1 标记好了。其中 0 代表海洋，1
 * 代表陆地，你知道距离陆地区域最远的海洋区域是是哪一个吗？请返回该海洋区域到离它最近的陆地区域的距离。
 * 
 * 我们这里说的距离是『曼哈顿距离』（ Manhattan Distance）：(x0, y0) 和 (x1, y1) 这两个区域之间的距离是 |x0 -
 * x1| + |y0 - y1| 。
 * 
 * 如果我们的地图上只有陆地或者海洋，请返回 -1。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 
 * 输入：[[1,0,1],[0,0,0],[1,0,1]]
 * 输出：2
 * 解释： 
 * 海洋区域 (1, 1) 和所有陆地区域之间的距离都达到最大，最大距离为 2。
 * 
 * 
 * 示例 2：
 * 
 * 
 * 
 * 输入：[[1,0,0],[0,0,0],[0,0,0]]
 * 输出：4
 * 解释： 
 * 海洋区域 (2, 2) 和所有陆地区域之间的距离都达到最大，最大距离为 4。
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= grid.length == grid[0].length <= 100
 * grid[i][j] 不是 0 就是 1
 * 
 * 
 */

// @lc code=start

class Cell {
    public int x, y;
    public int d; // depth

    Cell(int x, int y) {
        this.x = x;
        this.y = y;
        this.d = 0;
    }

    Cell(int x, int y, int d) {
        this(x, y);
        this.d = d;
    }

    @Override
    public String toString() {
        return x + "," + y;
    }

    public Cell up() {
        return new Cell(x - 1, y, d + 1);
    }

    public Cell down() {
        return new Cell(x + 1, y, d + 1);
    }

    public Cell left() {
        return new Cell(x, y - 1, d + 1);
    }

    public Cell right() {
        return new Cell(x, y + 1, d + 1);
    }

    public boolean isValid(int n) {
        return (0 <= x && x < n) && (0 <= y && y < n);
    }
}

class Solution {
    public int maxDistance(int[][] grid) {
        int n = grid.length;
        List<Cell> waterCells = new ArrayList<>();
        List<Cell> landCells = new ArrayList<>();

        boolean[][] visitedGrid = new boolean[n][n];
        // find all water cells
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                visitedGrid[i][j] = false;
                if (grid[i][j] == 0) {
                    waterCells.add(new Cell(i, j));
                } else {
                    landCells.add(new Cell(i, j));
                }
            }
        }

        // find the nearest land cells of all water cells, then get tha maximium
        int d = -1; // max distance
        Integer t;
        for (Cell c : waterCells) {
            visitedGrid[c.x][c.y] = true;
            t = nearestLandDistance(c, grid, visitedGrid);
            // System.out.println(c.toString() + ": " + t);
            d = Math.max(t, d);
        }

        return d;
    }

    Integer nearestLandDistance(Cell xy, int[][] grid, boolean[][] visitedGrid) {
        Integer depthMax = 2 * grid.length;
        int depth = 1;
        int d = depthMax;

        boolean loopFlag = true;
        boolean isFound = false;
        while (loopFlag) {
            List<Cell> nextCells = nextCircleCells(xy, grid.length, depth);
            for (Cell cell : nextCells) {
                // is a land cell
                if (grid[cell.x][cell.y] == 1) {
                    // d = Math.min(d, calculateDistance(xy, cell));
                    d = Math.min(d, depth);
                    isFound = true;
                    loopFlag = false;
                }
            }
            if (depth >= depthMax) {
                loopFlag = false;
                if (!isFound) {
                    d = -1;
                }
            }
            depth++;
        }

        return d;
    }

    List<Cell> nextCircleCells(Cell xy, int n, int radius) {
        Queue<Cell> queue = new LinkedList<>();
        queue.add(xy);
        Map<String, Cell> visited = new HashMap<>();
        while (true) {
            if (queue.isEmpty()) {
                break;
            }

            Cell c = queue.poll();
            visited.put(c.toString(), c);

            Cell[] allCells = new Cell[] { c.up(), c.down(), c.left(), c.right() };

            for (Cell cell : allCells) {
                if (cell.isValid(n) && !visited.containsKey(cell.toString())) {
                    queue.offer(cell);
                    visited.put(cell.toString(), cell);
                }
            }

            if (c.d + 1 == radius) {
                break;
            }

        }

        List<Cell> cells = new ArrayList<>();
        while (!queue.isEmpty()) {
            cells.add(queue.poll());
        }

        return cells;
    }

    int calculateDistance(Cell cell1, Cell cell2) {
        return Math.abs(cell1.x - cell2.x) + Math.abs(cell1.y - cell2.y);
    }

    public static void main(String[] args) {
        int[][] grid = new int[][] { new int[] { 1, 0, 1 }, new int[] { 0, 0, 0 }, new int[] { 1, 0, 1 } };

        Solution s = new Solution();
        System.out.println(s.maxDistance(grid));
    }

}
// @lc code=end
