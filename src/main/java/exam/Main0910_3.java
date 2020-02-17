package exam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main0910_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            String line = scanner.nextLine();

            String[] pairStr = line.split("#");

            List<Pair> pairs = new ArrayList<>();
            for(String item : pairStr) {
                if(isBlank(item)) {
                    continue;
                }

                if(item.indexOf(":") == item.lastIndexOf(":")) {
                    String[] kv = item.split(":");
                    if(isBlank(kv[0]) || isBlank(kv[1])) {
                        continue;
                    }
                    pairs.add(new Pair(kv[0], kv[1]));
                } else {
                    String[] kv = item.split(":");
                    int count = 0;
                    for(String k : kv) {
                        if(count == kv.length - 1) {
                            continue;
                        }

                        if(!isBlank(k) && !isBlank(kv[count + 1])) {
                            pairs.add(new Pair(k, kv[count + 1]));
                            break;
                        }
                        count++;
                    }
                }
            }
            System.out.println(pairs.size());
            for(Pair pair : pairs) {
                System.out.println(pair.key.trim() + " " + pair.val.trim());
            }
        }
    }

    private static boolean isBlank(CharSequence cs) {
        int strLen;
        if(cs != null && (strLen = cs.length()) != 0) {
            for(int i = 0; i < strLen; ++i) {
                if(!Character.isWhitespace(cs.charAt(i))) {
                    return false;
                }
            }
            return true;
        } else {
            return true;
        }
    }

    static class Pair {
        public String key;
        public String val;

        public Pair(String k, String v) {
            this.key = k;
            this.val = v;
        }
    }
}
