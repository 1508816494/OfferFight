package leetcode;

import javafx.util.Pair;

import java.util.*;

public class TopK {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        //Pair<频率，元素> 优先队列中比较频率
        PriorityQueue<Pair<Integer, Integer>> queue = new PriorityQueue<>(new pairComparator());
        List<Integer> res = new ArrayList<>();

        for(int i = 0; i < nums.length; i++) {
            int key = nums[i];
            if(map.get(key) != null) {
                int value = map.get(key);
                map.put(key, value+1);
            } else {
                map.put(key, 1);
            }
        }

        map.forEach((item, num) -> {
            Pair<Integer, Integer> pair = new Pair<>(num, item);
            if(queue.size() == k) {
                if(queue.peek().getKey() < pair.getKey()) {
                    queue.poll();
                    queue.offer(pair);
                }
            } else {
                queue.offer(pair);
            }
        });

        while (!queue.isEmpty()) {
            res.add(queue.poll().getValue());
        }
        return res;
    }
    static class pairComparator implements Comparator<Pair<Integer, Integer>> {

        @Override
        public int compare(Pair<Integer, Integer> p1, Pair<Integer, Integer> p2) {
            return p1.getKey() - p2.getKey();
        }
    }
}
