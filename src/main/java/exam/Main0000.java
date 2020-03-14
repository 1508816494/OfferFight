package exam;

import java.util.Scanner;
import java.util.TreeMap;

public class Main0000 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line1 = scanner.nextLine();
        String[] nums = line1.split(" ");
        int faceNum = Integer.valueOf(nums[0]);
        int salary = Integer.valueOf(nums[1]);

        TreeMap<Integer, Integer> sortedMap = new TreeMap<>();

        for(int i = 0; i < faceNum; i++) {
            String line = scanner.nextLine();
            String[] arr = line.split(" ");
            sortedMap.put(Integer.valueOf(arr[i]), Integer.valueOf(arr[1]));
        }

        sortedMap.descendingKeySet();
        int count = 0;

        while (true) {
            boolean over = true;
            int sum = 0;
            for(Integer face : sortedMap.keySet()) {
                Integer val = sortedMap.get(face);
                if(val <= 0) {
                    continue;
                }
                sum += face;
                sortedMap.put(face, --val);
                if(sum >= salary) {

                    over = false;
                    count++;
                    break;
                }
            }
            if(over) {
                break;
            }
        }
        System.out.println(count);
    }
}
