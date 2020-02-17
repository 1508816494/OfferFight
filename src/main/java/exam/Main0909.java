package exam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main0909 {
    private static int res = 0;
    private static List<String> list = new ArrayList<>();
    private static HashMap<String, String> map = new HashMap<>();


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int delId;

        while (in.hasNext()) {
            String line = in.nextLine();
            String[] pid = line.split(" ");

            String line2 = in.nextLine();
            String[] ppid = line.split(" ");

            delId = in.nextInt();

            for(int i = 0; i < pid.length; i++) {
                map.put(pid[i], ppid[i]);
            }

            String del = Integer.toString(delId);

            delFunc(del);

            while (list.size() != 0) {
                String val = list.remove(0);
                delFunc(val);
            }
            System.out.println(res);


        }
    }

    private static void delFunc(String del) {
        if(map.containsValue(del)) {
            map.forEach((key, value) -> {
                if(map.get(key).equals(del)) {
                    list.add(key);
                    res = res + 2;
                }
            });
        }
    }
}
