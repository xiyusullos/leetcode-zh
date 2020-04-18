/*
 * @Author: aponder
 * @Date: 2020-04-18 20:00:07
 * @LastEditors: aponder
 * @LastEditTime: 2020-04-18 20:32:35
 * @FilePath: /leetcode-zh/medium/11.盛最多水的容器/Solution.java
 */
/*
 * @lc app=leetcode.cn id=11 lang=java
 *
 * [11] 盛最多水的容器
 *
 * https://leetcode-cn.com/problems/container-with-most-water/description/
 *
 * algorithms
 * Medium (62.33%)
 * Likes:    1350
 * Dislikes: 0
 * Total Accepted:    188.1K
 * Total Submissions: 298.9K
 * Testcase Example:  '[1,8,6,2,5,4,8,3,7]'
 *
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为
 * (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 * 
 * 
 * 
 * 
 * 
 * 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 * 
 * 
 * 
 * 示例：
 * 
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * 
 */

// @lc code=start
class Solution {
    // 方法 1：暴力枚举
    // public int maxArea(int[] height) {
    //     int l = height.length;
    //     // 1,2; 1,2; 2,3;
    //     // 1,2; 1,3; 1,4; 2,3; 2,4; 3,4;
    //     long max = 0, possible = 0;
    //     for (int i = 0; i < l - 1; i++) {
    //         for (int j = i + 1; j < l; j++) {
    //             possible = (j - i) * Math.min(height[i], height[j]);
    //             if (possible > max) max = possible;
    //         }
    //     }
    //     return (int) max;
    // }
    
    // 方法 2：双指针，移动短边
    public int maxArea(int[] height) {
        int l = height.length;
        long max = 0, possible = 0;
        int i = 0, j = l - 1;
        while (i < j) {
            possible = Math.min(height[i], height[j]) * (j - i);
            if (possible > max) max = possible;
            if (height[i] < height[j]) i++;
            else j--;
        }
        
        return (int) max;
    }
}
// @lc code=end

// 方法 1：暴力枚举
// Accepted
// 50/50 cases passed (513 ms)
// Your runtime beats 13.51 % of java submissions
// Your memory usage beats 27.86 % of java submissions (40 MB)

// 方法 2：双指针，移动短边
// Accepted
// 50/50 cases passed (3 ms)
// Your runtime beats 92.82 % of java submissions
// Your memory usage beats 36.43 % of java submissions (39.9 MB)