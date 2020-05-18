import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=500 lang=java
 *
 * [500] 键盘行
 *
 * https://leetcode-cn.com/problems/keyboard-row/description/
 *
 * algorithms
 * Easy (68.59%)
 * Likes:    92
 * Dislikes: 0
 * Total Accepted:    16.7K
 * Total Submissions: 24.2K
 * Testcase Example:  '["Hello","Alaska","Dad","Peace"]'
 *
 * 给定一个单词列表，只返回可以使用在键盘同一行的字母打印出来的单词。键盘如下图所示。
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 示例：
 * 
 * 输入: ["Hello", "Alaska", "Dad", "Peace"]
 * 输出: ["Alaska", "Dad"]
 * 
 * 
 * 
 * 
 * 注意：
 * 
 * 
 * 你可以重复使用键盘上同一字符。
 * 你可以假设输入的字符串将只包含字母。
 * 
 */

// @lc code=start
class Solution {
    public String[] findWords(String[] words) {
        Set<Character> line1 = new HashSet<>();
        line1.add('q');
        line1.add('w');
        line1.add('e');
        line1.add('r');
        line1.add('t');
        line1.add('y');
        line1.add('u');
        line1.add('i');
        line1.add('o');
        line1.add('p');
        Set<Character> line2 = new HashSet<>();
        line2.add('a');
        line2.add('s');
        line2.add('d');
        line2.add('f');
        line2.add('g');
        line2.add('h');
        line2.add('j');
        line2.add('k');
        line2.add('l');
        Set<Character> line3 = new HashSet<>();
        line3.add('z');
        line3.add('x');
        line3.add('c');
        line3.add('v');
        line3.add('b');
        line3.add('n');
        line3.add('m');
        List<String> result = new ArrayList<>();
        for (String word : words) {
            boolean isLine1 = true;
            boolean isLine2 = true;
            boolean isLine3 = true;
            for (char c : word.toCharArray()) {
                if ('A' <= c && c <= 'Z') c +=32;
                if (isLine1 && !line1.contains(c)) isLine1 = false;
                if (isLine2 && !line2.contains(c)) isLine2 = false;
                if (isLine3 && !line3.contains(c)) isLine3 = false;
            }
            if (isLine1 || isLine2 || isLine3) result.add(word);
        }

        return result.toArray(new String[0]);
    }

    public static void main(String[] args) {
        new Solution().findWords(new String[]{"Hello", "Alaska", "Dad", "Peace"});
    }
}
// @lc code=end

