package it.nicolarossi92.javafx.c1;

import javafx.beans.property.*;

/**
 * In JavaFX, you do not declare the property of a class as one of the primitive types. Rather, you use one of the JavaFX property classes.
 */
public class C1S5UsingPropertiesInJavaFXBeans {

    public static class Book {

        /*
         * Note that it uses the ReadOnlyStringWrapper class instead of the SimpleStringProperty class.
         * There is no setter for the property value. You may declare one; however, it must be private.
         * The getter for the property value works the same as for a read/write property.
         * The ISBNProperty() method uses ReadOnlyStringProperty as the return type, not ReadOnlyStringWrapper.
         */

        private final ReadOnlyStringWrapper ISBN = new ReadOnlyStringWrapper(this, "ISBN", "Unknown");
        private final StringProperty title = new SimpleStringProperty(this, "title", "Unknown");
        private final DoubleProperty price = new SimpleDoubleProperty(this, "price", 0.0);


        public Book() {

        }

        public Book(String title, double price, String ISBN) {
            this.title.set(title);
            this.price.set(price);
            this.ISBN.set(ISBN);
        }

        public final String getTitle(){
            return titleProperty().get();
        }

        public final void setTitle(String title){
            titleProperty().set(title);
        }

        public final StringProperty titleProperty(){
            return title;
        }


        public final String getISBN(){
            return ISBN.get();
        }

        public final ReadOnlyStringProperty ISBNProperty(){
            return ISBN.getReadOnlyProperty();
        }

        public final double getPrice() {
            return price.get();
        }

        public final void setPrice(double price) {
            this.price.set(price);
        }

        public final DoubleProperty priceProperty(){
            return price;
        }


    }

    // The preceding declaration of the Book class is fine to work with the title property:

    public static void main(String[] args){
        Book b = new Book("Harnessing JavaFX", 9.99, "0123456789");
        System.out.println("After creating the Book object");

        // Print Property details
        printDetails(b.titleProperty());
        printDetails(b.priceProperty());
        printDetails(b.ISBNProperty());

        // Change the book's properties
        b.setTitle("Harnessing JavaFX 17.0");
        b.setPrice(9.49);

        System.out.println("After changing the Book properties...");

        // Print Property details
        printDetails(b.titleProperty());
        printDetails(b.priceProperty());
        printDetails(b.ISBNProperty());


    }

    public static void printDetails(ReadOnlyProperty<?> p){
        String name = p.getName();
        Object value = p.getValue();
        Object bean = p.getBean();
        System.out.println("Name: " + name);
        System.out.println("Value: " + value);
        System.out.println("Bean: " + bean);
    }
}
