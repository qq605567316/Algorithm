package org.example;

import java.util.*;

public class OfferAlgoManager {

    //while循环二分查找
    public int binarySearch(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        if (high < low || target < nums[low] || target > nums[high]) {
            return -1;
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
        return -1;
    }

    //递归二分查找
    public int binarySearch2(int[] nums, int target, int low, int high) {
        if (high < low || target < nums[low] || target > nums[high]) return -1;
        int mid = low + (high - low) / 2;
        if (nums[mid] > target) return binarySearch2(nums, target, low, mid - 1);
        else if (nums[mid] < target) return binarySearch2(nums, target, mid + 1, high);
        return mid;
    }

    //快速排序
    public void quickSort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int low = left;
        int high = right;
        int mid = array[low];
        while (low < high) {
            while (array[high] >= mid && low < high) {
                high--;
            }
            while (array[low] <= mid && low < high) {
                low++;
            }
            if (low < high) {
                int tmp = array[low];
                array[low] = array[high];
                array[high] = tmp;
            }
        }
        array[left] = array[low];
        array[low] = mid;
        quickSort(array, left, low - 1);
        quickSort(array, low + 1, right);
    }

    //剑指 Offer 58 - II. 左旋转字符串
    public String reverseLeftWords(String s, int n) {
//        return s.substring(n) + s.substring(0, n);
        StringBuilder builder = new StringBuilder();
        for (int i = n; i < n + s.length(); i++) {
            builder.append(s.charAt(n % s.length()));
        }
        return builder.toString();
    }

