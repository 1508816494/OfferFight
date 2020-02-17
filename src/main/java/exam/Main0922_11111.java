package exam;

import java.util.Scanner;

public class Main0922_11111 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();

            System.out.println(getNum(n, m));
        }
    }

    private static int getNum(int m, int n) {
        int[][] arr = new int[m + 1][n + 1];
        for(int i = 1; i <= m; ++i) {
            for(int j = 1; j <= n; ++j) {
                if(i == 1 || j == 1) {
                    arr[i][j] = 1;
                } else {
                    arr[i][j] = arr[i - 1][j] + arr[i][j - 1];
                }
            }
        }
        return arr[m][n];

    }
}
