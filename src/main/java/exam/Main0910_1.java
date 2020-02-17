package exam;

import java.util.Scanner;

public class Main0910_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            String word1 = scanner.nextLine();
            String word2 = scanner.nextLine();

            int len1 = word1.length();
            int len2 = word2.length();

            int[][] arr = new int[len1 + 1][len2 + 1];

            for (int i = 0; i < len1 + 1; i++) {
                arr[i][0] = i;
            }
            for (int j = 0; j < len2 + 1; j++) {
                arr[0][j] = j;
            }


            for (int i = 1; i <= len1; i++) {
                for (int j = 1; j <= len2; j++) {
                    if(word1.charAt(i - 1) == word2.charAt(j - 1)) {
                        arr[i][j] = arr[i -1][j - 1];
                    } else {
                        int min = getMin(arr[i][j - 1], arr[i - 1][j - 1], arr[i - 1][j]);
                        arr[i][j] = min + 1;
                    }
                }
            }

            System.out.println(arr[len1][len2]);
        }
    }

    private static int getMin(int x, int y, int z) {
        int temp = Math.min(x, y);
        return Math.min(temp, z);
    }
}

