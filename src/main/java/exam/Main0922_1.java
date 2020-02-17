package exam;

import java.util.Scanner;

public class Main0922_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();

            System.out.println(getNum(n, m));
        }
    }

    private static int getNum(int n, int m) {
        int num = 0;
        if(n == 1 && m == 1) {
            return 1;
        }
        if(n > 1) {
            num += getNum(n - 1, m);
        }
        if(m > 1) {
            num += getNum(n, m - 1);
        }
        return num;
    }

}
