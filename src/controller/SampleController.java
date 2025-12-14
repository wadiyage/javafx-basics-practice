package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Customer;

import java.util.ArrayList;

public class SampleController {
    public TextField txtCustomerID;
    public TextField txtCustomerName;
    public TextField txtEmail;
    public TextField txtAddress;
    public TextField txtSalary;
    public TableView tblCustomerDetails;
    public TableColumn colCustomerID;
    public TableColumn colName;
    public TableColumn colEmail;
    public TableColumn colAddress;
    public TableColumn colSalary;

    ArrayList<Customer> customerArrayList = new ArrayList<>();

    public void btnAddCustomerOnAction(ActionEvent actionEvent) {
        addCustomer();
    }

    private void addCustomer() {
        String customerID = txtCustomerID.getText();
        String name = txtCustomerName.getText();
        String email = txtEmail.getText();
        String address = txtAddress.getText();
        double salary = Double.parseDouble(txtSalary.getText());

        Customer customer = new Customer(customerID, name, email, address, salary);
        customerArrayList.add(customer);
        System.out.println("New Customer Added successfully!");
        loadTable();
    }

    public void btnReloadOnAction(ActionEvent actionEvent) {
        loadTable();
    }

    private void loadTable() {
        colCustomerID.setCellValueFactory(new PropertyValueFactory<>("customerID"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colSalary.setCellValueFactory(new PropertyValueFactory<>("salary"));

        ObservableList<Customer> customerObservableList = FXCollections.observableArrayList();
        customerArrayList.forEach(customer -> {
            customerObservableList.add(customer);
        });
        tblCustomerDetails.setItems(customerObservableList);
    }
}
