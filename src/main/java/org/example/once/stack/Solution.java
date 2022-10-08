package org.example.once.stack;

import java.util.Random;

//528. 按权重随机选择
class Solution {
    private int[] pre;

    private int length;

    public Solution(int[] w) {
        this.pre = new int[w.length + 1];
        int i = 1;
        for (; i < pre.length; i++) {
            pre[i] = pre[i - 1] + w[i - 1];
        }
        length = pre[i - 1];
    }

    public int pickIndex() {
        int n = new Random().nextInt(length);
        return binSearchPreSumReturnWIndex(n);
    }

    private int binSearchPreSumReturnWIndex(int n) {
        int low = 0, high = pre.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (pre[mid] == n) {
                return mid;
            } else if (pre[mid] < n) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] w = {3, 6, 0, 8};
        Solution solution = new Solution(w);
        System.out.println(solution.pickIndex());
        System.out.println(solution.pickIndex());
    }
}