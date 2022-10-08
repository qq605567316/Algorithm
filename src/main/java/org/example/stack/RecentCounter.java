package org.example.stack;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author tanjiang
 * @date 2022/5/6
 */
public class RecentCounter {

    public Queue<Integer> queue;

    public RecentCounter() {
        queue = new ArrayDeque<>();
    }

    public int ping(int t) {
        int n = t - 3000;
        while (queue.size() > 0 && queue.peek() < n) {
            queue.poll();
        }
        queue.offer(t);
        return queue.size();
    }
}
