import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @Author: aponder
 * @Date: 2020-04-24 12:36:12
 * @LastEditors: aponder
 * @LastEditTime: 2020-04-24 14:11:24
 * @FilePath: /leetcode-zh/hard/面试题51.数组中的逆序对/Solution.java
 */
/*
 * @lc app=leetcode.cn lang=java
 *
 * 面试题51. 数组中的逆序对
 *
 * https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof/
 *
 * algorithms
 * Hard (27.09%)
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
 * 
 *  
 * 
 * 示例 1:
 * 
 * 输入: [7,5,6,4]
 * 输出: 5
 *  
 * 
 * 限制：
 * 
 * 0 <= 数组长度 <= 50000
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 */

// @lc code=start

// class Solution {
//     public int reversePairs(int[] nums) {
//         // 2^n - 1 - n
//         int length = nums.length;
//         if (length == 0)
//             return 0;

//         int count = 0;
//         // Map<Integer, List<Integer>> map = new HashMap<>();
//         // List<Integer> list = new ArrayList<>();
//         // list.add(0);
//         // map.put(0, list);
//         // for (int i = 1; i < length; i++) {
//         //     for (Integer key : map.keySet()) {
//         //         List<Integer> l = map.get(key);
//         //         if (nums[l.get(l.size() - 1)] > nums[i]) {
//         //             l.add(i);
//         //         } else {
//         //             List<Integer> newList = new ArrayList<>();
//         //             newList.add(i);
//         //             map.put(i, newList);
//         //         }
//         //     }
//         // }

//         // Map<Integer, Long> countMap = new HashMap<>();
//         // for (Integer key : map.keySet()) {
//         //     int l = map.get(key).size();
//         //     Long t = countMap.get(l);
//         //     if (t == null) {
//         //         t = (long) (Math.pow(2, l) - 1 - l);
//         //         countMap.put(l, t);
//         //     }
//         //     count += t;
//         // }

//         for (int i = 0; i < length - 1; i++) {
//             for (int j = i + 1; j < length; j++) {
//                 if (nums[i] > nums[j]) count++;
//             }
//         }

//         return count;
//     }

//     public static void main(String[] args) {
//         // 7,5,__             2,1
//         // 7,6,__             2,1
//         // __=4,3,2,1,0       10

//         // 7+5+5+10
//         new Solution().reversePairs(new int[] { 7, 5, 6, 4, 3, 2, 1, 0 });
//     }
// }

public class Solution {

    public int reversePairs(int[] nums) {
        int len = nums.length;

        if (len < 2) {
            return 0;
        }

        int[] copy = new int[len];
        for (int i = 0; i < len; i++) {
            copy[i] = nums[i];
        }

        int[] temp = new int[len];
        return reversePairs(copy, 0, len - 1, temp);
    }

    /**
     * nums[left..right] 计算逆序对个数并且排序
     *
     * @param nums
     * @param left
     * @param right
     * @param temp
     * @return
     */
    private int reversePairs(int[] nums, int left, int right, int[] temp) {
        if (left == right) {
            return 0;
        }

        int mid = left + (right - left) / 2;
        int leftPairs = reversePairs(nums, left, mid, temp);
        int rightPairs = reversePairs(nums, mid + 1, right, temp);

        if (nums[mid] <= nums[mid + 1]) {
            return leftPairs + rightPairs;
        }

        int crossPairs = mergeAndCount(nums, left, mid, right, temp);
        return leftPairs + rightPairs + crossPairs;
    }

    /**
     * nums[left..mid] 有序，nums[mid + 1..right] 有序
     *
     * @param nums
     * @param left
     * @param mid
     * @param right
     * @param temp
     * @return
     */
    private int mergeAndCount(int[] nums, int left, int mid, int right, int[] temp) {
        for (int i = left; i <= right; i++) {
            temp[i] = nums[i];
        }

        int i = left;
        int j = mid + 1;

        int count = 0;
        for (int k = left; k <= right; k++) {

            if (i == mid + 1) {
                nums[k] = temp[j];
                j++;
            } else if (j == right + 1) {
                nums[k] = temp[i];
                i++;
            } else if (temp[i] <= temp[j]) {
                nums[k] = temp[i];
                i++;
            } else {
                nums[k] = temp[j];
                j++;
                count += (mid - i + 1);
            }
        }
        return count;
    }
}
// @lc code=end

