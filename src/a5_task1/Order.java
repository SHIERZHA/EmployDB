/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a5_task1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author yezh0
 */
public class Order {

    String url = "jdbc:derby:StaffDB";
    String username = "user1";
    String password = "123456";

    /**
     * list
     */
    public static ObservableList<Employer> List = FXCollections.observableArrayList();

    /**
     * display all employers
     */
    public void displayAll() {

        List.clear();
        String query = "SELECT * FROM STAFF";
        try (Connection con = DriverManager.getConnection(url, username, password);
                java.sql.Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(query);) {
            while (rs.next()) {
                String LastName = rs.getString("LASTNAME");
                String FirstName = rs.getString("FIRSTNAME");
                String Position = rs.getString("POSITION");
                int Wage = rs.getInt("WAGE");
                int Age = rs.getInt("AGE");
                List.add(new Employer(LastName, FirstName, Position, Wage, Age));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            ex.getStackTrace();
        }
    }

    /**
     * add data
     */
    public void addData() {
        Scanner input = new Scanner(System.in);
        System.out.println("Please input the first name of the staff");
        String firstname = input.nextLine();
        System.out.println("Please input the last name of the staff");
        String lastname = input.nextLine();
        System.out.println("Please input the position of the staff");
        String position = input.nextLine();
        System.out.println("Please input the wage of the staff");
        int wage = input.nextInt();
        System.out.println("Please input the age of the staff");
        int age = input.nextInt();
        String query = "insert into staff values(" + "'" + firstname + "','" + lastname + "','" + position + "'," + wage + "," + age + ")";
        try (Connection con = DriverManager.getConnection(url, username, password);
                java.sql.Statement stmt = con.createStatement();) {
            int rs = stmt.executeUpdate(query);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            ex.getStackTrace();

        }
    }

    /**
     * display by position
     */
    public void displayPosition() {
        List.clear();
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the name of positions(Doctor,Lawyer,Singer,Artist,Cook,Enginerr,Mechanic)");
        String position = input.nextLine();
        String query = "SELECT * FROM USER1.STAFF where position = '" + position + "'";
        try (Connection con = DriverManager.getConnection(url, username, password);
                java.sql.Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                String LastName = rs.getString("LASTNAME");
                String FirstName = rs.getString("FIRSTNAME");
                String Position = rs.getString("POSITION");
                int Wage = rs.getInt("WAGE");
                int Age = rs.getInt("AGE");
                List.add(new Employer(LastName, FirstName, Position, Wage, Age));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            ex.getStackTrace();

        }
    }

    /**
     * display who earn least
     */
    public void displaySmallest() {
        String query = "SELECT * FROM USER1.STAFF  Where wage = (select MIN(Wage) from staff)";
        System.out.println("The person earns least is:");
        System.out.printf("%-10s%-10s%-10s%-10s%-10s", "LastName", "FirstName", "Position", "Wage", "Age");
        System.out.println();
        try (Connection con = DriverManager.getConnection(url, username, password);
                java.sql.Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                String LastName = rs.getString("LASTNAME");
                String FirstName = rs.getString("FIRSTNAME");
                String Position = rs.getString("POSITION");
                int Wage = rs.getInt("WAGE");
                int Age = rs.getInt("AGE");
                List.add(new Employer(LastName, FirstName, Position, Wage, Age));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
    }

    /**
     * display who earn most
     */
    public void displayMost() {
        String query = "SELECT * FROM USER1.STAFF  Where wage = (select MAX(Wage) from staff)";
        System.out.println("The person earns most is:");
        System.out.printf("%-10s%-10s%-10s%-10s%-10s", "LastName", "FirstName", "Position", "Wage", "Age");
        System.out.println();
        try (Connection con = DriverManager.getConnection(url, username, password);
                java.sql.Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                String LastName = rs.getString("LASTNAME");
                String FirstName = rs.getString("FIRSTNAME");
                String Position = rs.getString("POSITION");
                int Wage = rs.getInt("WAGE");
                int Age = rs.getInt("AGE");
                List.add(new Employer(LastName, FirstName, Position, Wage, Age));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
    }

    /**
     * display who earn more than average
     */
    public void displayAboveAverage() {
        String query = "SELECT * FROM USER1.STAFF  Where wage >= (select AVG(Wage) from staff)";
        System.out.println("The people earn above average are:");
        System.out.printf("%-10s%-10s%-10s%-10s%-10s", "LastName", "FirstName", "Position", "Wage", "Age");
        System.out.println();
        try (Connection con = DriverManager.getConnection(url, username, password);
                java.sql.Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                String LastName = rs.getString("LASTNAME");
                String FirstName = rs.getString("FIRSTNAME");
                String Position = rs.getString("POSITION");
                int Wage = rs.getInt("WAGE");
                int Age = rs.getInt("AGE");
                List.add(new Employer(LastName, FirstName, Position, Wage, Age));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
    }

    /**
     * display employers who earn more than 55000
     */
    public void displayAboveNumber() {
        String query = "SELECT * FROM USER1.STAFF  Where wage >= 55000";
        System.out.println("The people earn above $55000 are:");
        System.out.printf("%-10s%-10s%-10s%-10s%-10s", "LastName", "FirstName", "Position", "Wage", "Age");
        System.out.println();
        try (Connection con = DriverManager.getConnection(url, username, password);
                java.sql.Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                String LastName = rs.getString("LASTNAME");
                String FirstName = rs.getString("FIRSTNAME");
                String Position = rs.getString("POSITION");
                int Wage = rs.getInt("WAGE");
                int Age = rs.getInt("AGE");
                List.add(new Employer(LastName, FirstName, Position, Wage, Age));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
    }

}
