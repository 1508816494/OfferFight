package exam;

import java.util.Scanner;

public class Main0915_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int score = 0;
            boolean turn = true;
            int n = scanner.nextInt();
            int[] arr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }

            int left = 0;
            int right = n -1;
            while (left <= right) {
                if(turn) {
                    if(arr[left] > arr[right]) {
                        score += arr[left];
                        left++;
                    } else {
                        score += arr[right];
                        right--;
                    }
                } else {
                    if(arr[left] > arr[right]) {
                        left++;
                    } else {
                        right--;
                    }
                }
                turn = !turn;
            }
            System.out.println(score);
        }
    }
}
