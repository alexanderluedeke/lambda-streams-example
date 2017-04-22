package concurrent;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadSaveCounterDemo {
  private static AtomicInteger commonCounter = new AtomicInteger(0);

  static class MyRunnable implements Runnable {
    private int counter;
    private int prevCounter;
    private int counterPlusFive;

    public void run() {
      counter = commonCounter.incrementAndGet();
      System.out.println("Thread " + Thread.currentThread().getId() + " -> Counter : " + counter);

      prevCounter = commonCounter.getAndIncrement();
      System.out.println("Thread " + Thread.currentThread().getId() + " -> Previous : " + prevCounter);

      counterPlusFive = commonCounter.addAndGet(3);
      System.out.println("Thread " + Thread.currentThread().getId() + " -> plus three : " + counterPlusFive);
    }
  }

  public static void main(String[] args) {
    Thread t1 = new Thread(new MyRunnable());
    Thread t2 = new Thread(new MyRunnable());
    t1.start();
    t2.start();
  }
}