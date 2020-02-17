package exam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main1011_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int b = scanner.nextInt();

            List house = new ArrayList();
            for(int i = 0; i < n; i++) {
                int[] arr = new int[3];
                arr[0] = scanner.nextInt();
                arr[1] = scanner.nextInt();
                arr[2] = scanner.nextInt();
                house.add(arr);
            }

            List car = new ArrayList();
            for(int i = 0; i < m; i++) {
                int[] arr = new int[2];
                arr[0] = scanner.nextInt();
                arr[1] = scanner.nextInt();
                car.add(arr);
            }

            int res = Integer.MIN_VALUE;

            for(int i = 0; i < house.size(); i++) {
                for(int j = 0; j < car.size(); j++) {

                }
            }
        }
    }
}
