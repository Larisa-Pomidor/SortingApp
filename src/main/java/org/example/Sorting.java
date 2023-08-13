package org.example;

import java.util.Arrays;

public class Sorting {
  public static void main(String[] args) {
    if (args.length > 10) throw new IllegalArgumentException();

    String[] numbersArray = args;
    int[] numbers = new int[numbersArray.length];

    for (int i = 0; i < numbersArray.length; i++) {
      numbers[i] = Integer.parseInt(numbersArray[i]);
    }

    Arrays.sort(numbers);

    String sortedNumbers = Arrays.toString(numbers);
    System.out.print(sortedNumbers);
  }
}
