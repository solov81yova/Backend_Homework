package homework_01.task01;
/*
Дан диапазон чисел: от 1 до 2_000_000 включительно. Задача: найти, сколько чисел из этого
диапазона делятся нацело на 21.
Решить данную задачу в один поток.
 */
public class Main {

  public static void main(String[] args) {
    int counter = 0;
    for (int i = 1; i <= 2_000_000; i++) {
      if (i % 21 == 0) {
        counter++;
      }
    }
    System.out.println("Counter: " + counter);
  }

}
