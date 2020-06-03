/*
 * @Author: aponder
 * @Date: 2020-06-03 23:45:51
 * @LastEditTime: 2020-06-03 23:58:27
 * @LastEditors: aponder
 * @Description: 
 * @FilePath: /leetcode-zh/easy/686.重复叠加字符串匹配/Solution.java
 */ 
/*
 * @lc app=leetcode.cn id=686 lang=java
 *
 * [686] 重复叠加字符串匹配
 *
 * https://leetcode-cn.com/problems/repeated-string-match/description/
 *
 * algorithms
 * Easy (33.93%)
 * Likes:    82
 * Dislikes: 0
 * Total Accepted:    9.9K
 * Total Submissions: 29.3K
 * Testcase Example:  '"abcd"\n"cdabcdab"'
 *
 * 给定两个字符串 A 和 B, 寻找重复叠加字符串A的最小次数，使得字符串B成为叠加后的字符串A的子串，如果不存在则返回 -1。
 * 
 * 举个例子，A = "abcd"，B = "cdabcdab"。
 * 
 * 答案为 3， 因为 A 重复叠加三遍后为 “abcdabcdabcd”，此时 B 是其子串；A 重复叠加两遍后为"abcdabcd"，B
 * 并不是其子串。
 * 
 * 注意:
 * 
 * A 与 B 字符串的长度在1和10000区间范围内。
 * 
 */

// @lc code=start
class Solution {
    // public int repeatedStringMatch(String A, String B) {
    //     int la = A.length();
    //     int i = A.indexOf(B.charAt(0));
    //     int count = 1;
    //     for (char c : B.toCharArray()) {
    //         if (A.charAt(i) == c) {
    //             i++;
    //             count += i / la;
    //             i = i % la;
    //         } else {
    //             return -1;
    //         }
    //     }
    //     return count;
    // }

    public int repeatedStringMatch(String A, String B) {
        
        /*if(A == null)return -1;
        if(B == null)return 0;
            //暴力法
            int count = B.length() / A.length();
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<count;i++){
                sb.append(A);
            }
            if(B.equals(sb.toString())){
                return count;
            }
            sb.append(A);
            if(sb.indexOf(B) != -1){
                return count+1;
            }
            sb.append(A);
            if(sb.indexOf(B) != -1){
                return count+2;
            }
            return -1;*/
            //先查询是否包含A，然后比较头长度，作头操作.若符合利用loop数组看能否跑到尾，loop的计数就能算出次数
            //先看是否包含尾部(最长?不可，记录尾数组？)
        /*int i=0;
        StringBuilder sb = new StringBuilder();
        while(sb.length() < B.length()){
            sb.append(A);
            i++;
        }
        return sb.lastIndexOf(B) == -1 ? (sb.append(A).lastIndexOf(B) == -1 ? -1 : i+1) : i;*/
        //滚轮？ A作为滚轮
        char[] a = A.toCharArray();
        char[] b = B.toCharArray();
        for(int i=0;i<a.length;i++){
            int len = loop(a,b,i);
            if(len > 0){// 
                int count = 1;
                /*len -= (a.length-i);
                if(len > 0){
                    count += len/a.length;
                    count += len%a.length > 0 ? 1 : 0;
                }*/
                len = B.length() - a.length + i;
                count += len/a.length;
                count += len%a.length > 0 ? 1 : 0;
                return count;
            }else if(len + a.length <= 0){
                return -1;
            }
        }
        return -1;
        
    }
    //使用a滚轮印刷b，start为起始点
    public int loop(char[] a,char[] b,int start){
        int count = start;
        for(char c : b){
            if(a[start % a.length] != c){
                return count - start;
            }
            start++;
        }
        return 1;//start - count;
    }
}
// @lc code=end

// Accepted
// 55/55 cases passed (0 ms)
// Your runtime beats 100 % of java submissions
// Your memory usage beats 16.67 % of java submissions (38 MB)