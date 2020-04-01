/*
 * @lc app=leetcode.cn id=26 lang=java
 *
 * [26] 删除排序数组中的重复项
 *
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/description/
 *
 * algorithms
 * Easy (49.31%)
 * Likes:    1372
 * Dislikes: 0
 * Total Accepted:    281.6K
 * Total Submissions: 570.8K
 * Testcase Example:  '[1,1,2]'
 *
 * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * 
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * 
 * 
 * 
 * 示例 1:
 * 
 * 给定数组 nums = [1,1,2], 
 * 
 * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。 
 * 
 * 你不需要考虑数组中超出新长度后面的元素。
 * 
 * 示例 2:
 * 
 * 给定 nums = [0,0,1,1,1,2,2,3,3,4],
 * 
 * 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
 * 
 * 你不需要考虑数组中超出新长度后面的元素。
 * 
 * 
 * 
 * 
 * 说明:
 * 
 * 为什么返回数值是整数，但输出的答案是数组呢?
 * 
 * 请注意，输入数组是以「引用」方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
 * 
 * 你可以想象内部操作如下:
 * 
 * // nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
 * int len = removeDuplicates(nums);
 * 
 * // 在函数里修改输入数组对于调用者是可见的。
 * // 根据你的函数返回的长度, 它会打印出数组中该长度范围内的所有元素。
 * for (int i = 0; i < len; i++) {
 * print(nums[i]);
 * }
 * 
 * 
 */

// @lc code=start
class Solution {
    public int removeDuplicates(int[] nums) {
        int l = nums.length;
        if (l == 0) {
            return 0;
        }

        int lastNum = nums[0];
        int p = 1;  // 新数组的长度
        for (int i = 1; i < l - 1; i++) {  // 此处 i < l-1 ，确保 下面的 i+1 不越界
            if (lastNum == nums[i]) {
                // 当前的数与上次的数相等，即该数是重复的，修改新数组当前位置为下一个数（假设下一个数不重复）
                nums[p] = nums[i + 1];
            } else {
                // 当前数不重复，修改新数组当前位置为该数，将新数组的长度 p 增加 1
                nums[p] = nums[i];
                lastNum = nums[p];
                p++;
            }
        }
        // 最后检查最后一个数是否重复
        if (lastNum == nums[l - 1]) {
            // 重复，忽略该数
        } else {
            // 不重复，p 增加 1，将新数组最后一个数更新为该数
            p++;
            nums[p - 1] = nums[l - 1];
        }

        return p;
    }
}
// @lc code=end

// Accepted
// 161/161 cases passed (1 ms)
// Your runtime beats 99.69 % of java submissions
// Your memory usage beats 5.01 % of java submissions (42.2 MB)