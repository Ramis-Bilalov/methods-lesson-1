import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws IOException {

        // Задача 1
        System.out.print("\nЗадача 1. Напишите год в формате #### и мы определим является ли год високосным или нет: ");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String yearValue = reader.readLine();            // считывание значения с клавиатуры
        int year = Integer.parseInt(yearValue);          // преобразование строки в число

        isLeapYear(year);


        // Задача 2

        System.out.print("\nЗадача 2. Выберите операционную систему вашего устройства: \n 0 - IOS \n 1 - Android \nВаша операционная система: ");

        String osValue = reader.readLine();            // считывание значения с клавиатуры
        int os = Integer.parseInt(osValue);            // преобразование строки в число

        System.out.print("Напишите год выпуска операционной системы: ");
        String osYear = reader.readLine();            // считывание значения с клавиатуры
        int clientDeviceYear = Integer.parseInt(osYear);       // преобразование строки в число

        osVersion(os, clientDeviceYear);

        // Задача 3

        System.out.print("\nЗадача 3. Напишите расстояние от банка до адреса дома: ");

        String distanceValue = reader.readLine();                           // считывание значения с клавиатуры
        int deliveryDistance = Integer.parseInt(distanceValue);          // преобразование строки в число

        int deliveryTime = getDeliveryTime(deliveryDistance);

        if(deliveryTime > 0) {
            System.out.println("Количество дней доставки: " + deliveryTime);
        }
    }

    public static void isLeapYear(int year) {                                                                               // метод к первой задаче
        if ((year % 100 == 0 && year % 400 == 0) || (year % 4 == 0 && year % 100 != 0)) {
            System.out.println("Год является високосным");
        } else System.out.println("Год не является високосным");
    }

    private static void osVersion(int os, int year) {                                                                       // метод ко второй задаче
        int currentYear = LocalDate.now().getYear();
        if(year < currentYear) {
            switch (os) {
                case 0 -> System.out.println("Установите облегченную версию приложения для iOS по ссылке");
                case 1 -> System.out.println("Установите облегченную версию приложения для Android по ссылке");
                default -> System.out.println("Выберите корректное значение (IOS либо Android)");
            }
        } else {
            switch (os) {
                case 0 -> System.out.println("Установите версию приложения для iOS по ссылке");
                case 1 -> System.out.println("Установите версию приложения для Android по ссылке");
                default -> System.out.println("Выберите корректное значение (IOS либо Android)");
            }
        }
    }

    private static int getDeliveryTime(int deliveryDistance) {                                                             // метод к третьей задаче
        int deliveryTime = 0;
        if(deliveryDistance > 0 && deliveryDistance <= 20) {
            deliveryTime = 1;
        } else if (deliveryDistance > 20 && deliveryDistance <= 60) {
            deliveryTime = 2;
        } else if (deliveryDistance > 60 && deliveryDistance <= 100) {
            deliveryTime = 3;
        } else {
            System.out.println("Доставки нет");
        }
        return deliveryTime;
    }

}