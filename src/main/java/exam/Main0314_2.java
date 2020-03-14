package exam;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main0314_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line1 = scanner.nextLine();
        String line2 = scanner.nextLine();

        String[] likes = line2.split(" ");

        Map<Integer, Integer> likeMap = new HashMap<>();
        for(String like : likes) {
            Integer l = Integer.valueOf(like);
            Integer count = likeMap.get(l);
            if(count == null) {
                likeMap.put(l, 1);
            } else {
                likeMap.put(l, ++count);
            }
        }

        int result = 0;
        for(Integer value : likeMap.values()) {
            if(value == null) {
                continue;
            }
            if(value % 2 == 0) {
                result += value / 2;
            } else {
                result += value / 2 + 1;
            }
        }
        System.out.println(result);
    }
}
