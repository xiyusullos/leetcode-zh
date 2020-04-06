import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=70 lang=java
 *
 * [70] 爬楼梯
 *
 * https://leetcode-cn.com/problems/climbing-stairs/description/
 *
 * algorithms
 * Easy (48.21%)
 * Likes:    912
 * Dislikes: 0
 * Total Accepted:    164.8K
 * Total Submissions: 341.8K
 * Testcase Example:  '2'
 *
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 
 * 注意：给定 n 是一个正整数。
 * 
 * 示例 1：
 * 
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 
 * 示例 2：
 * 
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 * 
 * 
 */

// @lc code=start
class Solution {
    public int climbStairs(int n) {
        // C(n, k), k 个 2
        int i = 0, j = n / 2;
        int r = 0;
        for (int k = i; k <= j; k++) {
            r += C(n - k, k);
        }

        return r;

    }

    int C(int n, int k) {
        // n! / (k! * (n-k)!)
        Set<Integer> set0 = buildArrangementSet(n);
        Set<Integer> set1 = buildArrangementSet(k);
        Set<Integer> set2 = buildArrangementSet(n-k);
        // 约去 set0 和 set1
        Set<Integer> set1Join = buildArrangementSet(n);
        set1Join.retainAll(set1);
        set0.removeAll(set1Join);
        set1.removeAll(set1Join);
        // 对 约去后 set0 和 set2 进行约分
        Set<Integer> set2Join = new HashSet<>();
        set2Join.addAll(set0);
        set2Join.retainAll(set2);
        set0.removeAll(set2Join);
        set2.removeAll(set2Join);
 
        int l0 = set0.size(), l1 = set1.size(), l2 = set2.size();
        Integer[] nums0 = set0.toArray(new Integer[l0]);
        Integer[] nums1 = set1.toArray(new Integer[l1]);
        Integer[] nums2 = set2.toArray(new Integer[l2]);
        
        long result = 1;
        for (int i = 0; i < l0; i++) {
            if (i < l0) {
                result *= nums0[i];
            }
            if (i < l1) {
                result /= nums1[i];
            }
            if (i < l2) {
                result /= nums2[i];
            }
        }
        
        return (int) result;

        
    }

    // int[] join(int[] set1, int[] set2) {
    //     List<Integer> arr=new ArrayList<>();
    //     for (int i : set1) {
            
    //     }
    // }

    // boolean in(int[] set, int k) {
    //     for (int i : set) {
    //         if (i == k) {
    //             return true;
    //         }
    //     }
    //     return false;
    // }

    Set<Integer> buildArrangementSet(int n) {
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            set.add(i);
        }
        return set;
    }

    // /**
    //  * @description: Combination
    //  * @param n
    //  * @param k 
    //  * @return: 
    //  */    
    // int C(int n, int k) {
    //     return A(n) / A(k) / A(n - k);
    // }

    
    // /**
    //  * @description: Arrangement
    //  * @param n 
    //  * @return: 
    //  */    
    // int A(int n) {
    //     int r = 1;
    //     while (n > 0) {
    //         r *= n--;
    //     }
    //     return r;
    // }
}
// @lc code=end
