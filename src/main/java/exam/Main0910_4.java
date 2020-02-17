package exam;

import java.util.Scanner;

public class Main0910_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            int N = scanner.nextInt();

            if(N <= 0) {
                System.out.println(0);
            }

            int l = 1;
            int r = 1;

            int count = 0;


            while (r <= N) {
                int sum = 0;

                for(int i = r; i <= l; i++) {
                    sum = sum + i;
                }

                if(sum == N) {
                    count++;
                    l++;
                }
                if(sum < N) {
                    r++;
                }
                if(sum > N) {
                    l++;
                }
            }
            System.out.println(count);
        }
    }
}
