package pro.sky.agapov;

import pro.sky.agapov.algo1.StringList;
import pro.sky.agapov.algo1.StringListImpl;

public class Main {
    public static void main(String[] args) {
        StringList list = new StringListImpl();
        list.add("one");
        list.add("one");
        list.add("two");
        list.add("three");

        StringList list2 = new StringListImpl();
        list2.add("one");
        list2.add("two");
        list2.add("one");
        list2.add("three");

        System.out.println(list);
        System.out.println(list2);
        if (list.equals(list2)) {
            System.out.println("Равны");
        } else {
            System.out.println("Не равны");
        }
        list2.remove("two");
        list2.add(2, "two");

        System.out.println(list);
        System.out.println(list2);
        if (list.equals(list2)) {
            System.out.println("Равны");
        } else {
            System.out.println("Не равны");
        }
    }
}