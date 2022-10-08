package org.example.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Demo3 {
    public static void main(String[] args) {
        int[] a = new int[100];
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<String> rs = new ArrayList<>();
        retry:
        for (int i = 0; i < n; i++) {
            String s = in.next();
            String[] arr = s.split("=");
            if (arr[0].equals("REQUEST")) {
                for (int j = 0; j < 100; j++) {
                    if (j == 0) {
                        get(a, Integer.parseInt(arr[1]));
                        rs.add(j + "");
                    }
                }
                rs.add("error");
            } else {
                int j = Integer.parseInt(arr[1]);
                if (a[j] > 0) {
                    clear(a, j);
                }
            }
        }
        rs.forEach(System.out::println);
    }

    public static void get(int[] a, int size) {

    }

    public static void clear(int[] a, int j) {
        do {
            a[j] = 0;
            j++;
        } while (a[j] < 0);
    }
}
