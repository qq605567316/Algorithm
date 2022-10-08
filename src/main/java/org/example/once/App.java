package org.example.once;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        int[] x = {4, 2, 3, 1};
        int m = 72;
//        int rs1 = step1(m);
//        int[] arr = {4, 2, 3, 1};
        int[] rs2 = step2(m);
        int[] y = step3(x);
        System.out.println(1);
    }

    public static int step1(int x) {
        x = Math.abs(x);
        if (x < 18) {
            x = 18;
        }
        while ((x = sum(x)) >= 10) {
        }
        return x;
    }

    public static int sum(int x) {
        int sum = 0;
        String s = "" + x;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            sum += Integer.parseInt(String.valueOf(chars[i]));
        }
        return sum;
    }

    public static int[] step2(int x) {
        x = Math.abs(x);
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= Math.sqrt(x); i++) {
            if (x % i == 0) {
                list.add(i);
                if (x / i != i) {
                    list.add(x / i);
                }
            }
        }
        list.sort((v1, v2) -> {
            return v2 - v1;
        });
        int[] rs;
        if (list.size() <= 4) {
            rs = new int[list.size()];
        } else {
            rs = new int[4];
        }
        for (int i = 0; i < rs.length; i++) {
            rs[i] = list.get(i);
        }
        if (list.size() <= 4) {
            Arrays.sort(rs);
        }
        return rs;
    }

    public static int[] step3(int[] x) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < x.length; i++) {
            stack.push(x[i]);
            if (i == 6) {
                break;
            }
        }
        stack.pop();
        int[] rs = new int[stack.size()];
        for (int i = 0; i < rs.length; i++) {
            rs[i] = stack.pop();
        }
        return rs;
    }

}
