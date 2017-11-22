/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a5_task1;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author yezh0
 */
public class ChartController {

    final String doctor = "Doctor";
    final String singer = "Singer";
    final String mechanic = "Mechanic";
    final String cook = "Cook";
    final String artist = "Artist";

    /**
     * display the chart
     */
    public void display() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Chart.fxml"));
            Pane page = loader.load();
            // Create the dialog Stage.
            Stage stage = new Stage();
            final CategoryAxis xAxis = new CategoryAxis();
            final NumberAxis yAxis = new NumberAxis();
            final BarChart<String, Number> chart
                    = new BarChart<String, Number>(xAxis, yAxis);
            chart.setTitle("Average Wage Summary");
            xAxis.setLabel("Position");
            yAxis.setLabel("Average Wage");
            XYChart.Series series = new XYChart.Series();
            series.getData().add(new XYChart.Data(doctor, 10561.34));
            series.getData().add(new XYChart.Data(singer, 11148.82));
            series.getData().add(new XYChart.Data(mechanic, 10220));
            series.getData().add(new XYChart.Data(cook, 10293.15));
            series.getData().add(new XYChart.Data(artist, 11283));
            Scene scene = new Scene(chart);
            chart.getData().add(series);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
