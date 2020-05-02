import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * @Author: aponder
 * @Date: 2020-05-02 10:05:53
 * @LastEditors: aponder
 * @LastEditTime: 2020-05-02 10:43:04
 * @FilePath: /leetcode-zh/easy/299.猜数字游戏/Solution.java
 */
/*
 * @lc app=leetcode.cn id=299 lang=java
 *
 * [299] 猜数字游戏
 *
 * https://leetcode-cn.com/problems/bulls-and-cows/description/
 *
 * algorithms
 * Easy (47.38%)
 * Likes:    68
 * Dislikes: 0
 * Total Accepted:    12.4K
 * Total Submissions: 26K
 * Testcase Example:  '"1807"\n"7810"'
 *
 * 你正在和你的朋友玩 猜数字（Bulls and
 * Cows）游戏：你写下一个数字让你的朋友猜。每次他猜测后，你给他一个提示，告诉他有多少位数字和确切位置都猜对了（称为“Bulls”,
 * 公牛），有多少位数字猜对了但是位置不对（称为“Cows”, 奶牛）。你的朋友将会根据提示继续猜，直到猜出秘密数字。
 * 
 * 请写出一个根据秘密数字和朋友的猜测数返回提示的函数，用 A 表示公牛，用 B 表示奶牛。
 * 
 * 请注意秘密数字和朋友的猜测数都可能含有重复数字。
 * 
 * 示例 1:
 * 
 * 输入: secret = "1807", guess = "7810"
 * 
 * 输出: "1A3B"
 * 
 * 解释: 1 公牛和 3 奶牛。公牛是 8，奶牛是 0, 1 和 7。
 * 
 * 示例 2:
 * 
 * 输入: secret = "1123", guess = "0111"
 * 
 * 输出: "1A1B"
 * 
 * 解释: 朋友猜测数中的第一个 1 是公牛，第二个或第三个 1 可被视为奶牛。
 * 
 * 说明: 你可以假设秘密数字和朋友的猜测数都只包含数字，并且它们的长度永远相等。
 * 
 */

// @lc code=start
class Solution {
    // 方法 1
    // public String getHint(String secret, String guess) {
    //     int l1 = secret.length();
    //     int l2 = guess.length();
    //     if (l1 != l2) return "";

    //     Map<Character, Integer> map1 = new HashMap();
    //     Map<Character, Integer> map2 = new HashMap();
        
    //     int a = 0, b = 0;
    //     char c1, c2;
    //     for (int i = 0; i < l1; i++) {
    //         c1 = secret.charAt(i);
    //         c2 = guess.charAt(i);
    //         if (c1 == c2) a++;
    //         else {
    //             Integer t1 = map1.get(c1);
    //             if (t1 == null) map1.put(c1, 1);
    //             else map1.put(c1, 1 + t1);
                
    //             Integer t2 = map2.get(c2);
    //             if (t2 == null) map2.put(c2, 1);
    //             else map2.put(c2, 1 + t2);
    //         }
    //     }

    //     Set<Character> set1 = map1.keySet();
    //     Set<Character> set2 = map2.keySet();
    //     set1.retainAll(set2);
    //     for (Character c : set1) {
    //         // System.out.println(c + ":" + map1.get(c) + "," + map2.get(c));
    //         b += Math.min(map1.get(c), map2.get(c));
    //     }

    //     return "" + a + "A" + b + "B";
    // }

    public String getHint(String secret, String guess) {
        int l1 = secret.length();
        int l2 = guess.length();
        if (l1 != l2) return "";

        int[] map1 = new int[10];
        int[] map2 = new int[10];
        
        int a = 0, b = 0;
        char c1, c2;
        for (int i = 0; i < l1; i++) {
            c1 = secret.charAt(i);
            c2 = guess.charAt(i);
            if (c1 == c2) a++;
            else {
                map1[c1 - '0'] += 1;
                map2[c2 - '0'] += 1;
            }
        }

        for (int i = 0; i < 10; i++) {
            b += Math.min(map1[i], map2[i]);
        }

        // return "" + a + "A" + b + "B";

        // 方法 3
        StringBuilder sb = new StringBuilder();
        return sb.append(a).append('A').append(b).append('B').toString();
    }
}
// @lc code=end

// 方法 1
// Accepted
// 152/152 cases passed (11 ms)
// Your runtime beats 25.97 % of java submissions
// Your memory usage beats 5.55 % of java submissions (40 MB)

// 方法 2
// Accepted
// 152/152 cases passed (6 ms)
// Your runtime beats 79.22 % of java submissions
// Your memory usage beats 5.55 % of java submissions (40.2 MB)

// 方法 3
// Accepted
// 152/152 cases passed (1 ms)
// Your runtime beats 100 % of java submissions
// Your memory usage beats 5.55 % of java submissions (38.6 MB)