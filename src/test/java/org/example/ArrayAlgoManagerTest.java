package org.example;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayAlgoManagerTest {

    private ArrayAlgoManager manager;

    @Before
    public void create() {
        manager = new ArrayAlgoManager();
    }

    @Test
    public void thirdMax() {
        int[] data = {2, 2, 3, 1};
        System.out.println(manager.thirdMax(data));
    }

    @Test
    public void wordPattern() {
        System.out.println(manager.wordPattern("abba", "dog cat cat dog"));
    }

    @Test
    public void longestCommonPrefix() {
        String[] strings = {"dog", "racecar", "car"};

        System.out.println(manager.longestCommonPrefix(strings));
    }

    @Test
    public void longestPalindrome() {
        System.out.println(manager.longestPalindrome("babad"));
    }

    @Test
    public void avoidFlood() {
        int[] rains = {1, 2, 0, 1, 2};
        int[] rs = manager.avoidFlood(rains);
        System.out.println(rs);
    }

    @Test
    public void strStr() {
        System.out.println(manager.strStr("mississippi", "pi"));
    }

    @Test
    public void numberOfArithmeticSlices() {
        int[] rains = {1, 2, 3, 4};
        System.out.println(manager.numberOfArithmeticSlices(rains));
    }

    @Test
    public void findRelativeRanks() {
        int[] rains = {10, 3, 8, 9, 4};
        System.out.println(Arrays.toString(manager.findRelativeRanks(rains)));
    }

    @Test
    public void colorBorder() {
        int[] a1 = {1, 1, 1};
        int[] a2 = {1, 1, 1};
        int[] a3 = {1, 1, 1};
        int[][] arr = new int[3][];
        arr[0] = a1;
        arr[1] = a2;
        arr[2] = a3;
        System.out.println(Arrays.toString(manager.colorBorder(arr, 1, 1, 2)));
    }

    @Test
    public void convert() {
        System.out.println(manager.convert("AB", 1));
    }

    @Test
    public void shortestToChar() {
        System.out.println(manager.shortestToChar("loveleetcode", 'e'));
    }

    @Test
    public void toGoatLatin() {
        System.out.println(manager.toGoatLatin("I speak Goat Latin"));
    }

    @Test
    public void diStringMatch() {
        System.out.println(manager.diStringMatch("IDID"));
    }

    @Test
    public void minMoves2() {
        int[] arr = {1, 2, 3};
        System.out.println(manager.minMoves2(arr));
    }

    @Test
    public void minSumOfLengths() {
        int[] arr = {7, 3, 4, 7};
        System.out.println(manager.minSumOfLengths(arr, 7));
    }

    @Test
    public void binaryGap() {
        System.out.println(manager.binaryGap(22));
    }

    @Test
    public void minDiffInBST() {
        TreeNode root = new TreeNode(4);
        TreeNode root1 = new TreeNode(2);
        TreeNode root2 = new TreeNode(6);
        TreeNode root3 = new TreeNode(1);
        TreeNode root4 = new TreeNode(3);
        root.left = root1;
        root.right = root2;
        root1.left = root3;
        root1.right = root4;
        System.out.println(Math.abs(-1000));
        System.out.println(manager.minDiffInBST(root));
    }

    @Test
    public void romanToInt() {
        System.out.println(manager.romanToInt("III"));
    }

    @Test
    public void replaceWords() {
        List<String> dictionary = new ArrayList();
        dictionary.add("a");
        dictionary.add("aa");
        dictionary.add("aaa");
        String sentence = "a aa a aaaa aaa aaa aaa aaaaaa bbb baba ababa";
        System.out.println(manager.replaceWords(dictionary, sentence));
    }

    @Test
    public void getMaximumGenerated() {
        System.out.println(manager.maxConsecutiveAnswers("TTFTTFTT", 1));
    }

    @Test
    public void reverseList() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        System.out.println(manager.reverseList(node1));
    }

    @Test
    public void isPalindrome() {
        System.out.println(manager.isPalindrome(-121));
    }

    @Test
    public void findCheapestPrice() {
        int n = 3, src = 0, dst = 2, k = 1;
        int[][] edge = {{0, 1, 100}, {1, 2, 100}, {0, 2, 500}};
        System.out.println(manager.findCheapestPrice(n, edge, src, dst, k));
    }

    @Test
    public void plusOne() {
        int[] arr = {9};
        System.out.println(manager.plusOne(arr));
    }
}
