package practice3;

import java.util.ArrayList;
import java.util.List;

public class LockListTest {
    public static void main(String[] args) {
        // Создаем обычный список
        List<Integer> originalList = new ArrayList<>();
        originalList.add(1);
        originalList.add(2);
        originalList.add(3);

        // Создаем экземпляр LockList
        LockList<Integer> lockList = new LockList<>(originalList);

        // Тест методов чтения
        System.out.println("Размер: " + lockList.size());
        System.out.println("Пуст ли список: " + lockList.isEmpty());
        System.out.println("Содержит ли 2: " + lockList.contains(2));
        System.out.println("Получить элемент по индексу 1: " + lockList.get(1));
        System.out.println("Индекс элемента 3: " + lockList.indexOf(3));

        // Тест методов записи
        lockList.add(4);
        System.out.println("Список после добавления 4: " + lockList);
        lockList.remove((Integer) 2);
        System.out.println("Список после удаления 2: " + lockList);
        lockList.set(0, 10);
        System.out.println("Список после замены элемента с индексом 0 на 10: " + lockList);

        // Тест итерации
        System.out.print("Итерация по списку: ");
        for (Integer i : lockList) {
            System.out.print(i + " ");
        }
        System.out.println();

        // Тест подсписка
        List<Integer> subList = lockList.subList(1, 3);
        System.out.println("Подсписок с индекса 1 до 3: " + subList);

        // Очистка списка
        lockList.clear();
        System.out.println("Список после очистки: " + lockList);
    }
}
