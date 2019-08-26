package offer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m, n;
        List list = new ArrayList();
        while (in.hasNextInt()) {
            m = in.nextInt();
            n = in.nextInt();
            for(int i = m; i <= n; i++) {
                int first = i % 10;
                int seconde = i / 10 % 10;
                int third = i / 10 / 10 % 10;
                if(first*first*first + seconde*seconde*seconde + third*third*third == i) {
                    list.add(i);
                }
            }
            if(list.isEmpty()) {
                System.out.println("no");
            }else {
                list.forEach(item -> {
                    System.out.print(item);
                    System.out.print(" ");
                });
                list.clear();
            }
        }
    }
}
