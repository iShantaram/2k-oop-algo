package pro.sky.agapov;

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

//        long start = System.currentTimeMillis();
//        arrList.sortBubble();
//        System.out.print("Bubble time = ");
//        System.out.println(System.currentTimeMillis() - start);

//        long start2 = System.currentTimeMillis();
//        arrListCopy1.sortMaximum();
//        System.out.print("Maximum time = ");
//        System.out.println(System.currentTimeMillis() - start2);

//        чтобы использовать этот кусок кода, надо сделать метод qSort публичным
//        long start3 = System.currentTimeMillis();
//        arrListCopy2.qSort(0, arrListCopy2.size()-1);
//        System.out.print("QSort time = ");
//        System.out.println(System.currentTimeMillis() - start3);
//        System.out.println(arrListCopy2);

        System.out.println("Обычный:");
        if (arrListCopy2.contains(0)) {
            System.out.println("0 содержит");
        } else {
            System.out.println("0 не содержит");
        }

        // После использования метода binaryContains внутренний массив будет отсортирован
        System.out.println("Бинарный:");
        if (arrListCopy2.binaryContains(0)) {
            System.out.println("0 содержит");
        } else {
            System.out.println("0 не содержит");
        }
    }
}