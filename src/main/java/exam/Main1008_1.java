package exam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main1008_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            int num = scanner.nextInt();
            List<Integer> list = new ArrayList<>();
            List<Integer> list2 = new ArrayList<>();
            int sum = 0;
            int min = 0;
            int max = 100;

            for(int i = 0; i < num; i++) {
                int val = scanner.nextInt();
                list.add(val);
                min = Math.min(min, val);
                max = Math.max(max, val);
                sum = sum + val;
            }

//            int sum2 = 0;
//            for(int i = 0; i < num; i++) {
//                int val = Math.abs(sum/num - list.get(i));
//                list2.add(val);
//                sum2 = sum2 + val;
//            }
//            System.out.println(sum2/num);
        }
    }
}

