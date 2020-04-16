import java.util.Arrays;

/*
 * @Author: aponder
 * @Date: 2020-04-16 11:05:01
 * @LastEditors: aponder
 * @LastEditTime: 2020-04-16 11:55:02
 * @FilePath: /leetcode-zh/easy/167.两数之和-ii-输入有序数组/Solution.java
 */
/*
 * @lc app=leetcode.cn id=167 lang=java
 *
 * [167] 两数之和 II - 输入有序数组
 *
 * https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/description/
 *
 * algorithms
 * Easy (53.21%)
 * Likes:    279
 * Dislikes: 0
 * Total Accepted:    83.3K
 * Total Submissions: 156.1K
 * Testcase Example:  '[2,7,11,15]\n9'
 *
 * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
 * 
 * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
 * 
 * 说明:
 * 
 * 
 * 返回的下标值（index1 和 index2）不是从零开始的。
 * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 * 
 * 
 * 示例:
 * 
 * 输入: numbers = [2, 7, 11, 15], target = 9
 * 输出: [1,2]
 * 解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
 * 
 */

// @lc code=start
class Solution {
    // 方法 1
    // public int[] twoSum(int[] numbers, int target) {
    //     int l = numbers.length;
    //     int t;
    //     for (int i = 0; i < l - 1; i++) {
    //         if (numbers[i] > target) break;
    //         for (int j = i + 1; j < l; j++) {
    //             t = numbers[i] + numbers[j];
    //             if (t == target) return new int[]{i + 1, j + 1};
    //             if (t < target) continue;
    //             if (t > target) break;
    //         }
    //     }

    //     return new int[2];
    // }

    // // 方法 2
    public int[] twoSum(int[] numbers, int target) {
        int l = numbers.length;
        int i = 0, j = l - 1;
        int t;
        while (i < j) {
            // t = numbers[i] + numbers[j];
            // if (t == target) return new int[]{i + 1, j + 1};
            // else if (t < target) i++; // too small
            // else j--; // too big

            t = target - numbers[j];
            if (t == numbers[i]) return new int[]{i + 1, j + 1};
            else if (t > numbers[i]) i++; // too small
            else j--; // too big
        }

        return new int[2];
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().twoSum(new int[]{1,2, 2147483647}, 3)));
    }
}
// @lc code=end

// 方法 1
// Accepted
// 17/17 cases passed (96 ms)
// Your runtime beats 13.36 % of java submissions
// Your memory usage beats 6.67 % of java submissions (40.4 MB)

// Accepted
// 17/17 cases passed (1 ms)
// Your runtime beats 97.93 % of java submissions
// Your memory usage beats 6.67 % of java submissions (40.2 MB)

//  0  1  2  3  4  5  6  7   8   9   10
// [1, 2, 3, 4, 6, 7, 9, 12, 14, 15, 16] = 14