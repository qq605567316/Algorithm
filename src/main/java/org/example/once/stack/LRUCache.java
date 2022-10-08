package org.example.once.stack;

import java.util.HashMap;

class LRUCache {

    class Node {
        Node pre, next;
        int val, key;
    }

    HashMap<Integer, Node> map = new HashMap<>();
    Node head, tail;
    int capacity;

    public LRUCache(int capacity) {
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.pre = head;
        this.capacity = capacity;
    }

    public void add(Node node) {
        node.next = head.next;
        node.pre = head;
        head.next.pre = node;
        head.next = node;
    }

    public void delete(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node cur = map.get(key);
            delete(cur);
            add(cur);
            return cur.val;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.val = value;
            delete(node);
            add(node);
        } else {
            if (--capacity < 0) {
                Node del = tail.pre;
                delete(del);
                map.remove(del.key);
            }
            Node cur = new Node();
            cur.val = value;
            cur.key = key;
            map.put(key, cur);
            add(cur);
        }
    }
}
