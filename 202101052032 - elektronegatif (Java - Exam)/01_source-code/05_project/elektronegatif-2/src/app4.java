
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class ReaderThread implements Runnable {

    protected BlockingQueue<String> blockingQueue = null;

    public ReaderThread(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        System.out.println("Okunan veri >> \n------------------------");
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(new File("inputFile.txt")));
            String buffer = null;
            while ((buffer = br.readLine()) != null) {
                System.out.println(buffer);
                blockingQueue.put(buffer);
            }
            blockingQueue.put("EOF");

        } catch (FileNotFoundException e) {

            e.printStackTrace();
        } catch (IOException e) {

            e.printStackTrace();
        } catch (InterruptedException e) {

        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("------------------------");
    }

}

class WriterThread implements Runnable {

    protected BlockingQueue<String> blockingQueue = null;

    public WriterThread(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        PrintWriter writer = null;

        try {
            writer = new PrintWriter(new File("outputFile.txt"));

            while (true) {
                String buffer = blockingQueue.take();
                if (buffer.equals("EOF")) {
                    break;
                }
                writer.println(buffer);
            }

        } catch (FileNotFoundException e) {

            e.printStackTrace();
        } catch (InterruptedException e) {

        } finally {
            writer.close();
        }

    }

}

public class app4 {

    public static void main(String[] args) {
        BlockingQueue<String> queue = new ArrayBlockingQueue<String>(1024);

        ReaderThread reader = new ReaderThread(queue);
        WriterThread writer = new WriterThread(queue);

        new Thread(reader).start();
        new Thread(writer).start();
    }
}
