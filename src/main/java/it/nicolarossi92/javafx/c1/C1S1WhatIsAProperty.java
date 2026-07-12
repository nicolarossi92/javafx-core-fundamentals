package it.nicolarossi92.javafx.c1;

/**
 * A Java class can contain two types of members: fields and methods. Fields represent
 * the state of the objects, and they are declared private. Public methods, known as accessors, or getters
 * and setters, are used to read and modify private fields. In simple terms, a Java class that has public accessors, for all or part of its private fields, is known as a
 * Java bean, and the accessors define the properties of the bean. Properties of the bean allow users to customize its state, behavior
 * or both. Java beans are observable. They support property change notification.
 * A property can be read-only, write only, or read/write. The JavaBeans API provides a class library, through the java.beans package.
 */
public class C1S1WhatIsAProperty {

    /**
     * An example of a Person bean
     */
    public static class Person {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    /**
     * The following snippet manipulates the name property of a Person bean programmatically.
     */
    public static void main(String[] args){
        Person p = new Person();
        p.setName("John Jacobs");
        String name = p.getName();
    }
}
