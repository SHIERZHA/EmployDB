/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a5_task1;

import static a5_task1.Order.List;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;

/**
 *
 * @author yezh0
 */
public class FXMLDocumentController implements Initializable {

    String url = "jdbc:derby:StaffDB";
    String username = "user1";
    String password = "123456";

    @FXML
    private Text succeed;
    @FXML
    private TextField firstName;
    @FXML
    private TextField lastName;
    @FXML
    private TextField position;
    @FXML
    private TextField wage;
    @FXML
    private TextField age;
    @FXML
    private TextField positionInput;
    @FXML
    private Button add;
    @FXML
    private Button displayAll;
    @FXML
    private Button earningLeast;
    @FXML
    private Button earningMost;
    @FXML
    private Button earningAboveAverage;
    @FXML
    private Button earnMore;
    @FXML
    private Button findPosition;
    @FXML
    private Button showChart;

    @FXML
    private TableColumn<Employer, String> fnCol;
    @FXML
    private TableColumn<Employer, String> lnCol;
    @FXML
    private TableColumn<Employer, String> positionCol;
    @FXML
    private TableColumn<Employer, Integer> wageCol;
    @FXML
    private TableColumn<Employer, Integer> ageCol;
    @FXML
    private TableView<Employer> table;

    /**
     * add employers
     */
    @FXML
    private void addAction() {
        String firstname = firstName.getText();
        String lastname = lastName.getText();
        String posi = position.getText();
        String wg = wage.getText();
        String ag = age.getText();
        String query = "insert into staff values(" + "'" + firstname + "','" + lastname + "','" + posi + "'," + wg + "," + ag + ")";
        try (Connection con = DriverManager.getConnection(url, username, password);
                java.sql.Statement stmt = con.createStatement();) {
            int rs = stmt.executeUpdate(query);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            ex.getStackTrace();
        }
        System.out.println("You clicked me!");
        succeed.setVisible(true);
    }

    /**
     * display all employers
     */
    @FXML
    private void displayAllAction() {
        System.out.println("You clicked me!");
        new Order().displayAll();
        showRs();

    }

    /**
     * find employers who earn least
     */
    @FXML
    private void earningLeastAction() {
        List.clear();
        new Order().displaySmallest();
        showRs();
    }

    /**
     * find employers who earn most
     */
    @FXML
    private void earningMostAction() {
        List.clear();
        new Order().displayMost();
        showRs();
    }

    /**
     * find employers who earn more than average
     */
    @FXML
    private void earningAboveAverageAction() {
        List.clear();
        new Order().displayAboveAverage();
        showRs();
    }

    /**
     * find employers who earn more than 55000
     */
    @FXML
    private void earnMore() {
        List.clear();
        new Order().displayAboveNumber();
        showRs();
    }

    /**
     * find position
     */
    @FXML
    private void findPosition() {
        List.clear();
        String position = positionInput.getText();
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
            ex.getStackTrace();
        }
        showRs();
    }

    /**
     * show chart
     */
    @FXML
    private void showChart() {
        System.out.println("You clicked me!");
        new ChartController().display();
    }

    /**
     * show the table
     */
    public void showRs() {

        fnCol.setCellValueFactory(new PropertyValueFactory<Employer, String>("firstName"));
        lnCol.setCellValueFactory(new PropertyValueFactory<Employer, String>("lastName"));
        positionCol.setCellValueFactory(new PropertyValueFactory<Employer, String>("position"));
        wageCol.setCellValueFactory(new PropertyValueFactory<Employer, Integer>("wage"));
        ageCol.setCellValueFactory(new PropertyValueFactory<Employer, Integer>("age"));
        table.setItems(Order.List);
    }

    /**
     * initialize
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        succeed.setVisible(false);
    }

}