    //剑指 Offer 53 - II. 0～n-1中缺失的数字
    public int missingNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (i != nums[i]) {
                return i;
            }
        }
        return nums.length;
    }

    //剑指 Offer 03. 数组中重复的数字
    public int findRepeatNumber(int[] nums) {
        int[] empty = new int[nums.length];
        for (int i : nums) {
            if (empty[i] == 0) {
                empty[i] = 1;
            } else {
                return i;
            }
        }
        return 0;
    }

    //剑指 Offer 05. 替换空格
    public String replaceSpace(String s) {
        StringBuilder builder = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (' ' == c) {
                builder.append("%20");
            } else {
                builder.append(c);
            }
        }
        return builder.toString();
    }

    //剑指 Offer 06. 从尾到头打印链表
    public int[] reversePrint(ListNode head) {
        ListNode node = head;
        int count = 0;
        while (node != null) {
            count++;
            node = node.next;
        }
        int[] result = new int[count];
        for (int i = 0; i < count; i++) {
            result[count - 1 - i] = head.val;
            head = head.next;
        }
        return result;
    }

    //剑指 Offer 04. 二维数组中的查找
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int m = matrix.length, n = matrix[0].length;
        int row = 0, col = n - 1;
        while (row < m && col >= 0) {
            if (matrix[row][col] > target) {
                col--;
            } else if (matrix[row][col] < target) {
                row++;
            } else {
                return true;
            }
        }
        return false;
    }

    //剑指 Offer 50. 第一个只出现一次的字符
    public char firstUniqChar(String s) {
        int[] target = new int[26];

        char[] data = s.toCharArray();
        for (char c : data) {
            target[c - 'a']++;
        }
        for (char c : data) {
            if (target[c - 'a'] == 1) {
                return c;
            }
        }
        return ' ';
    }

    //剑指 Offer 27. 二叉树的镜像
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode node = new TreeNode(root.val);
        node.left = mirrorTree(root.right);
        node.right = mirrorTree(root.left);
        return node;
    }

    //剑指 Offer 24. 反转链表
    public ListNode reverseList(ListNode head) {
        ListNode pre = null, next = null, curr = head;
        while (curr != null) {
            next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }

    //剑指 Offer 25. 合并两个排序的链表
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode p = head;
        while (l1 != null || l2 != null) {
            if (l1 != null && l2 != null) {
                if (l2.val < l1.val) {
                    p.next = l2;
                    l2 = l2.next;
                } else {
                    p.next = l1;
                    l1 = l1.next;
                }
                p = p.next;
                continue;
            } else if (l1 != null) {
                p.next = l1;
                break;
            } else {
                p.next = l2;
                break;
            }
        }
        return head.next;
    }

    //剑指 Offer 58 - I. 翻转单词顺序
    public String reverseWords(String s) {
        //将传进来的字符串以空格拆分
        String[] strings = s.trim().split(" +");
        StringBuffer stringBuffer = new StringBuffer();
        //从尾巴开始遍历
        for (int i = strings.length - 1; i >= 0; i--) {
            //到头了，append然后去空格
            if (i == 0) {
                stringBuffer.append(strings[i].trim());
            } else {
                // 怕有多余的空格，去掉，再加上去
                stringBuffer.append(strings[i].trim()).append(" ");
            }
        }
        //输出String 完事，安排！
        return stringBuffer.toString();
    }

    //剑指 Offer 57 - II. 和为s的连续正数序列
    public int[][] findContinuousSequence(int target) {
        List<int[]> list = new ArrayList<>();
        if (target < 3) {
            return null;
        }
        int high = (target / 2) + 1;
        int l = 1, r = 2;
        int sum = l + r;
        retry:
        while (l < high && l < r) {
            if (sum == target) {
                int[] one = new int[r - l + 1];
                int tmp = l;
                int i = 0;
                while (tmp <= r) {
                    one[i++] = tmp;
                    tmp++;
                }
                list.add(one);
                if (r == high) {
                    break retry;
                } else {
                    r++;
                    sum += r;
                }
            } else if (sum > target) {
                sum -= l;
                l++;
            } else if (sum < target) {
                if (r == high)
                    break;
                r++;
                sum += r;
            }
        }

        int[][] res = new int[list.size()][];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    //剑指 Offer 39. 数组中出现次数超过一半的数字
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            map.putIfAbsent(n, 0);
            map.computeIfPresent(n, (k, v) -> ++v);
        }
        int m = nums.length / 2;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > m) {
                return entry.getKey();
            }
        }
        return -1;
    }

    //剑指 Offer 68 - II. 二叉树的最近公共祖先
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 如果树为空，直接返回null
        if (root == null) {
            return null;
        }
        // 如果 p和q中有等于 root的，那么它们的最近公共祖先即为root（一个节点也可以是它自己的祖先）
        if (root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q); // 递归遍历左子树，只要在左子树中找到了p或q，则先找到谁就返回谁
        TreeNode right = lowestCommonAncestor(root.right, p, q); // 递归遍历右子树，只要在右子树中找到了p或q，则先找到谁就返回谁
        // 如果在左子树中 p和 q都找不到，则 p和 q一定都在右子树中，右子树中先遍历到的那个就是最近公共祖先（一个节点也可以是它自己的祖先）
        if (left == null) {
            return right;
        }
        // 否则，如果 left不为空，在左子树中有找到节点（p或q），这时候要再判断一下右子树中的情况，如果在右子树中，p和q都找不到，
        // 则 p和q一定都在左子树中，左子树中先遍历到的那个就是最近公共祖先（一个节点也可以是它自己的祖先）
        else if (right == null) {
            return left;
        }
        //否则，当 left和 right均不为空时，说明 p、q节点分别在 root异侧, 最近公共祖先即为 root
        else {
            return root;
        }
    }

    //剑指 Offer 68 - I. 二叉搜索树的最近公共祖先
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val > Math.max(p.val, q.val)) {
            return lowestCommonAncestor2(root.left, p, q);
        } else if (root.val < Math.min(p.val, q.val)) {
            return lowestCommonAncestor2(root.right, p, q);
        } else {
            return root;
        }
    }

    //剑指 Offer 32 - II. 从上到下打印二叉树 II
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> queue1 = new ArrayDeque<>();
        Deque<TreeNode> queue2 = new ArrayDeque<>();
        queue1.offer(root);
        while (!queue1.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            while (!queue1.isEmpty()) {
                TreeNode node = queue1.poll();
                list.add(node.val);
                if (node.left != null) {
                    queue2.offer(node.left);
                }
                if (node.right != null) {
                    queue2.offer(node.right);
                }
            }
            result.add(list);

            Deque<TreeNode> tmp = queue1;
            queue1 = queue2;
            queue2 = tmp;
        }

        return result;
    }

    //剑指 Offer 52. 两个链表的第一个公共节点
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode h1 = headA, h2 = headB;
        while (h1 != h2) {
            h1 = h1 == null ? headB : h1.next;
            h2 = h2 == null ? headA : h2.next;
        }
        return h1;
    }

    //剑指 Offer 21. 调整数组顺序使奇数位于偶数前面
    public int[] exchange(int[] nums) {
        int left = 0, right = nums.length - 1;
        for (; left < right; left++) {
            if (nums[left] % 2 == 1) {
                continue;
            }
            for (; right > left; right--) {
                if (nums[right] % 2 == 0) {
                    continue;
                }
                int tmp = nums[left];
                nums[left] = nums[right];
                nums[right] = tmp;
                break;
            }
        }
        return nums;
    }

    //剑指 Offer 53 - I. 在排序数组中查找数字 I
    public int search(int[] nums, int target) {
        int len = nums.length;
        int lo = 0, hi = len - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] < target) {
                lo = mid + 1;
            } else if (nums[mid] > target) {
                hi = mid - 1;
            } else {
                if (nums[hi] != target)
                    hi--;
                else if (nums[lo] != target)
                    lo++;
                else
                    break;
            }
        }
        return hi - lo + 1;
