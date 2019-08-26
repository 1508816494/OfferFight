package offer;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        int n;
        int res = 1;

        while (in.hasNext()) {
            n = in.nextInt();
            for(int i = 0; i < n; i++) {
                list.add(in.nextInt());
            }
            for(int i = 0; i < n; i++) {
                if( i + 1 == n) {
                    break;
                }
                if(list.get(i) >= list.get(i+1)) {
                    continue;
                }
                if(list.get(i) < list.get(i+1)) {
                    res++;
                }
            }

            System.out.println(res);
        }
    }
}
