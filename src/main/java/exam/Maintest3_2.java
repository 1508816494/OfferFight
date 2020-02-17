package exam;

import java.util.Scanner;

public class Maintest3_2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Long num;

        int count = 0;

        while (in.hasNext()) {
            num = in.nextLong();

            while (num != 0) {
                count++;
                num = (num - 1) & num;
            }

            System.out.println(count);
        }
    }
}
