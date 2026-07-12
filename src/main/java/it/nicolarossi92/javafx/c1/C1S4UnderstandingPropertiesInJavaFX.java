package it.nicolarossi92.javafx.c1;

import javafx.beans.property.*;

/**
 * JavaFX support properties, events, and bindings through properties and binding APIs. Properties support in JavaFX is a huge leap forward from the JavaBeans properties
 * All properties in JavaFX are observable. They can be observed for invalidation and value changes.
 * We'll analyze in this chapter properties that represent a single value.
 */
public class C1S4UnderstandingPropertiesInJavaFX {


    public static void main(String[] args){
        IntegerProperty counter = new SimpleIntegerProperty(1);

        int counterValue = counter.get();
        System.out.println("countervalue: " + counterValue);

        counter.setValue(2);
        counterValue = counter.getValue();

        System.out.println("countervalue: " + counterValue);

        /*
         * Working with read-only properties is a bit tricky. A ReadOnlyXXXWrapper class wraps two properties of XXX types:
         * one read only and one read write. Both properties are synchronized. Its getReadOnlyProperty() method returns a ReadOnlyXXProperty object
         */

        ReadOnlyIntegerWrapper idWrapper = new ReadOnlyIntegerWrapper(100);
        ReadOnlyIntegerProperty id = idWrapper.getReadOnlyProperty();

        System.out.println("idWrapper: " + idWrapper.get());
        System.out.println("id: " + id.getValue());


        // Change the value

        idWrapper.set(101);

        System.out.println("idWrapper: " + idWrapper.get());
        System.out.println("id: " + id.getValue());

        /*
         * Wrapper properties are used as a private instance variable of a class. The class can change the property internally. It
         * can also return a ReadOnlyProperty to the outside world making it read-only for accessing methods.
         */


        /*
         * When you create a property object, you supply the reference of the bean that contains it, a name and a value.
         * A property object can be part of a bean, or it can be a standalone object. In this case it is a standalone object.
         */

    }


    public static class Person {
        private final StringProperty name = new SimpleStringProperty(this, "name", "Li");

        // Every property class has getBean() and getName() methods that returns the bean reference and the property name, respectively
    }
}
