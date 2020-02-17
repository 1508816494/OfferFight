package exam;

import java.util.Scanner;

public class Maintest3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Long num;

        while (in.hasNext()) {
            num = in.nextLong();
            int count = 0;

            String str = Long.toBinaryString(num);

            for(int i = 0; i < str.length(); i++) {
                if( str.charAt(i) == '1') {
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
