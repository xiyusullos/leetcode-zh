/*
 * @Author: aponder
 * @Date: 2020-05-12 13:35:38
 * @LastEditors: aponder
 * @LastEditTime: 2020-05-12 13:47:12
 * @FilePath: /leetcode-zh/easy/443.压缩字符串/Solution.java
 */
/*
 * @lc app=leetcode.cn id=443 lang=java
 *
 * [443] 压缩字符串
 *
 * https://leetcode-cn.com/problems/string-compression/description/
 *
 * algorithms
 * Easy (39.73%)
 * Likes:    110
 * Dislikes: 0
 * Total Accepted:    16K
 * Total Submissions: 39.9K
 * Testcase Example:  '["a","a","b","b","c","c","c"]'
 *
 * 给定一组字符，使用原地算法将其压缩。
 * 
 * 压缩后的长度必须始终小于或等于原数组长度。
 * 
 * 数组的每个元素应该是长度为1 的字符（不是 int 整数类型）。
 * 
 * 在完成原地修改输入数组后，返回数组的新长度。
 * 
 * 
 * 
 * 进阶：
 * 你能否仅使用O(1) 空间解决问题？
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：
 * ["a","a","b","b","c","c","c"]
 * 
 * 输出：
 * 返回6，输入数组的前6个字符应该是：["a","2","b","2","c","3"]
 * 
 * 说明：
 * "aa"被"a2"替代。"bb"被"b2"替代。"ccc"被"c3"替代。
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：
 * ["a"]
 * 
 * 输出：
 * 返回1，输入数组的前1个字符应该是：["a"]
 * 
 * 说明：
 * 没有任何字符串被替代。
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：
 * ["a","b","b","b","b","b","b","b","b","b","b","b","b"]
 * 
 * 输出：
 * 返回4，输入数组的前4个字符应该是：["a","b","1","2"]。
 * 
 * 说明：
 * 由于字符"a"不重复，所以不会被压缩。"bbbbbbbbbbbb"被“b12”替代。
 * 注意每个数字在数组中都有它自己的位置。
 * 
 * 
 * 注意：
 * 
 * 
 * 所有字符都有一个ASCII值在[35, 126]区间内。
 * 1 <= len(chars) <= 1000。
 * 
 * 
 */

// @lc code=start
class Solution {
    public int compress(char[] chars) {
        int length = chars.length;
        if (length == 1) return 1;

        char previous = chars[0];
        int num = 0;
        int l = 0;
        String s;
        for (char c : chars) {
            if (c == previous) {
                num++;
            } else {
                chars[l++] = previous;
                if (num != 1) {
                    s = String.valueOf(num);
                    for (char d : s.toCharArray()) {
                        chars[l++] = d;
                    }
                }

                // 重置字符计数
                previous = c;
                num = 1;
            }
        }

        // 最后的重复字符
        chars[l++] = previous;
        if (num != 1) {
            s = String.valueOf(num);
            for (char d : s.toCharArray()) {
                chars[l++] = d;
            }
        }

        return l;
    }
}
// @lc code=end

// Accepted
// 70/70 cases passed (1 ms)
// Your runtime beats 100 % of java submissions
// Your memory usage beats 20 % of java submissions (39 MB)