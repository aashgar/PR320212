/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ch3Apps;

import java.net.URL;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.ResourceBundle;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

/**
 * FXML Controller class
 *
 * @author aashgar
 */
public class TextAreaPaneController implements Initializable {

    @FXML
    private TextArea textArea;
    @FXML
    private Button buttonShow;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void buttonShowHandle(ActionEvent event) {
        int[] ar = {3, 17, 1, 12, 4, 9, 21, 50};
        textArea.setText("Sorted: ");
        IntStream
                .of(ar)
                .sorted()
                .forEach(v-> textArea.appendText(v+" "));
        textArea.appendText("\nFiltered: ");
        
        Stream
                .of(3, 17, 1, 12, 4, 9, 21, 50 )
                .filter(v-> v%2 ==0)
                .forEach(v-> textArea.appendText(v+" "));        
       
        textArea.appendText("\nSum: ");
        
        int sum =
        IntStream
                .rangeClosed(1, 10)
                .filter(v-> v%2 ==0)
                .reduce(0, (a,b)-> a+b);
        
        textArea.appendText(sum +"");
        textArea.appendText("\nAverage: ");
        
        
        Double[] ar2 = {1.1, 5.5, 7.7, 11.11, 20.20, 6.6};
        double avg=
        Arrays
                .stream(ar2)
                .mapToDouble(v-> (double) v)
                .average().getAsDouble();
        
        textArea.appendText(avg +"");
        
        textArea.appendText("\nFind Any:");
        textArea.appendText(
        Stream
                .of("Ahmad", "Ali", "Mona", "Mostafa", "Huda")
                .parallel()
                .filter(s-> s.length()>3)
                .findAny()
                .get()
        );
        textArea.appendText("\nGrouping:\n");
              Stream
                .of("Programming needs open minded and programming thinking",
                    "Programming Programming needs needs and needs expeience")
                 .flatMap(s-> Stream.of(s.split("[\\s]+")))
                 .collect(Collectors.groupingBy(String::toString))
                 .forEach((s, list)-> textArea.appendText(s+": "+list+"\n"));
        
        textArea.appendText("\nCounting:\n"); 
        Stream
                .of("Programming needs open minded and programming thinking",
                    "Programming Programming needs needs and needs expeience")
                 .flatMap(s-> Stream.of(s.split("[\\s]+")))
                 .collect(Collectors.groupingBy(String::toString, Collectors.counting()))
                 .forEach((s, c)-> textArea.appendText(s+": "+c+"\n"));
        
     Employee[] employees = {
            new Employee(1, "Ahmad", "IT", 1201.1),
            new Employee(2, "Sami", "Sales", 950.8),
            new Employee(5, "Huda", "IT",1010.5),
            new Employee(7, "Ali", "Marketing", 1300.2),
            new Employee(4, "Hani", "Sales", 1050.1)
     };
        List<Employee> listEmployees = Arrays.asList(employees);
        
        textArea.appendText("\nSorted Employees:\n"); 
        listEmployees
                .stream()
                .filter(e-> e.getSalary()>=1100)
                .forEach(e-> textArea.appendText(e+"\n"));
 
        listEmployees
                .stream()
                .filter(e-> e.getSalary() >=800 && e.getSalary() <1200)
                .map(e-> new Employee(e.getId(), e.getName(), e.getDepartment(), e.getSalary()*1.02))
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()))
                .forEach((d, c) -> System.out.println("Dept: "+ d + ", Count: " + c));
        
         listEmployees
                .stream()
                .filter(e-> e.getSalary() >=800 && e.getSalary() <1200)
                .map(e-> new Employee(e.getId(), e.getName(), e.getDepartment(), e.getSalary()*1.02))
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()))
                .forEach((d, c) -> System.out.println("Dept: "+ d + ", Count: " + c));
    }
}
