package org.example;

public class ArrayAlgoManager {

    //剑指 Offer 53 - II. 0～n-1中缺失的数字
    public int missingNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (i != nums[i]) {
                return i;
            }
        }
        return nums.length;
    }

}
