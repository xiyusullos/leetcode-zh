import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @Author: aponder
 * @Date: 2020-05-13 13:12:10
 * @LastEditors: aponder
 * @LastEditTime: 2020-05-13 13:38:00
 * @FilePath: /leetcode-zh/easy/447.回旋镖的数量/Solution.java
 */
/*
 * @lc app=leetcode.cn id=447 lang=java
 *
 * [447] 回旋镖的数量
 *
 * https://leetcode-cn.com/problems/number-of-boomerangs/description/
 *
 * algorithms
 * Easy (57.35%)
 * Likes:    86
 * Dislikes: 0
 * Total Accepted:    11.6K
 * Total Submissions: 20.2K
 * Testcase Example:  '[[0,0],[1,0],[2,0]]'
 *
 * 给定平面上 n 对不同的点，“回旋镖” 是由点表示的元组 (i, j, k) ，其中 i 和 j 之间的距离和 i 和 k
 * 之间的距离相等（需要考虑元组的顺序）。
 * 
 * 找到所有回旋镖的数量。你可以假设 n 最大为 500，所有点的坐标在闭区间 [-10000, 10000] 中。
 * 
 * 示例:
 * 
 * 
 * 输入:
 * [[0,0],[1,0],[2,0]]
 * 
 * 输出:
 * 2
 * 
 * 解释:
 * 两个回旋镖为 [[1,0],[0,0],[2,0]] 和 [[1,0],[2,0],[0,0]]
 * 
 * 
 */

// @lc code=start
class Solution {
    // 方法 1
    // public int numberOfBoomerangs(int[][] points) {
    //     int count = 0;
    //     int length = points.length;
    //     int d1, d2; // 点之间的距离
    //     int t1, t2; // 临时变量
    //     for (int i = 0; i < length; i++) {
    //         for (int j = 0; j < length; j++) {
    //             if (j == i) continue;
    //             t1 = points[i][0] - points[j][0];
    //             t2 = points[i][1] - points[j][1];
    //             d1 = t1 * t1 + t2 * t2;
    //             for (int k = 0; k < length; k++) {
    //                 if (k == i || k == j) continue;
    //                 t1 = points[i][0] - points[k][0];
    //                 t2 = points[i][1] - points[k][1];
    //                 d2 = t1 * t1 + t2 * t2;
    //                 if (d1 == d2) count++;
    //             }
    //         }
    //     }

    //     return count;
    // }

    // 方法 2
    public int numberOfBoomerangs(int[][] points) {
        // points 不重复
        Map<Integer, Integer> map = new HashMap<>();
        int t1, t2;
        int d1, d2;
        int count = 0;
        for (int[] p1 : points) {
            for (int[] p2 : points) {   
                t1 = p1[0] - p2[0];
                t2 = p1[1] - p2[1];
                d1 = t1 * t1 + t2 * t2;
                map.put(d1, 1 + map.getOrDefault(d1, 0));
            }

            for (int val : map.values()) {
                count += val * (val - 1);
            }
            map.clear();
        }

        return count;
    }
}
// @lc code=end

// 方法 1
// Accepted
// 31/31 cases passed (2504 ms)
// Your runtime beats 5.01 % of java submissions
// Your memory usage beats 75 % of java submissions (39.4 MB)

// 方法 2
// Accepted
// 31/31 cases passed (122 ms)
// Your runtime beats 64.68 % of java submissions
// Your memory usage beats 75 % of java submissions (39.6 MB)