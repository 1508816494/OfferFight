package exam;

import java.util.*;

public class Main1009_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            str.trim();

            List<Character> list = new ArrayList<>();
            Set<Character> set = new HashSet<>();

            for(int i = 0; i < str.length(); i++) {
                char val = str.charAt(i);
                if(set.add(val)) {
                    list.add(val);
                }
            }

            for(int j = 0; j < list.size(); j++) {
                System.out.print(list.get(j));
            }
            System.out.println();
        }
    }
}
