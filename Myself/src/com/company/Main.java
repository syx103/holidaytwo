package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string1 = scanner.nextLine();
        String string2 = scanner.nextLine();
        if (string1.equals("0")  || string2.equals("0")) {
            System.out.println("0");
        } else {
            int len1 = string1.length();
            int len2 = string2.length();
            int ten = 0, one, mul;
            int[][] result = new int[len2][len1 + len2];
            int k = 0, h = 0;
            for (int i = len2 - 1; i >= 0; i--) {
                for (int j = len1 - 1; j >= 0; j--) {
                    k = len2 - 1 - i;
                    h = len1 - 1 - j;
                    mul = (string1.charAt(j) - '0') * (string2.charAt(i) - '0');
                    one = mul % 10 + ten;
                    ten = mul / 10;
                    result[k][h + k] = one;
                }
                if (ten != 0) {
                    result[k][h + k + 1] = ten;
                    ten = 0;
                }
            }
            ten = 0;
            StringBuffer stringBuffer = new StringBuffer();
            for (int i = 0; i < len2 + len1; i++) {
                int temp = 0;
                for (int j = 0; j < len2; j++) {
                    temp += result[j][i];
                }
                one = (temp + ten) % 10;
                ten = (temp + ten) / 10;
                stringBuffer.append(one);
            }
            if (ten != 0) {
                stringBuffer.append(ten);
            }
            String s = stringBuffer.reverse().toString();
            int i = 0;
            while (s.charAt(i) == '0') {
                i++;
            }
            System.out.println(s.substring(i));
        }
    }
}

