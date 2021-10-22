package org.example;

import org.junit.Before;
import org.junit.Test;

public class OfferAlgoManagerTest {

    private OfferAlgoManager manager;

    @Before
    public void create() {
        manager = new OfferAlgoManager();
    }

    @Test
    public void missingNumber() {
        int[] data = {0, 1, 2, 3, 4, 5, 6, 7, 9};
        System.out.println(manager.missingNumber(data));
    }

    @Test
    public void findRepeatNumber() {
        int[] data = {0, 1, 2, 3, 2, 5, 6, 7, 9};
        System.out.println(manager.findRepeatNumber(data));
    }

    @Test
    public void replaceSpace() {
        String s = "We are happy.";
        System.out.println(manager.replaceSpace(s));
    }

    @Test
    public void firstUniqChar() {
        String s = "leetcode";
        System.out.println(manager.firstUniqChar(s));
    }

    @Test
    public void mirrorTree() {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(7);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);
        System.out.println(manager.mirrorTree(root));
    }

    @Test
    public void binarySearch() {
        int[] data = {0, 1, 2, 2, 3, 5, 6, 7, 9, 10};
        System.out.println(manager.binarySearch(data, 9));
    }

    @Test
    public void quickSort() {
        int[] data = {0, 1, 5, 2, 11, 5, 8, 7, 3, 10};
        manager.quickSort(data, 0, data.length - 1);
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + " ");
        }
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
    public void mergeTwoLists() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(4);

        node1.next = node2;
        node2.next = node3;


        ListNode node4 = new ListNode(1);
        ListNode node5 = new ListNode(3);
        ListNode node6 = new ListNode(4);
        node4.next = node5;
        node5.next = node6;


        System.out.println(manager.mergeTwoLists(node1, node4));
    }

    @Test
    public void getIntersectionNode() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(4);

        node1.next = node2;
        node2.next = node3;


        ListNode node4 = new ListNode(1);
        ListNode node5 = new ListNode(3);
        ListNode node6 = new ListNode(4);
        node4.next = node5;
        node5.next = node6;


        System.out.println(manager.getIntersectionNode(node1, node4));
    }

    @Test
    public void levelOrder() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(manager.levelOrder(root));
    }

    @Test
    public void majorityElement() {
        int[] a = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        System.out.println(manager.majorityElement(a));
    }

    @Test
    public void search() {
        int[] a = {1};
        System.out.println(manager.search(a, 1));
    }

    @Test
    public void spiralOrder() {
        int[][] a = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        for (Integer i : manager.spiralOrder(a)) {
            System.out.println(i);
        }
    }

    @Test
    public void reverseWords() {
        System.out.println(manager.reverseWords("a good   example"));
    }

    @Test
    public void test() {
        System.out.println(OfferAlgoManagerTest.test1());
    }

    public static int test1() {
        int x = 0;
        try {
            System.out.println(4 & 2);
            return x;
        } finally {
            x = 10;
        }
    }
}
