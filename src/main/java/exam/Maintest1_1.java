package exam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Maintest1_1 {

    private static int num;

    private static int time;

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        List<Order> list = new ArrayList<>();

        while (in.hasNext()) {
            num = in.nextInt();
            time = in.nextInt();

            for (int i = 0; i < num; i++) {
                Order order = new Order(in.nextInt(), in.nextInt(), in.nextInt());
                list.add(order);
            }

            List<Integer> res = list.stream().filter(order ->
                    order.getTimeIn() <= time
            ).filter(order2 ->
                    order2.getTimeOut() >= time
            ).map(Order::getId).sorted().collect(Collectors.toList());

            if (res.size() == 0) {
                System.out.println("null");
            } else {
                res.forEach(id -> {
                    System.out.println(id);
                });
            }


        }
    }
}

//订单类
class Order {
    private int id;

    private int timeIn;

    private int timeOut;

    public Order() {

    }

    public Order(int id, int timeIn, int timeOut) {
        this.id = id;
        this.timeIn = timeIn;
        this.timeOut = timeOut;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTimeIn() {
        return timeIn;
    }

    public void setTimeIn(int timeIn) {
        this.timeIn = timeIn;
    }

    public int getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(int timeOut) {
        this.timeOut = timeOut;
    }
}
