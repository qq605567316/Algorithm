package org.example.once;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int resultNum = 0;
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        if (n != 1) {
            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = in.nextInt();
            }
            Arrays.sort(array);

            for (int i = array.length - 1; i > 0; i--) {
                for (int j = i - 1; j >= 0; j--) {
                    int temp = array[i] + array[j];
                    if (temp == 24) {
                        resultNum++;
                    } else if (temp < 24) {
                        resultNum = getResult(resultNum, array, temp, j - 1);
                        break;
                    }
                }
            }
        }

        System.out.println(resultNum);
    }

    public static int getResult(int resultNum, int[] array, int temp, int j) {
        if (j < 0) {
            return resultNum;
        }
        temp = temp + array[j];
        if (temp == 24) {
            return resultNum + 1;
        } else if (temp > 24) {
            return resultNum;
        }
        return getResult(resultNum, array, temp, j - 1);
    }

}
