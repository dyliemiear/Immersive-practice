package editor.cn.无重复字符的最长子串_3;//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 示例 4: 
//
// 
//输入: s = ""
//输出: 0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 5 * 104 
// s 由英文字母、数字、符号和空格组成 
// 
// Related Topics 哈希表 字符串 滑动窗口 
// 👍 5679 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * 第一遍思路：暴力法
 * 两个循环，第一个范围i=[0,s.length)，第二个范围j=[i,s.length)
 * i循环内用HashSet记录每次出现过的字符
 * j循环遍历i位置后的字符,若有重复字符则continue,且记录当前子串长度
 */

import java.util.HashSet;

/**
 * 了解了滑动窗口后，第二遍思路
 * 两个指针,left,right
 * right先找到第一次最大的位置的后一位，left左移到与right位置元素重复的下一个位置。
 * right接着右移，right右移到头时每次都记录下长度
 * 注意，由于right每次停止的地方都比最大长度大1，所以算距离时直接right-left就可以了
 */


public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        if(s.length() == 1){
            return 1;
        }
        int length = s.length();
        int left = 0,right = 0,maxSubLength = 0;
        HashSet<Character> hashSet = new HashSet<>();
        while (right<=length-1){
            char c = s.charAt(right);
            if(!hashSet.contains(c)){
                hashSet.add(c);
                right++;
                maxSubLength = Math.max(maxSubLength, right-left);
            }else {
              while (left < right) {
                  char leftc = s.charAt(left);
                  left++;
                  hashSet.remove(leftc);
                  if(leftc == s.charAt(right)){
                      break;
                  }

              }
            }
        }
        return maxSubLength;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/**

 *
 * 执行用时：8 ms, 在所有 Java 提交中击败了55.16%的用户
 * 内存消耗：38.4 MB, 在所有 Java 提交中击败了74.78%的用户
 */