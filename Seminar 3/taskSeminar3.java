//Задание

//Пусть дан произвольный список целых чисел.
//1) Нужно удалить из него чётные числа
//2) Найти минимальное значение
//3) Найти максимальное значение
//4) Найти среднее значение

import java.util.ArrayList;
import java.util.Random;

public class taskSeminar3{
    public static void main(String[] args) {
        ArrayList<Integer> numbersList = new ArrayList<>();
        
        for (int i = 0; i < 10; i++) {
            numbersList.add(new Random().nextInt(50) + 1);
        }
        System.out.println(numbersList);
        System.out.println("-".repeat(20));

        int maxNumber = numbersList.get(0);
        for (int i = 0; i < 10; i++) {
            if (numbersList.get(i) > maxNumber) {
                maxNumber = numbersList.get(i);
            }
        }
        System.out.println("Максимальное значение элемента списка: " );
        System.out.println(maxNumber);
        System.out.println("-".repeat(20));
        
        int minNumber = numbersList.get(0);
        for (int i = 0; i < 10; i++) {
            if (numbersList.get(i) < minNumber) {
                minNumber = numbersList.get(i);
            }
        }
        System.out.println("Минимальное значение элемента списка: " );
        System.out.println(minNumber);
        System.out.println("-".repeat(20));

        int midNumber = 0;
        int sum = 0;
        for (int i = 0; i < 10; i++) {
              sum += numbersList.get(i);  
        }
        midNumber = sum/10;
        System.out.println("Среднее значение элементов списка: " );
        System.out.println(midNumber);
        System.out.println("-".repeat(20));

        ArrayList<Integer> temp = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            if (numbersList.get(i) % 2 == 0) {
                temp.add(numbersList.get(i));
            }
        }
        numbersList.removeAll(temp);
        System.out.println("Список после удаления чётных чисел: " );
        System.out.println(numbersList);
        System.out.println("-".repeat(20));

    }
}