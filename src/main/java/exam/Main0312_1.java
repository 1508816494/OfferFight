package exam;

import java.util.Objects;
import java.util.Scanner;

public class Main0312_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.valueOf(scanner.nextLine());
        int[][] arr = new int[2][n];

        for(int i = 0; i < 2; i++) {
            String line = scanner.nextLine();
            for(int i1 = 0; i1 < line.length(); i1++) {
                char c = line.charAt(i1);
                arr[i][i1] = Objects.equals(String.valueOf(c), "X") ? 1 : 0;
            }
        }

        int[][] memo = new int[2][n];
        memo[0][0] = 1;

        memo[1][0] = 0;


        for(int i = 1; i < n; i++) {
            for(int j = 0; j < 2; j++) {
                if(arr[j][i] == 1) {
                    memo[j][i] = 0;
                    continue;
                }
                if(j == 0) {
                    memo[j][i] = memo[j + 1][i - 1] + memo[j][i - 1];
                } else {
                    memo[j][i] = memo[j - 1][i - 1] + memo[j][i - 1];
                }
            }
        }

        if( memo[1][n - 1] == 0) {
            System.out.println(-1);
        } else {
            System.out.println(memo[1][n - 1]);
        }

    }
}
