package exam;

import java.util.*;

public class Maintest2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {

            int cap = sc.nextInt();

            LRUCache<String, String> lruCache = new LRUCache<>(cap);

            //没有给出输入的条数时，再加一层循环
            while (sc.hasNext()) {

                String line = sc.nextLine();

                String[] split = line.split(" ");

                switch (split[0]) {
                    case "p":
                        lruCache.put(split[1], split[2]);
                        break;
                    case "g":
                        String s = lruCache.get(split[1]) == null ? "-1" : lruCache.get(split[1]);
                        System.out.println(s);
                        break;
                }
            }
        }
    }
}

class LRUCache<K, V> {

    private int capacity;

    private LinkedList<K> linkedList;

    private HashMap<K, V> cache;

    LRUCache(int capacity) {
        this.capacity = capacity;
        this.linkedList = new LinkedList<>();
        this.cache = new HashMap<K, V>(capacity, 0.75f);
    }

    public V get(K key) {
        if (cache.containsKey(key)) {
            //将这个Key移动到头部
            moveToHead(key);
            return cache.get(key);
        } else
            return null;
    }

    public void put(K key, V value) {
        //新添的数据添加应添加到头部
        if (!cache.containsKey(key)) {
            linkedList.addFirst(key);
        }
        cache.put(key, value);
        if (cache.size() > capacity) {
            //尾部是最少访问的
            K first = linkedList.pollLast();
            cache.remove(first);
        }
    }

    private void moveToHead(K key) {
        //将原位置删除
        linkedList.removeIf(e -> e.equals(key));
        //添加到尾部
        linkedList.addFirst(key);
    }
}
