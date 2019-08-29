//package leetcode;
//
//import java.util.*;
//
//public class Main33 {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n, total, coast;
//        List<Integer> list1 = new ArrayList<>();
//        List<Integer> list2 = new ArrayList<>();
//        while (scanner.hasNext()) {
//            n = scanner.nextInt();
//            total = scanner.nextInt();
//            coast = scanner.nextInt();
//
//            for(int i = 0; i < n; i++) {
//                list1.add(scanner.nextInt());
//            }
//            for(int i = 0;i < n; i++) {
//                list2.add(scanner.nextInt());
//            }
//
//            int result = 0;
//            int index1 = 0;
//            int index2 = 0;
//
//            Set<Integer> set = new HashSet<>();
//
//            int size = 0;
//
//            while(total > coast || !list1.isEmpty() || !list2.isEmpty()) {
//                set.add(list1.get(index1));
//                size++;
//                index1++;
//                if(set.size() < size) {
//                    list1 = new ArrayList<>(list1.subList(index1 + 1,list1.size()));
//                    list2 = new ArrayList<>(list2.subList(index2 + 1, list2.size());
//                    result++;
//                    set = new HashSet<>();
//                    size = 0;
//                    continue;
//                }
//                set.add(list2.get(index1));
//                size++;
//                index2++;
//                if(set.size() < size) {
//                    list1 = new ArrayList<>(list1.subList(index1 + 1,list1.size()));
//                    list2 = new ArrayList<>(list2.subList(index2 + 1, list2.size());
//                    result++;
//                    set = new HashSet<>();
//                    size = 0;
//                    continue;
//                }
//
//             }
//        }
//
//    }
//}
