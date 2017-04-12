import java.util.ArrayList;
import java.util.List;

/**
 * Created by Saurav on 10-04-2017.
 */
public class NResourceNThread {
    public static void main(String[] args) {
        Thread threadOne = new Thread(new TestTOne("T-One"));
        Thread threadTwo = new Thread(new TestTOne("T-Two"));
        threadOne.start();
        threadTwo.start();
    }
}

class TestTOne implements Runnable {
    private String[] resources = {"Never", "mistake", "activity", "for", "achievement"};

    String name;

    public TestTOne(String name) {
        this.name = name;
    }

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        for (int i = 0; i < resources.length; i++) {
            waitToRun();
            System.out.println(name + ": " + resources[i]);
        }
    }

    void waitToRun(){
        try {
            Thread.currentThread().sleep((long) (3500 * Math.random()));
        } catch (InterruptedException e) {
            System.err.println("Exception raised :: "+ e);
        }
    }
}
