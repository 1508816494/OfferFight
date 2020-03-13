package exam;

import java.util.Scanner;

public class Main0312_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int L = scanner.nextInt();
            int R = scanner.nextInt();

            int val = 1;
            for(int i = 1; i <= n; i++) {
                val = val * (R - L + 1);
            }
//            System.out.println(val);


        }
    }
}
