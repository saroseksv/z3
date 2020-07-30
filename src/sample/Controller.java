package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import javax.swing.*;

public class Controller {
    private ObservableList<Record> usersData = FXCollections.observableArrayList();

    @FXML
    private TableView<Record> tvTable;

    @FXML
    private TableColumn<Record, Double> tcC1;

    @FXML
    private TableColumn<Record, Double> tcC2;

    @FXML
    private TableColumn<Record, Double> tcC3;

    @FXML
    private TableColumn<Record, Double> tcC4;

    @FXML
    private TableColumn<Record, Double> tcC5;

    int f=0;
    //@FXML
    private void initData() {
        Massiv mas=new Massiv();
        //mas.Fill();
        for(int i=0;i<5;i++)
        {
            usersData.add(new Record(mas.v[i][0],mas.v[i][1],mas.v[i][2],mas.v[i][3],mas.v[i][4]));
        }
    }

    @FXML
    Massiv mas=new Massiv();

    public void bFillClick(ActionEvent actionEvent) {
        usersData.clear();
        initData();

        tcC1.setCellValueFactory(new PropertyValueFactory<Record, Double>("c1"));
        tcC2.setCellValueFactory(new PropertyValueFactory<Record, Double>("c2"));
        tcC3.setCellValueFactory(new PropertyValueFactory<Record, Double>("c3"));
        tcC4.setCellValueFactory(new PropertyValueFactory<Record, Double>("c4"));
        tcC5.setCellValueFactory(new PropertyValueFactory<Record, Double>("c5"));
        tvTable.setItems(usersData);
        f=1;
    }

    @FXML
    private Label lMax;

    @FXML
    private Label lMin;

    public void bProcessClick(ActionEvent actionEvent) {
        if(f==0)
            JOptionPane.showMessageDialog(null, "Сначала нужно заполнить массив");
        else{
            Double max=mas.v[0][0];
            Double min=mas.v[0][0];
            for (int i=0;i<5;i++)
                for(int j=0;j<5;j++) {
                    if (mas.v[i][j]>max) max=mas.v[i][j];
                    if (mas.v[i][j]<min) min=mas.v[i][j];
                }
            lMax.setText(String.valueOf(max));
            lMin.setText(String.valueOf(min));

            if (max/Math.abs(min)>10)
            {
                for (int i=0;i<5;i++)
                    for(int j=0;j<5;j++) {
                        if (mas.v[i][j] == 0) mas.v[i][j] = 1.0;
                        else if (mas.v[i][j] < 0) mas.v[i][j] = Math.abs(mas.v[i][j]);
                    }
                for(int i=0;i<5;i++)
                {
                    usersData.add(new Record(mas.v[i][0],mas.v[i][1],mas.v[i][2],mas.v[i][3],mas.v[i][4]));
                }
            }
        }
    }
}
