/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ch1App;

/**
 *
 * @author aashgar
 */
public class MainApp {
    public static void main(String[] args) {
        Double data1[] = {3.0, 5.0, 1.0, 2.0, 4.0};
        show(data1);
        
        Person persons[] ={
            new Student("Ahmad", "SE", 88.9),
            new Employee("Ali", "Sales", 999.8),
            new Student("Huda", "CS", 79.8)
        };
        
        show(persons);
    }
    
    public static <T> void show(T data[]){
        for(T d: data)
            System.out.println(d);
    }
}
