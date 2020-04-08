import java.util.Arrays;

/*
 * @Author: aponder
 * @Date: 2020-04-07 18:18:40
 * @LastEditors: aponder
 * @LastEditTime: 2020-04-08 14:08:27
 * @FilePath: /leetcode-zh/easy/88.合并两个有序数组/Solution.java
 */
/*
 * @lc app=leetcode.cn id=88 lang=java
 *
 * [88] 合并两个有序数组
 *
 * https://leetcode-cn.com/problems/merge-sorted-array/description/
 *
 * algorithms
 * Easy (47.21%)
 * Likes:    465
 * Dislikes: 0
 * Total Accepted:    131.6K
 * Total Submissions: 278.8K
 * Testcase Example:  '[1,2,3,0,0,0]\n3\n[2,5,6]\n3'
 *
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 num1 成为一个有序数组。
 * 
 * 
 * 
 * 说明:
 * 
 * 
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * 
 * 
 * 
 * 
 * 示例:
 * 
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * 
 * 输出: [1,2,2,3,5,6]
 * 
 */

// @lc code=start
class Solution {
    // public void merge(int[] nums1, int m, int[] nums2, int n) {
    //     int i1 = 0, i2 = 0, i3 = 0;
    //     int i = 0, j = 0;
    //     int a, b;
    //     while (i1 < m && i2 < n) {
    //         // if (i3 + j < m) {
    //         nums1[m + (i3 + j) % n] = nums1[i];
    //         // }
    //         a = nums1[m + (i3 % n)];
    //         b = nums2[i2];
    //         if (a <= b) {
    //             nums1[i++] = a;
    //             i1++;
    //             i3++;
    //             // i2 = i2;
    //         } else {
    //             nums1[i++] = b;
    //             i2++;
    //             j++;
    //         }
    //     }

    //     if (i1 == m) {
    //         // 还剩余 nums2
    //         while (i2 < n) {
    //             nums1[i++] = nums2[i2++];
    //         }
    //     } else {
    //         // 还剩余 nums1
    //         Arrays.sort(nums1, i, m + n);
    //     }
    // }
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // 从后往前排
        int i1 = m -1 , i2 = n - 1;
        int i = m+n-1;
        int a,b;
        while (i1 >= 0 && i2 >= 0) {
            a = nums1[i1];
            b = nums2[i2];
            if (a > b) {
                nums1[i--] = a;
                i1--;
            } else {
                nums1[i--] = b;
                i2--;
            }
        }

        // nums2 还有剩余
        while (i2 >= 0) {
            nums1[i--] = nums2[i2--];
        }

        // nums1 还有剩余，不需要更改
    }

    public static void main(String[] args) {
        int[] nums1, nums2;
        // nums1 = new int[] { -1, 4, 5, 7, 9, 0, 0, 0 };
        // nums2 = new int[] { 1, 2, 6 };
        // nums1 = new int[] { 1, 2, 3, 0, 0, 0 };
        // nums2 = new int[] { 2, 5, 6 };
        nums1 = new int[] { 4, 0, 0, 0, 0, 0 };
        nums2 = new int[] { 1, 2, 3, 5, 6 };
        int n = nums2.length;
        int m = nums1.length - n;
        (new Solution()).merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }
}
// @lc code=end

// Accepted
// 59/59 cases passed (0 ms)
// Your runtime beats 100 % of java submissions
// Your memory usage beats 5.08 % of java submissions (39.9 MB)