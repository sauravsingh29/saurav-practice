import java.util.Date;
import java.util.Vector;

import static java.lang.Thread.sleep;

/**
 * Created by Saurav on 10-04-2017.
 */
public class ProducerConsumer {
    public static void main(String[] args) {
        Producer producer = new Producer();
        producer.setName("Producer");
        producer.start();
        Consumer consumer = new Consumer(producer);
        consumer.setName("Consumer");
        consumer.start();
    }
}

class Producer extends Thread {
    static final int MAX_QUEUE = 10;
    private Vector<Date> messages = new Vector<>();

    public void run() {
        try {
            while (true) {
                putMessage();
                sleep(1000);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private synchronized void putMessage() throws InterruptedException {
        while (messages.size() == MAX_QUEUE)
            wait();
        System.out.println("Adding message");
        messages.add(new Date());
        notify();
    }

    public synchronized String getMessage() throws InterruptedException {
        notify();
        while (messages.size() == 0)
            wait();

        Date message = messages.firstElement();
        System.out.println("Getting message :: "+message);
        messages.remove(message);
        return message.toString();
    }
}

class Consumer extends Thread {

    private Producer producer;



    public Consumer(Producer producer) {
        this.producer = producer;
    }

    public void run() {
        try {
            while (true) {
                String message = producer.getMessage();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
