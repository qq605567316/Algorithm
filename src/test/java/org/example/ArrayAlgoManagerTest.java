package org.example;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
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
    public void numberOfArithmeticSlices() {
        int[] rains = {1, 2, 3, 4};
        System.out.println(manager.numberOfArithmeticSlices(rains));
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
