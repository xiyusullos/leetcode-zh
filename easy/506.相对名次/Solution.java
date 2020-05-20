import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=506 lang=java
 *
 * [506] 相对名次
 *
 * https://leetcode-cn.com/problems/relative-ranks/description/
 *
 * algorithms
 * Easy (53.84%)
 * Likes:    46
 * Dislikes: 0
 * Total Accepted:    9K
 * Total Submissions: 16.6K
 * Testcase Example:  '[5,4,3,2,1]'
 *
 * 给出 N 名运动员的成绩，找出他们的相对名次并授予前三名对应的奖牌。前三名运动员将会被分别授予 “金牌”，“银牌” 和“ 铜牌”（"Gold
 * Medal", "Silver Medal", "Bronze Medal"）。
 * 
 * (注：分数越高的选手，排名越靠前。)
 * 
 * 示例 1:
 * 
 * 
 * 输入: [5, 4, 3, 2, 1]
 * 输出: ["Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"]
 * 解释: 前三名运动员的成绩为前三高的，因此将会分别被授予 “金牌”，“银牌”和“铜牌” ("Gold Medal", "Silver Medal"
 * and "Bronze Medal").
 * 余下的两名运动员，我们只需要通过他们的成绩计算将其相对名次即可。
 * 
 * 提示:
 * 
 * 
 * N 是一个正整数并且不会超过 10000。
 * 所有运动员的成绩都不相同。
 * 
 * 
 */

// @lc code=start
class Solution {
    // public String[] findRelativeRanks(int[] nums) {
    //     int[] maxes = new int[3];
    //     int length = nums.length;
    //     if (length < 4) return new String[0];
    //     if (nums[0] > nums[1] && nums[0] > nums[2]) {
    //         maxes[0] = nums[0];
    //         if (nums[1] > nums[2]) {
    //             maxes[1] = nums[1];
    //             maxes[2] = nums[2];
    //         } else {
    //             maxes[1] = nums[1];
    //             maxes[2] = nums[2];
    //         }
    //     } else if (nums[1] > nums[0] && nums[1] > nums[2]) {
    //         maxes[0] = nums[1];
    //         if (nums[0] > nums[2]) {
    //             maxes[1] = nums[0];
    //             maxes[2] = nums[2];
    //         } else {
    //             maxes[1] = nums[2];
    //             maxes[2] = nums[0];
    //         }
    //     } else {
    //         maxes[0] = nums[2];
    //         if (nums[0] > nums[1]) {
    //             maxes[1] = nums[0];
    //             maxes[2] = nums[1];
    //         } else {
    //             maxes[1] = nums[1];
    //             maxes[2] = nums[0];
    //         }
    //     }
    //     // maxes[0] = nums[0];
    //     // maxes[1] = nums[1];
    //     // maxes[2] = nums[2];
    //     // Arrays.sort(maxes);

    //     int tmp;
    //     for (int i = 3; i < length; i++) {
    //         tmp = nums[i];
    //         if (tmp > maxes[0]) {
    //             maxes[2] = maxes[1];
    //             maxes[1] = maxes[0];
    //             maxes[0] = tmp;
    //         } else if (tmp > maxes[1]) {
    //             maxes[2] = maxes[1];
    //             maxes[1] = tmp;
    //         } else if (tmp > maxes[2]) {
    //             maxes[2] = tmp;
    //         }
    //     }

    //     String[] results = new String[length];
    //     for (int i = 0; i < length; i++) {
    //         tmp = nums[i];
    //         if (tmp == maxes[0]) {
    //             results[i] = "Gold Medal";
    //         } else if (tmp == maxes[1]) {
    //             results[i] = "Silver Medal";
    //         } else if (tmp == maxes[2]) {
    //             results[i] = "Bronze Medal";
    //         } else {
    //             results[i] = String.valueOf(tmp);
    //         }
    //     }

    //     return results;
    // }
    public String[] findRelativeRanks(int[] nums) {
        int length = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(i + 1, nums[i]);
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, Comparator.comparing(Map.Entry::getValue));
        
        String[] results = new String[length];
        int i = 0;
        int rank;
        for (Map.Entry<Integer,Integer> entry : list) {
            rank = length - i;
            // System.out.println(entry.getKey() + "=>" + rank);
            if ( rank > 3) {
                results[entry.getKey() - 1] = String.valueOf(rank);
            } else if (rank == 1) {
                results[entry.getKey() - 1] = "Gold Medal";
            } else if (rank == 2) {
                results[entry.getKey() - 1] = "Silver Medal";
            } else {
                results[entry.getKey() - 1] = "Bronze Medal";
            }
            i++;
        }

        return results;
    }
}
// @lc code=end

// Accepted
// 17/17 cases passed (22 ms)
// Your runtime beats 21.77 % of java submissions
// Your memory usage beats 33.33 % of java submissions (41.2 MB)