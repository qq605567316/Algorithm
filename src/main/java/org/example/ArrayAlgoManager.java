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

    //414. 第三大的数
    public int thirdMax(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE, flag = 0;
        boolean f = true;
        for (Integer i : nums) {
            if (i == Integer.MIN_VALUE && f) {
                flag++;
                f = false;
            }
            if (i > max1) {
                flag++;
                //原先第二大传递给第三大
                max3 = max2;
                //原先最大值传递给第二大
                max2 = max1;
                //更新最大值
                max1 = i;
            } else if (i > max2 && i < max1) {
                flag++;
                max3 = max2;
                max2 = i;
            } else if (nums[i] > max3 && i < max2) {
                flag++;
                max3 = i;
            }
        }
        return flag >= 3 ? max3 : max1;
    }

}
