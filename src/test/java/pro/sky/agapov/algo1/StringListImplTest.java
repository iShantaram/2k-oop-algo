package pro.sky.agapov.algo1;


import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class StringListImplTest {

    private StringList stringList;
    private String item1, item2, item3;
    private int index;

    public void setUp() {
        stringList = new StringListImpl(2);
        item1 = "item1";
        item2 = "item2";
        item3 = "item3";
        stringList.add(item1);
        stringList.add(item2);
    }

    @Test
    void growing() {
        assertTrue(StringListImpl.GROWING_COEFFICIENT > 1.0);
    }

    @Test
    void add_success() {
        // Подготовка вводных данных
        setUp();
        index = 2;

        // Подготовка результата
        String expectedString = item3;
        String[] expectedStringArray = {item1, item2, item3};
        int capacity = (int) (2 * StringListImpl.GROWING_COEFFICIENT) + 1;

        // Начало теста
        String actualString = stringList.add(index, item3);
        assertEquals(expectedString, actualString);
        assertArrayEquals(expectedStringArray, stringList.toArray());

        assertEquals(3, stringList.size());
        assertEquals(capacity, stringList.getCapacity());

    }
    @Test
    void add_withNullPointerException() {
        // Подготовка вводных данных
        setUp();
        item3 = null;
        // Подготовка результата
        String expectedString = "Method \"add\" required not NULL parameter.";
        String[] expectedStringArray = {item1, item2};

        // Начало теста
        Exception exception = assertThrows(
                NullPointerException.class,
                () -> stringList.add(item3)
        );
        assertEquals(expectedString, exception.getMessage());
        assertArrayEquals(expectedStringArray, stringList.toArray());
    }

    @Test
    void add_WithIndexOutOfBoundsException() {
        // Подготовка вводных данных
        setUp();
        index = 3;
        // Подготовка результата
        String expectedString = "Index in method \"add\" must be in range of 0 and 2.";
        String[] expectedStringArray = {item1, item2};
        // Начало теста
        Exception exception = assertThrows(
                IndexOutOfBoundsException.class,
                () -> stringList.add(index, item3)
        );
        assertEquals(expectedString, exception.getMessage());
        assertArrayEquals(expectedStringArray, stringList.toArray());
    }

    @Test
    void set_success() {
        // Подготовка вводных данных
        setUp();
        stringList.add(item3);
        index = 1;
        // Подготовка результата
        String expectedString = item3;
        String[] expectedStringArray = {item1, item3, item3};
        // Начало теста
        String actualString = stringList.set(index, item3);
        assertEquals(expectedString, actualString);
        assertArrayEquals(expectedStringArray, stringList.toArray());
    }
    @Test
    void set_withNullPointerException() {
        // Подготовка вводных данных
        setUp();
        index = 2;
        item3 = null;
        // Подготовка результата
        String expectedString = "Method \"set\" required not NULL parameter.";
        String[] expectedStringArray = {item1, item2};

        // Начало теста
        Exception exception = assertThrows(
                NullPointerException.class,
                () -> stringList.set(index, item3)
        );
        assertEquals(expectedString, exception.getMessage());
        assertArrayEquals(expectedStringArray, stringList.toArray());
    }

    @Test
    void set_WithIndexOutOfBoundsException() {
        // Подготовка вводных данных
        setUp();
        index = 3;
        // Подготовка результата
        String expectedString = "Index in method \"set\" must be in range of 0 and 1.";
        String[] expectedStringArray = {item1, item2};

        // Начало теста
        Exception exception = assertThrows(
                IndexOutOfBoundsException.class,
                () -> stringList.set(index, item3)
        );
        assertEquals(expectedString, exception.getMessage());
        assertArrayEquals(expectedStringArray, stringList.toArray());
    }

    @Test
    void removeItem_success() {
        // Подготовка вводных данных
        setUp();
        stringList.add(item3);
        String itemForRemove = item1;

        // Подготовка результата
        String expectedString = item1;
        String[] expectedStringArray = {item2, item3};

        // Начало теста
        String actualString = stringList.remove(itemForRemove);
        assertEquals(expectedString, actualString);
        assertArrayEquals(expectedStringArray, stringList.toArray());
    }

    @Test
    void removeItem_WithNullPointerException() {
        // Подготовка вводных данных
        setUp();
        String itemForRemove = null;

        // Подготовка результата
        String expectedString = "Method \"remove\" required not NULL parameter.";
        String[] expectedStringArray = {item1, item2};

        // Начало теста
        Exception exception = assertThrows(
                NullPointerException.class,
                () -> stringList.remove(itemForRemove)
        );
        assertEquals(expectedString, exception.getMessage());
        assertArrayEquals(expectedStringArray, stringList.toArray());
    }

    @Test
    void removeWithIndex_success() {
        // Подготовка вводных данных
        setUp();
        stringList.add(item3);
        index = 0;

        // Подготовка результата
        String[] expectedStringArray = {item2, item3};
        String expectedString = item1;

        // Начало теста
        String actualString = stringList.remove(index);
        assertEquals(expectedString, actualString);
        assertArrayEquals(expectedStringArray, stringList.toArray());
    }


    @Test
    void remove_WithIndexOutOfBoundsException() {
        // Подготовка вводных данных
        setUp();
        index = 4;

        // Подготовка результата
        String expectedString = "Index in method \"remove\" must be in range of 0 and 1.";
        String[] expectedStringArray = {item1, item2};

        // Начало теста
        Exception exception = assertThrows(
                IndexOutOfBoundsException.class,
                () -> stringList.remove(index)
        );
        assertEquals(expectedString, exception.getMessage());
        assertArrayEquals(expectedStringArray, stringList.toArray());
    }

    @Test
    void contains_test() {
        // Подготовка вводных данных
        setUp();
        stringList.add(item3);
        String itemExist = item2;
        String itemNotExist = "not exist string";

        // Подготовка результата

        // Начало теста
        assertTrue(stringList.contains(itemExist));
        assertFalse(stringList.contains(itemNotExist));
    }

    @Test
    void indexOf_success() {
        // Подготовка вводных данных
        setUp();
        stringList.add(item3);
        stringList.add(item3);
        String item = item3;

        // Подготовка результата
        int expectedIndex = 2;

        // Начало теста
        int actualIndex = stringList.indexOf(item);
        assertEquals(expectedIndex, actualIndex);
    }

    @Test
    void lastIndexOf_success() {    // Подготовка вводных данных
        setUp();
        stringList.add(item3);
        stringList.add(item3);
        String item = item3;

        // Подготовка результата
        int expectedIndex = 3;

        // Начало теста
        int actualIndex = stringList.lastIndexOf(item);
        assertEquals(expectedIndex, actualIndex);
    }

    @Test
    void indexOf_fail() {
        // Подготовка вводных данных
        setUp();
        stringList.add(item3);
        stringList.add(item3);
        String item = "Not exist string";

        // Подготовка результата
        int expectedIndex = -1;

        // Начало теста
        int actualIndex = stringList.indexOf(item);
        assertEquals(expectedIndex, actualIndex);
    }

    @Test
    void lastIndexOf_fail() {    // Подготовка вводных данных
        setUp();
        stringList.add(item3);
        stringList.add(item3);
        String item = "Not exist string";

        // Подготовка результата
        int expectedIndex = -1;

        // Начало теста
        int actualIndex = stringList.lastIndexOf(item);
        assertEquals(expectedIndex, actualIndex);
    }

    @Test
    void get() {
        // Подготовка вводных данных
        setUp();
        index = 0;

        // Подготовка результата
        String expectedString = item1;

        // Начало теста
        String actualString = stringList.get(index);
        assertEquals(expectedString, actualString);
    }

    @Test
    void clear() {
        // Подготовка вводных данных
        setUp();

        // Подготовка результата

        // Начало теста
        assertEquals(2, stringList.size());
        stringList.clear();
        assertTrue(stringList.isEmpty());
    }
}