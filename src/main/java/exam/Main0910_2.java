package exam;

import java.util.Scanner;

public class Main0910_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {

            int N = scanner.nextInt();

            if(N <= 0) {
                System.out.println(0);
            }

            int num = 0;
            int max = N << 1;

            int i = 1;
            int x = i * (i + 1);

            while (x <= max) {
                if((N - x / 2) % i == 0) {
                    num++;
                }
                i = i + 1;
                x = i * (i + 1);
            }
            System.out.println(num);
        }
    }
}
