
/*
 * @Author: aponder
 * @Date: 2020-04-25 11:57:18
 * @LastEditors: aponder
 * @LastEditTime: 2020-04-25 15:03:45
 * @FilePath: /leetcode-zh/medium/46.全排列/Solution.java
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=46 lang=java
 *
 * [46] 全排列
 *
 * https://leetcode-cn.com/problems/permutations/description/
 *
 * algorithms
 * Medium (74.63%)
 * Likes:    643
 * Dislikes: 0
 * Total Accepted:    111.4K
 * Total Submissions: 147.9K
 * Testcase Example:  '[1,2,3]'
 *
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 * 
 * 示例:
 * 
 * 输入: [1,2,3]
 * 输出:
 * [
 * ⁠ [1,2,3],
 * ⁠ [1,3,2],
 * ⁠ [2,1,3],
 * ⁠ [2,3,1],
 * ⁠ [3,1,2],
 * ⁠ [3,2,1]
 * ]
 * 
 */

// @lc code=start
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        int length = nums.length;
        // [1,2]
        // 1,2
        // 2,1
        // [1,2,3]
        List<List<Integer>> items = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>(length);
        for (int i : nums) {
            map.put(i, i);
        }

        int n = factorial(length);
        for (int i = 0; i < n; i++) {
            items.add(new ArrayList<>(length));
        }

        Integer[] reachableNums;
        int j = length;
        int g = n;
        while (j > 0) {
            g /= j;
            for (int i = 0; i < n; i++) {
                List<Integer> list = items.get(i);
                reachableNums = remainNums(list, map);
                int l = reachableNums.length;
                items.get(i).add(reachableNums[i / g % l]);
            }
            j--;
        }

        return items;
    }

    int factorial(int n) {
        int s = 1;
        while (n > 1) {
            s *= n;
            n--;
        }
        return s;
    }

    Integer[] remainNums(List<Integer> list, Map<Integer, Integer> map) {
        Map<Integer, Integer> newMap = new HashMap<>(map);
        for (Integer i : list) {
            newMap.remove(i);
        }
        Integer[] remainNums = new Integer[map.size() - list.size()];
        newMap.values().toArray(remainNums);
        return remainNums;
    }

    public static void main(String[] args) {
        // int[] nums = new int[] { 5, 4, 2, 6 };
        int[] nums = new int[] { 1, 2, 3};
        new Solution().permute(nums);
    }
}
// @lc code=end

// Accepted
// 25/25 cases passed (12 ms)
// Your runtime beats 5.52 % of java submissions
// Your memory usage beats 7.32 % of java submissions (40.6 MB)