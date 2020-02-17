package exam;

import java.util.Objects;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class Main0911_2 {
    public static volatile AtomicReference<String> current = new AtomicReference<>("C");

    private final static AtomicBoolean LOCK = new AtomicBoolean(false);

    private static volatile AtomicInteger SUM = new AtomicInteger(1);


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            int count = scanner.nextInt();

            new Thread(new Printer("A", count)).start();
            new Thread(new Printer("B", count)).start();
            new Thread(new Printer("C", count)).start();

        }
    }

    static class Printer implements Runnable {

        private  String number;

        private int count;

        Printer(String number, int count) {
            this.number = number;
            this.count = count;
        }

        @Override
        public synchronized void run() {
            while (true) {
                if(LOCK.compareAndSet(false, true)) {
                    try {
                        if(SUM.get() > count) {
                            break;
                        }
                        if(SUM.get() % 2 != 0 && Objects.equals("A", number)) {
                            System.out.println(number);
                            SUM.addAndGet(1);
                            continue;
                        }
                        if(SUM.get() % 2 == 0 && !Objects.equals(current.get(), number)) {
                            if(!Objects.equals(current.get(), number)) {
                                System.out.println(number);
                                SUM.addAndGet(1);
                                current.set(number);
                            }
                        }
                    }finally {
                        LOCK.set(false);
                    }
                }
            }
        }
    }
 }
