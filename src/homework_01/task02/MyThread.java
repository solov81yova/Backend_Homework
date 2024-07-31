package homework_01.task02;

public class MyThread extends Thread {

  private final int rangeFrom;
  private final int rangeUpTo;
  private int counter;

  public MyThread(int rangeFrom, int rangeUpTo) {
    this.rangeFrom = rangeFrom;
    this.rangeUpTo = rangeUpTo;
    this.counter = 0;
  }

  @Override
  public void run() {
    for (int i = rangeFrom; i <= rangeUpTo; i++) {
      if (i % 21 == 0) {
        counter++;
      }
    }
  }

  public int getCounter() {
    return counter;
  }
}
