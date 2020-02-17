package exam;

import java.util.Scanner;

public class Main0911_3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int num;

        while (in.hasNext()) {
            int sum = 0;

            num = in.nextInt();

            if(num <= 0) {
                System.out.println("No");
            }

            if(num >= 1) {
                for(int i = 1; i <= 100; i++) {
                    sum = sum + i;
                    if(sum == num) {
                        System.out.println(i);
                        break;
                    }
                }
                if(sum != num) {
                    System.out.println("No");
                }
            }

        }
    }
}
