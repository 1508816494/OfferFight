package exam;

import leetcode.PartitionSum;

import java.util.*;

public class Main0915_1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            int n = scanner.nextInt();

            int res = 0;

            List<Integer> list = new ArrayList<>();
            List<MyPair> pairList = new ArrayList<>();
            Map<Integer, List<MyPair>> map = new HashMap<>();

            for (int i = 0; i < n; i++) {
                list.add(scanner.nextInt());
            }

            int K = scanner.nextInt();

            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    for(int k = j + 1; k < n; k++) {
                        int sum = list.get(i) + list.get(j) + list.get(k);
                        if(sum < K) {
                            res++;
                        }
                    }
//                    int sum = list.get(i) + list.get(j);
//                    if( sum < K) {
//                        MyPair pair = new MyPair(i, j);
//                        //不包含该key
//                        if(!map.containsKey(sum)) {
//                            List<MyPair> innerList = new ArrayList<>();
//                            innerList.add(pair);
//                            map.put(sum, innerList);
//                        } else {
//                            map.get(sum).add(pair);
//                        }
//
//                    }
                }
            }

//            for (int i = 0; i < n; i++) {
//                int odd = K - list.get(i);
//
//                if(odd <= 0) {
//                    continue;
//                }
//
//                Set<Integer> set = map.keySet();
//                for(Integer key : set) {
//                    if(key < odd) {
//                        List<MyPair> list1 = map.get(key);
//                        for(MyPair pair : list1) {
//                            int k = pair.getKey();
//                            int p = pair.getValue();
//                            if(key != k && key != p) {
//                                res++;
//                            }
//                        }
//                    }
//                }
//
//            }
            System.out.println(res);
        }
    }
}

class MyPair {
    int key;
    int value;

    MyPair(int key, int value) {
        this.key = key;
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public int getValue() {
        return value;
    }
}

