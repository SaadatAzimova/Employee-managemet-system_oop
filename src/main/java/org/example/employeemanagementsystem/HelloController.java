package org.example.employeemanagementsystem;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
;

public class HelloController {

    @FXML private Button add;
    @FXML private Button remove;
    @FXML private TextField name;
    @FXML private TextField position;
    @FXML private ChoiceBox<String> unitChoice; // Updated to ChoiceBox
    @FXML private TextField fMonthlySalary;
    @FXML private TextField pHourlyWage;
    @FXML private TextField pHourlyWorked;
    @FXML private TextField cHourlyRate;
    @FXML private TextField cMaxHour;
    @FXML private Label salary;
    @FXML private Label removed;
    @FXML private TableView<Employee> table;
    @FXML private TableColumn<Employee, String> tableName;
    @FXML private TableColumn<Employee, String> tableType;
    @FXML private TableColumn<Employee, Double> tableSalary;
    @FXML private Tab fTab;
    @FXML private Tab pTab;
    @FXML private Tab cTab;
    @FXML private Tab mainTab;
    @FXML private TabPane tabpane;
    private ObservableList<Employee> employees;

    @FXML
    public void initialize() {
        employees = FXCollections.observableArrayList();

        // Initialize ChoiceBox with employee types
        if (unitChoice != null) {
            unitChoice.setItems(FXCollections.observableArrayList("Full-time", "Part-time", "Contract"));
            unitChoice.setValue("Full-time"); // Set default value

            // Add listener to ChoiceBox for switching tabs
            unitChoice.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
                switch (newValue) {
                    case "Full-time":
                        tabpane.getSelectionModel().select(fTab);
                        break;
                    case "Part-time":
                        tabpane.getSelectionModel().select(pTab);
                        break;
                    case "Contract":
                        tabpane.getSelectionModel().select(cTab);
                        break;
                }
            });
        }

        // Table column bindings
        tableName.setCellValueFactory(new PropertyValueFactory<>("name"));
        tableType.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getClass().getSimpleName()));
        tableSalary.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().calculateSalary()));

        table.setItems(employees);
    }

    @FXML
    private void addEmployee() {
        String employeeName = name.getText();
        String employeePosition = position.getText();
        String employeeType = unitChoice.getValue();
        Employee employee = null;
        salary.setText(""); // Clear salary label

        try {
            switch (employeeType) {
                case "Full-time":
                    double monthlySalary = Double.parseDouble(fMonthlySalary.getText());
                    employee = new FullTimeEmployee(employeeName, employeePosition, monthlySalary);
                    break;
                case "Part-time":
                    double hourlyWage = Double.parseDouble(pHourlyWage.getText());
                    int hoursWorked = Integer.parseInt(pHourlyWorked.getText());
                    employee = new PartTimeEmployee(employeeName, employeePosition, hourlyWage, hoursWorked);
                    break;
                case "Contract":
                    double hourlyRate = Double.parseDouble(cHourlyRate.getText());
                    int maxHours = Integer.parseInt(cMaxHour.getText());
                    employee = new Contractor(employeeName, employeePosition, hourlyRate, maxHours);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid employee type.");
            }

            employees.add(employee);
            clearFields();
        } catch (Exception e) {
            showAlert("Invalid Input", "Please enter valid details for the selected employee type.");
        }
    }

    @FXML
    private void removeEmployee() {
        Employee selectedEmployee = table.getSelectionModel().getSelectedItem();
        if (selectedEmployee != null) {
            employees.remove(selectedEmployee);
            removed.setText(selectedEmployee.getName() + " removed");
        } else {
            showAlert("No Selection", "Please select an employee to remove.");
        }
    }

    private void clearFields() {
        name.clear();
        position.clear();
        fMonthlySalary.clear();
        pHourlyWage.clear();
        pHourlyWorked.clear();
        cHourlyRate.clear();
        cMaxHour.clear();
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    @FXML
    private void calculateFullTimeSalary() {
        try {
            // Retrieve and validate input
            String employeeName = name.getText();
            String employeePosition = position.getText();
            double monthlySalary = Double.parseDouble(fMonthlySalary.getText());

            // Create FullTimeEmployee instance
            FullTimeEmployee employee = new FullTimeEmployee(employeeName, employeePosition, monthlySalary);

            // Calculate and display salary using calculateSalary()
            double calculatedSalary = employee.calculateSalary();
            salary.setText(String.format("Salary: %.2f", calculatedSalary));

            // Switch to the main tab
            tabpane.getSelectionModel().select(mainTab);
        } catch (NumberFormatException e) {
            showAlert("Invalid Input", "Please enter valid details for the Full-Time employee.");
        }
    }

    @FXML
    private void calculatePartTimeSalary() {
        try {
            // Retrieve and validate input
            String employeeName = name.getText();
            String employeePosition = position.getText();
            double hourlyWage = Double.parseDouble(pHourlyWage.getText());
            int hoursWorked = Integer.parseInt(pHourlyWorked.getText());

            // Create PartTimeEmployee instance
            PartTimeEmployee employee = new PartTimeEmployee(employeeName, employeePosition, hourlyWage, hoursWorked);

            // Calculate and display salary using calculateSalary()
            double calculatedSalary = employee.calculateSalary();
            salary.setText(String.format("Salary: %.2f", calculatedSalary));

            // Switch to the main tab
            tabpane.getSelectionModel().select(mainTab);
        } catch (NumberFormatException e) {
            showAlert("Invalid Input", "Please enter valid details for the Part-Time employee.");
        }
    }

    @FXML
    private void calculateContractorSalary() {
        try {
            // Retrieve and validate input
            String employeeName = name.getText();
            String employeePosition = position.getText();
            double hourlyRate = Double.parseDouble(cHourlyRate.getText());
            int maxHours = Integer.parseInt(cMaxHour.getText());

            // Create Contractor instance
            Contractor employee = new Contractor(employeeName, employeePosition, hourlyRate, maxHours);

            // Calculate and display salary using calculateSalary()
            double calculatedSalary = employee.calculateSalary();
            salary.setText(String.format("Salary: %.2f", calculatedSalary));

            // Switch to the main tab
            tabpane.getSelectionModel().select(mainTab);
        } catch (NumberFormatException e) {
            showAlert("Invalid Input", "Please enter valid details for the Contract employee.");
        }
    }

}
