/*
 * @Author: aponder
 * @Date: 2020-06-06 12:47:55
 * @LastEditTime: 2020-06-06 13:10:47
 * @LastEditors: aponder
 * @Description: 
 * @FilePath: /leetcode-zh/easy/697.数组的度/Solution.java
 */ 
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=697 lang=java
 *
 * [697] 数组的度
 *
 * https://leetcode-cn.com/problems/degree-of-an-array/description/
 *
 * algorithms
 * Easy (53.25%)
 * Likes:    131
 * Dislikes: 0
 * Total Accepted:    16.9K
 * Total Submissions: 31.6K
 * Testcase Example:  '[1,2,2,3,1]'
 *
 * 给定一个非空且只包含非负数的整数数组 nums, 数组的度的定义是指数组里任一元素出现频数的最大值。
 * 
 * 你的任务是找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。
 * 
 * 示例 1:
 * 
 * 
 * 输入: [1, 2, 2, 3, 1]
 * 输出: 2
 * 解释: 
 * 输入数组的度是2，因为元素1和2的出现频数最大，均为2.
 * 连续子数组里面拥有相同度的有如下所示:
 * [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
 * 最短连续子数组[2, 2]的长度为2，所以返回2.
 * 
 * 
 * 示例 2:
 * 
 * 
 * 输入: [1,2,2,3,1,4,2]
 * 输出: 6
 * 
 * 
 * 注意:
 * 
 * 
 * nums.length 在1到50,000区间范围内。
 * nums[i] 是一个在0到49,999范围内的整数。
 * 
 * 
 */

// @lc code=start
class Solution {
    public int findShortestSubArray(int[] nums) {
        int length = nums.length;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            List<Integer> list = map.get(nums[i]);
            if (list == null) {
                list = new ArrayList<>();
                list.add(i);
                map.put(nums[i], list);
            } else {
                list.add(i);
            }
        }

        List<List<Integer>> frequentLists = new ArrayList<>();
        int frequent = 0;
        int frequentNum = 0;
        int count;
        for (int num : map.keySet()) {
            List<Integer> list = map.get(num);
            count = list.size();
            if (count > frequent) {
                frequentLists.clear();
                frequentLists.add(list);
                frequent = count;
                frequentNum = num;
            } else if (count == frequent) {
                frequentLists.add(list);
            }
        }


        int minLength = length;
        int l; // temp length
        for (List<Integer> list : frequentLists) {
            l = list.get(list.size() - 1) - list.get(0) + 1;
            if (l < minLength) {
                minLength = l;
            }
        }

        return minLength;
    }
}
// @lc code=end

// Accepted
// 89/89 cases passed (12 ms)
// Your runtime beats 96.03 % of java submissions
// Your memory usage beats 6.25 % of java submissions (44.7 MB)