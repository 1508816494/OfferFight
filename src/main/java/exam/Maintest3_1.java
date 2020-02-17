package exam;

import java.util.Scanner;

public class Maintest3_1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Long num;

        while (in.hasNext()) {
            num = in.nextLong();
            System.out.println(Long.bitCount(num));
        }
    }
}

