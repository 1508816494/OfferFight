package concurrent;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

public class Piped {
    public static void main(String[] args) throws IOException {
        PipedWriter out = new PipedWriter();
        PipedReader in = new PipedReader();
        //将输入输出流绑定
        out.connect(in);

        Thread printThread = new Thread(new Print(in), "PrintThread");
        printThread.start();

        int receive;
        //将main线程的输入通过PipedWriter写入
        try {
            while ((receive = System.in.read()) != -1 ) {
                out.write(receive);
            }
        } finally {
            out.close();
        }
    }
    static class Print implements Runnable {
        private  PipedReader in;
        Print(PipedReader in) {
            this.in = in;
        }

        @Override
        public void run() {
            int receive;
            //通过PipedReader将内容读出
            try {
                while ((receive = in.read()) != -1) {
                    System.out.print((char) receive);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
