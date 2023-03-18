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

public class task1phone {
// Создадим метод добавления нового контакта
    public static void addNumber(String key, int num, Map<String, ArrayList<Integer>> map) {
// если контакт есть, добавляем номер
        if (map.containsKey(key)) {
            map.get(key).add(num);
            System.out.println("Контакту " + key + " добавлен еще один номер " + num);
// если контакт нет, добавляем имя и номер           
        } else {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(num);
            map.put(key, list);
            System.out.println("Новый контакт " + key +" успешно создан." );            
        }

    }
// Создадим метод для вывода данных из телефонной книжки
    public static void printPhoneBook(Map<String, ArrayList<Integer>> map) {
        for (Entry<String, ArrayList<Integer>> item : map.entrySet()) {
            String phones = "";
            for (int el : item.getValue()) {
                phones = phones + el + ", ";
            }
            System.out.printf("%s: %s \n", item.getKey(), phones);

        }
    }
// Основная программа:
public static void main(String[] args) {
// Создаем телефонную книжку и добавляем некоторое количество контактов на пробу работы.
        Map<String, ArrayList<Integer>> bookPhone = new HashMap<>();
        addNumber("Kent", 322223, bookPhone);
        addNumber("Kent", 924845455, bookPhone);
        addNumber("Google", 546585, bookPhone);
        addNumber("Kent", 8956477, bookPhone);
        addNumber("Google", 12356233, bookPhone);
        addNumber("Иванов", 787897, bookPhone);
        try (Scanner input = new Scanner(System.in)) {
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
                    int num = input.nextInt();
                    addNumber(name, num, bookPhone);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
