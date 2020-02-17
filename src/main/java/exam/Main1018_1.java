package exam;

import java.util.Scanner;

public class Main1018_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();

            int result = 1;

            for(int i = n-1; i >=(n+1)/2; i--) {
                int k1 = 2 * i - n;
                int k2 = n - i;
                int max = k1 > k2 ? k1:k2;
                result = result + getNum(i, max);
            }
            System.out.println(result);
        }
    }

    private static int getNum(int m, int n) {
        return fac(m)/(fac(n) * fac(m - n));
    }

    private static int fac(int n) {
        int result = 1;
        for(int i = 1; i <=n; i++) {
            result *= i;
        }
        return result;
    }
}
