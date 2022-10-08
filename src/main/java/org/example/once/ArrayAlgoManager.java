package org.example.once;

import org.example.common.ListNode;
import org.example.common.TreeNode;

import java.util.*;
import java.util.stream.IntStream;

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

    //66. 加一
    public int[] plusOne(int[] digits) {
        int length = digits.length;
        for (int i = length - 1; i >= 0; i--) {
            if (digits[i] != 9) {
                digits[i] += 1;
                return digits;
            }
            digits[i] = 0;
        }
        int[] rs = new int[length + 1];
        rs[0] = 1;
        return rs;
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

    //7. 整数反转
    public int reverse(int x) {
        boolean flag = false;
        if (x < 0) {
            flag = true;
            x = -x;
        }
        StringBuilder s = new StringBuilder("0");
        while (x != 0) {
            s.append(x % 10);
            x /= 10;
        }
        try {
            x = Integer.parseInt(s.toString());
        } catch (NumberFormatException e) {
            return 0;
        }
        return flag ? -x : x;
    }

    //9. 回文数
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int n = x, m = 0;
        while (x != 0) {
            m = m * 10 + x % 10;
            x /= 10;
        }
        return n == m;
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


    //13. 罗马数字转整数
    public int romanToInt(String s) {
        Map<Character, Integer> mappingMap = new HashMap<>();
        mappingMap.put('I', 1);
        mappingMap.put('V', 5);
        mappingMap.put('X', 10);
        mappingMap.put('L', 50);
        mappingMap.put('C', 100);
        mappingMap.put('D', 500);
        mappingMap.put('M', 1000);
        int rs = 0;
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length - 1; i++) {
            if (mappingMap.get(arr[i]) < mappingMap.get(arr[i + 1])) {
                rs -= mappingMap.get(arr[i]);
            } else {
                rs += mappingMap.get(arr[i]);
            }
        }
        rs += mappingMap.get(arr[arr.length - 1]);
        return rs;
    }

    //27. 移除元素
    public int removeElement(int[] nums, int val) {
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            if (nums[end] == val) {
                end--;
                continue;
            }
            if (nums[start] == val) {
                nums[start] = nums[end--];
            }
            start++;
        }
        return ++end;
    }

    //28. 实现 strStr()
    public int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0) {
            return 0;
        }
        char[] haystackChars = haystack.toCharArray();
        char[] needleChars = needle.toCharArray();
        int j = 0;
        for (int i = 0; i < haystackChars.length; i++) {
            if (haystackChars[i] != needleChars[j]) {
                if (j != 0) {
                    i = i - j;
                    j = 0;
                }
                continue;
            }
            j++;
            if (j == needleChars.length) {
                return i - j + 1;
            }
        }
        return -1;
    }

    //506. 相对名次
    public String[] findRelativeRanks(int[] score) {
        String[] rs = new String[score.length];
        int max = 0;
        for (int i : score) {
            if (i > max) {
                max = i;
            }
        }
        int[] arr = new int[max + 1];
        int i = 0;
        for (; i < score.length; i++) {
            int index = score[i];
            if (i == 0) {
                arr[index] = -1;
            } else {
                arr[index] = i;
            }
        }
        i = max;
        max = 1;
        while (i >= 0) {
            if (arr[i] != 0) {
                int index = arr[i] == -1 ? 0 : arr[i];
                if (max == 1) {
                    rs[index] = "Gold Medal";
                    max++;
                } else if (max == 2) {
                    rs[index] = "Silver Medal";
                    max++;
                } else if (max == 3) {
                    rs[index] = "Bronze Medal";
                    max++;
                } else {
                    rs[index] = max + "";
                    max++;
                }
            }
            i--;
        }
        return rs;
    }

    //783. 二叉搜索树节点最小距离
    int last = Integer.MAX_VALUE, ans = Integer.MAX_VALUE;

    public int minDiffInBST(TreeNode root) {
        if (root != null) {
            minDiffInBST(root.left);
            ans = Math.min(ans, Math.abs(root.val - last));
            System.out.println(ans);
            last = root.val;
            minDiffInBST(root.right);
        }
        return ans;
    }

    //1034. 边界着色
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        int value = grid[row][col];
        color(grid, row, col, value, color, 0);
        return grid;
    }

    //v的值：  0起点 1up 2down 3left 4right
    private boolean color(int[][] grid, int row, int col, int value, int color, int v) {
        if (grid[row][col] != value) {
            return false;
        }
        boolean f = true;
        while (true) {
            if (v != 1 && row > 0)
                f = color(grid, row - 1, col, value, color, 2);
            if (!f)
                break;
            if (v != 3 && col > 0)
                f = color(grid, row, col - 1, value, color, 4);
            if (!f)
                break;
            if (v != 2 && grid.length > 1 && row < grid.length - 1)
                f = color(grid, row + 1, col, value, color, 1);
            if (!f)
                break;
            if (v != 4 && grid[0].length > 1 && col < grid[0].length - 1)
                f = color(grid, row, col + 1, value, color, 3);
            break;
        }
        if (f && (row == 0 || col == 0 || row == grid.length - 1 || col == grid[0].length - 1)) {
            f = false;
        }
        if (!f) {
            grid[row][col] = color;
        }
        return true;
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

    //*************************************************mid***************************************************************

    //6. Z 字形变换
    public String convert(String s, int numRows) {
        if (s.length() <= numRows || numRows == 1) {
            return s;
        }
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        int step = (numRows - 1) * 2;
        for (int i = 0; i < numRows; i++) {
            for (int j = i; j < s.length(); j += step) {
                sb.append(chars[j]);
                if (i != 0 && i != numRows - 1) {
                    int index = step - (i * 2);
                    if (index < s.length() - j) {
                        sb.append(chars[j + index]);
                    }
                }
            }
        }
        return sb.toString();
    }

    //206. 反转链表
    public ListNode reverseList(ListNode head) {
        ListNode p = head;
        ListNode c = head.next;
        while (c != null) {
            ListNode n = c;
            c = c.next;
            n.next = p;
            p = n;
        }
        return p;
    }

    //2024. 考试的最大困扰度
    public int maxConsecutiveAnswers(String answerKey, int k) {
        return Math.max(getCnt(answerKey, k, 'T'), getCnt(answerKey, k, 'F'));
    }

    private int getCnt(String answerKey, int k, char c) {
        int value = 0;
        for (int i = 0, j = 0, nums = 0; i < answerKey.length(); i++) {
            if (answerKey.charAt(i) != c) {
                nums++;
            }
            while (nums > k) {
                if (answerKey.charAt(j++) != c) {
                    nums--;
                }
            }
            value = Math.max(value, i - j + 1);
        }
        return value;
    }

    //2055. 蜡烛之间的盘子
    public static int[] platesBetweenCandles(String s, int[][] queries) {
        int n = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '|') {
                n++;
            }
        }
        int[] index = new int[n];
        int t = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '|') {
                index[t++] = i;
            }
        }
        int[] result = new int[queries.length];
        if (n <= 1) {
            return result;
        }
        for (int i = 0; i < queries.length; i++) {
            int l = binarySearch(index, queries[i][0], true);
            int r = binarySearch(index, queries[i][1], false);
            if (l >= r) {
                result[i] = 0;
                continue;
            }
            result[i] = index[r] - index[l] - r + l;
        }
        return result;
    }

    private static int binarySearch(int[] nums, int target, boolean isLeft) {
        int low = 0, high = nums.length - 1;
        if (nums[0] >= target) {
            return 0;
        }
        if (nums[high] <= target) {
            return high;
        }
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        if (isLeft) {
            if (nums[low] > target) {
                return low;
            }
            return low + 1;
        }
        if (nums[low] < target) {
            return low;
        }
        return low - 1;
    }

    //386. 字典序排数
    public List<Integer> lexicalOrder(int n) {
        List<Integer> resultList = new ArrayList<>();
        for (int i = 0, j = 1; i < n; i++) {
            resultList.add(j);
            if (j * 10 <= n) {
                j *= 10;
            } else {
                while (j % 10 == 9 || j + 1 > n) {
                    j /= 10;
                }
                j++;
            }
        }
        return resultList;
    }


    //821. 字符的最短距离
    public int[] shortestToChar(String s, char c) {
        int[] arr = new int[s.length()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr.length;
        }
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                int t = 0;
                for (int j = i; j >= 0 && arr[j] > t; j--) {
                    arr[j] = t++;
                }
                t = 1;
                for (int j = i + 1; j < s.length() && s.charAt(j) != c; j++) {
                    arr[j] = t++;
                }
            }
        }
        return arr;
    }

    //面试题 08.09. 括号
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        dfsGenerateParenthesis(n, result, 0, 0, "");
        return result;
    }

    //868. 二进制间距
    public int binaryGap(int n) {
        int t = 1, max = 0, temp = -1;
        while (n != 0) {
            if ((t & n) != 1) {
                n = n >> 1;
            } else {
                break;
            }
        }
        while (t < n) {
            temp++;
            if ((t & n) == t) {
                if (temp > max) {
                    max = temp;
                }
                temp = 0;
            }
            t = t << 1;
        }
        return max;
    }

    private void dfsGenerateParenthesis(int n, List<String> temp, int leftNum, int rightNum, String str) {
        //出口一：判断不满足条件的情况，主要从左右括号数量上判断，三种情况。
        if (leftNum < rightNum || leftNum > n) {
            return;
        }
        //出口二：满足条件，即左右括号数量相等且已经达到最大值。
        if (leftNum == rightNum && rightNum == n) {
            temp.add(str);
        }
        //否则
        else {
            //一定要先加左括号，再加右括号；
            //加完左括号后，左括号数量加1,回溯；
            dfsGenerateParenthesis(n, temp, leftNum + 1, rightNum, str + "(");

            //再加右括号，然后dfs，再回溯。
            dfsGenerateParenthesis(n, temp, leftNum, rightNum + 1, str + ")");
        }
    }

    //824. 山羊拉丁文
    public String toGoatLatin(String sentence) {
        String[] arr = sentence.split(" ");
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');
        StringBuilder builder = new StringBuilder();
        StringBuilder a = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            a.append("a");
            if (set.contains(arr[i].charAt(0))) {
                builder.append(arr[i]).append("ma").append(a.toString()).append(" ");
            } else {
                char c = arr[i].charAt(0);
                builder.append(arr[i], 1, arr[i].length()).append(c).append("ma").append(a.toString()).append(" ");
            }
        }
        return builder.deleteCharAt(builder.length() - 1).toString();
    }

    //713. 乘积小于 K 的子数组
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int rs = 0;
        for (int i = 0; i < nums.length; i++) {
            int t = 0;
            int n = 1;
            for (int j = i; j < nums.length; j++) {
                n *= nums[j];
                if (n < k) {
                    t++;
                } else {
                    break;
                }
            }
            rs += t;
        }
        return rs;
    }

    //942. 增减字符串匹配
    public int[] diStringMatch(String s) {
        int l = 0, r = s.length(), rsLength = r + 1;
        int[] rs = new int[rsLength];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'I') {
                rs[i] = l++;
            } else {
                rs[i] = r--;
            }
        }
        rs[rsLength - 1] = l;
        return rs;
    }

    //462. 最少移动次数使数组元素相等 II
    public int minMoves2(int[] nums) {
        int rs = 0;
        Arrays.sort(nums);
        int n = nums[nums.length / 2];
        for (int i = 0; i < nums.length; i++) {
            rs += Math.abs(nums[i] - n);
        }
        return rs;
    }

    //1828. 统计一个圆中点的数目
    public int[] countPoints(int[][] points, int[][] queries) {
        int[] rs = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int n = 0;
            for (int[] point : points) {
                if ((Math.sqrt(Math.pow(point[0] - queries[i][0], 2) + Math.pow(point[1] - queries[i][1], 2)) <= queries[i][2])) {
                    n++;
                }
            }
            rs[i] = n;
        }
        return rs;
    }

    //1477. 找两个和为目标值且不重叠的子数组
    public int minSumOfLengths(int[] arr, int target) {
        int l = 0, r = 0, n = 0, min1 = arr.length, min2 = arr.length;
        while (l < arr.length) {
            if (n > target) {
                if (l + 1 == r) {
                    l++;
                    n = 0;
                    continue;
                }
                n -= arr[l++];
            } else if (n == target) {
                int newMin = r - l;
                int temp = 0;
                if (newMin < min1) {
                    temp = min1;
                    min1 = newMin;
                    newMin = temp;
                }
                if (newMin < min2) {
                    min2 = newMin;
                }
                n -= arr[l++];
            } else {
                if (r == arr.length) {
                    break;
                }
                n += arr[r++];
            }
        }
        if (n == target) {
            int newMin = r - l;
            if (newMin < min1) {
                min1 = newMin;
            } else if (newMin < min2) {
                min2 = newMin;
            }
        }
        return min1 + min2 > arr.length ? -1 : min1 + min2;
    }

    //349. 两个数组的交集
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0) {
            return null;
        }
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int i : nums1) {
            set1.add(i);
        }
        for (int i : nums2) {
            if (set1.contains(i)) {
                set2.add(i);
            }
        }
        int[] rs = new int[set2.size()];
        int index = 0;
        for (int i : set2) {
            rs[index++] = i;
        }
        return rs;
    }

    //53. 最大子数组和
    public static int maxSubArray(int[] nums) {
        int max = nums[0];
        int num = 0;
        for (int n : nums) {
            num += n;
            max = Math.max(num, max);
            if (num < 0) {
                num = 0;
            }
        }
        return max;
    }

    //55. 跳跃游戏
    public static boolean canJump(int[] nums) {
        int n = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (n < i) {
                return false;
            }
            n = Math.max(n, i + nums[i]);
            if (n > nums.length) {
                break;
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        LinkedHashMap<String, String> map = new LinkedHashMap<>();
//        int[] m = {2, 3, 1, 1, 4};
//        System.out.println(jump(m));
//        while (true) {
//            int res = JOptionPane.showConfirmDialog(null, "你是不是喜欢我", "❤❤❤❤", JOptionPane.YES_NO_OPTION);
//            if (res == JOptionPane.YES_OPTION) {
//                System.out.println("选择是后执行的代码");
//                return;
//            } else {
//                System.out.println("选择否后执行的代码");
//            }
//        }
//        int a = 10;
//        int b = 10;
//        int[] arr = new int[5];
//        arr[0] = 10;
//        a = a ^ b;
//        b = a ^ b;
//        a = a ^ b;
//        System.out.println(a);
//        System.out.println(b);

        //""
        //[[2,33],[2,32],[3,31],[0,33],[1,24],[3,20],[7,11],[5,32],[2,31],[5,31],[0,31],[3,28],[4,33],[6,29],[2,30],[2,28],[1,30],[1,33],[4,32],[5,30],[4,23],[0,30],[3,10],[5,28],[0,28],[4,28],[3,33],[0,27]]
        String s = "***";
        int[][] arr = new int[1][];
        arr[0] = new int[]{2, 2};
//        arr[1] = new int[]{2, 32};
//        arr[2] = new int[]{3, 31};
//        arr[3] = new int[]{0, 33};
//        arr[4] = new int[]{1, 24};
//        arr[5] = new int[]{3, 20};
//        arr[6] = new int[]{7, 11};
//        arr[7] = new int[]{5, 32};
//        arr[8] = new int[]{2, 31};
//        arr[9] = new int[]{5, 31};
//        arr[10] = new int[]{0, 31};
//        arr[11] = new int[]{3, 28};
//        arr[12] = new int[]{4, 33};
//        arr[13] = new int[]{6, 29};
//        arr[14] = new int[]{2, 30};
//        arr[15] = new int[]{2, 28};
//        arr[16] = new int[]{1, 30};
//        arr[17] = new int[]{1, 33};
        int[] rs = platesBetweenCandles(s, arr);
        System.out.println(rs);
    }
}
