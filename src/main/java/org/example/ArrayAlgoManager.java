package org.example;

import javax.swing.*;
import java.util.*;

public class ArrayAlgoManager {
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

    //771. 宝石与石头
    public int numJewelsInStones(String jewels, String stones) {
        int result = 0;
        for (char c : stones.toCharArray()) {
            if (jewels.contains(Character.toString(c))) {
                result++;
            }
        }
        return result;
    }

    //290. 单词规律
    public boolean wordPattern(String pattern, String s) {
        char[] chars = pattern.toCharArray();
        String[] strings = s.split(" ");
        Map<Character, String> map = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            if (map.containsKey(chars[i])) {
                if (!map.get(chars[i]).equals(strings[i])) {
                    return false;
                }
            } else {
                map.put(chars[i], strings[i]);
            }
        }
        return true;
    }

    //14. 最长公共前缀
    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();
        Arrays.sort(strs);
        int length = strs.length;
        for (int i = 0; i < strs[length - 1].length() || i < strs[0].length(); i++) {
            if (strs[0].charAt(i) == strs[length - 1].charAt(i)) {
                sb.append(strs[0].charAt(i));
            } else {
                break;
            }
        }
        return sb.toString();
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //5. 最长回文子串
    public String longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        if (chars.length == 1) {
            return s;
        }
        Map<Character, String> map = new HashMap<>();
        int[] arr = {0, 1};      //arr[0]：最长串起始下标  arr[1]：最长串结束的下标（不包括） subString结果为[arr[0], arr[1])
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == chars[i - 1]) {
                findLongestPalindrome(chars, arr, i - 2, i + 1);
            }
            if (i > 1 && chars[i] == chars[i - 2]) {
                findLongestPalindrome(chars, arr, i - 3, i + 1);
            }
        }
        return s.substring(arr[0], arr[1]);
    }

    public void findLongestPalindrome(char[] chars, int[] arr, int left, int right) {
        while (left > -1 && right < chars.length) {
            if (chars[left] == chars[right]) {
                left--;
                right++;
            } else {
                break;
            }
        }
        if (right - left - 1 > arr[1] - arr[0]) {
            arr[0] = left + 1;
            arr[1] = right;
        }
    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //1833. 雪糕的最大数量
    public int maxIceCream(int[] costs, int coins) {
        int[] arr = countSort(costs);
        int count = 0;
        for (int x : arr) {
            if (coins >= x) {
                coins -= x;
            } else {
                break;
            }
            count++;
        }
        return count;
    }

    public int[] countSort(int[] arr) {
        int res[] = new int[arr.length];
        int max = arr[0], min = arr[0];
        for (int i : arr) {
            if (i > max) {
                max = i;
            }
            if (i < min) {
                min = i;
            }
        }
        int k = max - min + 1;
        int newArr[] = new int[k];
        for (int i = 0; i < arr.length; ++i) {
            newArr[arr[i] - min] += 1;
        }
        for (int i = 1; i < newArr.length; ++i) {
            newArr[i] = newArr[i] + newArr[i - 1];
        }
        for (int i = arr.length - 1; i >= 0; --i) {
            res[--newArr[arr[i] - min]] = arr[i];
        }
        return res;
    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//    //1833. 雪糕的最大数量
//    public int maxIceCream(int[] costs, int coins) {
//        int result = 0;
//        Arrays.sort(costs);
//        for (int i : costs) {
//            if (coins >= i) {
//                coins -=i;
//                result++;
//            }else {
//                break;
//            }
//        }
//        return result;
//    }

    //1488. 避免洪水泛滥
    public int[] avoidFlood(int[] rains) {
        int days = rains.length;
        int[] result = new int[days];


        Map<Integer, Integer> map = new HashMap<>(days);

        for (int i = 0; i < days; i++) {
            int lake = rains[i];
            if (lake != 0) {
                if (map.containsKey(lake)) {
                    if (!check(result, map.remove(lake) + 1, i, lake)) {
                        return new int[0];
                    }
                } else {
                    map.put(lake, i);
                    result[i] = -1;
                }
            }
        }
        return result;
    }

    private boolean check(int[] rains, int start, int end, int num) {
        for (int i = start; i < end; i++) {
            if (rains[i] == 0) {
                rains[i] = num;
                rains[end] = -1;
                return true;
            }
        }
        return false;
    }

    //413. 等差数列划分
    public int numberOfArithmeticSlices(int[] nums) {
        int length = nums.length;
        if (length < 3) {
            return 0;
        }
        int[] arr = new int[length - 1];
        for (int i = 0; i < length - 1; i++) {
            arr[i] = nums[i + 1] - nums[i];
        }
        List<Integer> list = new ArrayList();
        int n = 1, f = arr[0];
        for (int i = 1; i < length - 1; i++) {
            if (arr[i] == f) {
                n++;
            } else {
                f = arr[i];
                if (n != 1) {
                    list.add(n);
                    n = 1;
                }
            }
        }
        if (n != 1) {
            list.add(n);
        }
        int result = 0;
        for (int k : list) {
            int sum = 0;
            for (int i = 1; i <= k - 1; i++) {
                sum += i;
            }
            result += sum;
        }
        return result;
    }
    //f(1) = 1  f(2) = 3 f(3) = 6 f(4) = 10

    //648. 单词替换
    public String replaceWords(List<String> dictionary, String sentence) {
        String[] words = sentence.split("\\s+");
        StringBuffer res = new StringBuffer();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            for (String prefix : dictionary) {
                if (word.startsWith(prefix)) {
                    word = prefix;
                }
            }
            res.append(word).append(" ");
        }
        return res.toString().trim();
    }

    //1646. 获取生成数组中的最大值
    public int getMaximumGenerated(int n) {
        if (n < 2) {
            return n;
        }
        int[] nums = new int[n + 1];
        nums[0] = 0;
        nums[1] = 1;
        int max = 1;
        for (int i = 2; i <= n; ++i) {
            nums[i] = (i & 1) == 0 ? nums[i >> 1] : nums[i >> 1] + nums[(i >> 1) + 1];
            if (nums[i] > max) max = nums[i];
        }
        return max;
    }

    //787. K 站中转内最便宜的航班
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        final int INF = 10000 * 101 + 1;
        int[] f = new int[n];
        Arrays.fill(f, INF);
        f[src] = 0;
        int ans = INF;
        while (k >= 0) {
            int[] g = new int[n];
            Arrays.fill(g, INF);
            for (int[] flight : flights) {
                int j = flight[0], i = flight[1], cost = flight[2];
                g[i] = Math.min(g[i], f[j] + cost);
            }
            // g[]表示当前状态，f表示上一个状态。f=g，意思是进行状态更新或者说是迭代
            f = g;
            ans = Math.min(ans, f[dst]);
            k--;
        }
        return ans == INF ? -1 : ans;
    }

    //881. 救生艇
    public int numRescueBoats(int[] people, int limit) {
        int result = 0;
        Arrays.sort(people);
        int i = 0, j = people.length - 1;
        while (i <= j) {
            if (i == j) {
                result++;
                break;
            }
            if (people[j] + people[i] > limit) {
                result++;
                j--;
            } else {
                result++;
                i++;
                j--;
            }
        }
        return result;
    }

    //797. 所有可能的路径
