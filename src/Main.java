import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        IntegerListImpl list = new IntegerListImpl(10);

        // Добавление элементов
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(3, 15); // Добавление элемента на позицию 1

        // Вывод размера списка
        System.out.println("Size: " + list.size()); // Ожидаемый результат: 4

        // Вывод элементов списка
        System.out.println("List: " + Arrays.toString(list.toArray())); // Ожидаемый результат: [10, 15, 20, 30]

        // Проверка наличия элемента в списке
        System.out.println("Contains 20: " + list.contains(20)); // Ожидаемый результат: true
        System.out.println("Contains 25: " + list.contains(25)); // Ожидаемый результат: false

        // Получение элемента по индексу
        System.out.println("Element at index 2: " + list.get(2)); // Ожидаемый результат: 20

        // Изменение элемента по индексу
        list.set(1, 18); // Замена элемента на позиции 1 на значение 18
        System.out.println("List after set: " + Arrays.toString(list.toArray())); // Ожидаемый результат: [10, 18, 20, 30]

        // Удаление элемента
        Integer removedItem = list.remove(1); // Удаление элемента на позиции 2
        System.out.println("Removed item: " + removedItem); // Ожидаемый результат: 20
        System.out.println("List after remove: " + Arrays.toString(list.toArray())); // Ожидаемый результат: [10, 18, 30]

        // Очистка списка
        list.clear();
        System.out.println("List after clear: " + Arrays.toString(list.toArray())); // Ожидаемый результат: []

        // Проверка пустоты списка
        System.out.println("Is list empty: " + list.isEmpty()); // Ожидаемый результат: true
    }
}
