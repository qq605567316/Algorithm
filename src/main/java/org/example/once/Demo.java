package org.example.once;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Demo {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        String[] arr = input.split(" ");

        List<String> lists = new ArrayList<>();
        String[] sort = new String[15];
        for (int i = 0; i < arr.length; i++) {
            String s = arr[i];
            if (s.length() < 2) {
                char c = s.charAt(0);
                if (c <= '9') {
                    sort[c - 48] = s;
                } else if (c == 'J') {
                    sort[11] = s;
                } else if (c == 'Q') {
                    sort[12] = s;
                } else if (c == 'K') {
                    sort[13] = s;
                } else if (c == 'A') {
                    sort[14] = s;
                }
            } else {
                sort[10] = s;
            }
        }
        int t = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 3; i < sort.length; i++) {
            String s = sort[i];
            if (s != null) {
                t++;
                sb.append(s).append(" ");
            } else {
                if (t >= 5) {
                    lists.add(sb.toString().substring(0, sb.length() - 1));
                }
                t = 0;
                sb = new StringBuilder();
            }
        }
        if (t >= 5 && !sb.equals("")) {
            lists.add(sb.toString());
        }
        if (lists.size() == 0) {
            System.out.println("No");
        } else {
            for (String s : lists) {
                System.out.println(s);
            }
        }
    }
}
