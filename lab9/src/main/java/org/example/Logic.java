package org.example;

import java.sql.*;
import java.util.Scanner;

public class Logic {
    public void showAll(){
        try {
            Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/car","student","123");
            try (
                    PreparedStatement pr = connection.prepareStatement("select * from car");
                    ResultSet rs = pr.executeQuery())
            {
                while (rs.next()) {
                    print(rs);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public void searchMark(String mark) {

        try (Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/car","student","123");
             PreparedStatement pr = connection.prepareStatement("select * from car where mark = ? ORDER BY year ASC")) {
            pr.setString(1, mark);
            try (ResultSet rs = pr.executeQuery()) {
                while (rs.next()) {
                    print(rs);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public void searchMarkAndYear(String mark, int n){

        try (Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/car","student","123");
             PreparedStatement pr = connection.prepareStatement("select * from car where mark = ? AND (YEAR(CURRENT_DATE()) - year) > ?")) {
            pr.setString(1, mark);
            pr.setInt(2, n);
            try (ResultSet rs = pr.executeQuery()) {
                while (rs.next()) {
                    print(rs);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }}

    public void searchYearAndPrice(int year, int price){

        try (Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/car","student","123");
             PreparedStatement pr = connection.prepareStatement("select * from car where year = ? AND price > ?")) {
            pr.setInt(1, year);
            pr.setInt(2, price);
            try (ResultSet rs = pr.executeQuery()) {
                while (rs.next()) {
                    print(rs);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }}

    public void sortPriceDownOrYearUp(){

        try {
            Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/car","student","123");
            try (
                    PreparedStatement pr = connection.prepareStatement("select * from car ORDER BY price DESC, year ASC");
                    ResultSet rs = pr.executeQuery())
            {
                while (rs.next()) {
                    print(rs);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }}

    public void sortMark(){

        try {
            Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/car","student","123");
            try (
                    PreparedStatement pr = connection.prepareStatement("select id,mark, model, year, price, number from car ORDER BY mark");
                    ResultSet rs = pr.executeQuery())
            {
                while (rs.next()) {
                    print(rs);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }}


    public void print(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        String mark = rs.getString("mark");
        String model = rs.getString("model");
        int year = rs.getInt("year");
        int price = rs.getInt("price");
        String number = rs.getString("number");
        System.out.println("[" + "Id:" + id + "  Mark:" + mark + "  Model:" + model + "  Year:" + year + "  Price:" + price + "$" + "  Number:" + number + "]");
    }

    public void addCar(String mark, String model, int year, int price , String number) {

        try (Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/car","student","123");
             PreparedStatement pr = connection.prepareStatement("insert into car(mark, model,year,price,number) VALUES (?,?,?,?,?)")) {
            pr.setString(1, mark);
            pr.setString(2, model);
            pr.setInt(3, year);
            pr.setInt(4, price);
            pr.setString(5, number);
            try (ResultSet rs = pr.executeQuery()) {
                while (rs.next()) {
                    print(rs);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public void deleteCar(int id) {

        try (Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/car","student","123");
             PreparedStatement pr = connection.prepareStatement("delete from car where id = ?")) {
            pr.setInt(1, id);
            try (ResultSet rs = pr.executeQuery()) {
                while (rs.next()) {
                    print(rs);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
