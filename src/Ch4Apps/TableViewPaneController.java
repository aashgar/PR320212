/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ch4Apps;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author aashgar
 */
public class TableViewPaneController implements Initializable {

    @FXML
    private TextField txtFieldID;
    @FXML
    private TextField txtFieldName;
    @FXML
    private TextField txtFieldDepartment;
    @FXML
    private TextField txtFieldSalary;
    @FXML
    private TableColumn<Employee, Integer> tcID;
    @FXML
    private TableColumn<Employee, String> tcName;
    @FXML
    private TableColumn<Employee, String> tcDepartment;
    @FXML
    private TableColumn<Employee, Double> tcSalary;
    @FXML
    private Button buttonShow;
    @FXML
    private Button buttonAdd;
    @FXML
    private Button buttonUpdate;
    @FXML
    private Button buttonDelete;
    @FXML
    private Button buttonReset;
    @FXML
    private TableView<Employee> tableView;
    
    Statement statement;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection =
               DriverManager.
                getConnection("jdbc:mysql://127.0.0.1:3306/company?serverTimezone=UTC",
                        "root", "root");
            this.statement = connection.createStatement();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        tcID.setCellValueFactory(new PropertyValueFactory("id"));
        tcName.setCellValueFactory(new PropertyValueFactory("name"));
        tcDepartment.setCellValueFactory(new PropertyValueFactory("department"));
        tcSalary.setCellValueFactory(new PropertyValueFactory("salary"));
        tableView.getSelectionModel().selectedItemProperty().addListener(
                event-> showSelectedEmployee() );
    }    

    @FXML
    private void buttonShowHandle(ActionEvent event) throws Exception{
        ResultSet rs = this.statement.executeQuery("Select * From Employee");
        tableView.getItems().clear();
        while(rs.next()){
            Employee employee = new Employee();
            employee.setId(rs.getInt("id"));
            employee.setName(rs.getString("name"));
            employee.setDepartment(rs.getString("department"));
            employee.setSalary(rs.getDouble("salary"));
            tableView.getItems().add(employee);
        }
    }

    @FXML
    private void buttonAddHandle(ActionEvent event) throws Exception{
        Integer id = Integer.parseInt(txtFieldID.getText());
        String name = txtFieldName.getText();
        String department = txtFieldDepartment.getText();
        Double salary = Double.parseDouble(txtFieldSalary.getText());
        String sql = "Insert Into Employee values(" + id + ",'" +name + "','" 
                + department + "'," + salary + ")";
        this.statement.executeUpdate(sql);
    }

    @FXML
    private void buttonDeleteHandle(ActionEvent event) {
    }

    @FXML
    private void buttonResetHandle(ActionEvent event) {
        resetControls();
    }
    private void resetControls(){
        txtFieldID.setText("");
        txtFieldName.setText("");
        txtFieldDepartment.setText("");
        txtFieldSalary.setText("");
        tableView.getItems().clear();
    }

    @FXML
    private void buttonUpdateHandle(ActionEvent event) throws Exception{
        Integer id = Integer.parseInt(txtFieldID.getText());
        String name = txtFieldName.getText();
        String department = txtFieldDepartment.getText();
        Double salary = Double.parseDouble(txtFieldSalary.getText());
        String sql = "Update Employee Set name='" + name + "', department='" + 
                department + "', salary=" + salary + " Where id=" +id;
        this.statement.executeUpdate(sql);
        
    }
    private void showSelectedEmployee(){
        Employee employee = tableView.getSelectionModel().getSelectedItem();
        if(employee != null){
        txtFieldID.setText(String.valueOf(employee.getId()));
        txtFieldName.setText(employee.getName());
        txtFieldDepartment.setText(employee.getDepartment());
        txtFieldSalary.setText(String.valueOf(employee.getSalary()));
        }

    }
}
