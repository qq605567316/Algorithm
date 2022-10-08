package org.example.once.stack;

import java.util.Arrays;
import java.util.Scanner;

public class Demo2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        int k = in.nextInt();
        int[] arr = new int[52];
        int[] count = new int[52];
        Arrays.fill(arr, -1);
        for (int i = 0; i < s.length(); i++) {
            int a = s.charAt(i);
            if (a < 91) {
                if (arr[a - 65] == -1) {
                    arr[a - 65] = i;
                }
                count[a - 65]++;
            } else {
                if (arr[a - 71] == -1) {
                    arr[a - 71] = i;
                }
                count[a - 71]++;
            }
        }
        int i = 0;
        int n = 0;
        for (; i < arr.length; i++) {
            if (arr[i] != -1) {
                k -= count[i];
                n = i;
            }
            if (k <= 0) {
                System.out.println(arr[i]);
                return;
            }
        }
        System.out.println(arr[n]);
    }
}
