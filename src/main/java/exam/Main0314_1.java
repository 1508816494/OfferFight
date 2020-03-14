package exam;

import java.util.*;

public class Main0314_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();

            List<Integer> list = new ArrayList<>();
            Map<Integer, Integer> map = new HashMap<>();

            for(int i = 0; i < n; i++) {
                int key = scanner.nextInt();
                int value = scanner.nextInt();
                map.put(key, value);
            }

            for(Integer key : map.keySet()) {
                int value = map.get(key);
                for(int i = 0; i < value; i++) {
                    list.add(key);
                }
            }

            Collections.sort(list);
            Collections.reverse(list);

            int i = 0;
            int j = list.size() - 1;

            int res = 0;
            int sum = 0;

            while (i <= j) {
                if(i == j) {
                    if(sum >= m) {
                        res++;
                        break;
                    } else {
                        break;
                    }
                }
                if(sum >= m) {
                    i++;
                    res++;
                    sum = 0;
                }

                if(list.get(i) >= m) {
                    res++;
                    i++;
                    sum = 0;
                } else {
                    sum = sum + list.get(i) + list.get(j);
                    j--;
                }
            }
            System.out.println(res);

        }
    }
}