//    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
//        Map<Integer, List<Integer>> map = new HashMap<>();
//        for (int i = 0; i < graph.length; i++) {
//            for (int j : graph[i]) {
//                map.putIfAbsent(j, new ArrayList<>());
//                map.get(j).add(i);
//            }
//        }
//
//    }


    //45. 跳跃游戏 II
    public static int jump(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int cur = 0, result = 1;
        int end = nums[0];
        while (end < nums.length - 1) {
            int max = 0;
            for (int i = cur + 1; i <= end; i++) {
                int step = nums[i] + i;
                if (step > max) {
                    max = step;
                }
            }
            result++;
            cur = end;
            end = max;
        }
        return result;
    }

    //1109. 航班预订统计
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] result = new int[n];
        for (int i = 0; i < bookings.length; i++) {
            result[bookings[i][0] - 1] += bookings[i][2];
            if (bookings[i][1] < n) {
                result[bookings[i][1]] -= bookings[i][2];
            }
        }
        for (int i = 1; i < n; i++) {
            result[i] += result[i - 1];
        }
        return result;
    }

    //165. 比较版本号
    public int compareVersion(String version1, String version2) {
        String[] arr1 = version1.split("\\.");
        String[] arr2 = version2.split("\\.");
        int i = 0;
        while (i < arr1.length && i < arr2.length) {
            if (Integer.parseInt(arr1[i]) < Integer.parseInt(arr2[i])) {
                return -1;
            }
            if (Integer.parseInt(arr1[i]) > Integer.parseInt(arr2[i])) {
                return 1;
            }
            i++;
        }
        if (arr1.length > arr2.length) {
            for (; i < arr1.length; i++) {
                if (Integer.parseInt(arr1[i]) != 0) {
                    return 1;
                }
            }
        } else if (arr1.length < arr2.length) {
            for (; i < arr2.length; i++) {
                if (Integer.parseInt(arr2[i]) != 0) {
                    return -1;
                }
            }
        }
        return 0;
    }

    //1775. 通过最少操作次数使数组的和相等
    public int minOperations(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        if (length1 * 6 < length2 || length2 * 6 < length1) {
            return -1;
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < length1; i++) {
            sum1 += nums1[i];
        }
        for (int i = 0; i < length2; i++) {
            sum2 += nums2[i];
        }
        int[] max, min;
        int r;
        if (sum1 > sum2) {
            max = nums1;
            min = nums2;
            r = sum1 - sum2;
        } else if (sum1 < sum2) {
            max = nums2;
            min = nums1;
            r = sum2 - sum1;
        } else {
            return 0;
        }
        int i = 0, j = max.length - 1, p = 0;
        while (i < min.length && j >= 0) {
            int m = max[j] - 1;
            int n = 6 - min[i];
            p++;
            if (m >= n) {
                if (m >= r) {
                    return p;
                }
                r = r - m;
                j--;
            } else {
                if (n >= r) {
                    return p;
                }
                r = r - n;
                i++;
            }
        }
        if (i == min.length) {
            for (int k = j; k >= 0; k--) {
                int m = max[k] - 1;
                p++;
                if (m >= r) {
                    return p;
                }
                r = r - m;
            }
        } else {
            for (int k = 0; k < min.length; k++) {
                int n = 6 - min[k];
                p++;
                if (n >= r) {
                    return p;
                }
                r = r - n;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        LinkedHashMap<String,String> map = new LinkedHashMap<>();
        int[] m = {2, 3, 1, 1, 4};
        System.out.println(jump(m));
        while (true) {
            int res = JOptionPane.showConfirmDialog(null, "你是不是喜欢我", "❤❤❤❤", JOptionPane.YES_NO_OPTION);
            if (res == JOptionPane.YES_OPTION) {
                System.out.println("选择是后执行的代码");
                return;
            } else {
                System.out.println("选择否后执行的代码");
            }
        }
    }
}
