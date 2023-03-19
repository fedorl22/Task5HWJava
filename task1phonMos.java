// Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.
// Добавить функции 1) Добавление номера
// 2) Вывод всего
// Пример:
// Я ввожу: 1
// К: Введите фамилию
// Я: Иванов
// К: Введите номер
// Я: 1242353
// К: Введите 1) Добавление номера
// 2) Вывод всего
// Я ввожу: 1
// К: Введите фамилию
// Я: Иванов
// К: Введите номер
// Я: 547568
// К: Введите 1) Добавление номера
// 2) Вывод всего
// Я: 2
// Иванов: 1242353, 547568

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;

public class task1phonMos {
// Создадим метод добавления нового контакта
    public static void addNumber(String key, Long i, Map<String, ArrayList<Long>> map) {
// если контакт есть, добавляем номер
        if (map.containsKey(key)) {
            map.get(key).add(i);
            System.out.println("Контакту " + key + " добавлен еще один номер " + i);
// если контакт нет, добавляем имя и номер           
        } else {
            ArrayList<Long> list = new ArrayList<>();
            list.add(i);
            map.put(key, list);
            System.out.println("Новый контакт " + key +" успешно создан." );            
        }

    }
// Создадим метод для вывода данных из телефонной книжки
    public static void printPhoneBook(Map<String, ArrayList<Long>> map) {
        for (Entry<String, ArrayList<Long>> item : map.entrySet()) {
            String phones = "";
            for (Long el : item.getValue()) {
                phones = phones + el + ", ";
            }
            System.out.printf("%s: %s \n", item.getKey(), phones);

        }
    }
// Основная программа:
public static void main(String[] args) {
// Создаем телефонную книжку и добавляем некоторое количество контактов на пробу работы.
        Map<String, ArrayList<Long>> bookPhone = new HashMap<>();
        addNumber("Kent", (Long) 89253222233L, bookPhone);
        addNumber("Kent", (Long) 84959222237L, bookPhone);
        addNumber("Google", (Long) 84995552277L, bookPhone);
        addNumber("Kent", (Long) 89257772255L, bookPhone);
        addNumber("Google", (Long) 89251117733L, bookPhone);
        addNumber("Иванов", (Long) 89253222200L, bookPhone);
        try (Scanner input = new Scanner(System.in,"cp866")) {
            while (true) {
// Открываем цикл ввода данных.
                System.out.printf(
                        "Вы зашли в телефонную книжку, выберите режим работы '1'-добавить новый контакт или телефон, '2'-вывести данные, '3'-выход: ");
                int a = input.nextInt();
                if (a != 3 && a!=2 && a!=1) {
                    System.out.println("Вы ввели некорректные данные");
                }
                if (a == 3) {
                    break;
                }
                if (a == 2) {
                    printPhoneBook(bookPhone);
                }
                if (a == 1) {
                    
                    System.out.printf("Введите фамилию: ");
                    String name = input.next();
                    System.out.printf("Введите номер телефона: ");
                    Long num = input.nextLong();
                    addNumber(name, num, bookPhone);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
