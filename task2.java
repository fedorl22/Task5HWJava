// Пусть дан список сотрудников:
// Иван Иванов
// Светлана Петрова
// Кристина Белова
// Анна Мусина
// Анна Крутова
// Иван Юрин
// Петр Лыков
// Павел Чернов
// Петр Чернышов
// Мария Федорова
// Марина Светлова
// Мария Савина
// Мария Рыкова
// Марина Лугова
// Анна Владимирова
// Иван Мечников
// Петр Петин
// Иван Ежов

// Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений.
// Отсортировать по убыванию популярности Имени.
import java.util.*;

public class task2 {

    public static void main(String[] args) {
// создаем коллекцию для хранения имен сотрудников, берем данные из дз + добавляем данные для повторов.
        List<String> employees = new ArrayList<>(); 
        employees.add("Иван Иванов");
        employees.add("Светлана Петрова");
        employees.add("Кристина Белова");
        employees.add("Анна Мусина");
        employees.add("Анна Крутова");
        employees.add("Иван Юрин");
        employees.add("Петр Лыков");
        employees.add("Павел Чернов");
        employees.add("Петр Чернышов");
        employees.add("Мария Федорова");
        employees.add("Мария Савина");
        employees.add("Марина Светлова");
        employees.add("Мария Рыкова");
        employees.add("Марина Лугова");
        employees.add("Анна Владимирова");
        employees.add("Иван Мечников");
        employees.add("Петр Петин");
        employees.add("Иван Ежов");
        employees.add("Иван Иванов");
        employees.add("Светлана Петрова");
        employees.add("Кристина Белова");
        employees.add("Анна Мусина");
        employees.add("Анна Крутова");
        employees.add("Иван Юрин");
        employees.add("Петр Лыков");
        employees.add("Павел Чернов");
        employees.add("Петр Чернышов");
        employees.add("Мария Федорова");
        employees.add("Марина Лугова");
        employees.add("Анна Владимирова");
        employees.add("Иван Мечников");
        employees.add("Петр Петин");
        employees.add("Марина Светлова");
        employees.add("Мария Рыкова");
        employees.add("Марина Лугова");
        employees.add("Анна Владимирова");
        employees.add("Иван Мечников");
        employees.add("Петр Петин");
        employees.add("Иван Ежов");
        employees.add("Иван Иванов");
        employees.add("Светлана Петрова");
        employees.add("Кристина Белова");
        employees.add("Светлана Петрова");
        employees.add("Светлана Петрова");
        employees.add("Светлана Петрова");
        employees.add("Светлана Петрова");
        employees.add("Светлана Петрова");
// создаем коллекцию для хранения количества вхождений каждого имени  равного, например, =Светлана Петрова
        Map<String, Integer> nameCount = new HashMap<>(); 

        for (String name : employees) { // перебираем имена сотрудников
            if (nameCount.containsKey(name)) { // если имя упоминалось, увеличиваем счетчик на 1.
                nameCount.put(name, nameCount.get(name) + 1);
            } else {
                nameCount.put(name, 1); // если новое, добавляем в коллекцию с присвоениюсчетчика значения 1.
            }
        }
        nameCount.entrySet().stream()
        .sorted(Map.Entry.<String, Integer>comparingByValue().reversed()) 
        .forEach(System.out::println);

    }
}