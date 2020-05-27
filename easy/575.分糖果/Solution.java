/*
 * @Author: aponder
 * @Date: 2020-05-27 23:48:43
 * @LastEditTime: 2020-05-27 23:50:20
 * @LastEditors: aponder
 * @Description: 
 * @FilePath: /leetcode-zh/easy/575.分糖果/Solution.java
 */ 
import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=575 lang=java
 *
 * [575] 分糖果
 *
 * https://leetcode-cn.com/problems/distribute-candies/description/
 *
 * algorithms
 * Easy (66.09%)
 * Likes:    68
 * Dislikes: 0
 * Total Accepted:    20.2K
 * Total Submissions: 30.4K
 * Testcase Example:  '[1,1,2,2,3,3]'
 *
 * 
 * 给定一个偶数长度的数组，其中不同的数字代表着不同种类的糖果，每一个数字代表一个糖果。你需要把这些糖果平均分给一个弟弟和一个妹妹。返回妹妹可以获得的最大糖果的种类数。
 * 
 * 示例 1:
 * 
 * 
 * 输入: candies = [1,1,2,2,3,3]
 * 输出: 3
 * 解析: 一共有三种种类的糖果，每一种都有两个。
 * ⁠    最优分配方案：妹妹获得[1,2,3],弟弟也获得[1,2,3]。这样使妹妹获得糖果的种类数最多。
 * 
 * 
 * 示例 2 :
 * 
 * 
 * 输入: candies = [1,1,2,3]
 * 输出: 2
 * 解析: 妹妹获得糖果[2,3],弟弟获得糖果[1,1]，妹妹有两种不同的糖果，弟弟只有一种。这样使得妹妹可以获得的糖果种类数最多。
 * 
 * 
 * 注意:
 * 
 * 
 * 数组的长度为[2, 10,000]，并且确定为偶数。
 * 数组中数字的大小在范围[-100,000, 100,000]内。
 * 
 * 
 * 
 * 
 * 
 */

// @lc code=start
class Solution {
    public int distributeCandies(int[] candies) {
        int l = candies.length;
        Set<Integer> set = new HashSet<>(l);
        for (int candy : candies) {
            set.add(candy);
        }

        return Math.min(set.size(), l / 2);
    }
}
// @lc code=end

// Accepted
// 205/205 cases passed (27 ms)
// Your runtime beats 93.08 % of java submissions
// Your memory usage beats 50 % of java submissions (42.9 MB)