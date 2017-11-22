/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a5_task1;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author yezh0
 */
public class Employer {

    /**
     *
     */
    public SimpleStringProperty firstName;
    private SimpleStringProperty lastName;
    private SimpleStringProperty position;
    private SimpleIntegerProperty wage;
    private SimpleIntegerProperty age;

    /**
     *
     * @param fn
     * @param ln
     * @param position
     * @param wage
     * @param age
     */
    public Employer(String fn, String ln, String position, int wage, int age) {
        this.firstName = new SimpleStringProperty(fn);
        this.lastName = new SimpleStringProperty(ln);
        this.position = new SimpleStringProperty(position);
        this.wage = new SimpleIntegerProperty(wage);
        this.age = new SimpleIntegerProperty(age);
    }

    Employer() {
        this(null, null, null, 0, 0);
    }

    /**
     * get first name
     *
     * @return
     */
    public String getFirstName() {
        return firstName.get();
    }

    /**
     * get first name
     *
     * @return
     */
    public SimpleStringProperty getFirstNameProperty() {
        return firstName;
    }

    /**
     * set first name
     *
     * @param firstName
     */
    public void setFirstName(SimpleStringProperty firstName) {
        this.firstName = firstName;
    }

    /**
     * get last name
     *
     * @return
     */
    public String getLastName() {
        return lastName.get();
    }

    /**
     * set first name
     *
     * @param lastName
     */
    public void setLastName(SimpleStringProperty lastName) {
        this.lastName = lastName;
    }

    /**
     * get position
     *
     * @return
     */
    public String getPosition() {
        return position.get();
    }

    /**
     * set position
     *
     * @param position
     */
    public void setPosition(SimpleStringProperty position) {
        this.position = position;
    }

    /**
     * get wage
     *
     * @return
     */
    public int getWage() {
        return wage.get();
    }

    /**
     * set wage
     *
     * @param wage
     */
    public void setWage(SimpleIntegerProperty wage) {
        this.wage = wage;
    }

    /**
     * get age
     *
     * @return
     */
    public int getAge() {
        return age.get();
    }

    /**
     * set age
     *
     * @param age
     */
    public void setAge(SimpleIntegerProperty age) {
        this.age = age;
    }

}
