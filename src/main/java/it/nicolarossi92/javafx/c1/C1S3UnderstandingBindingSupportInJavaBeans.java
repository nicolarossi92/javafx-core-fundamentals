package it.nicolarossi92.javafx.c1;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * Let's have an example of the inner working of JavaBeans package
 */
public class C1S3UnderstandingBindingSupportInJavaBeans {


    /**
     * Both properties of the Employee bean are read/write. The salary property is also a bound property. Its setter generates property change notifications when the salary changes.
     * Interested listeners can register or deregister for the change notifications using the addPropertyChangeListener() and removePropertyChangeListener() methods.
     */
    public static class Employee {
        private String name;
        private double salary;
        private PropertyChangeSupport pcs = new PropertyChangeSupport(this);

        public Employee() {
            this.name = "John Doe";
            this.salary = 1000.0;
        }

        public Employee(String name, double salary) {
            this.name = name;
            this.salary = salary;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getSalary() {
            return salary;
        }
        public void setSalary(double salary) {
            double oldSalary = this.salary;
            this.salary = salary;

            // Notify the registered listeners about the change
            pcs.firePropertyChange("salary", oldSalary, salary);
        }

        public void addPropertyChangeListener(PropertyChangeListener listener) {
            pcs.addPropertyChangeListener(listener);
        }

        public void removePropertyChangeListener(PropertyChangeListener listener) {
            pcs.removePropertyChangeListener(listener);
        }

        @Override
        public String toString() {
            return "name= " + name + ", salary= " +  salary;
        }
    }


    public static void main(String[] args) {
        final Employee e1 = new Employee("John Jacobs", 2000.0);

        // Compute the tax
        computeTax(e1.getSalary());

        // Add a property change listener to e1
        e1.addPropertyChangeListener(new EmployeeChangeListener());

        // Change the salary
        e1.setSalary(3000.0);
        e1.setSalary(3000.0); // NO change notification is sent
        e1.setSalary(6000.0);
    }

    public static void computeTax(double salary) {
        final double TAX_PERCENT = 20.0;
        double tax = salary * TAX_PERCENT/100.0;
        System.out.println("Salary:" + salary + ", Tax:" + tax);
    }


    public static class EmployeeChangeListener implements PropertyChangeListener {
        public void propertyChange(PropertyChangeEvent evt) {
            String propertyName = evt.getPropertyName();

            if("salary".equals(propertyName)){
                System.out.println("Salary Has changed");
                System.out.println(evt.getOldValue());
                System.out.println(evt.getNewValue());

                computeTax((Double) evt.getNewValue());
            }
        }
    }
}
