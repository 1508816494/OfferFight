package exam;

import java.util.Scanner;

public class Main0922_1_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();

            int[][] arr = new int[n + 1][m + 1];

            for(int i = 1; i <= n; i++) {
                for(int j = 1; j <= m; j++) {
                    if(i == 0 && j == 0) {
                        arr[i][j] = 1;
                    } else if(i == 0) {
                        arr[i][j] = arr[i][j - 1];
                    } else if(j == 0) {
                        arr[i][j] = arr[i - 1][j];
                    } else {
                        arr[i][j] = arr[i - 1][j] + arr[i][j - 1];
                    }
                }
            }
            System.out.println(arr[n][m]);
        }
    }
}
