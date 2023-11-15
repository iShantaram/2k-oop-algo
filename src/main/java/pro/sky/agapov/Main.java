package pro.sky.agapov;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int count = 100_000;
        ArrListImpl arrList = new ArrListImpl(count);
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            arrList.add(random.nextInt(-100_000, 100_000));
        }

        ArrListImpl arrListCopy1 = new ArrListImpl(arrList.toArray());
        ArrListImpl arrListCopy2 = new ArrListImpl(arrList.toArray());
        ArrListImpl arrListCopy3 = new ArrListImpl(arrList.toArray());

        long start = System.currentTimeMillis();
        arrListCopy1.sortBubble();
        System.out.print("Bubble time = ");
        System.out.println(System.currentTimeMillis() - start);

        long start2 = System.currentTimeMillis();
        arrListCopy2.sortMaximum();
        System.out.print("Maximum time = ");
        System.out.println(System.currentTimeMillis() - start2);

        long start3 = System.currentTimeMillis();
        Integer[] sortedArray = ArrListImpl.qSort(arrListCopy3.toArray(), 0, arrListCopy3.size()-1);
        System.out.print("QSort time = ");
        System.out.println(System.currentTimeMillis() - start3);
        System.out.println(Arrays.toString(sortedArray));

        System.out.println("Обычный:");
        if (arrList.contains(0)) {
            System.out.println("0 содержит");
            System.out.println("0 - " + arrList.indexOf(0) + "-ый элемент");
        } else {
            System.out.println("0 не содержит");
        }

        // После использования метода binaryContains внутренний массив будет отсортирован приватным методом qSort
        System.out.println("Бинарный:");
        if (arrList.binaryContains(0)) {
            System.out.println("0 содержит");
            System.out.println("0 - " + arrList.indexOf(0) + "-ый элемент в упорядоченном массиве");
        } else {
            System.out.println("0 не содержит");
        }
    }
}