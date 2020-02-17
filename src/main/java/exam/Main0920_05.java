package exam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main0920_05 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int num = in.nextInt();

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        for (int i = 0; i < num; i++) {
            list1.add(in.nextInt());
        }

        for (int i = 0; i < num; i++) {
            list2.add(in.nextInt());
        }

        List<Integer> list3 = new ArrayList<>();

        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                list3.add(list1.get(i) + list2.get(j));
            }
        }

        int res = list3.get(0);
        for (int i = 1; i < list3.size(); i++) {
            res = res^list3.get(i);

        }
        System.out.println(res);

    }
}