//        int result = 0;
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] == target) {
//                result++;
//                continue;
//            }
//            if (result != 0) {
//                return result;
//            }
//        }
//        return result;
    }

    //剑指 Offer 57. 和为s的两个数字
    public int[] twoSum(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int[] rs = new int[2];
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum > target) right--;
            else if (sum < target) left++;
            else {
                rs[0] = nums[left];
                rs[1] = nums[right];
                return rs;
            }
        }
        return rs;
    }

    //剑指 Offer 62. 圆圈中最后剩下的数字
    public int lastRemaining(int n, int m) {
        int index = 0;
        for (int i = 2; i < n; i++) {
            index = (index + m) % i;
        }
        return index;
    }

    //剑指 Offer 55 - II. 平衡二叉树
    public boolean isBalanced(TreeNode root) {
        return recur(root) != -1;
    }

    private int recur(TreeNode root) {
        if (root == null) return 0;
        int left = recur(root.left);
        if (left == -1) return -1;
        int right = recur(root.right);
        if (right == -1) return -1;
        return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;
    }

    //剑指 Offer 28. 对称的二叉树
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isSym(root.left, root.right);
    }

    private boolean isSym(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        if (left.val != right.val) return false;
        return isSym(left.left, right.right) && isSym(right.left, left.right);
    }

    //剑指 Offer 65. 不用加减乘除做加法
    public int add(int a, int b) {
        /* a和b第一次计算完进位和、进位之后，将b 赋值为进位
         * 再与a进行第二次计算，直到进位为0，表示从低位到高位全部计算完
         * 所以这里需要循环处理所有的进位
         */
        while (b != 0) {
            int temp = (a & b) << 1;
            a = a ^ b;    /* a为无进位和 */
            b = temp;   /* b为进位 */
        }
        return a;
    }

    //剑指 Offer 61. 扑克牌中的顺子
    public boolean isStraight(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int max = 1, min = 13;
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            if (n == 0) {
                continue;
            }
            if (max < n) max = n;
            if (min > n) min = n;
            if (set.contains(n)) {
                return false;
            }
            set.add(n);
        }
        return max - min <= 4;
    }

    //剑指 Offer 29. 顺时针打印矩阵
    public int[] spiralOrder(int[][] matrix) {
        int downHigh = matrix.length;
        if (downHigh == 0) {
            return new int[0];
        }
        int leftRow = 0, topHigh = 0, rightRow = matrix[0].length;
        int[] rs = new int[rightRow * downHigh];
        int t = 0;
        while (true) {
            for (int i = leftRow; i < rightRow; i++) rs[t++] = matrix[topHigh][i];
            if (++topHigh >= downHigh) break;
            for (int i = topHigh; i < downHigh; i++) rs[t++] = matrix[i][rightRow - 1];
            if (--rightRow <= leftRow) break;
            for (int i = rightRow - 1; i >= leftRow; i--) rs[t++] = matrix[downHigh - 1][i];
            if (--downHigh <= topHigh) break;
            for (int i = downHigh - 1; i >= topHigh; i--) rs[t++] = matrix[i][leftRow];
            if (++leftRow >= rightRow) break;
        }
        return rs;
    }

    //剑指 Offer 40. 最小的k个数
    public int[] getLeastNumbers(int[] arr, int k) {
        Arrays.sort(arr);
        int[] rs = new int[k];
        for (int i = 0; i < k; i++) {
            rs[i] = arr[i];
        }
        return rs;
    }
}
