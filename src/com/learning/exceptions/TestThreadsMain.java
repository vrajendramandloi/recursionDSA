package exceptions;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

class TestThreadChild implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " processing ");
    }
}

public class TestThreadsMain {
    public static void main(String[] args) {

    }

}
