package editor.cn.Z字形变换_6;
//将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
//
// 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下： 
//
// 
//P   A   H   N
//A P L S I I G
//Y   I   R 
//
// 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。 
//
// 请你实现这个将字符串进行指定行数变换的函数： 
//
// 
//string convert(string s, int numRows); 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "PAYPALISHIRING", numRows = 3
//输出："PAHNAPLSIIGYIR"
// 
//示例 2：
//
// 
//输入：s = "PAYPALISHIRING", numRows = 4
//输出："PINALSIGYAHRPI"
//解释：
//P     I    N
//A   L S  I G
//Y A   H R
//P     I
// 
//
// 示例 3： 
//
// 
//输入：s = "A", numRows = 1
//输出："A"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 由英文字母（小写和大写）、',' 和 '.' 组成 
// 1 <= numRows <= 1000 
// 
// Related Topics 字符串 
// 👍 1195 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * 第一遍思路，使用一个char[numRows][]矩阵,i=0为行索引,j=0为列索引,k为字符串索引
 * while k<length,当i=0时,循环i到numRows-1,填充一列数据,
 * 当i=numRows-1,循环i--,j++到i=0,填充斜线数据
 * 循环填充整个矩阵,再依次遍历
 *
 * 执行用时：51 ms, 在所有 Java 提交中击败了9.78%的用户
 * 内存消耗：39.8 MB, 在所有 Java 提交中击败了9.24%的用户
 *
 *
 * 第二遍思路,用一个StringBuilder[numRows]存每一行的字符，替换思路1中的矩阵
 * 执行用时：9 ms, 在所有 Java 提交中击败了38.87%的用户
 * 内存消耗：39.2 MB, 在所有 Java 提交中击败了24.83%的用户
 */
class Solution {
    public static String convert(String s, int numRows) {
        if(s.length()==0 || s.length() == 1 || numRows == 1){
            return s;
        }
        int length = s.length(),k=0,i=0,j=0;
        StringBuilder stringBuilder = new StringBuilder();
        char[][] arr = new char[numRows][(length/(2*numRows-2)+1)*(numRows-1)];
        for(int l = 0;l<numRows;l++){
            int eachLength = arr[l].length;
            for (int h = 0;h<eachLength;h++){
                arr[l][h] = '-';
            }
        }
        while (k < length){
            if(i == 0){
                while (i<numRows && k<length){
                    arr[i][j] = s.charAt(k);
                    if(i == numRows-1){
                        break;
                    }
                    k++;
                    i++;
                }
            }
            if(i == numRows -1 ){
                while (i>=0 && k<length){
                    arr[i][j]=s.charAt(k);
                    if(i == 0){
                        break;
                    }
                    k++;
                    i--;
                    j++;
                }
            }
        }
        for(int l = 0;l<numRows;l++){
            int eachLength = arr[l].length;
            for (int h = 0;h<eachLength;h++){
                char str = arr[l][h];
                if(str != '-'){
                    stringBuilder.append(str);
                }
            }
        }
        return stringBuilder.toString();
    }

    public static String convert2(String s, int numRows) {
        if(s.length()==0 || s.length() == 1 || numRows == 1){
            return s;
        }
        int length = s.length(),k=0,i=0,j=0;
        StringBuilder[] arr = new StringBuilder[numRows];
        for (int index = 0;index<numRows;index++){
            arr[index] = new StringBuilder("");
        }
        arr[0].append(s.charAt(0));
        while (k < length){
            if(i == 0){
                while (i<numRows && k<length){
                    if(i != 0){
                        arr[i].append(s.charAt(k));
                    }
                    if(i == numRows-1){
                        break;
                    }
                    k++;
                    i++;
                }
            }
            if(i == numRows -1 ){
                while (i>=0 && k<length){
                    if(i != numRows -1){
                        arr[i].append(s.charAt(k));
                    }
                    if(i == 0){
                        break;
                    }
                    k++;
                    i--;
                    j++;
                }
            }
        }
        String res = "";
        for (int index = 0;index<numRows;index++){
            res += arr[index].toString();
        }
        return  res;
    }

    public static void main(String[] args) {
        convert2("abcdefghijklmno",4);
    }
}


//leetcode submit region end(Prohibit modification and deletion)
