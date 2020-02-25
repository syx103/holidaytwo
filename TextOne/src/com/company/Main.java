package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Solution solution = new Solution();
        int[][] kk = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        System.out.println(solution.spiralOrder(kk));
    }
}
//最后一个单词的长度
/*class Solution {
    public int lengthOfLastWord(String s) {
        StringBuffer stringBuffer = new StringBuffer(s);
        String s1 = stringBuffer.reverse().toString().trim();
        int num = 0,lenth = 0;
        while (num <= s1.length() - 1 && s1.charAt(num) != ' ') {
            lenth ++;
//            if(num == s1.length() - 1) {
//                lenth = 0;
//            }
            num ++;
        }
        return lenth;
    }
}*/
//螺旋矩阵
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int i,j,k,l,len;
        len = matrix.length / 2;
        for (int num = 0;num < len; num ++) {
            for (i = num; i < matrix[0].length - num - 1; i++) {
                list.add(matrix[num][i]);
            }
            for (j = num; j < matrix.length - num - 1; j++) {
                list.add(matrix[j][i]);
            }
            for (k = i - num; k > num; k--) {
                list.add(matrix[j][k]);
            }
            for (l = j - num;l > num; l--) {
                list.add(matrix[l][num]);
            }
        }
        if (matrix.length % 2 != 0) {
            list.add(matrix[len][len]);
        }
        return list;
    }
}
