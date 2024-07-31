package homework_01.task02;
/*
Дан диапазон чисел: от 1 до 2_000_000 включительно. Задача: найти, сколько чисел из этого
диапазона делятся нацело на 21.
Решить данную задачу в два потока, разделив между потоками заданный диапазон чисел пополам.
 */

public class Main {

  public static void main(String[] args) {
    int rangeFrom = 1;
    int rangeUpTo = 2_000_000;
    int midPoint = rangeUpTo / 2;


    MyThread thread1 = new MyThread(rangeFrom, midPoint);
    MyThread thread2 = new MyThread(midPoint + 1, rangeUpTo);
    thread1.start();
    thread2.start();

    try {
      thread1.join();
      thread2.join();
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }

    int counter = thread1.getCounter() + thread2.getCounter();
    System.out.println("Counter: " + counter);

  }

}
