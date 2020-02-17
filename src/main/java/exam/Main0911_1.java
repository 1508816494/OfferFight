package exam;

import java.util.HashMap;
import java.util.Scanner;

public class Main0911_1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        HashMap<String, String> val = new HashMap<>();
        val.put("0", "零");
        val.put("1", "壹");
        val.put("2", "贰");
        val.put("3", "叁");
        val.put("4", "肆");
        val.put("5", "伍");
        val.put("6", "陆");
        val.put("7", "柒");
        val.put("8", "捌");
        val.put("9", "玖");

        HashMap<Integer, String> wei = new HashMap<>();
        wei.put(0, "元");
        wei.put(1, "拾");
        wei.put(2, "百");
        wei.put(3, "千");
        wei.put(4, "万");
        wei.put(5, "拾万");
        wei.put(6, "百万");
        wei.put(7, "千万");
        wei.put(8, "亿");

        wei.put(-1, "角");
        wei.put(-2, "分");

        String[] arr;

        while (in.hasNext()) {
            String str = in.nextLine();
            arr = str.split(",");

            for(int i = 0; i < arr.length; i++) {
                String num = arr[i];

                int index = num.indexOf(".");

                //整数part
                for(int j = 0; j < index; j++) {

                }
            }




        }
    }
}
