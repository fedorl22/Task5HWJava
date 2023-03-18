// Написать программу, которая найдет и выведет повторяющиеся имена(без учета фамилий) с количеством повторений.
// Отсортировать по убыванию популярности Имени.
import java.util.*;

public class task2onlyname {

    public static void main(String[] args) {
// создаем коллекцию для хранения имен сотрудников, берем данные из дз .
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
// создаем коллекцию для хранения количества вхождений каждого имени  равного, например, =Светлана Петрова
        Map<String, Integer> nameCount = new HashMap<>(); 

        for (String name : employees) { // перебираем имена сотрудников

            String[] name1_name2 = name.split(" ");
            // Разбиваем строку по пробелу на массив стро, первая строка в массиве и есть Имя.
            // System.out.println(name1_name2[0]);

            if (nameCount.containsKey(name1_name2[0])) { // если Имя упоминалось, увеличиваем счетчик на 1.
                nameCount.put(name1_name2[0], nameCount.get(name1_name2[0]) + 1);
            } else {
                nameCount.put(name1_name2[0], 1); // если новое, добавляем в коллекцию с присвоению счетчика значения 1.
            }
        }
        nameCount.entrySet().stream()
        .sorted(Map.Entry.<String, Integer>comparingByValue().reversed()) 
        .forEach(System.out::println);

    }
}