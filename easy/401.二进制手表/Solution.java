
/*
 * @Author: aponder
 * @Date: 2020-05-08 11:07:16
 * @LastEditors: aponder
 * @LastEditTime: 2020-05-08 12:36:38
 * @FilePath: /leetcode-zh/easy/401.二进制手表/Solution.java
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=401 lang=java
 *
 * [401] 二进制手表
 *
 * https://leetcode-cn.com/problems/binary-watch/description/
 *
 * algorithms
 * Easy (51.89%)
 * Likes:    130
 * Dislikes: 0
 * Total Accepted:    13.7K
 * Total Submissions: 26.3K
 * Testcase Example:  '0'
 *
 * 二进制手表顶部有 4 个 LED 代表小时（0-11），底部的 6 个 LED 代表分钟（0-59）。
 * 
 * 每个 LED 代表一个 0 或 1，最低位在右侧。
 * 
 * 
 * 
 * 例如，上面的二进制手表读取 “3:25”。
 * 
 * 给定一个非负整数 n 代表当前 LED 亮着的数量，返回所有可能的时间。
 * 
 * 案例:
 * 
 * 
 * 输入: n = 1
 * 返回: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16",
 * "0:32"]
 * 
 * 
 * 
 * 注意事项:
 * 
 * 
 * 输出的顺序没有要求。
 * 小时不会以零开头，比如 “01:00” 是不允许的，应为 “1:00”。
 * 分钟必须由两位数组成，可能会以零开头，比如 “10:2” 是无效的，应为 “10:02”。
 * 
 * 
 */

// @lc code=start
class Solution {
    // Map<Integer, List<String>> map = new HashMap<>();
    public List<String> readBinaryWatch(int num) {
        // h: 1->4, 2->5, 3->2, 4->0
        // m: 1->6, 2->15, 3->20, 4->14, 5->4, 6->0
        // n: 1->10, 2->44, 3->22+60+30=112, 4->14+80+75+12, 5->4+56+100+30,
        // 6->16+70+40, 7->20+28, 8->8, 9->0
        List<String> list = new ArrayList<>();
        if (num >= 9)
            return list;
        
        if (num == 0) {
            list.add("0:00");
            return list;
        }

        for (int h = 0; h < 12; h++) {
            for (int m = 0; m < 60; m++) {
                if (Integer.bitCount(h) + Integer.bitCount(m) == num)
                    // times.add(String.format("%d:%02d", h, m));
                    list.add(toTimeString(h, m));
            }
        }

        return list;
    }

    String toTimeString(int h, int m) {
        StringBuilder sb = new StringBuilder();
        sb.append(h).append(':');
        if (m < 10)
            sb.append('0');
        sb.append(m);

        return sb.toString();
    }
}
// @lc code=end

// Accepted
// 10/10 cases passed (1 ms)
// Your runtime beats 98.85 % of java submissions
// Your memory usage beats 10 % of java submissions (38.5 MB)