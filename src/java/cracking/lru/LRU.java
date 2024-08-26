package cracking.lru;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRU {

    static class Cache {
        int key;
        int value;

        public Cache(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int capacity;
    private final Map<Integer, Cache> map;
    private final Deque<Integer> queue;

    public LRU(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.queue = new LinkedList<>();
    }

    public int get(int i) {
        if (map.containsKey(i)) {
            queue.remove(i);
            queue.addFirst(i);
        } else {
            push(i, i);
        }
        return map.get(i).value;
    }

    public void push(int key, int value) {
        if (map.containsKey(key)) {
            queue.remove(key);
        } else {
            Cache cache = new Cache(key, value);
            if (map.size() == capacity) {
                int last = queue.removeLast();
                map.remove(last);
            }
            map.put(key, cache);
        }
        queue.addFirst(key);
    }
}
