package exam;

import java.util.Scanner;

public class Main1009_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            int num = scanner.nextInt();
            for(int i = 0; i < num; i++) {
                getNum(scanner.nextInt());
            }
        }
    }

    public static void getNum(int n) {
        int res = 0;
        for(int i = 1; i < n; i++) {
            if((i * i + 2 * i) > n) {
                break;
            }
            for(int j = i; j < n; j++) {
                int val = i * j + i + j;
                if(val > n) {
                    break;
                }
                if(val == n) {
                    res++;
                }
            }
        }
        System.out.println(res);
    }
}

