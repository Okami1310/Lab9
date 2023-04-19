package org.example;

import menu.Menu;
import menu.MenuItem;
import java.sql.*;
import java.util.Arrays;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }

    private void run() {
        Logic logic = new Logic();
        List<MenuItem> menuItems = Arrays.asList(
                new MenuItem("Добавити авто", () -> {
                    Scanner s = new Scanner(System.in);
                    System.out.println("Введіть назву марки");
                    String mark = s.nextLine();
                    System.out.println("Введіть модель");
                    String model = s.nextLine();
                    System.out.println("Введіть рік випуску");
                    int year = s.nextInt();
                    s.nextLine();
                    System.out.println("Введіть ціну");
                    int price = s.nextInt();
                    s.nextLine();
                    System.out.println("Введіть номер");
                    String number = s.nextLine();

                    logic.addCar(mark,model,year,price,number);
                }),
                new MenuItem("Видалити авто", () -> {
                    Scanner s = new Scanner(System.in);
                    System.out.println("Введіть Id авто, якого хочете видалити");
                    int id = s.nextInt();
                    logic.deleteCar(id);
                }),
                new MenuItem("Cписок автомобілів заданої марки в порядку зростання року випуску;", () -> {
                 Scanner s = new Scanner(System.in);
                    System.out.println("Введіть назву марки");
                String mark = s.nextLine();
                 logic.searchMark(mark);
                }),
                new MenuItem("Список автомобілів заданої марки, які експлуатуються більше n років;", () -> {
                    Scanner s = new Scanner(System.in);
                    System.out.println("Введіть назву марки");
                    String mark = s.nextLine();
                    System.out.println("Введіть кількість років");
                    int n = s.nextInt();
                    logic.searchMarkAndYear(mark,n);
                }),
                new MenuItem("Список автомобілів заданого року випуску, ціна яких більше вказаної;", () -> {
                    Scanner s = new Scanner(System.in);
                    System.out.println("Введіть рік випуску");
                    int year = s.nextInt();
                    System.out.println("Введіть ціну");
                    int price = s.nextInt();
                    logic.searchYearAndPrice(year,price);
                }),
                new MenuItem("Список автомобілів в порядку спадання ціни. Якщо ціна однакова, то в порядку зростання року випуску;", () -> {
                 logic.sortPriceDownOrYearUp();
                }),
                new MenuItem("Список моделей автомобілів, зареєстрованих у програмі;", () -> {
                    logic.showAll();
                }),
                new MenuItem("Для кожної марки вивести список автомобілів.", () -> {
                   logic.sortMark();
                })
        );
        Menu menu = new Menu(menuItems);
        menu.run();
    }
}