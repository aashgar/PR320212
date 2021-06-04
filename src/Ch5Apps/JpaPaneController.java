/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ch5Apps;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;

/**
 * FXML Controller class
 *
 * @author aashgar
 */
public class JpaPaneController implements Initializable {

    @FXML
    private TextField txtFieldDeptID;
    @FXML
    private TextField txtFieldDeptName;
    @FXML
    private TextField txtFieldDeptLocation;
    @FXML
    private TextField txtFieldEmpName;
    @FXML
    private TextField txtFieldEmpSalary;
    @FXML
    private TextField txtFieldEmpDeptID;
    @FXML
    private TextField txtFieldEmpID;
    @FXML
    private TableView<Employee> tableView;
    @FXML
    private TableColumn<Employee, Integer> tcID;
    @FXML
    private TableColumn<Employee, String> tcName;
    @FXML
    private TableColumn<Employee, Integer> tcDepartment;
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
    private EntityManagerFactory emf;
    private Department department;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        tcID.setCellValueFactory(new PropertyValueFactory("id"));
        tcName.setCellValueFactory(new PropertyValueFactory("name"));
        tcDepartment.setCellValueFactory(new PropertyValueFactory("dept_id"));
        tcSalary.setCellValueFactory(new PropertyValueFactory("salary"));
        this.emf = Persistence.createEntityManagerFactory("PR320212PU");
    }    

    @FXML
    private void txtFieldDeptIDHandle(ActionEvent event) {
        EntityManager em = this.emf.createEntityManager();
        try{
        department = (Department) em.createNamedQuery("Department.findById")
                .setParameter("id", Integer.parseInt(txtFieldDeptID.getText()))
                .getSingleResult();
        txtFieldDeptName.setText(department.getName());
        txtFieldDeptLocation.setText(department.getLocation());
        txtFieldEmpDeptID.setText(department.getId()+"");
        }catch(NoResultException ex){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error Retrieving");
            alert.setContentText("No records found");
            alert.showAndWait();
        }
        em.close();
    }

    @FXML
    private void txtFieldEmpIDHandle(ActionEvent event) {
         EntityManager em = this.emf.createEntityManager();
        try{
        Employee employee = (Employee) em.createNamedQuery("Employee.findById")
                .setParameter("id", Integer.parseInt(txtFieldEmpID.getText()))
                .getSingleResult();
        txtFieldEmpName.setText(employee.getName());
        txtFieldEmpDeptID.setText(employee.getDept_id()+"");
        txtFieldEmpSalary.setText(employee.getSalary()+"");
        }catch(NoResultException ex){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error Retrieving");
            alert.setContentText("No records found");
            alert.showAndWait();
        }
        em.close();
        
    }

    @FXML
    private void buttonShowHandle(ActionEvent event) {
        EntityManager em = emf.createEntityManager();
        List<Employee> employees = em.createNamedQuery("Employee.findAll").getResultList();
        tableView.getItems().setAll(employees);
        em.close();
        
    }

    @FXML
    private void buttonAddHandle(ActionEvent event) {
        Employee employee = new Employee();
        employee.setName(txtFieldEmpName.getText());
        employee.setDept(department);
        employee.setSalary(Double.parseDouble(txtFieldEmpSalary.getText()));
        EntityManager em = this.emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(employee);
        em.getTransaction().commit();
        em.close();
    }

    @FXML
    private void buttonUpdateHandle(ActionEvent event) {
    }

    @FXML
    private void buttonDeleteHandle(ActionEvent event) {
    }

    @FXML
    private void buttonResetHandle(ActionEvent event) {
        resetControls();
    }
    private void resetControls(){
        txtFieldDeptID.setText("");
        txtFieldDeptLocation.setText("");
        txtFieldDeptName.setText("");
        txtFieldEmpDeptID.setText("");
        txtFieldEmpID.setText("");
        txtFieldEmpName.setText("");
        txtFieldEmpSalary.setText("");
        tableView.getItems().clear();
    }
}
