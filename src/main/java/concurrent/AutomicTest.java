package concurrent;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

public class AutomicTest {
    private static AtomicInteger ai = new AtomicInteger(3);

    private static int[] arr = new int[] {3, 6, 9};
    private static AtomicIntegerArray atarr = new AtomicIntegerArray(arr);

    public static void main(String[] args) {
        System.out.println(ai.get());
        System.out.println(ai.addAndGet(4));
        System.out.println(ai.getAndIncrement());

        System.out.println(atarr.addAndGet(1, 5));
        System.out.println(atarr.compareAndSet(0, 3, 4));
        System.out.println(atarr.get(0));
    }
}
