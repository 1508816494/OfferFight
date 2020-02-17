package exam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main0915_02 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int batchNum;
        List<Batch> batches = new ArrayList<>();

        while(scanner.hasNext()) {
            batches.clear();

            int maxLeft = 0;
            int leftFile = 0;
            int overTime = 0;

            batchNum = scanner.nextInt();

            for (int i = 0; i < batchNum; i++) {
                batches.add(new Batch(scanner.nextInt(), scanner.nextInt()));

            }
            //消耗总时间和堆积量
            for(Batch batch : batches) {
                int lastTras = batch.comeTime - overTime;
                if(leftFile == 0) {
                    leftFile = batch.fileSzie;
                    overTime = batch.comeTime;
                    maxLeft = batch.fileSzie;
                } else if (leftFile <= lastTras) {
                    overTime = batch.comeTime;
                    leftFile = batch.fileSzie;
                    maxLeft = Math.max(maxLeft, leftFile);
                    maxLeft = Math.max(maxLeft, batch.fileSzie);
                } else {
                    overTime = batch.comeTime;
                    leftFile = leftFile - lastTras + batch.fileSzie;
                    maxLeft = Math.max(maxLeft, leftFile);
                    maxLeft = Math.max(maxLeft, batch.fileSzie);
                }
            }
            overTime += leftFile;
            System.out.print(overTime);
            System.out.print(" ");
            System.out.println(maxLeft);
        }
    }

    static class Batch {
        int comeTime;
        int fileSzie;

        public Batch(int comeTime, int num) {
            this.comeTime = comeTime;
            this.fileSzie = num;
        }
    }

}
